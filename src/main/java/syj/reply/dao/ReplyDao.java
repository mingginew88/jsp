package syj.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import syj.mybatis.SqlMapSessionFactory;
import syj.reply.model.ReplyVo;

public class ReplyDao implements ReplyDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

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
		SqlSession session = sqlSessionFactory.openSession();
		int addResult = session.insert("reply.addReply", replyVo);
		session.commit();
		session.close();
		
		return addResult;
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
		SqlSession session = sqlSessionFactory.openSession();
		List<ReplyVo> replyList = session.selectList("reply.getAllReplyOfArticleNo", article_no);
		session.close();
		
		return replyList;
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
		SqlSession session = sqlSessionFactory.openSession();
		int deleteResult = session.update("reply.deleteReply", reply_no);
		session.commit();
		session.close();
		
		return deleteResult;
	}

}
