package com.wssc.service;


import java.io.File;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import com.wssc.model.Cloth;
import com.wssc.model.Elecpro;

import af.sql.c3p0.AfSimpleDB;
import af.web.restful.AfRestfulApi;


/** 图片入库
 * 文件从 WebRoot/tmp/ 转移到 WebRoot/data/ ，同时在数据库里插入记录
 * @author shaofa
 *
 */
public class productAddApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		int price = jreq.getInt("price");
		int remain = jreq.getInt("remain");
		String tmpPath = jreq.getString("tmpPath"); // 临时文件路径
		String information = jreq.getString("information"); // 原始的文件名
		String title = jreq.getString("title");
		String pictureName = jreq.getString("pictureName");
		String type = jreq.getString("type");
		
		String docBase = httpReq.getServletContext().getRealPath("/");
		//源文件
		File docBaseDir = new File(docBase);
		File srcFile = new File(docBaseDir, tmpPath);
		String fileName = srcFile.getName();
		
		if(type.equals("elec")){
			File dstDir = new File(docBaseDir, "elec");
			dstDir.mkdirs();
			FileUtils.moveFileToDirectory(srcFile, dstDir, true);
			
			Elecpro ele = new Elecpro();
			ele.setTitle(title);
			ele.setInformation(information);
			ele.setPictureName(pictureName);
			ele.setPicturePath("elec/"+fileName);
			ele.setPrice(price);
			ele.setRemainNum(remain);
			ele.setAddTime(new Date());
			
			// 插入到数据库
			AfSimpleDB.insert(ele);
			String sql_max_id = "SELECT MAX(eleID) FROM elecpro";
			String[] max_id = AfSimpleDB.get(sql_max_id);
			int id = Integer.parseInt(max_id[0]);
			System.out.print(id);
			//生成静态网页
			generateStaticHtml(id,ele,"ele");
		}
		if(type.equals("cloth")){
			File dstDir = new File(docBaseDir, "cloth");
			dstDir.mkdirs();
			FileUtils.moveFileToDirectory(srcFile, dstDir, true);
			Cloth clo = new Cloth();
			clo.setTitle(title);
			clo.setInformation(information);
			clo.setPictureName(pictureName);
			clo.setPicturePath("cloth/"+fileName);
			clo.setPrice(price);
			clo.setRemainNum(remain);
			clo.setAddTime(new Date());
			
			// 插入到数据库
			AfSimpleDB.insert(clo);
			
			String sql_max_id = "select max(cloID) from cloth";
			String[] max_id = AfSimpleDB.get(sql_max_id);
			int id = Integer.parseInt(max_id[0]);
			System.out.print(id);
			//生成静态网页
			generateStaticHtml(id,clo,"cloth");
		}
		

		return null;
		
	}
	
	private void generateStaticHtml (int id, Object product,String type) throws Exception
	{
		// 模板路径 
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
