/**
 * 
 */
package com.study.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * ���Խű�����ִ��javaScript����
 * 
 * @author zhangtao
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException, FileNotFoundException {
		//��ýű��������
		ScriptEngineManager sem=new ScriptEngineManager();
		ScriptEngine engine=sem.getEngineByName("javascript");
	
		//����������洢��������������
		engine.put("msg", "�����յ���");
		String str = "var user = {name:'����',age:18,schools:['�廪','����']};";
		str += "print(user.name);";
		
		//ִ�нű�
		engine.eval(str);
		engine.eval("msg='���κ�����';");
		System.out.println(engine.get("msg"));
		System.out.println("----------------------");
		
		//���庯��
		engine.eval("function add(a,b){var sum=a+b; return sum}");
		//ȡ�õ��ýӿ�
		Invocable jsInvoke=(Invocable) engine;
		//ִ�нű��ж���ķ���
		Object result1=jsInvoke.invokeFunction("add", new Object[]{13,20});
		System.out.println(result1);
		
		//����������Java����ʹ���������е�Java��
		String jsCode="var list= java.util.Arrays.asList([\"����\",\"�廪\"])";
		engine.eval(jsCode);
		List<String> list2=(List<String>)engine.get("list");
		for(String temp:list2){
			System.out.println(temp);
		}
		//ִ��һ��js�ļ�
		URL url=Demo01.class.getClassLoader().getResource("a.js");
		FileReader fr=new FileReader(url.getPath());
		engine.eval(fr);
		
		try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
