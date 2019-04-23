package OpenCV.imgproc;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * 特征匹配
 * 参考链接：https://www.jb51.net/article/134841.htm
 */
public class MatchTemplate {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        //读入图片
//        Mat src = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\mytest\\1.jpg");
//        Mat temp=Imgcodecs.imread("F:\\opencvPhoto\\photo\\1-temp.jpg");
        Mat g_src = Imgcodecs.imread("F:\\opencvPhoto\\photo\\1-temp.jpg");
        Mat  g_tem= Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\mytest\\0.jpg");

        int result_rows = g_src.rows() - g_tem.rows() + 1;
        int result_cols = g_src.cols() - g_tem.cols() + 1;
        System.out.println(result_cols+"  "+result_rows);
        Mat g_result = new Mat(result_rows, result_cols, CvType.CV_32FC1);
        Imgproc.matchTemplate(g_src, g_tem, g_result, Imgproc.TM_CCORR_NORMED); // 归一化平方差匹配法
        // Imgproc.matchTemplate(g_src, g_tem, g_result,
        // Imgproc.TM_CCOEFF_NORMED); // 归一化相关系数匹配法

        // Imgproc.matchTemplate(g_src, g_tem, g_result, Imgproc.TM_CCOEFF);
        // //
        // 相关系数匹配法：1表示完美的匹配；-1表示最差的匹配。

        // Imgproc.matchTemplate(g_src, g_tem, g_result, Imgproc.TM_CCORR); //
        // 相关匹配法

        // Imgproc.matchTemplate(g_src, g_tem, g_result,Imgproc.TM_SQDIFF); //
        // 平方差匹配法：该方法采用平方差来进行匹配；最好的匹配值为0；匹配越差，匹配值越大。

        // Imgproc.matchTemplate(g_src, g_tem,g_result,Imgproc.TM_CCORR_NORMED);
        // // 归一化相关匹配法
        Core.normalize(g_result, g_result, 0, 1, Core.NORM_MINMAX, -1, new Mat());
        Point matchLocation = new Point();
        Core.MinMaxLocResult mmlr = Core.minMaxLoc(g_result);

        matchLocation = mmlr.maxLoc; // 此处使用maxLoc还是minLoc取决于使用的匹配算法
        Imgproc.rectangle(g_src, matchLocation,
                new Point(matchLocation.x + g_tem.cols(), matchLocation.y + g_tem.rows()),
                new Scalar(0, 0, 0, 0));

        Imgcodecs.imwrite("F:\\opencvPhoto\\result\\MatchTemplate.jpg", g_src);
    }

}
