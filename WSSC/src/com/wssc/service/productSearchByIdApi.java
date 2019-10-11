package com.wssc.service;

import org.json.JSONObject;

import com.wssc.model.Cloth;
import com.wssc.model.Elecpro;

import af.sql.c3p0.AfSimpleDB;
import af.web.restful.AfRestfulApi;

public class productSearchByIdApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		int id = jreq.getInt("id");
		String type = jreq.getString("type");
		if(type.equals("elec")){
			String sql = "select * from elecpro where eleID="+id;
			Elecpro elec = (Elecpro) AfSimpleDB.get(sql,Elecpro.class);
			JSONObject ele = new JSONObject(elec);
			return ele;
		}
		if(type.equals("cloth")){
			String sql = "select * from cloth where cloID="+id;
			Cloth cloth = (Cloth) AfSimpleDB.get(sql,Cloth.class);
			JSONObject clo = new JSONObject(cloth);
			return clo;
		}
		
		return null;
	}

}
