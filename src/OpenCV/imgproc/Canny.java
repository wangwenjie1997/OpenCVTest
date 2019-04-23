package OpenCV.imgproc;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * 边缘检测
 */
public class Canny {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        //读入图片
        Mat src = Imgcodecs.imread("F:\\opencvPhoto\\result\\result.jpg");
        //将原始图转化为灰度图
        Imgproc.cvtColor(src, src, Imgproc.COLOR_BGR2GRAY);

        //先使用3*3内核来降噪
        Imgproc.blur(src, src, new Size(3, 3));

        //运行canny算子
        /**
         *  图像的边缘检测的原理是检测出图像中所有灰度值变化较大的点，而且这些点连接起来就构成了若干线条，这些线条就可以称为图像的边缘
         函数原型：

         void cvCanny(

         const CvArr* image,  //第一个参数表示输入图像，必须为单通道灰度图
         CvArr* edges,        //第二个参数表示输出的边缘图像，为单通道黑白图
         double threshold1,
         double threshold2,    //第三个参数和第四个参数表示阈值，这二个阈值中当中的小阈值用来控制边缘连接，
                             大的阈值用来控制强边缘的初始分割即如果一个像素的梯度大与上限值，则被认为
                             是边缘像素，如果小于下限阈值，则被抛弃。如果该点的梯度在两者之间则当这个
                             点与高于上限值的像素点连接时我们才保留，否则删除。
         int aperture_size=3    //第五个参数表示Sobel 算子大小，默认为3即表示一个3*3的矩阵。Sobel 算子与
                            高斯拉普拉斯算子都是常用的边缘算子
         );
         */
        Imgproc.Canny(src, src, 3, 9, 3);

        Imgcodecs.imwrite("F:\\opencvPhoto\\result\\canny.jpg", src);
    }

}
