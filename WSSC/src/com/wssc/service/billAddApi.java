package com.wssc.service;

import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import com.wssc.model.Bill;
import com.wssc.model.Cart;
import com.wssc.model.Elecpro;

import af.sql.c3p0.AfSimpleDB;
import af.web.restful.AfRestfulApi;

public class billAddApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		JSONArray ja = jreq.getJSONArray("id_array");
		ArrayList al = (ArrayList) ja.toList();
		String ids = "";
		for(int i=0;i<al.size();i++){
			//添加账单
			
			int cartID = Integer.parseInt((String) al.get(i));
			String sql = "select * from cart where cartID="+cartID;
			try{
			Cart cart = (Cart) AfSimpleDB.get(sql, Cart.class);
			Bill bill = new Bill();
			bill.setGoodID(cart.getGoodID());
			bill.setTitle(cart.getTitle());
			bill.setPrice(cart.getPrice());
			bill.setPicturePath(cart.getPicturePath());
			bill.setBuyTime(new Date());
			bill.setUserID(1);
			bill.setName("qiao");
			bill.setNumber(cart.getNumber());
			AfSimpleDB.insert(bill);
			}catch(Exception e){
				throw new Exception("请选择要购买的的商品！");
			}
			//删除购物车中商品信息
			if(i==0)ids+="("+al.get(0);
			else ids += "," + (String) al.get(i);
		}
		ids +=")";
		System.out.print("删除购物车商品："+ids);
		String sqlCartDelete = "delete from cart where cartID in"+ids;
		AfSimpleDB.execute(sqlCartDelete);
		return null;
	}

}
