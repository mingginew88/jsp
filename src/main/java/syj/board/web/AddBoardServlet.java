package syj.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import syj.board.model.BoardVo;
import syj.board.service.BoardService;

/**
 * Servlet implementation class AddBoardServlet
 */
@WebServlet("/addBoard")
public class AddBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		BoardService boardService = new BoardService();
		
		String board_use_confirm = request.getParameter("add_use_confirm");
		String board_name = request.getParameter("addBoardName");
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_name(board_name);
		boardVo.setBoard_use_confirm(board_use_confirm);
		
		int addBoardResult = boardService.addBoard(boardVo);
		List<BoardVo> boardList = boardService.getAllBoard();
		
		if(addBoardResult >= 1) {
			request.setAttribute("boardList", boardList);
			request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
//			response.sendRedirect("/jspTest/board/boardList.jsp");
		}
		
	}

}
