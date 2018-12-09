package com.study.server;

import java.io.IOException;
import java.net.Socket;
/**
 * 分发器
 * @author Administrator
 *
 */
public class Dispatcher1 implements Runnable{
	private Socket client;
	private Request request;
	private Response response;
	public Dispatcher1(Socket client){
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
			Servlet servlet=WebApp.getServletFromUrl(request.getUrl());
			if(null!=servlet){
				servlet.service(request, response);
				response.pushToBrowser(200);
			}else{
				//错误
				response.pushToBrowser(404);
			}
		}catch(Exception e){
			try {
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
