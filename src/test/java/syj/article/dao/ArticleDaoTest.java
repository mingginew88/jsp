package syj.article.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import syj.article.model.ArticleVo;
import syj.attachment.model.AttachmentVo;

public class ArticleDaoTest {

	ArticleDaoInf articleDao = new ArticleDao();
	
	
	/**
	* Method : getArticleInfoTest
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 해당 게시글 정보 조회
	*/
	@Test
	public void getArticleInfoTest() {
		/***Given***/
		int article_no = 1;

		/***When***/
		ArticleVo articleVo = articleDao.getArticleInfo(article_no);
		
		/***Then***/
		assertEquals("테스트입니다.", articleVo.getArticle_title());
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
	@Test
	public void addAttachment() {
		/***Given***/
		AttachmentVo attachmentVo = new AttachmentVo();
		attachmentVo.setArticle_no(1);
		attachmentVo.setAttach_name("sally.png");
		attachmentVo.setAttach_path("");
		attachmentVo.setAttach_upload_name("sally.png");

		/***When***/
		int result = articleDao.addAttachment(attachmentVo);
		
		/***Then***/
		assertEquals(1, result);
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
	@Test
	public void addArticle() {
		/***Given***/
		ArticleVo articleVo = new ArticleVo();
		articleVo.setArticle_gno(1);
		articleVo.setArticle_title("123");
		articleVo.setArticle_writer("syjun88");
		articleVo.setArticle_content("123123");
		articleVo.setArticle_del_confirm("N");
		articleVo.setBoard_no(1);
		articleVo.setMem_id("syjun88");

		/***When***/
		int result = articleDao.addArticle(articleVo);

		/***Then***/
		assertEquals(1, result);

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
	@Test
	public void deleteArticle() {
		/***Given***/
		int article_no = 1;
		
		/***When***/
		int result = articleDao.deleteArticle(article_no);

		/***Then***/
		assertEquals(1, result);

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
	@Test
	public void updateArticle() {
		/***Given***/
		ArticleVo articleVo = new ArticleVo();
		articleVo.setArticle_title("11111");
		articleVo.setArticle_content("123");
		articleVo.setArticle_no(1);
		
		/***When***/
		int result = articleDao.updateArticle(articleVo);

		/***Then***/
		assertEquals(1, result);
	}

}
