package com.wssc.service;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import af.web.restful.AfRestfulApi;

public class customerLogoutApi extends AfRestfulApi
{
	
	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		HttpSession ss = this.httpReq.getSession();
		ss.removeAttribute("user"); 
		
		return null;
	}

}
