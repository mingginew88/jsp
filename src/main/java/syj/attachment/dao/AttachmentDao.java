package syj.attachment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import syj.attachment.model.AttachmentVo;
import syj.mybatis.SqlMapSessionFactory;

public class AttachmentDao implements AttachmentDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	
	/**
	* Method : getAttachmentOfArticle
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC17
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 해당 게시글의 첨부파일 조회
	*/
	@Override
	public List<AttachmentVo> getAttachmentOfArticle(int article_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<AttachmentVo> attachmentList = session.selectList("attachment.getAttachmentOfArticle", article_no);
		session.close();
		
		return attachmentList;
	}

	
	/**
	* Method : deleteAttachment
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : PC17
	* 변경이력 :
	* @param article_no
	* @return
	* Method 설명 : 첨부파일 삭제
	*/
	@Override
	public int deleteAttachment(int article_no) {
		SqlSession session = sqlSessionFactory.openSession();
		int deleteResult = session.delete("attachment.deleteAttachment", article_no);
		session.commit();
		session.close();
		
		return deleteResult;
	}


	/**
	* Method : getAttachment
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC17
	* 변경이력 :
	* @param attach_no
	* @return
	* Method 설명 : 해당 첨부파일 조회
	*/
	@Override
	public AttachmentVo getAttachment(int attach_no) {
		SqlSession session = sqlSessionFactory.openSession();
		AttachmentVo attachmentVo = session.selectOne("attachment.getAttachment", attach_no);
		session.close();
		
		return attachmentVo;
	}

}
