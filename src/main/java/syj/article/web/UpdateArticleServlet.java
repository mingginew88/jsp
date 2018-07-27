package syj.article.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import syj.article.model.ArticleVo;
import syj.article.service.ArticleService;

/**
 * Servlet implementation class UpdateArticleServlet
 */
@WebServlet("/updateArticle")
public class UpdateArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleService articleService = new ArticleService();
		
		int article_no = Integer.parseInt(request.getParameter("article_no"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		ArticleVo articleVo = articleService.getArticleInfo(article_no);
		
		request.setAttribute("board_no", board_no);
		request.setAttribute("article_no", article_no);
		request.setAttribute("articleVo", articleVo);
		
		request.getRequestDispatcher("/article/updateArticle.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
