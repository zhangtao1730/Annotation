/**
 * 
 */
package com.study.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.study.test.bean.User;

/**
 * 通过反射API动态的操作：构造器、方法、属性
 * @author zhangtao
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		//动态操作构造器
		String path="com.study.test.bean.User";
		try {
			Class<User> clazz=(Class<User>) Class.forName(path);
			//通过反射API调用构造方法，构造对象
			User u=clazz.newInstance();
			System.out.println(u);
			User u2=clazz.getDeclaredConstructor(int.class,int.class,String.class).newInstance(1001,18,"张三");
			System.out.println(u2.getUname()+"-->"+u2.getAge());
		
			//通过反射API调用普通方法
			User u3=clazz.newInstance();
			Method method=clazz.getDeclaredMethod("setUname", String.class);
			method.invoke(u3, "李四");//u3.setUname("李四");
			System.out.println(u3.getUname());
			
			//通过反射API操作属性
			User u4=clazz.newInstance();
			Field f=clazz.getDeclaredField("uname");
			f.setAccessible(true);//这个属性不需要做安全检查，可以直接访问
			f.set(u4, "王五");//通过反射直接写属性
			System.out.println(u4.getUname());//通过反射直接读属性的值
			System.out.println(f.get(u4));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
