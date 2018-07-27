package syj.board.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import syj.article.model.ArticleVo;
import syj.board.service.BoardService;

/**
 * Servlet implementation class ShowBoardServlet
 */
@WebServlet("/showBoardList")
public class ShowBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardService boardService = new BoardService();
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		if(board_no == 0) {
			board_no = 1;
		}
		
		//page, pageSize 파라미터 값이 없을 경우
		String pageStr = request.getParameter("page");
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = pageSizeStr == null ? 10 : Integer.parseInt(pageSizeStr);
		
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("board_no", board_no);
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		String board_name = boardService.getBoardName(board_no);
		
		Map<String, Object> resultMap = boardService.getAllArticle(paramMap);
				
		List<ArticleVo> articleList = (List<ArticleVo>) resultMap.get("pageList");
		String pageNavi = (String) resultMap.get("pageNavi");		

		request.setAttribute("board_no", board_no);
		request.setAttribute("pageNavi", pageNavi);
		request.setAttribute("board_name", board_name);
		request.setAttribute("articleList", articleList);
		request.getRequestDispatcher("/board/showBoardList.jsp").forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
