package syj.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import syj.board.model.BoardVo;
import syj.board.service.BoardService;

/**
 * Servlet implementation class UpdateBoardServlet
 */
@WebServlet("/updateBoard")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		BoardService boardService = new BoardService();
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String board_use_confirm = request.getParameter("update_use_confirm");
		String board_name = request.getParameter("updateBoardName");
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_no(board_no);
		boardVo.setBoard_use_confirm(board_use_confirm);
		boardVo.setBoard_name(board_name);
		
		int updateResult = boardService.updateBoard(boardVo);
		
		if(updateResult >= 1) {
			request.getRequestDispatcher("/boardList").forward(request, response);
		} else {
			System.out.println("실패");
		}
		
		
	}

}
