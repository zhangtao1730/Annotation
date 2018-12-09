package com.study.server.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
/**
 * 分发器：加入状态内容处理 404 505和首页
 * @author Administrator
 *
 */
public class Dispatcher implements Runnable{
	private Socket client;
	private Request request;
	private Response response;
	public Dispatcher(Socket client){
		this.client=client;
		try {
			//获取请求协议
			request=new Request(client);
			//获取响应协议
			response=new Response(client);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.release();
		}
	}
	@Override
	public void run() {
		try{
			if(null==request.getUrl()||request.getUrl().equals("")){
				InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("index.html");
				byte[] datas=new byte[1024*1024];
				is.read(datas);
				String res = new String(datas);
				response.print(res);
				response.pushToBrowser(200);
				is.close();
				return;
			}
			Servlet servlet=WebApp.getServletFromUrl(request.getUrl());
			if(null!=servlet){
				servlet.service(request, response);
				response.pushToBrowser(200);
			}else{
				InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("error.html");
				byte[] datas=new byte[1024*1024];
				is.read(datas);
				String res = new String(datas);
				response.print(res);
				//错误
				response.pushToBrowser(404);
				is.close();
			}
		}catch(Exception e){
			try {
				response.println("你好我不好，我会马上好...");
				response.pushToBrowser(500);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		release();
	}
	//释放资源
	private void release(){
		try {
			client.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
