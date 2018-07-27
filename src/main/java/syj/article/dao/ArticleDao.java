package syj.article.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import syj.article.model.ArticleVo;
import syj.attachment.model.AttachmentVo;
import syj.mybatis.SqlMapSessionFactory;

public class ArticleDao implements ArticleDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	
	/**
	* Method : getArticleInfo
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 해당 게시글 번호의 상세정보 조회
	*/
	@Override
	public ArticleVo getArticleInfo(int article_no) {
		SqlSession session = sqlSessionFactory.openSession();
		ArticleVo articleVo = session.selectOne("article.getArticleInfo", article_no);
		session.close();
		
		return articleVo;
	}


	/**
	* Method : addAttachment
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC17
	* 변경이력 :
	* @param attachmentVo
	* @return
	* Method 설명 : 해당게시글 첨부파일 추가
	*/
	@Override
	public int addAttachment(AttachmentVo attachmentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int addResult = session.insert("article.addAttachment", attachmentVo);
		session.commit();
		session.close();
		
		return addResult;
	}

	/**
	* Method : addArticle
	* 최초작성일 : 2018. 7. 22.
	* 작성자 : SEO
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 추가
	*/
	@Override
	public int addArticle(ArticleVo articleVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int addResult = session.insert("article.addArticle", articleVo);
		session.commit();
		session.close();
		
		return addResult;
	}

	
	/**
	* Method : deleteArticle
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : SEO
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 게시글 삭제 ( 실제로는 삭제여부  N -> Y 로 업데이트 )
	*/
	@Override
	public int deleteArticle(int article_no) {
		SqlSession session = sqlSessionFactory.openSession();
		int updateResult = session.update("article.deleteArticle", article_no);
		session.commit();
		session.close();
		
		return updateResult;
	}

	
	/**
	* Method : updateArticle
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : SEO
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	@Override
	public int updateArticle(ArticleVo articleVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int updateResult = session.update("article.updateArticle", articleVo);
		session.commit();
		session.close();
		
		return updateResult;
	}


	@Override
	public int addReArticle(ArticleVo articleVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int addResult = session.insert("article.addReArticle", articleVo);
		session.commit();
		session.close();
		
		return addResult;
	}


	/**
	* Method : addAttachFromUpdate
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC17
	* 변경이력 :
	* @param attachmentVo
	* @return
	* Method 설명 : 게시글 수정을 통한 첨부파일추가 
	*/
	@Override
	public int addAttachFromUpdate(AttachmentVo attachmentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int addResult = session.insert("article.addAttachFromUpdate", attachmentVo);
		session.commit();
		session.close();
		
		return addResult;
	}
	
	
	
	
	

}
