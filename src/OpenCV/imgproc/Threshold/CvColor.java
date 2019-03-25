package OpenCV.imgproc.Threshold;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * 灰度化，图片二值化定义:
 *http://blog.sina.com.cn/s/blog_13c6397540102wqtt.html
 *
 * 参考链接:
 * https://blog.csdn.net/m1109048058/article/details/76474850
 */

//灰度化
//让像素点矩阵中的每一个像素点都满足下面的关系：R=G=B（就是红色变量的值，绿色变量的值，和蓝色变量的值，这三个值相等，“=”的意思不是程序语言中的赋值，是数学中的相等），此时的这个值叫做灰度值
public class CvColor {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        //读入图片
        Mat srcImage = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg");
        Mat dstImage = new Mat();
        //灰度化
        /**
         Imgproc.cvtColor(Mat src, Mat dst, int code, int dstCn)
         参数说明
             src：输入源图像
             dst：输出的目标图像
             code：code是一个掩码，表示由src到dst之间是怎么转的，比如是彩色转为灰度，还是彩色转为HSI模式。code的模式如：Imgproc.COLOR_BGR2GRAY：<彩色图像转灰度图像>
             dstCn：dst图像的波段数，这个值默认是0
         */
        Imgproc.cvtColor(srcImage, dstImage, Imgproc.COLOR_BGR2GRAY,0);
        Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\OpenCVResult\\opencv1Gray.jpg", dstImage);

    }

}
