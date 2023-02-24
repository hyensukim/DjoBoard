package models.admin;

import java.time.LocalDateTime;

public class Post {
	private int postNo;// 게시글 번호(기본키)
	private String postTitle;//게시글 제목
	private String postPw;//게시글 비번(선택)
	private String postContent;// 게시글 내용
	private String posterNm;// 게시글 작성자
	private LocalDateTime postRegDt; // 게시글 등록일자
	private LocalDateTime postMdDt; // 게시글 수정일자
	private LocalDateTime postDelDt;//게시글 삭제일자
	
	
}
