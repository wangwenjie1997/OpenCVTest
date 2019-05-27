# OpenCV教程链接 
链接: 
http://www.opencv.org.cn/opencvdoc/2.3.2/html/doc/tutorials/tutorials.html  
https://docs.opencv.org/3.4.1/index.html 
https://blog.csdn.net/sinat_36264666 CSDN拜小白OpenCV教程 
源码学习:https://github.com/liuqi0725/OpenCV3-Study-JAVA 
https://opencv-java-tutorials.readthedocs.io/en/latest/

- 1 OpenCVFirDemo OpenCV基础操作 
    - 1.1 OpenCVJavaTest：OpenCV图像读入，显示，输出 
    - 1.2 CrateMat 创建自定义Mat，修改Mat特定位置像素值 
    - 1.3 UnevenLightCompensate光照补偿
- 2 imgproc 模块图像处理(在这一部分你将学习OpenCV中的图像处理函数) 
    - 2.1 ImageSmoothing(图像平滑处理,学习一些简单的线性滤波器)  
        - 2.1.1 Blur 均值滤波 
        - 2.1.2 GaussianBlur 高斯滤波 
        - 2.1.3 MedianBlur 中值滤波 
        - 2.1.4 Filter2D 创建自己的线性滤波器
    - 2.2 ErodingAndDilating 腐蚀与膨胀 
        - 2.2.1 Erode 腐蚀 
        - 2.2.2 Dilate 膨胀 
    - 2.3 Resize 图像尺寸调整
        - 2.3.1 Resize 图像尺寸调整
        - 2.3.2 PyrDown 高斯图像金字塔-缩小过程
        - 2.3.3 PyrUp 高斯图像金字塔-扩大过程 
    - 2.4 Threshold 基本的阈值操作 
        - 2.4.1 CvColor 是将一个图像从一个颜色空间转换到另一个颜色空间 
        - 2.4.2 Threshold 二值化  
    -2.5 FloodFill 洪水填充 
    -2.6 MatchTemplate 特征匹配 
    -2.7 Canny
- 3 core OpenCV核心模块 
    - 3.1 AddWeighted 两幅图像求和 
    - 3.2 CutImgROI 图形裁剪 
    - 3.3 CopyTo 利用ROI进行图像叠加
    - 3.4 SplitAndMerge 通道混合与分离 
    - 3.5 InRange颜色分割(获取图片平均亮度) 
    
    
开运算：先腐蚀后膨胀-->去除孤立小点、毛刺、小桥而总的位置形状不变 
闭运算：先膨胀后腐蚀-->填充物体影像内细小空洞，连接邻近物体和平滑边界



