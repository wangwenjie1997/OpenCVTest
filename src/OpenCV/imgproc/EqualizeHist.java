package OpenCV.imgproc;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

/**
 * 直方图增强图像
 * 参考链接：https://blog.csdn.net/dcrmg/article/details/53677739
 */
public class EqualizeHist {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        //读入图片
        Mat src = Imgcodecs.imread("F:\\opencvPhoto\\photo\\14.jpg");

        List<Mat> channels=new ArrayList<Mat>();
        Core.split(src, channels);

        for (int i = 0; i < 3; i++) {
            Imgproc.equalizeHist(channels.get(i), channels.get(i));
        }
        Core.merge(channels, src);
        Imgcodecs.imwrite("F:\\opencvPhoto\\result\\merge.jpg", src);

    }

}
