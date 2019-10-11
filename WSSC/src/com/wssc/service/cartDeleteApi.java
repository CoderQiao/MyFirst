package com.wssc.service;

import org.json.JSONObject;

import af.sql.c3p0.AfSimpleDB;
import af.web.restful.AfRestfulApi;

public class cartDeleteApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		int cartID = jreq.getInt("cartID");
		String sql = "delete from cart where cartID="+cartID;
		AfSimpleDB.execute(sql);
		return null;
	}

}
