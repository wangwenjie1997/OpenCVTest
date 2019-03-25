package OpenCV.imgproc.ImageSmoothing;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * 参考链接:
 * https://blog.csdn.net/m1109048058/article/details/76539705
 */
//中值滤波[中值滤波将图像的每个像素用邻域 (以当前像素为中心的正方形区域)像素的中值代替]
//能有效的消除椒盐噪声
public class MedianBlur {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        Mat srcImage = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\medianBlur.png");
        Mat dstImage = new Mat();

        /**
         中值滤波
         Imgproc.medianBlur(Mat src, Mat dst, Size ksize, int ksize)
         参数说明
            src：输入源图像
            dst：输出目标图像
            ksize: 滤波模板的尺寸大小，必须是大于1的奇数，如3、5、7……
         */
        Imgproc.medianBlur(srcImage, dstImage, 7);
        Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\OpenCVResult\\medianBlurResult.jpg", dstImage);

    }

}
