package OpenCV.core;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * 颜色分割
 * 参考链接：https://blog.csdn.net/github_39611196/article/details/80315218
 * HSV色彩空间：http://www.cnblogs.com/wangyblzu/p/5710715.html
 */
public class InRange {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        //读入图片
        Mat src = Imgcodecs.imread("F:\\opencvPhoto\\photo\\14.jpg");

        /**
         * 获取图片平均亮度
         */

//        Mat gray=new Mat();
//        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
//        Scalar scalar=Core.mean(gray);
//        System.out.println(scalar.val[0]);

        //修改亮度对比度
        //-1表示与原图类型一致，alpha对比度，beta亮度
        src.convertTo(src, -1, 1, 50);
        Imgcodecs.imwrite("F:\\opencvPhoto\\result\\convertTo.jpg", src);

        //RGB->HSV
        Mat imgHSV = new Mat();
        Imgproc.cvtColor(src, imgHSV, Imgproc.COLOR_BGR2GRAY);

        //HSV色域的黑色范围
        Scalar minValues = new Scalar(0, 0, 0);
        Scalar maxValues = new Scalar(180,255,46);
        Mat dst = new Mat();
        Core.inRange(imgHSV, minValues, maxValues, dst);//颜色范围内变成白色，范围外变成黑色
        Imgcodecs.imwrite("F:\\opencvPhoto\\result\\InRange.jpg", dst);

    }

}
