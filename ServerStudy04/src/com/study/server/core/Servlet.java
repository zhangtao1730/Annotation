package com.study.server.core;
/**
 * 服务器小脚本接口
 * @author Administrator
 *
 */
public interface Servlet {
	void service(Request request,Response response);
}
