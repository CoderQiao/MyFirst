package com.wssc.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wssc.model.Elecpro;

import af.sql.c3p0.AfSimpleDB;
import af.sql.util.AfSqlWhere;
import af.web.AfFormData;
import af.web.freemarker.AfSimpleMVC;

/**
 * Servlet implementation class elecListServlet
 */
@WebServlet("/admin.do")
public class productListMVC extends AfSimpleMVC {

	
	@Override
	protected String execute(HttpServletRequest req, HttpServletResponse resp, Map<String, Object> model)
			throws Exception
	{
		String sqlElec = "select * from elecpro order by eleID";
		String sqlCloth = "select * from cloth order by cloID";
		//String sqlUser = "select * from user order by userID";
		String sqlBill = "select * from bill order by billID";
		String sqlCountEle = "select count(*) from elecpro";
		String sqlCountclo = "select count(*) from cloth";
		List<Map> elecs = AfSimpleDB.query(sqlElec,0);
		List<Map> clothes = AfSimpleDB.query(sqlCloth,0);
		//List<Map> users = AfSimpleDB.query(sqlUser,0);
		List<Map> bills = AfSimpleDB.query(sqlBill,0);
		String[] eleNum = AfSimpleDB.get(sqlCountEle);
		String[] cloNum = AfSimpleDB.get(sqlCountclo);
		int eleCount = 0;
		int cloCount = 0;
		if(eleNum!=null)eleCount=Integer.parseInt(eleNum[0]);
		if(cloNum!=null)cloCount=Integer.parseInt(cloNum[0]);
		
		// 从URL里获取参数
		AfFormData query = AfFormData.parse(req.getQueryString(), "UTF-8");
		int pageNumber = query.getInt("p", 1);
		String userName = query.getString("userName", "");
		// 查询条件 (暂无)
				AfSqlWhere asw = new AfSqlWhere();
				if(userName.length() > 0)
					asw.addLike("name", "%" + userName + "%");
				
				// 页码计算
				int count = getCount(asw.toString()); // 一共多少条记录
				int pageSize = 10; // 每页显示多少条
				int pageCount = count / pageSize; // 一共多少页
				if (count % pageSize != 0)
					pageCount += 1;

				// 排序
				String order = " ORDER BY userID ";
				// 条数限制
				String limit = String.format(" LIMIT %d,%d ", pageSize * (pageNumber - 1), pageSize);

				String sql = "select * from user " + asw + order + limit;
				System.out.println("查询: " + sql);

				// 查询, 每一行转成  Map
				List<Map> users = AfSimpleDB.query(sql, 0);


				// 数据放在 model里
				model.put("count", count);
				model.put("pageNumber", pageNumber);
				model.put("pageCount", pageCount);
				model.put("users", users);
				model.put("userName", userName);
				
				
		
		model.put("elecs", elecs);
		model.put("clothes", clothes);
	//	model.put("users", users);
		model.put("bills", bills);
		model.put("eleCount", eleCount);
		model.put("cloCount", cloCount);
		return "/page/index_admin.html";
	}

	// 使用 SQL 里的 COUNT 函数来查询一共有多少条记录
	private int getCount(String where) throws Exception
	{
		String sql = " select count(userID) from user " + where;
		String[] row = AfSimpleDB.get(sql);
		if(row != null)
		{
			return Integer.valueOf( row[0]);
		}
		return 0;
	}

}
