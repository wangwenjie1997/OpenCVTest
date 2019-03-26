package OpenCV.core;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import static org.opencv.core.Core.addWeighted;
import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;

/**
 * 参考链接:
 * https://blog.csdn.net/farmwang/article/details/73967728
 * https://blog.csdn.net/sinat_36264666/article/details/77102735
 * https://blog.csdn.net/alzm006/article/details/80800107
 * https://www.cnblogs.com/polly333/p/4794196.html
 *
 *
 * https://blog.csdn.net/sinat_36264666/article/details/77414835
 */
//两幅图像求和
public class AddWeighted {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        //读入图片
        Mat src1 = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg");
        Mat src2 = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\timg.jpg");

        /**
         addWeighted(Mat src1, double alpha, Mat src2, double beta, double gamma, Mat dst, int dtype)
         参数说明
         src1:输入图片1
         alpha:表示第一个数组的权重,图片1的融合比例
         src2:输入图片2
         beta:表示第二个数组的权重值,图片2的融合比例
         gamma:一个加到权重总和上的标量值
         dst:输出的数组，它和输入的两个数组拥有相同的尺寸和通道数
         dtype:输出阵列的可选深度，有默认值-1。;当两个输入数组具有相同的深度时，这个参数设置为-1（默认值），即等同于src1.depth（）
         */

        //如果图像大小不相等会报错
        //解决方法一：通过resize将图片缩放到想同大小
        Imgproc.resize(src1, src1, new Size(src2.cols(),src2.rows()));
        Core.addWeighted(src1,0.5,src2,0.3,0,src2);


        //解决方法二：利用ROI,ROI功能请看core.CopyTo(src1的尺寸小，src2的尺寸大)
//        Rect rect = new Rect(100,100,src1.cols(),src1.rows());//x,y坐标，宽，高
//        Mat roi_img = new Mat(src2,rect);//(个人理解:roi_img是src2的rect区域的像素点阵，这个像素点阵可以被其他像素点阵替换掉)
//        Core.addWeighted(src1,0.5,roi_img,0.3,0,roi_img);//将src1和roi_img混合输出到roi_img中，因为roi_img指向的是src1的矩阵部分所以出现混合效果



        imshow("显示图片",src2);
        waitKey(0);
    }

}
