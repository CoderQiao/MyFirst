package com.wssc.service;



import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.wssc.model.Admin;

import af.sql.c3p0.AfSimpleDB;
import af.sql.util.*;
import af.web.restful.AfRestfulApi;


public class adminLoginApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		String name = jreq.getString("username");
		String password = jreq.getString("password");
		
		// 查询数据库
		AfSqlWhere asw = new AfSqlWhere();
		asw.add2("username", name);
		
		String sql = "select * from admin " + asw;
		System.out.println("Admin登录查询: " + sql);
		Admin row = (Admin) AfSimpleDB.get(sql, Admin.class);
		
		// 认证
		if(row == null)
		{
			throw new Exception("无此用户, admin=" + name);
		}
		else if(! row.getPassword().equals(password))
		{
			throw new Exception("密码不匹配!");
		}
		
		// 把用户信息保存到当前会话
		HttpSession ss = this.httpReq.getSession();
		ss.setAttribute("admin", row); // 放一个Admin对象
		
		return null;
	}

}
