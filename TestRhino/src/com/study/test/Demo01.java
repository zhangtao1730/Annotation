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
 * 测试脚本引擎执行javaScript代码
 * 
 * @author zhangtao
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException, FileNotFoundException {
		//获得脚本引擎对象
		ScriptEngineManager sem=new ScriptEngineManager();
		ScriptEngine engine=sem.getEngineByName("javascript");
	
		//定义变量，存储到引擎上下文中
		engine.put("msg", "锄禾日当午");
		String str = "var user = {name:'张三',age:18,schools:['清华','北大']};";
		str += "print(user.name);";
		
		//执行脚本
		engine.eval(str);
		engine.eval("msg='汗滴禾下土';");
		System.out.println(engine.get("msg"));
		System.out.println("----------------------");
		
		//定义函数
		engine.eval("function add(a,b){var sum=a+b; return sum}");
		//取得调用接口
		Invocable jsInvoke=(Invocable) engine;
		//执行脚本中定义的方法
		Object result1=jsInvoke.invokeFunction("add", new Object[]{13,20});
		System.out.println(result1);
		
		//导入其他的Java包，使用其他包中的Java类
		String jsCode="var list= java.util.Arrays.asList([\"北大\",\"清华\"])";
		engine.eval(jsCode);
		List<String> list2=(List<String>)engine.get("list");
		for(String temp:list2){
			System.out.println(temp);
		}
		//执行一个js文件
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
