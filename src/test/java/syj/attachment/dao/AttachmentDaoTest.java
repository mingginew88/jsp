package syj.attachment.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import syj.attachment.model.AttachmentVo;

public class AttachmentDaoTest {
	
	AttachmentDaoInf attachmentDao = new AttachmentDao();

	/**
	* Method : getAttachmentOfArticleTest
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : SEO
	* 변경이력 :
	* Method 설명 : 해당 게시글의 첨부파일 조회
	*/
	@Test
	public void getAttachmentOfArticleTest() {
		/***Given***/
		int article_no = 1;
		/***When***/
		List<AttachmentVo> attachmentList = attachmentDao.getAttachmentOfArticle(article_no);

		/***Then***/
		assertEquals(0, attachmentList.size());
	}

	
	/**
	* Method : deleteAttachmentTest
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : SEO
	* 변경이력 :
	* Method 설명 : 첨부파일 삭제
	*/
	@Test
	public void deleteAttachmentTest() {
		/***Given***/
		int article_no = 1;
		
		/***When***/
		int result = attachmentDao.deleteAttachment(article_no);

		/***Then***/
		assertEquals(1, result);
	}

}
