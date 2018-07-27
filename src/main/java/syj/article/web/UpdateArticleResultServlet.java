package syj.article.web;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import syj.article.model.ArticleVo;
import syj.article.service.ArticleService;
import syj.attachment.model.AttachmentVo;
import syj.file.FileUtil;

/**
 * Servlet implementation class UpdateArticleResultServlet
 */
@WebServlet("/updateArticleResult")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class UpdateArticleResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ArticleService articleService = new ArticleService();
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int article_no = Integer.parseInt(request.getParameter("article_no"));
		String article_title	= request.getParameter("title");
		String article_content	= request.getParameter("smarteditor");
		
		ArticleVo articleVo = new ArticleVo();
		articleVo.setArticle_title(article_title);
		articleVo.setArticle_content(article_content);
		articleVo.setArticle_no(article_no);
		
		articleService.updateArticle(articleVo);
		
		Collection<Part> parts = request.getParts();
		
		for (Part uploadFilePart : parts) {
//			Part uploadFilePart = request.getPart("uploadFile");
			
			String contentType = uploadFilePart.getContentType();
			if( contentType != null ){
				//fileSize가 정상적인 경우에만 업로드를 수행한다
				if( uploadFilePart.getSize() > 0 ) {
					String contentDisposition = uploadFilePart.getHeader("Content-Disposition");
					
					String fileName = FileUtil.getFileName(contentDisposition);
					//고정된 영역으로 배포
					String path = FileUtil.fileUploadPath;			
					String var = UUID.randomUUID().toString();
					uploadFilePart.write(path + File.separator + var);			
					String attach_upload_name = fileName;
					String attach_path = path;
					String attach_name = var;
					
					AttachmentVo attachmentVo = new AttachmentVo();
					attachmentVo.setAttach_upload_name(attach_upload_name);
					attachmentVo.setAttach_path(attach_path);
					attachmentVo.setAttach_name(attach_name);
					articleService.addAttachment(attachmentVo);
					
					uploadFilePart.delete();
				}
			}
		}
		
		response.sendRedirect("/jspTest/showBoardList?board_no=" + board_no);
		
	}

}
