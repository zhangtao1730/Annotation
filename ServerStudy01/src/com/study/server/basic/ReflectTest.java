package com.study.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * ���䣺��Java���еĸ��ֽṹ(���������ԣ�������������)ӳ���һ������java����
 * 1.��ȡClass����
 * ���ַ�ʽ��
 *  1.����.getClass();
 *  2.��.class();
 * 	3.Class.forName("����·��") (�Ƽ�)
 * 2.���Զ�̬��������
 * 	1.clz.newInstance();
 * 	2.clz.getConstructor().newInstance(); (java9 �Ƽ�)
 * @author Administrator
 *
 */
public class ReflectTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//���ַ�ʽ
		//1.����.getClass();
		Iphone iphone=new Iphone();
		Class clz=iphone.getClass();
		//2.��.class();
		clz=Iphone.class;
		//3.Class.forName("����.����");
		clz=Class.forName("com.study.server.basic.Iphone");
		
		//��������
/*		Iphone iphone2=(Iphone)clz.newInstance();
		System.out.println(iphone2);*/
		Iphone iphone2=(Iphone)clz.getConstructor().newInstance();
		System.out.println(iphone2);
		
	}
}
class Iphone{
	public Iphone(){
		
	}
}