package com.wssc.service;

import java.util.Date;
import java.util.HashMap;

import org.json.JSONObject;

import com.wssc.model.Cloth;
import com.wssc.model.Elecpro;

import af.sql.c3p0.AfSimpleDB;
import af.web.restful.AfRestfulApi;


public class productUpdateApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		int id = jreq.getInt("id");
		int price = jreq.getInt("price");
		int remain = jreq.getInt("remain");
		String information = jreq.getString("information"); // 原始的文件名
		String title = jreq.getString("title");
		String pictureName = jreq.getString("pictureName");
		String picturePath = jreq.getString("picturePath");
		String type = jreq.getString("type");
		
		String infor = "'"+information+"'";
		String ti = "'"+title+"'";
		String picNa = "'"+pictureName+"'";
		String picPa = "'"+picturePath+"'";
		String ty = "'"+type+"'";
		
		if(type.equals("elec")){
			String sql = "update elecpro set title="+ti+",information="+infor+",pictureName="+picNa
					+",picturePath="+picPa+",price="+price+",remainNum="+remain+" where eleID="+id ;
			AfSimpleDB.execute(sql);
			
			Elecpro ele = new Elecpro();
			ele.setTitle(title);
			ele.setInformation(information);
			ele.setPictureName(pictureName);
			ele.setPicturePath(picturePath);
			ele.setPrice(price);
			ele.setRemainNum(remain);
			ele.setAddTime(new Date());
			//生成静态网页
			generateStaticHtml(id,ele,"ele");
		}
		if(type.equals("cloth")){
			String sql = "update cloth set title="+ti+",information="+infor+",pictureName="+picNa
					+",picturePath="+picPa+",price="+price+",remainNum="+remain+" where cloID="+id ;
			AfSimpleDB.execute(sql);
			
			Cloth clo = new Cloth();
			clo.setTitle(title);
			clo.setInformation(information);
			clo.setPictureName(pictureName);
			clo.setPicturePath("cloth/"+pictureName);
			clo.setPrice(price);
			clo.setRemainNum(remain);
			clo.setAddTime(new Date());
			//生成静态网页
			generateStaticHtml(id,clo,"cloth");
		}
		
		
		return null;
	}
	
	private void generateStaticHtml (int id, Object product,String type) throws Exception
	{
		// 模板路径 ( 注：模板内容与上一章有变化）
		String templatePath = "/product/template/product_template.shtml";
		
		// 输出的HTML路径
		String htmlPath = String.format("/product/view/%d_%s.shtml", id,type);
		
		// Data Model
		HashMap<String,Object> model = new HashMap<String,Object>();
		model.put("product", product);
		model.put("basePath", httpReq.getContextPath()+"/"); // 末尾必须加斜杠
		
		
		System.out.print("生成静态页:" + htmlPath + " ...");
		HtmlGen.i.generate(templatePath, htmlPath, model);
	}

}