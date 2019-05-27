package OpenCV.imgproc.Threshold;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * 参考链接：https://blog.csdn.net/qq_37385726/article/details/82017177
 */
public class AdaptiveThreshold {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        // 加载时灰度
        Mat src = Imgcodecs.imread("F:\\opencvPhoto\\photo\\46.jpg", Imgcodecs.IMREAD_GRAYSCALE);
        /*
        //灰度化
        Mat gray=new Mat();
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
        */
        //自适应阈值化
        Mat target = new Mat();
        Imgproc.adaptiveThreshold(src, target, 255, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, Imgproc.THRESH_BINARY, 25, 5);
        Imgproc.medianBlur(target, target, 5);

        // 保存二值化后图片
        Imgcodecs.imwrite("F:\\opencvPhoto\\result\\target.jpg", target);
    }

}
