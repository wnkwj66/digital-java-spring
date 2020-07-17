package kr.green.springtest.pagination;

public class Criteria {
	private int page;
	private int perPageNum; //한페이지에 게시글 갯수
	private String search;
	private int type; //설정하기에 따라 int || String이 될 수 있다.
	//생성자
	public Criteria() {
		page = 1;
		perPageNum =10;
		search = "";
		type = 0;  //생략가능 : int는 기본 초기값이 0이기 때문에 
		
	}
	public int getPage() {
		return page;
	}
	//페이지가 1페이지부터 시작되기 때문에 setPage 수정 작업 실시
	public void setPage(int page) {
		if(page <= 0) 
			this.page = 1;
		else
			this.page = page;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	//한 페이지에 최소 10개의 게시물이 보여지도록 수정
	public void setPerPageNum(int perPageNum) {
		// ↓게시물이 열개보다 작으면 열개로 보이도록 수정
		if(perPageNum < 10) { 
			this.perPageNum = 10;
		}
		else
			this.perPageNum = perPageNum;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		if(type < 0 || type > 3)
			this.type = 0;
		else
			this.type = type;
//		↑조건선택연산자로 표현 : (this.type = type < 0 || type > 3) ? 0 : type;
	}
//	Mapper에서 사용 
	public int getStartPage() {
		return (page - 1) * perPageNum;
	}
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", search=" + search + ", type=" + type + "]";
	}
	
}
