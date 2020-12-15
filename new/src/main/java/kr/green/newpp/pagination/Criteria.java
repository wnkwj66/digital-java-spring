package kr.green.newpp.pagination;

public class Criteria {
	//현재 페이지
	private int page; 
	//한 페이지 당 컨텐츠 갯수
	private int perPageNum;
	private String search;
	private int type;
	//Criteria 디폴트 생성자 : 현재 페이지를 1페이지로, 한 페이지에 10개의 컨텐츠
	public Criteria() {
		page = 1;
		this.perPageNum = 1;			perPageNum = 3;
		search="";
		type=0;
	}
	//getter and setter
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		//현재 페이지 번호를 음수로 설정하려 할 때
		if(page <= 0) {
			this.page = 1;
		}
		else
			this.page = page;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		/* 한 페이지에 컨텐츠 수를 0이상 100이하로 설정
		개발자 설정에 따라 100부분을 수정할 수 있음 */
		if(perPageNum <1) {
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
		if(type <0 || type > 3) 
			this.type = 0;
		else
			this.type = type;
	}
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", search=" + search + ", type=" + type + "]";
	}
	/* 쿼리문에서 limit에 사용되는 인덱스를 계산하는 getter */
	/*	쿼리문에서 limit를 사용할 때 가져올 컨텐츠의 시작 위치를
	 * 	계산하는 메소드로 xml에서 쿼리문에 #{startPage}를 호출할 때 
	 * 	getStartPage()가 호출됨 */
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
	
}
