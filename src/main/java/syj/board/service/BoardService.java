package syj.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import syj.article.model.ArticleVo;
import syj.board.dao.BoardDao;
import syj.board.dao.BoardDaoInf;
import syj.board.model.BoardVo;

public class BoardService implements BoardServiceInf {
	
	BoardDaoInf boardDao = new BoardDao();

	/**
	* Method : getAllBoard
	* 최초작성일 : 2018. 7. 16.
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시판 정보 조회
	*/
	@Override
	public List<BoardVo> getAllBoard() {
		return boardDao.getAllBoard();
	}
	

	/**
	* Method : getAllArticle
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC17
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : Map에 페이지네이션과 게시글전체 정보 조회
	*/
	@Override
	public Map<String, Object> getAllArticle(Map<String, Integer> map) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//학생 페이지 리스트 조회
		List<ArticleVo> pageList = boardDao.getAllArticleList(map);
		resultMap.put("pageList", pageList); 
		
		//페이지 네비게이션 html 생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		int board_no = map.get("board_no");
		System.out.println(board_no);
		//학생 전체 건수 조회
		int totCnt = boardDao.getArticleTotCnt(board_no);
		resultMap.put("totCnt", totCnt);
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt, board_no));
		
		return resultMap;
	}
	
	
	/**
	* Method : makePageNavi
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @param page
	* @param pageSize
	* @param totCnt
	* @return
	* Method 설명 : 페이지네이션 처리
	*/
	private String makePageNavi(int page, int pageSize, int totCnt, int board_no) {
		int cnt = totCnt / pageSize;	//몫
		int mod = totCnt % pageSize;	//나머지
		if(mod > 0)
			cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1 ? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		
		int firstPage = 1;
		int lastPage  = cnt;
		
		pageNaviStr.append("<li><a href=\"/jspTest/showBoardList?board_no="+board_no+"&page="+ firstPage +"&pageSize=" + pageSize + "\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		pageNaviStr.append("<li><a href=\"/jspTest/showBoardList?board_no="+board_no+"&page="+ prevPage +"&pageSize=" + pageSize + "\" aria-label=\"Previous\"><span aria-hidden=\"true\">Previous</span></a></li>");
		
		for(int i = 1; i <= cnt; i++) {
			String activeClass = "";
			if( i == page )
				activeClass = " class=\"active\"";
			
			pageNaviStr.append("<li"+activeClass+"><a href=\"/jspTest/showBoardList?board_no="+board_no+"&page="+ i +"&pageSize=" + pageSize + "\">" + i + "</a></li>");
		}
		pageNaviStr.append("<li><a href=\"/jspTest/showBoardList?board_no="+board_no+"&page="+ nextPage +"&pageSize=" + pageSize + "\" aria-label=\"Next\"><span aria-hidden=\"true\">Next</span></a></li>");
		pageNaviStr.append("<li><a href=\"/jspTest/showBoardList?board_no="+board_no+"&page="+ lastPage +"&pageSize=" + pageSize + "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
		
		return pageNaviStr.toString();
		
	}
	

	/**
	* Method : getAllArticleList
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : Map에 페이지네이션과 게시글전체 정보 조회
	*/
	@Override
	public List<ArticleVo> getAllArticleList(Map<String, Integer> map) {
		return boardDao.getAllArticleList(map);
	}


	/**
	* Method : getArticleTotCnt
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 전체 게시글 갯수 조회
	*/
	@Override
	public int getArticleTotCnt(int board_no) {
		return boardDao.getArticleTotCnt(board_no);
	}
	
	

	/**
	* Method : getBoardName
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 게시판번호에 해당하는 게시판명 검색
	*/
	@Override
	public String getBoardName(int board_no) {
		return boardDao.getBoardName(board_no);
	}


	/**
	* Method : addBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 추가
	*/
	@Override
	public int addBoard(BoardVo boardVo) {
		return boardDao.addBoard(boardVo);
	}


	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판정보 수정
	*/
	@Override
	public int updateBoard(BoardVo boardVo) {
		return boardDao.updateBoard(boardVo);
	}



}
