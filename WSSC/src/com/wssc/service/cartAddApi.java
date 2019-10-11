package com.wssc.service;

import java.util.Date;

import org.json.JSONObject;

import com.wssc.model.Bill;
import com.wssc.model.Cart;
import com.wssc.model.Elecpro;

import af.sql.c3p0.AfSimpleDB;
import af.web.restful.AfRestfulApi;

public class cartAddApi extends AfRestfulApi
{

	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		int id = Integer.parseInt(jreq.getString("id"));
		int price = Integer.parseInt(jreq.getString("price"));
		int number = Integer.parseInt(jreq.getString("number"));
		String title = jreq.getString("title");
		String information = jreq.getString("information");
		String picturePath = jreq.getString("picturePath");
		
		Cart cart = new Cart();
		cart.setGoodID(id);
		cart.setTitle(title);
		cart.setPrice(price);
		cart.setPicturePath(picturePath);
		cart.setUserID(1);
		cart.setNumber(number);
		
		
		AfSimpleDB.insert(cart);
		
		return null;
	}

}
