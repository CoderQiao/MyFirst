package com.wssc.service;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import af.sql.c3p0.AfSimpleDB;
import af.web.freemarker.AfSimpleMVC;

@WebServlet("/cart.do")
public class cartListMVC extends AfSimpleMVC
{

	@Override
	protected String execute(HttpServletRequest jreq, HttpServletResponse resp, Map<String, Object> model)
			throws Exception
	{
		int userID = 1;
		String sql = "select * from cart where userID="+userID;
		List<Map> products = AfSimpleDB.query(sql,0);
		model.put("products", products);
		return "/page/shopingCart.html";
	}

}
