package com.study.test;
/**
 * 测试java.lang.Class对象的获取方式
 * @author zhangtao
 *
 */
@SuppressWarnings("all")
public class Demo01 {
	public static void main(String[] args) {
		String path="com.study.test.bean.User";
		try {
			Class clazz=Class.forName(path);
			//对象是表示或封装一些数据。一个类被加载后，JVM会创建一个对应该类的Class对象，类的整个结构信息会放到对应的Class对象中。
			//这个Class对象就像一面镜子一样，通过这面镜子我可以看到对应类的全部信息。
			System.out.println(clazz.hashCode());
			
			Class clazz2=Class.forName(path);//一个类只对应一个Class对象
			System.out.println(clazz2.hashCode());
			
			Class strClazz=String.class;
			Class strClazz2=path.getClass();
			System.out.println(strClazz==strClazz2);
			
			Class intClazz=int.class;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
