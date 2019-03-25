package Imgcodecs;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;

/**
 * 灰度化，图片二值化定义:
 * http://blog.sina.com.cn/s/blog_13c6397540102wqtt.html
 *
 * 参考链接：
 * https://blog.csdn.net/m1109048058/article/details/76241056
 * https://blog.csdn.net/qq_37385726/article/details/82015545
 */

//图片二值化(图像的二值化就是将图像上的像素点的灰度值设置为0或255，这样将使整个图像呈现出明显的黑白效果)
public class Threshold {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        // 加载时灰度
        /**
         Imgcodecs.imwrite(String filename, int flag)
         参数说明
            filename:被读取或者保存的图像文件名
            flag 参数值有三种情况：
                flag>0，该函数返回 3 通道图像，如果磁盘上的图像文件是单通道的灰度图像，则会被强制转为 3 通道；
                flag=0，该函数返回单通道图像，如果磁盘的图像文件是多通道图像，则会被强制转为单通道；
                flag<0，则函数不对图像进行通道转换。
         */
        Mat src = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg", Imgcodecs.IMREAD_GRAYSCALE);
        // 保存灰度
        Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\OpenCVResult\\opencv1Gray.jpg", src);

        // 二值化处理(方法1)
        /**
         Imgproc.threshold(Mat src, Matdst, double thresh, double maxval, int type)
         参数说明：
            src：输入源图像
            dst：输出目标图像
            thresh：手动设置的阈值
            maxval：和type有关，如果type设置为Imgproc.THRESH_BINARY，则二值化图像像素大于阈值的为maxval。如果type设置为Imgproc.THRESH_BINARY_INV，则小于阈值的为maxval
            type：二值类型，决定了该方法的结果
            (THRESH_BINARY:大于阈值的部分被置为255，小于部分被置为0
            THRESH_BINARY_INV:大于阈值部分被置为0，小于部分被置为255
            THRESH_TRUNC:大于阈值部分被置为threshold，小于部分保持原样
            THRESH_TOZERO:小于阈值部分被置为0，大于部分保持不变
            THRESH_TOZERO_INV:大于阈值部分被置为0，小于部分保持不变 )
         */
        Mat target = new Mat();
        Imgproc.threshold(src, target, 0, 255, Imgproc.THRESH_TOZERO_INV | Imgproc.THRESH_OTSU);//灰度图像二值化
        Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\OpenCVResult\\opencv1Threshold.jpg", target);

        // 保存二值化后图片（方法2）
        /**
        Imgproc.adaptiveThreshold(Mat src, Mat dst, double maxValue, int adaptiveMethod, int thresholdType, intblockSize, double C)
        参数说明：
            src：输入源图像
            dst：输出目标图像
            maxval：和thresholdType相关，如果这一参数为 THRESH_BINARY，那么二值化图像像素大于阈值为maxValue，反之参数为THRESH_BINARY_INV，则小于阈值的被赋值为maxValue
            adaptiveMethod：使用哪种自适应阈值算法
            thresholdType：二值类型
            blockSize：对于某个像素，计算其阈值所考虑的阈值范围
            C：从均值中减去的一个常数
         */
        Mat target2 = new Mat();
        Imgproc.adaptiveThreshold(src, target2, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 5, 0);
        // 保存二值化后图片
        Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\OpenCVResult\\opencv1Threshold2.jpg", target2);
    }

}
