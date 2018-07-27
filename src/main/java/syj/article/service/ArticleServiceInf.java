package syj.article.service;

import syj.article.model.ArticleVo;
import syj.attachment.model.AttachmentVo;

public interface ArticleServiceInf {
	
	
	/**
	* Method : getArticleInfo
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 해당 게시글 번호의 상세정보 조회
	*/
	ArticleVo getArticleInfo(int article_no);
	
	
	/**
	* Method : addAttachment
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC17
	* 변경이력 :
	* @param attachmentVo
	* @return
	* Method 설명 : 해당게시글 첨부파일 추가
	*/
	int addAttachment(AttachmentVo attachmentVo);
	
	
	/**
	* Method : addArticle
	* 최초작성일 : 2018. 7. 22.
	* 작성자 : SEO
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 추가
	*/
	int addArticle(ArticleVo articleVo);
	
	
	/**
	* Method : deleteArticle
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : SEO
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 게시글 삭제 ( 실제로는 삭제여부  N -> Y 로 업데이트 )
	*/
	int deleteArticle(int article_no);
	
	
	/**
	* Method : updateArticle
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : SEO
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	int updateArticle(ArticleVo articleVo);
	
	
	/**
	* Method : addReArticle
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC17
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 해당 게시글의 답글 작성
	*/
	int addReArticle(ArticleVo articleVo);
	
	
	/**
	* Method : addAttachFromUpdate
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC17
	* 변경이력 :
	* @param attachmentVo
	* @return
	* Method 설명 : 게시글 수정을 통한 첨부파일추가 
	*/
	int addAttachFromUpdate(AttachmentVo attachmentVo);
	

}
