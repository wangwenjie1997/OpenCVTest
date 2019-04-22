package OpenCV.OpenCVFirDemo;

import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

import static org.opencv.highgui.HighGui.waitKey;

//加载OpenCV的dll方法二
public class DemoTwo {

    public static void main(String[] args) {
        //加载dll
        System.load("D:\\Program Files\\opencv\\build\\java\\x64\\opencv_java401.dll");
        //读入图片
        Mat src = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\timg.jpg");
        HighGui.imshow("显示图片",src);
        waitKey(0);
    }

}
