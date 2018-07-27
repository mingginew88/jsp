package syj.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import syj.article.model.ArticleVo;
import syj.board.model.BoardVo;
import syj.mybatis.SqlMapSessionFactory;

public class BoardDao implements BoardDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

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
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.getAllBoard");
		session.close();
		
		return boardList;
	}

	
	/**
	* Method : getAllArticle
	* 최초작성일 : 2018. 7. 18.
	* 작성자 : PC17
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 게시판번호에 해당하는 모든 게시글 조회
	*/
	@Override
	public List<ArticleVo> getAllArticle(int board_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<ArticleVo> articleList = session.selectList("article.getAllArticle", board_no);
		session.close();
		
		return articleList;
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
	@Override
	public List<ArticleVo> getAllArticleList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<ArticleVo> articleList = session.selectList("article.getAllArticleList", map);
		session.close();
		
		return articleList;
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
		SqlSession session = sqlSessionFactory.openSession();
		int count = session.selectOne("article.getArticleTotCnt", board_no);
		
		session.close();
		
		return count;
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
		SqlSession session = sqlSessionFactory.openSession();
		String board_name = session.selectOne("board.getBoardName", board_no);
		session.close();
		
		return board_name;
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
		SqlSession session = sqlSessionFactory.openSession();
		int addResult = session.insert("board.addBoard", boardVo);
		session.commit();
		session.close();
		
		return addResult;
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
		SqlSession session = sqlSessionFactory.openSession();
		int updateResult = session.update("board.updateBoard", boardVo);
		session.commit();
		session.close();
		
		return updateResult;
	}




}
