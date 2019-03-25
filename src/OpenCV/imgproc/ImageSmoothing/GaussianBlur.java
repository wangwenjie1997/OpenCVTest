package OpenCV.imgproc.ImageSmoothing;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;

/**
 * 参考链接:
 * https://blog.csdn.net/m1109048058/article/details/76534468
 */

//高斯滤波[最有用的滤波器 (尽管不是最快的)。高斯滤波是将输入数组的每一个像素点与高斯内核卷积将卷积和当作输出像素值。]
public class GaussianBlur {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        Mat srcImage = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg");
        Mat dstImage = new Mat();

        /**
        Imgproc.GaussianBlur(Mat src, Mat dst, Size ksize, double sigmaX, double sigmaY, int borderType)
        参数说明：
            src：输入源图像
            dst：输出目标图像
            ksize：内核模板大小
            sigmaX：高斯内核在X方向的标准偏差
            sigmaY：高斯内核在Y方向的标准偏差。如果sigmaY为0，他将和sigmaX的值相同，如果他们都为0，那么他们由ksize.width和ksize.height计算得出
            borderType： 用于判断图像边界的模式
         */
        Imgproc.GaussianBlur(srcImage, dstImage, new Size(9,9), 0, 0, Core.BORDER_DEFAULT);
        Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\OpenCVResult\\opencv1GaussianBlur.jpg", dstImage);

    }

}
