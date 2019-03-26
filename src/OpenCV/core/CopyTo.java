package OpenCV.core;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;

import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;

/**
 * 参考链接:
 * https://blog.csdn.net/sinat_36264666/article/details/77414835
 */
//利用ROI图像叠加
public class CopyTo {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        //读入图片(src1尺寸小，src2尺寸大)
        Mat src1 = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg");
        Mat src2 = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\timg.jpg");

        Rect rect = new Rect(100,100,src1.cols(),src1.rows());//x,y坐标，宽，高
        /**
         Q：关于获取ROI，融合后对源图像的影响？
         A：ROI像素的任何转换都会被应用在原始图像中的相应位置中去，因为原始图像和ROI区域共享的是相同的图像数据。因为定义ROI区域是并不复制数据,无论ROI区域的大小，它在一个固定的时间被执行
         */
        Mat roi_img = new Mat(src2,rect);//(个人理解:roi_img是src2的rect区域的像素点阵，这个像素点阵可以被其他像素点阵替换掉)


        /**
         copyTo(Mat m, Mat mask)
         使用方法
            Mat mat.copyTo(Mat m, Mat mask)
         使用说明
            将mat复制到m中
         参数说明
            mask:掩模(需要是灰度图->图片读入时flags为0或者图片进行灰度化处理)
                mask作为一个掩模板。函数会检测mask中如果在某个像素点(i, j)其值为1（只看第一通道，所以mask单通道即可）则把srcImage.at(i, j)处的值直接赋给dstImage.at(i, j)；如果其值为0则dstImage.at(i, j)处保留其原始像素值。

         */

        //替换观察代码
//         Mat src3 = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\OpenCVResult\\ROI.bmp");
//         src3.copyTo(roi_img);//roi_img被替换成了src1，同时src2的rect区域被替换成src1

        src1.copyTo(roi_img);//roi_img被替换成了src1，同时src2的rect区域被替换成src1(可替换成上面的代码来观察窗口显示的ROI)

        imshow("ROI",roi_img);
        imshow("显示图片",src2);
        waitKey(0);
    }

}
