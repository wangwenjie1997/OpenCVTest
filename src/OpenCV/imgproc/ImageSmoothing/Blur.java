package OpenCV.imgproc.ImageSmoothing;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;

/**
 * 参考链接:
 * https://blog.csdn.net/m1109048058/article/details/76531738
 */

//均值滤波[最简单的滤波器，输出像素值是核窗口内像素值的均值(所有像素加权系数相等)]
public class Blur {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        Mat srcImage = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg");
        Mat dstImage = new Mat();

        /**
         Imgproc.blur(Mat src, Mat dst, Size ksize, Point anchor, int borderType)
         参数说明
             src：输入源图像
             dst：输出目标图像
             ksize：内核的大小
             anchor：锚点，有默认值new Point(-1,-1)，代表核的中心
             borderType：推断图像外部像素的边界模式，有默认值Core.BORDER_DEFAULT
                 BORDER_REPLICATE：复制法，既是复制最边缘像素，例如aaa|abc|ccc
                 BORDER_REFLECT：对称法，例如cba|abc|cba
                 BORDER_REFLECT_101：对称法，最边缘像素不会被复制，例如cb|abc|ba
                 BORDER_CONSTANT：常量法，默认为0
                 BORDER_WRAP：镜像对称复制
         */
        Imgproc.blur(srcImage, dstImage, new Size(9,9), new Point(-1, -1), Core.BORDER_DEFAULT);
        Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\OpenCVResult\\opencv1Blur.jpg", dstImage);

    }

}
