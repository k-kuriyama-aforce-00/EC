package jp.co.aforce.product;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jp.co.aforce.beans.ProductBean;
import jp.co.aforce.dao.InsertProductDAO;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class InsertProduct
 */
@WebServlet("/jp.co.aforce/insertproduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MBまでのファイルをメモリに保持
maxFileSize = 1024 * 1024 * 10,      // 10MBまでのファイルをアップロード可能
maxRequestSize = 1024 * 1024 * 50)   // 50MBまでのデータを受け付ける
public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		ProductBean productBean = new ProductBean();
		
		productBean.setProductName(request.getParameter("productName"));
		productBean.setStock(Integer.parseInt(request.getParameter("stock")));
		
		try {
			
	
		//画像のアップロード
		Part filePart = request.getPart("imagePass");
		String fileName = filePart.getSubmittedFileName();
		String uploadDir = getServletContext().getRealPath("img");
		InputStream fileContent = filePart.getInputStream();
		
		//アップロード先のディレクトリを指定
		
        String filePath = uploadDir + File.separator + fileName;
        Files.copy(fileContent, new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
        
        String dbFilePath = "../img/" + fileName;
        productBean.setImagePass(dbFilePath);
        }catch(IOException i) {
        	i.printStackTrace();
        }
        
        
		productBean.setPrice(Integer.parseInt(request.getParameter("price")));
		productBean.setProductCategory(request.getParameter("productCategory"));
		
		InsertProductDAO ipDAO = new InsertProductDAO();
		int count = 0;
		
		try {
			count = ipDAO.countInsertProductRows(productBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(count >= 1) {
			request.setAttribute("insertFailure", "商品を追加しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("../views/insertProduct.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("insertFailure", "商品の追加に失敗しました");
			RequestDispatcher dispatcher = request.getRequestDispatcher("../views/insertProduct.jsp");
			dispatcher.forward(request, response);
		}
		Page.footer(out);
	}

}
