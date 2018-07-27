package syj.reply.model;

import java.util.Date;

/**
* ReplyVo.java
*
* @author PC17
* @since 2018. 7. 18.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 7. 18. PC17 최초 생성
*
* </pre>
*/
public class ReplyVo {
	
	private int 	reply_no;			//댓글번호
	private String 	reply_writer;		//댓글작성자
	private Date 	reply_date;			//댓글작성날짜
	private String 	reply_content;		//댓글내용
	private String 	reply_del_confirm;	//댓글삭제여부
	private int 	article_no;			//게시글번호
	private String  mem_id;				//작성자
	
	public ReplyVo(){ }
	
	
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public String getReply_writer() {
		return reply_writer;
	}
	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_del_confirm() {
		return reply_del_confirm;
	}
	public void setReply_del_confirm(String reply_del_confirm) {
		this.reply_del_confirm = reply_del_confirm;
	}
	public int getArticle_no() {
		return article_no;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}


	@Override
	public String toString() {
		return "ReplyVo [reply_no=" + reply_no + ", reply_writer="
				+ reply_writer + ", reply_date=" + reply_date
				+ ", reply_content=" + reply_content + ", reply_del_confirm="
				+ reply_del_confirm + ", article_no=" + article_no
				+ ", mem_id=" + mem_id + "]";
	}

	
	
	
	
}
