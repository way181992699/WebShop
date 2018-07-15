package com.hd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.hd.model.McType;
import com.hd.service.IMcTypeService;
import com.hd.service.impl.McTypeServiceImpl;
import com.hd.util.WebUtil;

/**
 * Servlet 商品类别
 */
@WebServlet("/back/McTypeServlet")
public class McTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	IMcTypeService service = new McTypeServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取请求的类型
		String task = request.getParameter("task");
		PrintWriter out = response.getWriter();
		if("getFatherType".equals(task)){
			// 表示查询所有的商品大类
			// 1.查询出所有的大类
			List<McType> list = service.queryFather();
			// 2.把查询的数据保存到作用域中
			request.setAttribute("list", list);
			// 3.跳转到添加商品类别的jsp页面
			request.getRequestDispatcher("mctype/McTypeAdd.jsp").forward(request, response);
		}else if("ajaxFather".equals(task)){
			// ajax获取所有的商品大类
			List<McType> list = service.queryFather();
			// 将查询的list数据转化成json格式的字符串
			JSONArray json = new JSONArray(list);
			// 将请求的数据返回给客户端
			out.write(json.toString());
			out.flush();
			out.close();
		}else if("ajaxSmall".equals(task)){
			// 根据大类编号获取对应的所有的商品小类
			String id = request.getParameter("id");
			List<McType> list = service.queryByFatherId(WebUtil.parserInt(id));
			// 将List转化成为json格式的字符串
			JSONArray json = new JSONArray(list);
			out.write(json.toString());
			out.flush();
			out.close();
		}else if("add".equals(task)){
			// 表示添加新的商品类别数据
			// 1.获取表单提交的数据
			String typeName = request.getParameter("typename");
			String fatherid = request.getParameter("fatherid");
			McType type = new McType();
			type.setTypename(typeName);
			type.setFatherid(WebUtil.parserInt(fatherid));
			// 2.调用service中的方法保存数据
			service.add(type);
			// 3.跳转到查询界面  提取公共代码封装成方法 ctrl+1 
			query(request, response);

		}else if("getTypeId".equals(task)){
			// 进入更新界面前查询相关的信息
			// 获取传递过来的类别编号
			String typeid = request.getParameter("typeid");
			// 根据id查询出类别信息
			McType type = service.queryById(WebUtil.parserInt(typeid));
			// 查询出所有的大类信息
			List<McType> list = service.queryFather();
			// 将查询的数据保存到作用域中
			request.setAttribute("type", type);
			request.setAttribute("list", list);
			// 跳转到更新界面
			request.getRequestDispatcher("mctype/McTypeUpdate.jsp").forward(request, response);
		}else if("update".equals(task)){
			// 表示更新数据
			// 1.获取表单提交的数据
			String typeName = request.getParameter("typename");
			String fatherid = request.getParameter("fatherid");
			String typeid = request.getParameter("typeid");
			// 2.调用service的方法保存
			service.update(new McType(WebUtil.parserInt(typeid),typeName,WebUtil.parserInt(fatherid)));
			// 3.跳转回查询界面
			query(request, response);
		}else if("delete".equals(task)){
			// 表示根据id删除记录 删除大类的时候如果有关联的小类一并删掉
			// 1.获取提交id
			String typeid = request.getParameter("typeid");
			// 2.调用方法删除
			service.delete(WebUtil.parserInt(typeid));
			// 3.跳转回查询界面
			query(request, response);
		}else{
			query(request, response);

		}
	}

	/**
	 * 查询所有的商品类别的数据
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.通过service中的方法查询出所有的商品类别的信息
		List<McType> list = service.queryAll();
		// 2.将查询的结果保存到作用域中
		request.setAttribute("list", list);
		// 3.跳转到McType.jsp页面
		request.getRequestDispatcher("mctype/ShowMcType.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
