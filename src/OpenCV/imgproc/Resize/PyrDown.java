package OpenCV.imgproc.Resize;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import static javax.swing.text.StyleConstants.Size;

/**
 * 参考链接:
 * https://blog.csdn.net/woainishifu/article/details/62888228
 */
//高斯图像金字塔-缩小过程
public class PyrDown {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        //读入图片
        Mat srcImage = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg");
        Mat dstImage = new Mat();
        //缩小过程
        /**
         Imgproc.pyrDown(Mat src, Mat dst, Size dstsize)
         参数说明
         src：输入源图像
         dst：输出的目标图像
         dstsize：降采样之后的目标图像的大小，默认值为Size((src.cols+1)/2, (src.rows+1)/2)
         */
        Imgproc.pyrDown(srcImage, dstImage,new Size(srcImage.cols()/2,srcImage.rows()/2));
        Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\OpenCVResult\\opencv1PyrDown.jpg", dstImage);

    }

}
