package syj.board.dao;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import syj.article.model.ArticleVo;
import syj.board.model.BoardVo;


public class BoardDaoTest {
	
	BoardDaoInf boardDao = new BoardDao();

	/**
	* Method : getAllBoardTest
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 모든 게시판 조회
	*/
	@Test
	public void getAllBoardTest() {
		/***Given***/

		/***When***/
		List<BoardVo> boardList = boardDao.getAllBoard();
		
		/***Then***/
		assertEquals(3, boardList.size());

	}
	
	
	/**
	* Method : getAllArticle
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 해당 게시판의 모든 게시글 조회
	*/
	@Test
	public void getAllArticleTest(){
		/***Given***/
		int board_no = 1;

		/***When***/
		List<ArticleVo> articleList = boardDao.getAllArticle(board_no);
		System.out.println("제목 : " + articleList.get(2).getArticle_title());
		
		
		/***Then***/
		assertEquals(1, articleList.size());
	}
	
	
	/**
	* Method : getBoardName
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 :게시판번호에 해당하는 게시판명 검색
	*/
	@Test
	public void getBoardNameTest() {
		/***Given***/
		int board_no = 1;

		/***When***/
		String board_name = boardDao.getBoardName(board_no);

		/***Then***/
		assertEquals("자유게시판", board_name);
	}
	
	
	/**
	* Method : addBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 게시판 추가
	*/
	@Test
	public void addBoardTest() {
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_no(4);
		boardVo.setBoard_name("학생게시판");
		boardVo.setBoard_use_confirm("Y");

		/***When***/
		int addResult = boardDao.addBoard(boardVo);

		/***Then***/
		assertEquals(1, addResult);
	}
		
	
	/**
	* Method : getAllArticleList
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 게시글 전체리스트 정보 조회
	*/
	@Test
	public void getAllArticleListTest(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
		map.put("board_no", 1);
		
		/***When***/
		List<ArticleVo> articleList = boardDao.getAllArticleList(map);

		/***Then***/
		assertEquals(7, articleList.size());
	}
	
	
	/**
	* Method : getArticleTotCnt
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 전체 게시글 갯수 조회
	*/
	@Test
	public void getArticleTotCntTest(){
		/***Given***/
		int board_no = 1;

		/***When***/
		int cnt = boardDao.getArticleTotCnt(board_no);

		/***Then***/
		assertEquals(10, cnt);
	}
	
	
	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 정보 수정
	*/
	@Test
	public void updateBoardTest(){
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_no(4);
		boardVo.setBoard_name("장터게시판");
		boardVo.setBoard_use_confirm("Y");

		/***When***/
		int result =boardDao.updateBoard(boardVo);

		/***Then***/
		assertEquals(1, result);
	}
	

}
