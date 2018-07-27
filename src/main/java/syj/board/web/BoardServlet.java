package syj.board.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import syj.board.model.BoardVo;
import syj.board.service.BoardService;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/boardList")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		BoardService boardService = new BoardService();
		List<BoardVo> boardList = boardService.getAllBoard();
		
		Date date = new Date();
		request.setAttribute("date", date);
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
	}


}
