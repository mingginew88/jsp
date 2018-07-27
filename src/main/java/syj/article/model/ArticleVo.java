package syj.article.model;

import java.util.Date;

/**
* ArticleVo.java
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
public class ArticleVo {
	
	private int 	article_no;				//게시글번호
	private int 	article_pno;			//부모게시글번호
	private int 	article_gno;			//게시글그룹번호
	private String 	article_title;			//게시글제목
	private String 	article_content;		//게시글내용
	private String 	article_writer;			//게시글작성자
	private Date 	article_date;			//게시글작성날짜
	private String  article_del_confirm;	//게시글삭제여부
	private int		board_no;				//게시판번호
	private String  mem_id;					//회원ID
	
	
	public ArticleVo(){ }


	public int getArticle_no() {
		return article_no;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	public int getArticle_pno() {
		return article_pno;
	}
	public void setArticle_pno(int article_pno) {
		this.article_pno = article_pno;
	}
	public int getArticle_gno() {
		return article_gno;
	}
	public void setArticle_gno(int article_gno) {
		this.article_gno = article_gno;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public String getArticle_writer() {
		return article_writer;
	}
	public void setArticle_writer(String article_writer) {
		this.article_writer = article_writer;
	}
	public Date getArticle_date() {
		return article_date;
	}
	public void setArticle_date(Date article_date) {
		this.article_date = article_date;
	}
	public String getArticle_del_confirm() {
		return article_del_confirm;
	}
	public void setArticle_del_confirm(String article_del_confirm) {
		this.article_del_confirm = article_del_confirm;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}


	@Override
	public String toString() {
		return "ArticleVo [article_no=" + article_no + ", article_pno="
				+ article_pno + ", article_gno=" + article_gno
				+ ", article_title=" + article_title + ", article_content="
				+ article_content + ", article_writer=" + article_writer
				+ ", article_date=" + article_date + ", article_del_confirm="
				+ article_del_confirm + ", board_no=" + board_no + ", mem_id="
				+ mem_id + "]";
	}
	
	
	
	
}
