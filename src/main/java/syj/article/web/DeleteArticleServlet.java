package syj.article.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import syj.article.service.ArticleService;

/**
 * Servlet implementation class DeleteArticleServlet
 */
@WebServlet("/deleteArticle")
public class DeleteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleService articleService = new ArticleService();
		
		int article_no = Integer.parseInt(request.getParameter("article_no"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		articleService.deleteArticle(article_no);
		
		response.sendRedirect("/jspTest/showBoardList?board_no=" + board_no);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
