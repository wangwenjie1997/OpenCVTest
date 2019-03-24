import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import static org.opencv.highgui.HighGui.*;

public class OpenCVJavaTest{

    // 载入dll（必须先加载）
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        //读入图片
        Mat srcImage = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg");

        if(srcImage.dataAddr()==0)
            System.out.println("图片读入出错");
        else{
            namedWindow("显示图片",WINDOW_NORMAL);
            imshow("显示图片",srcImage);
            waitKey(0);
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