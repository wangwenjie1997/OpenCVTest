package OpenCV.imgproc.ImageSmoothing;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.nio.ByteBuffer;

/**
 * 参考链接:
 * https://blog.csdn.net/xmfthu/article/details/15027195
 * https://blog.csdn.net/keith_bb/article/details/53103026
 */
//创建自己的线性滤波器
public class Filter2D {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        //读入图片
        Mat srcImage = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg");
        Mat dstImage = new Mat();

        //创建自己的内核
        Mat mask=Mat.eye(3, 3, CvType.CV_8UC1);
        mask.put(0,0,new byte[]{0, -1 ,0, -1, 5, -1, 0, -1, 0});

        /**
         Imgproc.filter2D(Mat src, Mat dst, int ddepth, Mat kernrl, Point anchor, double delta, int borderType)
         参数说明
             src：输入源图像
             dst：输出目标图像
             ddepth: 目标图像深度，如果没写将生成与原图像深度相同的图像。原图像和目标图像支持的图像深度如下：
                 src.depth() = CV_8U, ddepth = -1/CV_16S/CV_32F/CV_64F
                 src.depth() = CV_16U/CV_16S, ddepth = -1/CV_32F/CV_64F
                 src.depth() = CV_32F, ddepth = -1/CV_32F/CV_64F
                 src.depth() = CV_64F, ddepth = -1/CV_64F
                 当ddepth输入值为-1时，目标图像和原图像深度保持一致。
            kernel: 卷积核（或者是相关核）,一个单通道浮点型矩阵。如果想在图像不同的通道使用不同的kernel，可以先使用split()函数将图像通道事先分开
            anchor: 内核的基准点(anchor)，其默认值为(-1,-1)说明位于kernel的中心位置。基准点即kernel中与进行处理的像素点重合的点
            delta: 在储存目标图像前可选的添加到像素的值，默认值为0
            borderType: 像素向外逼近的方法，默认值是BORDER_DEFAULT,即对全部边界进行计算
         */
        Imgproc.filter2D (srcImage,dstImage,srcImage.depth (),mask);

        Imgproc.pyrUp(srcImage, dstImage,new Size(srcImage.cols()*2,srcImage.rows()*2));
        Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\OpenCVResult\\opencv1Filter2D.jpg", dstImage);

    }

}
