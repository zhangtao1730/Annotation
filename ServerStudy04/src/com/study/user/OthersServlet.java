package com.study.user;

import com.study.server.core.Request;
import com.study.server.core.Response;
import com.study.server.core.Servlet;

public class OthersServlet implements Servlet {

	@Override
	public void service(Request request,Response response) {
		response.print("其他测试页面");
	}

}
