package com.study.user;

import com.study.server.core.Request;
import com.study.server.core.Response;
import com.study.server.core.Servlet;

public class RegisterServlet implements Servlet {

	@Override
	public void service(Request request,Response response) {
		//关注业务逻辑
		String uname =request.getParameter("uname");
		String[] favs=request.getParameterValues("fav");
		response.println("你注册的信息为："+uname);
		for(String v:favs){
			if(v=="0"){
				response.println("女神为：张均甯");
			}else if(v=="1"){
				response.println("女神为：陈意涵");
			}else{
				response.println("女神为：林依晨");
				
			}
		}
	}

}
