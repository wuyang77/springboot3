package com.wuyang;

/**
 * 打包成本地镜像
 * 1.打成jar包：注意修改 jar包内的MANIFEST.MF 文件， 指定Main-Class的全类名
 *      - java -jar xxx.jar 就可以执行
 * 2.打成本地镜像，可执行文件
 *      - 切换机器，安装java环境。默认解释执行，启动速度慢，运行速度慢
 *      - native-image  -cp 你的jar包/路径 你的主类 -o 输出的文件名
 *      并不是所有的Java代码都支持本地打包：SpringBoot保证Spring应用的所有程序都能在AOT的时候提前告知graalvm怎么处理？
*         - 动态能力： 反射的代码：（动态获取构造器，反射创建对象，反射调用一些方法）
*         - 额外处理（SpringBoot通过了一些额外的注解）： 提前告知graalvm反射会用到哪些方法
*         - 配置文件损失：
*             - 解决方案（）：额外处理（）：提前告知graalvm配置文件怎么读取
*             - 二进制里面不能包含的，不能动态的都得提前处理
 *      不是所有框架都是赔了AOT特性：Spring全系类栈适配OK
 */
public class MainApplication {

  public static void main(String[] args) {
    System.out.println("Hello World");
  }
}
