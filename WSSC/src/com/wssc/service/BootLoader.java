package com.wssc.service;

import java.io.File;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.json.JSONObject;

@WebFilter()
public class BootLoader implements Filter
{
	public void init(FilterConfig fConfig) throws ServletException
	{
		// 系统初始化都放在这里
		File appDir = new File(fConfig.getServletContext().getRealPath("/"));
		HtmlGen.i.init(appDir);
		indexApi index = new indexApi();
		JSONObject job = null;
		try
		{
			index.execute(job);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void destroy()
	{
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		chain.doFilter(request, response);
	}


}
