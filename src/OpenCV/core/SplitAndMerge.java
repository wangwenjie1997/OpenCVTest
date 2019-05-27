package OpenCV.core;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

import java.util.ArrayList;
import java.util.List;

import static org.opencv.core.Core.merge;
import static org.opencv.core.Core.split;
import static org.opencv.core.CvType.CV_8UC1;
import static org.opencv.core.CvType.CV_8UC3;
import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.highgui.HighGui.waitKey;

/**
 * 参考链接:
 * https://blog.csdn.net/sinat_36264666/article/details/76933106
 * https://blog.csdn.net/sinat_36264666/article/details/77413165
 * https://blog.csdn.net/u013195275/article/details/79867781
 */
//通道混合与分离
public class SplitAndMerge {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        Mat srcImage = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\photo\\opencv1.jpg");
        imshow("原始图", srcImage);

        List<Mat> channels=new ArrayList<Mat>();//可以理解为存放Mat类型的容器
        split(srcImage, channels);  //对原图像进行通道分离，即把一个3通道图像转换成为3个单通道图像channels[0],channels[1] ,channels[2]
        imshow("分离的B通道", channels.get(0));
        imshow("分离的G通道", channels.get(1));
        imshow("G分离的R通道", channels.get(2));
        Mat hideChannel=new Mat(srcImage.size(), CV_8UC1, new Scalar(0));//需要隐藏的通道。尺寸与srcImage相同，单通道黑色图像。
        List<Mat> mgbr=new ArrayList<Mat>();//创建类型为Mat，数组长度为3的变量mbgr

        //注意：0通道为B分量，1通道为G分量，2通道为R分量。因为：RGB色彩空间在opencv中默认通道顺序为BGR！！！
        //【1】显示彩色的B-蓝色分量。
        Mat imageB=new Mat(srcImage.size(), CV_8UC3);	//创建尺寸与srcImage相同，三通道图像imageB
        mgbr.add(channels.get(0));
        mgbr.add(hideChannel);
        mgbr.add(hideChannel);
        merge(mgbr, imageB);

        imshow("imageB-蓝色通道", imageB);
        waitKey(0);
    }

}
