package OpenCV.OpenCVFirDemo;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

/**
 * 参考链接:
 * https://blog.csdn.net/u012343179/article/details/68060880
 * https://my.oschina.net/drjones/blog/312876
 */
//创建自定义Mat
public class CrateMat {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);//3行3列，矩阵元素类型(1通道，8位无符号)
        System.out.println("起始mat = " + mat.dump());//矩阵打印

        mat.put(0,0,new byte[]{1,2,3,4,5,6,7,8,9});//0行0列开始设置矩阵元素
        System.out.println("赋值后mat = " + mat.dump());//矩阵打印

        //获得特定位置像素(个人理解可能会有多通道所以为数组)
        double[] doubles = mat.get(0, 0);
        System.out.println("特定位置像素信息");
        for(int i=0;i<doubles.length;i++)
            System.out.println(i+"   "+doubles[i]);

        //修改特定位置像素值
        mat.put(0,0,255);
        System.out.println("修改特定位置像素信息后mat = " + mat.dump());//矩阵打印
    }
}
