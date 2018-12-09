package com.study.test.annotation;

import java.lang.annotation.Annotation;

/**
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		try {
			Class clazz=Class.forName("com.study.test.annotation.Student");
			//获得类的所有有效注解
			Annotation[] annotations=clazz.getAnnotations();
			for(Annotation a:annotations){
				System.out.println(a);
			}
			//获得类的指定注解
			Table st=(Table)clazz.getAnnotation(Table.class);
			System.out.println(st.value());
			//获得类属性的注解
			java.lang.reflect.Field f=clazz.getDeclaredField("name");
			Field field=f.getAnnotation(Field.class);
			System.out.println(field.columnName()+"-->"+field.type()+"-->"+field.length());
		
			//根据获得的表名，字段的信息，拼出DDL语句，使用JDBC执行SQL,在数据库中生成相关的表
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
