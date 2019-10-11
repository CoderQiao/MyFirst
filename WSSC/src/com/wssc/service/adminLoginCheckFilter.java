package com.wssc.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter({"*.do6"} )
public class adminLoginCheckFilter implements Filter
{
	@Override
	public void init(FilterConfig arg0) throws ServletException
	{		
	}
	
	@Override
	public void destroy()
	{		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain)	throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		if( req.getSession().getAttribute("admin") == null)
		{
			resp.sendRedirect(req.getContextPath()+"/page/login_admin.html");
			return;
		}
		
		chain.doFilter(req, resp);
	}



}
