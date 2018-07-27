package syj.reply.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import syj.reply.service.ReplyService;

/**
 * Servlet implementation class DeleteReplyServlet
 */
@WebServlet("/deleteReply")
public class DeleteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReplyService replyService = new ReplyService();
		
		int reply_no = Integer.parseInt(request.getParameter("reply_no"));
		int updateResult = replyService.deleteReply(reply_no);
		
		if(updateResult >= 1) {
			int article_no = Integer.parseInt(request.getParameter("article_no"));
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			response.sendRedirect("/jspTest/articleDetail?article_no=" + article_no +"&board_no=" + board_no);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
