package OpenCV.imgproc.ImageSmoothing;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


/**
 * 参考链接:
 * https://blog.csdn.net/duwangthefirst/article/details/79971369
 * https://blog.csdn.net/cau_eric/article/details/28295899
 */
//双边滤波
public class BilateralFilter {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        Mat srcImage = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg");
        Mat dstImage = new Mat();

        /**
         双边滤波
         Imgproc.bilateralFilter(Mat src, Mat dst, int d, double sigmaColor, double sigmaSpace)
         参数说明
            src：输入源图像
            dst：输出目标图像
            d:过滤期间使用的各像素邻域的直径
            sigmaColor:色彩空间的sigma参数，该参数较大时，各像素邻域内相距较远的颜色会被混合到一起，从而造成更大范围的半相等颜色
            sigmaSpace:坐标空间的sigma参数，该参数较大时，只要颜色相近，越远的像素会相互影响


         一般来说，要想得到比较好的结果，3、4、5参数最好都指定。
         第三个参数如果设定值大于5，那计算会很慢，所以一般设置都等于5，如果少数情况需要去除比较大的噪声，那么d=9,。
         */
        Imgproc.bilateralFilter(srcImage,dstImage,5,5*2,5/2);
        Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\OpenCVResult\\opencv1BilateralFilter.jpg", dstImage);

    }

}
