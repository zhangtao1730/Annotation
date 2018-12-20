/**
 * 
 */
package com.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * @author zhangtao
 *
 */
public class Demo01 {
	public static void main(String[] args) throws IOException {
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		int result=compiler.run(null, null, null, "F:/myJava/HelloWorld.java");
		System.out.println(result==0?"±‡“Î≥…π¶":"±‡“Î ß∞‹");
	
		Runtime run=Runtime.getRuntime();
		Process process=run.exec("java -cp f:/myJava  HelloWorld");
		InputStream in=process.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		String info="";
		while((info=reader.readLine())!=null){
			System.out.println(info);
		}
	}
}
