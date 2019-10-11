package com.wssc.service;

import org.json.JSONObject;

import af.sql.c3p0.AfSimpleDB;
import af.web.restful.AfRestfulApi;

public class productDeleteApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		int proID = jreq.getInt("proID");
		String data1 = jreq.getString("data1");
		if(data1.equals("elec")){
			String sql = "delete from elecpro where eleID=" + proID;
			AfSimpleDB.execute(sql);
		}
		if(data1.equals("cloth")){
			String sql = "delete from cloth where cloID=" + proID;
			AfSimpleDB.execute(sql);
		}
		
		return null;
	}
}
