package OpenCV.imgproc.Resize;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * 参考链接:
 * https://blog.csdn.net/m1109048058/article/details/77069607
 * https://blog.csdn.net/woainishifu/article/details/53260546
 */
//图像尺寸调整
public class Resize {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        Mat srcImage = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg");
        Mat dstImage = new Mat();

        /**
         Imgproc.resize(Mat src, Mat dst, Size dsize, double fx, double fy, int interpolation)
         参数说明：
             src：源图像
             dst：输出图像
             dsize：输出图像的大小。如果它为0，则计算dsize=new Size(Math.round(fx*src.cols()), Math.round(fy*src.rows()))，其中dsize、fx、fy不能同时为0
             fx：水平方向的方向系数，有默认值0。当fx=0时，会计算fx=(double) dsize.width() / src.cols()
             fy：垂直方向的方向系数，有默认值0。当fy=0时，会计算fy=(double) dsize.height() / src.rows()
             interpolation：插值方式。默认为INTER_LINEAR。可选的插值方式有：INTER_NEAREST（最邻近插值）、INTER_LINEAR（线性插值）、INTER_AREA（区域插值）、INTER_CUBIC（三次样条插值）、INTER_LANCZOS4（Lanczos插值）等
         */
        //缩小一半
        Mat dst = new Mat();
        Imgproc.resize(srcImage, dst, new Size(srcImage.cols()/2,srcImage.rows()/2), 0, 0, Imgproc.INTER_AREA);
        Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\OpenCVResult\\narrow.jpg", dst);

        //放大一倍
        Mat endst = new Mat();
        Imgproc.resize(srcImage, endst, new Size(srcImage.cols()*2,srcImage.rows()*2), 0, 0, Imgproc.INTER_LINEAR);
        Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\OpenCVResult\\enlarge.jpg", endst);

    }

}
