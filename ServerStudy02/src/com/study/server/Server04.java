package com.study.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 目标：封装请求信息中参数转成map
 * @author Administrator
 *
 */
public class Server04 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		Server04 server=new Server04();
		server.start();
	}
	//启动服务
	public void start(){
		try {
			serverSocket=new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			System.out.println("服务器启动失败");
		}
	}
	//接受连接处理
	public void receive(){
		try {
			Socket client=serverSocket.accept();
			System.out.println("一个客户端建立了连接...");
			//获取请求协议
			Request2 request=new Request2(client);
			
			Response response=new Response(client);
			//关注内容
			response.print("<html>");
			response.print("<head>");
			response.print("<title>");
			response.print("服务器响应成功");
			response.print("</title>");
			response.print("</head>");
			response.print("<body>");
			response.print("终于回来了。。。"+request.getParameter("uname"));
			response.print("</body>");
			response.print("</html>");
			//关注了状态
			response.pushToBrowser(200);
		} catch (IOException e) {
			System.out.println("客户端错误");
		}
	}
	//停止服务
	public void stop(){
		
	}
}
