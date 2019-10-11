package com.wssc.service;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import af.sql.c3p0.AfSimpleDB;
import af.sql.util.*;
import af.web.restful.AfRestfulApi;

public class adminLogoutApi extends AfRestfulApi
{
	
	@Override
	public Object execute(JSONObject jreq) throws Exception
	{
		HttpSession ss = this.httpReq.getSession();
		ss.removeAttribute("admin"); 
		
		return null;
	}

}
