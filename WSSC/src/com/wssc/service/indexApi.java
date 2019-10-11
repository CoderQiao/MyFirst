package com.wssc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.wssc.model.Cloth;
import com.wssc.model.Elecpro;

import af.sql.c3p0.AfSimpleDB;
import af.web.restful.AfRestfulApi;

public class indexApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		String sqlEle = "select * from elecpro limit 4";
		String sqlClo = "select * from cloth limit 4";
		List<Elecpro> elecs = AfSimpleDB.query(sqlEle,Elecpro.class);
		List<Cloth> cloths = AfSimpleDB.query(sqlClo,Cloth.class);
		
//		//处理图片路径
//		for(Elecpro elec:elecs){
//			String picturePath = elec.picturePath;
//			elec.picturePath = picturePath.split("/", 2)[1];
//		}
//		for(Cloth clo:cloths){
//			String picturePath = clo.picturePath;
//			clo.picturePath = picturePath.split("/", 2)[1];
//		}
		
		
		//生产静态HTML
		// 模板路径 
		String templatePath = "/product/template/index_template.shtml";
		
		// 输出的HTML路径
		String htmlPath = "index.shtml";
		
		// Data Model
		HashMap<String,Object> model = new HashMap<String,Object>();
		model.put("elecs", elecs);
		model.put("cloths", cloths);
		//model.put("basePath", httpReq.getContextPath()+"/"); // 末尾必须加斜杠
		
		System.out.print("生成静态页:" + htmlPath + " ...");
		HtmlGen.i.generate(templatePath, htmlPath, model);

		return null;
	}

}
