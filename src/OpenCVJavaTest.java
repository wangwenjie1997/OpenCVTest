import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import static org.opencv.highgui.HighGui.*;

//OpenCV图像读入，显示，输出
public class OpenCVJavaTest{

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        //读入图片(该函数是根据图像文件的内容来确定文件格式，而不是根据文件的扩展名来确定)
        Mat srcImage = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg");
        if(srcImage.empty())
            System.out.println("图片读入出错");
        else{
            //显示图片
//            namedWindow("显示图片",WINDOW_NORMAL);
            imshow("显示图片",srcImage);
            waitKey(0);
            //保存图片(文件的格式由 filename 参数指定的文件扩展名确定)
            if(Imgcodecs.imwrite("C:\\Users\\Administrator\\Desktop\\OCRResult\\test.bmp", srcImage))
                System.out.println("图片保存成功");
            else
                System.out.println("图片保存失败");
        }

        srcImage.release();

//        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
//        System.out.println("mat = " + mat.dump());
    }
}