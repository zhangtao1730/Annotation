package com.study.test.annotation;
@MyAnnotation01
public class Demo02 {
	@MyAnnotation01(age=19,studentName="����",
			id=1001,schools={"�ϴ�","���"})
	public void test(){
		
	}
	@MyAnnotation02("aaa")
	public void test2(){
		
	}
}
