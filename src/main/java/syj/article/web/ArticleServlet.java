package syj.article.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import syj.article.model.ArticleVo;
import syj.article.service.ArticleService;
import syj.attachment.model.AttachmentVo;
import syj.attachment.service.AttachmentService;
import syj.reply.model.ReplyVo;
import syj.reply.service.ReplyService;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/articleDetail")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleService articleService = new ArticleService();
		ReplyService replyService = new ReplyService();
		AttachmentService attachmentService = new AttachmentService();
		
		int article_no = Integer.parseInt(request.getParameter("article_no"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		ArticleVo articleVo = articleService.getArticleInfo(article_no);
		List<ReplyVo> replyList =replyService.getAllReplyOfArticleNo(article_no);
		List<AttachmentVo> attachmentList = attachmentService.getAttachmentOfArticle(article_no);
		
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		request.setAttribute("mem_id", mem_id);
		request.setAttribute("replyList", replyList);
		request.setAttribute("attachmentList", attachmentList);
		request.setAttribute("article_no", article_no);
		request.setAttribute("board_no", board_no);
		request.setAttribute("articleVo", articleVo);
		request.getRequestDispatcher("/article/articleDetail.jsp").forward(request, response);
		
	}


}
