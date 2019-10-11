package com.wssc.service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import af.sql.c3p0.AfSimpleDB;
import af.web.restful.AfRestfulApi;

public class billDeleteApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		JSONArray ja = jreq.getJSONArray("id_array");
		ArrayList al = (ArrayList) ja.toList();
		String ids = "";
		for(int i=0;i<al.size();i++){
			if(i==0)ids+="("+al.get(0);
			else ids += "," + (String) al.get(i);
		}
		ids +=")";


		System.out.print("删除订单："+ids);
		String sql = "delete from bill where billID in"+ids;
		AfSimpleDB.execute(sql);
		
		return null;
	}

}
