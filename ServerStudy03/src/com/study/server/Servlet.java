package com.study.server;
/**
 * 服务器小脚本接口
 * @author Administrator
 *
 */
public interface Servlet {
	void service(Request request,Response response);
}
