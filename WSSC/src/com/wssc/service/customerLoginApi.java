package com.wssc.service;



import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import com.wssc.model.User;

import af.sql.c3p0.AfSimpleDB;
import af.web.restful.AfRestfulApi;

public class customerLoginApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		String name = jreq.getString("name");
		String password = jreq.getString("password");
		
		// 查询数据库
		String sql = "select * from user where name="+"'"+name+"'";//未取完
		
		System.out.println("顾客登录查询: " + sql);
		User row = (User) AfSimpleDB.get(sql, User.class);
		
		// 认证
		if(row == null)
		{
			throw new Exception("无此用户, 账号为" + name);
		}
		else if(! row.getPassword().equals(password))
		{
			throw new Exception("密码不匹配!");
		}
		
		// 把用户信息保存到当前会话
		HttpSession ss = this.httpReq.getSession();
		ss.setAttribute("user", row); // 放一个User对象
		
		return null;
	}

}
