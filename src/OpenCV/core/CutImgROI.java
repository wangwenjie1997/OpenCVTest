package OpenCV.core;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;

import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;

/**
 * 参考链接：
 * https://blog.csdn.net/tryflys/article/details/78921347
 * https://blog.csdn.net/sinat_36264666/article/details/77414835
 */
//图像裁剪
public class CutImgROI {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        Mat srcImage = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg");
        Mat dst=new Mat();
        Rect rect = new Rect(100,100,50,50);//x,y坐标起点，宽，高
        Mat imgROI = new Mat(srcImage, rect);
        imgROI.copyTo(dst);//可以注解掉

        imshow("裁剪前",srcImage);
        imshow("裁剪后",dst);
        waitKey(0);
    }

}
