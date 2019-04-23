package OpenCV.imgproc;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * 洪水填充
 *      又叫水漫填充，用特定的颜色填充连通区域，常用来标记或分离图像的一部分。
 *      漫水填充，将种子点颜色相近的区域进行连通，类似 photoshop 的魔术棒工具。
 * 参考链接：https://my.oschina.net/u/3767256/blog/1802234
 *          https://blog.csdn.net/poem_qianmo/article/details/28261997
 */
public class FloodFill {

    // 载入dll（必须先加载）,不写报java.lang.UnsatisfiedLinkError
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {

        //读入图片
        Mat src = Imgcodecs.imread("C:\\Users\\Administrator\\Desktop\\mytest\\test.jpg");

        /*
         * 官方说明 : https://docs.opencv.org/3.0-beta/modules/imgproc/doc/miscellaneous_transformations.html#floodfill
         *
         * 原型方法 :
         *      floodFill(Mat image, Mat mask, Point seedPoint, Scalar newVal)  这个原型方法，用参数测试了下，没效果。不知道原因。
         *      floodFill(Mat image, Mat mask, Point seedPoint, Scalar newVal, Rect rect, Scalar loDiff, Scalar upDiff, int flags)
         *
         *      参数 :
         *          image : Mat 输入图像 输入/输出图像，1通道或3通道，8位图像
         *          mask : Mat 操作掩膜，单通道，8位，比image 长宽都大2个像素的图像。
         *          seedPoint : Point ,起始点,漫水填充的种子点
         *          newVal : Scalar ,像素点被染色的值，即通过起始点漫水填充后的区域填充的颜色
         *          rect : Rect ,不传的话，默认为0。设置漫水填充的最小区域。如果设置了，而漫水填充找出的区域 < rect 那么不会填充。
         *          loDiff : Scalar ,在当前观察到的像素和它的一个相邻的像素点之间的最大亮度/颜色的负差 最大值。
         *          upDiff : Scalar ,在当前观察到的像素和它的一个相邻的像素点之间的最大亮度/颜色的正差 最大值。
         *          flags : int ,操作标识符。参看下面示例
         *
         *          一般不需要borderType，borderValue，均有默认值。如果需要使用，可参考官网获取更多信息
         */

        // mask 单通道，8位图，比原始图片宽高多2像素
        Mat mask = new Mat(src.height()+2,src.width()+2 , CvType.CV_8UC1);
        Point seedPonit = new Point(30,35);
        Scalar loDiff = new Scalar(20,20,20); //没怎么明白，建议要了解的看下官方说明
        Scalar upDiff = new Scalar(20,20,20); //没怎么明白，建议要了解的看下官方说明
        /*
         * flags 此参数参看示例设置
         *
         * 分别分为3个部分，低、高、中，参数之间用为运算符号 "|" （按位或）链接
         *
         * 1. 低八位
         *      -- 可选值： 4 、8 ，2个选项。
         *      -- 4 只计算水平、垂直方向，8 多了个对角线方向
         * 2. 高八位
         *      -- 可选值 ，0 或 FLOODFILL_MASK_ONLY 、 FLOODFILL_FIXED_RANGE，除0外，2个常量可以组合或单独使用
         *      -- FLOODFILL_MASK_ONLY  不会填充原始图，只填充 mask 。 即 newVal 参数会失效
         *      -- FLOODFILL_FIXED_RANGE 设置后：会考虑当前像素与种子像素之间的色差，不设置：会考虑当前像素与邻近像素之间的差。
         * 3. 中八位
         *      -- 当高八位设置成 FLOODFILL_MASK_ONLY 时，由于不填充 src，填充 mask，而 mask 为单通道，newVal 为 RGB，所以不适用，导致 newVal 失效。
         *          这里就给一个值，用于填充 mask 。
         *      -- 如果为 0 ，则 mask 会用1来填充
         *      -- 注意，非0 的情况，中八位的值要填充高八位，需要向左位移8位。如填充 值为38 ，38二进制位 100110 , 向左位移8位 10011000000000
         */
        int flags = 8 | Imgproc.FLOODFILL_MASK_ONLY | Imgproc.FLOODFILL_FIXED_RANGE | (38<<8);
        // flags 计算规则(位运算)
        // 原始数字                                      二进制
        // 8                                     =                    1000
        // Imgproc.FLOODFILL_MASK_ONLY = 131072  =      100000000000000000
        // Imgproc.FLOODFILL_FIXED_RANGE = 65536 =       10000000000000000
        // 38<<8 = 100110 << 8                   =          10011000000000
        //
        // 按位或（"|"）计算：                            110010011000001000

        System.out.println(flags);

        Rect rect = new Rect(2,2,1,1);

        Scalar newVal = new Scalar(0,0,255);

        //这个原型方法，用参数测试了下，没效果。不知道原因。
//        Imgproc.floodFill(src,mask,seedPonit,newVal);

        Imgproc.floodFill(src,mask,seedPonit,newVal,rect,loDiff,upDiff,flags);
        Imgcodecs.imwrite("F:\\opencvPhoto\\result\\floodFill1.jpg", src);
        Imgcodecs.imwrite("F:\\opencvPhoto\\result\\floodFill2.jpg", mask);

    }

}
