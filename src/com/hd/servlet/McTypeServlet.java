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
 * Servlet ��Ʒ���
 */
@WebServlet("/back/McTypeServlet")
public class McTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	IMcTypeService service = new McTypeServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ���������
		String task = request.getParameter("task");
		PrintWriter out = response.getWriter();
		if("getFatherType".equals(task)){
			// ��ʾ��ѯ���е���Ʒ����
			// 1.��ѯ�����еĴ���
			List<McType> list = service.queryFather();
			// 2.�Ѳ�ѯ�����ݱ��浽��������
			request.setAttribute("list", list);
			// 3.��ת�������Ʒ����jspҳ��
			request.getRequestDispatcher("mctype/McTypeAdd.jsp").forward(request, response);
		}else if("ajaxFather".equals(task)){
			// ajax��ȡ���е���Ʒ����
			List<McType> list = service.queryFather();
			// ����ѯ��list����ת����json��ʽ���ַ���
			JSONArray json = new JSONArray(list);
			// ����������ݷ��ظ��ͻ���
			out.write(json.toString());
			out.flush();
			out.close();
		}else if("ajaxSmall".equals(task)){
			// ���ݴ����Ż�ȡ��Ӧ�����е���ƷС��
			String id = request.getParameter("id");
			List<McType> list = service.queryByFatherId(WebUtil.parserInt(id));
			// ��Listת����Ϊjson��ʽ���ַ���
			JSONArray json = new JSONArray(list);
			out.write(json.toString());
			out.flush();
			out.close();
		}else if("add".equals(task)){
			// ��ʾ����µ���Ʒ�������
			// 1.��ȡ���ύ������
			String typeName = request.getParameter("typename");
			String fatherid = request.getParameter("fatherid");
			McType type = new McType();
			type.setTypename(typeName);
			type.setFatherid(WebUtil.parserInt(fatherid));
			// 2.����service�еķ�����������
			service.add(type);
			// 3.��ת����ѯ����  ��ȡ���������װ�ɷ��� ctrl+1 
			query(request, response);

		}else if("getTypeId".equals(task)){
			// ������½���ǰ��ѯ��ص���Ϣ
			// ��ȡ���ݹ����������
			String typeid = request.getParameter("typeid");
			// ����id��ѯ�������Ϣ
			McType type = service.queryById(WebUtil.parserInt(typeid));
			// ��ѯ�����еĴ�����Ϣ
			List<McType> list = service.queryFather();
			// ����ѯ�����ݱ��浽��������
			request.setAttribute("type", type);
			request.setAttribute("list", list);
			// ��ת�����½���
			request.getRequestDispatcher("mctype/McTypeUpdate.jsp").forward(request, response);
		}else if("update".equals(task)){
			// ��ʾ��������
			// 1.��ȡ���ύ������
			String typeName = request.getParameter("typename");
			String fatherid = request.getParameter("fatherid");
			String typeid = request.getParameter("typeid");
			// 2.����service�ķ�������
			service.update(new McType(WebUtil.parserInt(typeid),typeName,WebUtil.parserInt(fatherid)));
			// 3.��ת�ز�ѯ����
			query(request, response);
		}else if("delete".equals(task)){
			// ��ʾ����idɾ����¼ ɾ�������ʱ������й�����С��һ��ɾ��
			// 1.��ȡ�ύid
			String typeid = request.getParameter("typeid");
			// 2.���÷���ɾ��
			service.delete(WebUtil.parserInt(typeid));
			// 3.��ת�ز�ѯ����
			query(request, response);
		}else{
			query(request, response);

		}
	}

	/**
	 * ��ѯ���е���Ʒ��������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.ͨ��service�еķ�����ѯ�����е���Ʒ������Ϣ
		List<McType> list = service.queryAll();
		// 2.����ѯ�Ľ�����浽��������
		request.setAttribute("list", list);
		// 3.��ת��McType.jspҳ��
		request.getRequestDispatcher("mctype/ShowMcType.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
