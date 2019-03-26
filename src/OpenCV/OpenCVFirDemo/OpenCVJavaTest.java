package OpenCV.OpenCVFirDemo;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import static org.opencv.highgui.HighGui.*;

/**
 * 参考链接:
 * https://blog.csdn.net/wangwenjie1997/article/details/88778155
 */

//OpenCV图像读入，显示，输出
public class OpenCVJavaTest{

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        //读入图片(该函数是根据图像文件的内容来确定文件格式，而不是根据文件的扩展名来确定)
        /**
         Imgcodecs.imread(String filename, int flags)
         参数说明
             filename:图片读入路径
             flags:flags:表示载入标识，指定加载图像的颜色类型，默认为三通道彩色图像
                flags常用标志符：
                    CV_LOAD_IMAGE_UNCHANGED——等价取值为-1
                    CV_LOAD_IMAGE_GRAYSCALE——等价取值为0，将图像转化为灰度
                    CV_LOAD_IMAGE_COLOR——等价取值为1，将图像转化为彩色
                    CV_LOAD_IMAGE_ANYDEPTH——等价取值为2，当载入图像深度为16位或32位，返回对应深度的图像，否则转化为8位图像返回
                    CV_LOAD_IMAGE_ANYCOLOR——等价取值为4，无损的源图像
                    当输入有冲突时，采用较小数字值。CV_LOAD_IMAGE_COLOR|CV_LOAD_IMAGE_ANYCOLOR将载入三通道图；CV_LOAD_IMAGE_ANYDEPTH|CV_LOAD_IMAGE_ANYCOLOR将载入最真实无损的源图像。

                    若以数值表示，则：
                    flags>0返回一个3通道的彩色图像
                    flags=0返回灰度图像
                    flags<0返回包含Alpha通道的加载图像当以彩色载入时，通道顺序为BGR(蓝、绿、红)，而非RGB。
         */
        Mat srcImage = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg");
        if(srcImage.empty())
            System.out.println("图片读入出错");
        else{
            //显示图片
            /**
             namedWindow(String winname, int flags)
             参数说明
                winname:填写窗口名称，将被用作窗口标志符
                flags:窗口标志类型：
                    WINDOW_NORMAL，可改变窗口大小
                    WINDOW_AUTOSIZE（值为1），窗口大小会自动调整以适应所要显示的图像，且用户无法手动调整
                    WINDOW_OPENGL，窗口创建时将支持OpenGL
             */
            namedWindow("显示图片",WINDOW_NORMAL);
            /**
             imshow(String winname, Mat img)
             参数说明
                winname:填需要显示的窗口标志名称(需要与namedWindow的winname一致)
                img:填需要显示的图像
             */
            imshow("显示图片",srcImage);

            //等待按下函数：参数如果写负数或者0。当显示图片后，按下任意键后程序退出。如果参数写为3000就是3秒后程序自动退出。
            waitKey(0);

            //保存图片(文件的格式由 filename 参数指定的文件扩展名确定)
            /**
             Imgcodecs.imwrite(String filename, Mat img, MatOfInt params)
             参数说明
                 filename：填写要写入的文件名，需带上后缀，即文件类型名
                 img：需要输出的图像，一般为Mat类型
                 params：特定格式保存的参数编码，一般不需要填写
             */
            if(Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\OCRResult\\test.bmp", srcImage))
                System.out.println("图片保存成功");
            else
                System.out.println("图片保存失败");
        }

        srcImage.release();

    }
}