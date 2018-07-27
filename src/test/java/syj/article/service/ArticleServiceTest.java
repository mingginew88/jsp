package syj.article.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import syj.article.model.ArticleVo;
import syj.attachment.model.AttachmentVo;

public class ArticleServiceTest {

	ArticleServiceInf articleService = new ArticleService();
	
	/**
	* Method : getArticleInfoTest
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 게시글 정보 조회
	*/
	@Test
	public void getArticleInfoTest() {
		/***Given***/
		int article_no = 1;

		/***When***/
		ArticleVo articleVo = articleService.getArticleInfo(article_no);
		
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
		attachmentVo.setAttach_name("sally.png");
		attachmentVo.setAttach_path("D:\\A_TeachingMaterial\\7.JspSrpgin\\fileUpload");
		attachmentVo.setAttach_upload_name("5098a838-a010-4efa-9de4-c2d7974f5100");

		/***When***/
		int result = articleService.addAttachment(attachmentVo);
		
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
		int result = articleService.addArticle(articleVo);

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
		int result = articleService.deleteArticle(article_no);

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
		int result = articleService.updateArticle(articleVo);

		/***Then***/
		assertEquals(1, result);
	}
	
	
	/**
	* Method : addReArticle
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC17
	* 변경이력 :
	* @param articleVo
	* @return
	* Method 설명 : 해당 게시글의 답글 작성
	*/
	@Test
	public void addReArticleTest() {
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
		int articleResult = articleService.addReArticle(articleVo);

		/***Then***/
		assertEquals(1, articleResult);

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
	@Test
	public void addAttachFromUpdate() {
		/***Given***/
		AttachmentVo attachmentVo = new AttachmentVo();

		/***When***/
		int addResult = articleService.addAttachFromUpdate(attachmentVo);
		
		/***Then***/
		assertEquals(1, addResult);

	}
	
	
	
	
	
	
	


}
