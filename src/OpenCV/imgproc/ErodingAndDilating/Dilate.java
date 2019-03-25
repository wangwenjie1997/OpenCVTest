package OpenCV.imgproc.ErodingAndDilating;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * 参考链接:
 * https://blog.csdn.net/kksc1099054857/article/details/76569718
 * https://blog.csdn.net/m1109048058/article/details/76640714
 */
//膨胀
public class Dilate {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {

        Mat srcImage = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg");
        Mat dstImage = new Mat();

        /**
         返回指定形状或尺寸的内核矩阵
         Imgproc.getStructuringElement(int shape, Size ksize, Point anchor)
         参数说明
         shape:在opencv3.2.0中有多达11种取值，这里给出三种：Imgproc.MORPH_RECT（矩形）、Imgproc.MORPH_CROSS（交叉形）、Imgproc.MORPH_ELLIPSE（椭圆形）
         ksize:内核的尺寸
         anchor:内核的锚点位置,默认值Point(-1,-1)表示锚点位于结构元素中心。
         */
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3, 3));

        /**
         腐蚀
         Imgproc.dilate(Mat src, Mat dst, Mat kernel, Point anchor, int iterations, int borderType, Scalar borderValue)
         参数说明
         src：输入源图像
         dst：输出目标图像
         kernel：膨胀操作的核，当为Null时，表示的是使用参考点位于中心的3x3的核。我们一般使用getStructuringElement配合这个参数使用
         anchor：锚的位置，默认值为（-1，-1），表示锚位于中心
         iterations：迭代使用膨胀的次数，默认为1
         borderType：推断外部像素的某种边界模式，默认值为BORDER_DEFAULT
         borderValue：当边界为常数时的边界值，有默认值，一般不去管它
         */
        Imgproc.dilate(srcImage, dstImage, element, new Point(-1, -1), 1);
        Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\OpenCVResult\\opencvDilate.jpg", dstImage);


    }
}
