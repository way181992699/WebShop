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
 * Servlet 商品信息
 */
@WebServlet("/back/McServlet")
public class McServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IMcService service = new McServiceImpl();
    

	/**
	 * 商品信息的添加
	 *   1.获取普通文本信息保存到数据库中
	 *   2.获取上传的文件保存到对应的目录中
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");
		if("add".equals(task)){
			// 添加商品信息
			// 1.获取DiskFileItemFactory对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 2.获取ServletFileUpload
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// 3.通过ServletFileUpload解析HttpServletReqeust对象
				List<FileItem> list = upload.parseRequest(request);
				// mc 封装要保存的所有的数据
				Mc mc = new Mc();
				for (FileItem fi : list) {
					if(fi.isFormField()){
						// 表示是普通的标记
						String fieldName = fi.getFieldName();
						// 解决中文乱码问题
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
						// 表示是上传的文件
						// 获取图片名称
						String fileName = fi.getName();
						mc.setPic(fileName);
						// 将上传的文件保存到对应的位置
						String path = request.getServletContext().getRealPath("/upload");
						System.out.println(path);
						fi.write(new File(path+"/"+fileName));
					}
				}
				// 调用service中的方法保存数据
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
	 * 查询所有的商品信息并显示
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取分页查询的条件
		String mcname = request.getParameter("mcname");
		Mc mc = new Mc();
		// 判断时候需要根据条件查询
		if(!WebUtil.isEmpty(mcname) && !"商品名称搜索".equals(mcname)){
			// 表示需要根据typename查询
			mc.setMcname(mcname);
		}
		// 1.获取分页参数
		int currentPage = WebUtil.getCurrentPage(request, 0);
		int pageSize = WebUtil.getPageSize(request, 5);
		BasePage<Mc> page = service.queryPage(mc, currentPage, pageSize);
		// 2.将BasePage放入作用域中
		request.setAttribute("page", page);
		request.setAttribute("mcname", mcname);
		// 3.跳转到相应的jsp页面
		request.getRequestDispatcher("mc/Mc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
