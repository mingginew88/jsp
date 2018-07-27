package syj.reply.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import syj.reply.model.ReplyVo;

public class ReplyServiceTest {

	ReplyServiceInf replyService = new ReplyService();
	
	/**
	* Method : addReplyTest
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : SEO
	* 변경이력 :
	* Method 설명 : 해당게시글에 댓글 추가
	*/
	@Test
	public void addReplyTest() {
		/***Given***/
		ReplyVo replyVo = new ReplyVo();
		replyVo.setReply_no(10);
		replyVo.setReply_writer("syjun88");
		replyVo.setReply_content("123");
		replyVo.setArticle_no(1);
		replyVo.setMem_id("syjun88");
		replyVo.setReply_del_confirm("N");

		/***When***/
		int result = replyService.addReply(replyVo);

		/***Then***/
		assertEquals(1, result);
	}
	
	
	/**
	* Method : getAllReplyOfArticleNoTest
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : SEO
	* 변경이력 :
	* Method 설명 : 해당 게시글에 모든 댓글
	*/
	@Test
	public void getAllReplyOfArticleNoTest() {
		/***Given***/
		int article_no = 1;
		
		/***When***/
		List<ReplyVo> replyList = replyService.getAllReplyOfArticleNo(article_no);
		
		/***Then***/
		assertEquals(2, replyList.size());
	}
	
	
	/**
	* Method : deleteReplyTest
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : SEO
	* 변경이력 :
	* Method 설명 : 댓글을 삭제한다. 하지만 실제로 삭제하지않고 삭제여부를 N -> Y로 업데이트한다.
	*/
	@Test
	public void deleteReplyTest() {
		/***Given***/
		int reply_no = 1;

		/***When***/
		int result = replyService.deleteReply(reply_no);

		/***Then***/
		assertEquals(1, result);
	}
	

}


