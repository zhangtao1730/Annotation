package com.study.test.annotation;
@MyAnnotation01
public class Demo02 {
	@MyAnnotation01(age=19,studentName="张三",
			id=1001,schools={"南大","浙大"})
	public void test(){
		
	}
	@MyAnnotation02("aaa")
	public void test2(){
		
	}
}
