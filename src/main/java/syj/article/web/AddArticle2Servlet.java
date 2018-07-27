package syj.article.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddArticle2Servlet
 */
@WebServlet("/addArticle2")
public class AddArticle2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int article_pno = Integer.parseInt(request.getParameter("article_no"));
		int article_gno = Integer.parseInt(request.getParameter("article_gno"));
		
		request.setAttribute("board_no", board_no);
		request.setAttribute("article_pno", article_pno);
		request.setAttribute("article_gno", article_gno);
		
		request.getRequestDispatcher("/article/addArticle2.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
