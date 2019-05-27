package OpenCV.OpenCVFirDemo;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * 光照补偿
 * 参考链接：
 */
public class UnevenLightCompensate {

    public UnevenLightCompensate(String dllPath){
        System.load(dllPath);
    }

    public static void main(String[] args) {
        UnevenLightCompensate demo=new UnevenLightCompensate("D:\\Program Files\\opencv\\build\\java\\x64\\opencv_java401.dll");
        //读入图片
        Mat src = Imgcodecs.imread("F:\\opencvPhoto\\photo\\14.jpg");

        int blockSize=32;

        if(src.channels()==3)
            Imgproc.cvtColor(src,src,Imgproc.COLOR_BGR2GRAY);

        double average= Core.mean(src).val[0];

        int rows_new= (int) Math.ceil(src.rows() /blockSize);
        int cols_new = (int) Math.ceil(src.cols() /blockSize);

        Mat blockImage=new Mat(rows_new, cols_new, CvType.CV_32FC1);

        for (int i = 0; i < rows_new; i++)
        {
            for (int j = 0; j < cols_new; j++)
            {
                int rowmin = i*blockSize;
                int rowmax = (i + 1)*blockSize;
                if (rowmax > src.rows())
                    rowmax = src.rows();
                int colmin = j*blockSize;
                int colmax = (j + 1)*blockSize;
                if (colmax > src.cols())
                    colmax = src.cols();
                Rect rect=new Rect(new Point(colmin,rowmin),new Point(colmax,rowmax));
                Mat imageROI =new Mat(src,rect);
                double temaver = Core.mean(imageROI).val[0];
                blockImage.put(i, j,temaver-average);
            }
        }

        Mat blockImage2=new Mat();
        Imgproc.resize(blockImage, blockImage2, src.size(), 0,0, Imgproc.INTER_CUBIC);
        Mat image2=new Mat();
        src.convertTo(image2,CvType.CV_32FC1);
        Mat dst =new Mat();
        Core.subtract(image2,blockImage2,dst);
        dst.convertTo(src, CvType.CV_8UC1);

        Imgcodecs.imwrite("F:\\opencvPhoto\\result\\demo.jpg",dst);
    }

}
