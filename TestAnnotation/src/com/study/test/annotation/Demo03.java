package com.study.test.annotation;

import java.lang.annotation.Annotation;

/**
 * ʹ�÷����ȡע�����Ϣ��ģ�⴦��ע����Ϣ������
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		try {
			Class clazz=Class.forName("com.study.test.annotation.Student");
			//������������Чע��
			Annotation[] annotations=clazz.getAnnotations();
			for(Annotation a:annotations){
				System.out.println(a);
			}
			//������ָ��ע��
			Table st=(Table)clazz.getAnnotation(Table.class);
			System.out.println(st.value());
			//��������Ե�ע��
			java.lang.reflect.Field f=clazz.getDeclaredField("name");
			Field field=f.getAnnotation(Field.class);
			System.out.println(field.columnName()+"-->"+field.type()+"-->"+field.length());
		
			//���ݻ�õı������ֶε���Ϣ��ƴ��DDL��䣬ʹ��JDBCִ��SQL,�����ݿ���������صı�
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
