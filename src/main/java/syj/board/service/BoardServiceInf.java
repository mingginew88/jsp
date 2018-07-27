package syj.board.service;

import java.util.List;
import java.util.Map;

import syj.article.model.ArticleVo;
import syj.board.model.BoardVo;

public interface BoardServiceInf {
	
	/**
	* Method : getAllBoard
	* 최초작성일 : 2018. 7. 16.
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 모든 게시판 정보
	*/
	List<BoardVo> getAllBoard();
	
	
	/**
	* Method : getAllArticle
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC17
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : Map에 페이지네이션과 게시글전체 정보 조회
	*/
	Map<String, Object> getAllArticle(Map<String, Integer> map);
	
	
	/**
	* Method : getAllArticleList
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 게시글 전체리스트 정보 조회
	*/
	List<ArticleVo> getAllArticleList(Map<String, Integer> map);
	
	
	/**
	* Method : getArticleTotCnt
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 전체 게시글 갯수 조회
	*/
	int getArticleTotCnt(int board_no);
	
	
	/**
	* Method : getBoardName
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 게시판번호에 해당하는 게시판명 검색
	*/
	String getBoardName(int board_no);
	
	
	/**
	* Method : addBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 추가
	*/
	int addBoard(BoardVo boardVo);
	
	
	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 정보 수정
	*/
	int updateBoard(BoardVo boardVo);
	
	
	

}
