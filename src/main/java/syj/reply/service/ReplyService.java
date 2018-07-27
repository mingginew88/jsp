package syj.reply.service;

import java.util.List;

import syj.reply.dao.ReplyDao;
import syj.reply.dao.ReplyDaoInf;
import syj.reply.model.ReplyVo;

public class ReplyService implements ReplyServiceInf{
	
	ReplyDaoInf replyDao = new ReplyDao();

	/**
	* Method : addReply
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC17
	* 변경이력 :
	* @param replyVo
	* @return
	* Method 설명 : 해당게시글에 댓글 추가
	*/
	@Override
	public int addReply(ReplyVo replyVo) {
		return replyDao.addReply(replyVo);
	}

	
	/**
	* Method : getAllReplyOfArticleNo
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : PC17
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 해당 게시글에 모든 댓글
	*/
	@Override
	public List<ReplyVo> getAllReplyOfArticleNo(int article_no) {
		return replyDao.getAllReplyOfArticleNo(article_no);
	}

	
	/**
	* Method : deleteReply
	* 최초작성일 : 2018. 7. 22.
	* 작성자 : SEO
	* 변경이력 :
	* @param reply_no
	* @return 
	* Method 설명 : 댓글을 삭제한다. 하지만 실제로 삭제하지않고 삭제여부를 N -> Y로 업데이트한다.
	*/
	@Override
	public int deleteReply(int reply_no) {
		return replyDao.deleteReply(reply_no);
	}

}
