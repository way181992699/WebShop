package com.hd.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hd.model.Mc;
import com.hd.service.IMcService;
import com.hd.service.impl.McServiceImpl;
import com.hd.util.BasePage;
import com.hd.util.WebUtil;

/**
 * Servlet ��Ʒ��Ϣ
 */
@WebServlet("/back/McServlet")
public class McServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IMcService service = new McServiceImpl();
    

	/**
	 * ��Ʒ��Ϣ�����
	 *   1.��ȡ��ͨ�ı���Ϣ���浽���ݿ���
	 *   2.��ȡ�ϴ����ļ����浽��Ӧ��Ŀ¼��
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");
		if("add".equals(task)){
			// �����Ʒ��Ϣ
			// 1.��ȡDiskFileItemFactory����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 2.��ȡServletFileUpload
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// 3.ͨ��ServletFileUpload����HttpServletReqeust����
				List<FileItem> list = upload.parseRequest(request);
				// mc ��װҪ��������е�����
				Mc mc = new Mc();
				for (FileItem fi : list) {
					if(fi.isFormField()){
						// ��ʾ����ͨ�ı��
						String fieldName = fi.getFieldName();
						// ���������������
						String fieldValue = fi.getString("utf-8");
						
						if("mcname".equals(fieldName)){
							mc.setMcname(fieldValue);
						}else if("price".equals(fieldName)){
							mc.setPrice(WebUtil.parserDouble(fieldValue));
						}else if("quantity".equals(fieldName)){
							mc.setQuantity(WebUtil.parserInt(fieldValue));
						}else if("flag".equals(fieldName)){
							mc.setFlag(fieldValue);
						}else if("smallTypeId".equals(fieldName)){
							mc.setSmalltypeid(WebUtil.parserInt(fieldValue));
						}else if("mcdecx".equals(fieldName)){
							mc.setMcdecx(fieldValue.trim());
						}
						
					}else{
						// ��ʾ���ϴ����ļ�
						// ��ȡͼƬ����
						String fileName = fi.getName();
						mc.setPic(fileName);
						// ���ϴ����ļ����浽��Ӧ��λ��
						String path = request.getServletContext().getRealPath("/upload");
						System.out.println(path);
						fi.write(new File(path+"/"+fileName));
					}
				}
				// ����service�еķ�����������
				service.add(mc);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			query(request, response);
		}else{
			query(request, response);
		}
		
	}

	/**
	 * ��ѯ���е���Ʒ��Ϣ����ʾ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ҳ��ѯ������
		String mcname = request.getParameter("mcname");
		Mc mc = new Mc();
		// �ж�ʱ����Ҫ����������ѯ
		if(!WebUtil.isEmpty(mcname) && !"��Ʒ��������".equals(mcname)){
			// ��ʾ��Ҫ����typename��ѯ
			mc.setMcname(mcname);
		}
		// 1.��ȡ��ҳ����
		int currentPage = WebUtil.getCurrentPage(request, 0);
		int pageSize = WebUtil.getPageSize(request, 5);
		BasePage<Mc> page = service.queryPage(mc, currentPage, pageSize);
		// 2.��BasePage������������
		request.setAttribute("page", page);
		request.setAttribute("mcname", mcname);
		// 3.��ת����Ӧ��jspҳ��
		request.getRequestDispatcher("mc/Mc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
