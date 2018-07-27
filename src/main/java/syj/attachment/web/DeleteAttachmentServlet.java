package syj.attachment.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import syj.attachment.service.AttachmentService;

/**
 * Servlet implementation class DeleteAttachmentServlet
 */
@WebServlet("/deleteAttach")
public class DeleteAttachmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AttachmentService attachmentService = new AttachmentService();
		
		int attach_no = Integer.parseInt(request.getParameter("attach_no"));
		int deleteResult = attachmentService.deleteAttachment(attach_no);
		
		if(deleteResult >= 1) {
			int article_no = Integer.parseInt(request.getParameter("article_no"));
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			response.sendRedirect("/jspTest/articleDetail?article_no=" + article_no +"&board_no=" + board_no);
		}
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
