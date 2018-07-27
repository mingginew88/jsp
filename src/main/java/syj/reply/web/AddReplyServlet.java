package syj.reply.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import syj.reply.model.ReplyVo;
import syj.reply.service.ReplyService;

/**
 * Servlet implementation class AddReplyServlet
 */
@WebServlet("/addReply")
public class AddReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReplyService replyService = new ReplyService();
		HttpSession session = request.getSession();
		
		String reply_content = request.getParameter("reply_content");
		String reply_writer = (String) session.getAttribute("mem_id");
		String mem_id = (String) session.getAttribute("mem_id");
		int article_no = Integer.parseInt(request.getParameter("article_no"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String reply_del_confirm = "N";
		
		ReplyVo replyVo = new ReplyVo();
		replyVo.setReply_writer(reply_writer);
		replyVo.setReply_content(reply_content);
		replyVo.setMem_id(mem_id);
		replyVo.setArticle_no(article_no);
		replyVo.setReply_del_confirm(reply_del_confirm);
		
		int addResult = replyService.addReply(replyVo);
		
		if(addResult >= 1)
			response.sendRedirect("/jspTest/articleDetail?article_no=" + article_no +"&board_no=" + board_no);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
