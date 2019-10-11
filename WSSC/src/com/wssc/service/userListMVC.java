package com.wssc.service;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wssc.model.User;

import af.sql.c3p0.AfSimpleDB;
import af.web.freemarker.AfSimpleMVC;

@WebServlet("/customerInfor.do")
public class userListMVC extends AfSimpleMVC
{

	@Override
	protected String execute(HttpServletRequest arg0, HttpServletResponse arg1, Map<String, Object> model)
			throws Exception
	{
		int userID = 1;
		String sqlBill = "select * from bill where userID="+userID;
		String sqlUser = "select * from user where userID="+userID;
		List<Map> bills = AfSimpleDB.query(sqlBill,0);
		User user = (User) AfSimpleDB.get(sqlUser,User.class);
		model.put("bills", bills);
		model.put("user", user);
		return "/page/customerInfor.html";
	}

}
