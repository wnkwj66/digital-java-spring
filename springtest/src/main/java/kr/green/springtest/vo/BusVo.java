package kr.green.springtest.vo;


public class BusVo {
	
	private String depPlaceNm; //출발지
	private String depPlandTime; //출발시간
	private String arrPlaceNm; //도착지
	private String arrPlandTime; //도착시간
	private String gradeNm; // 등급
	private String charge; // 가격
	private String routeId; //코스?
	
	
	public String getDepPlaceNm() {
		return depPlaceNm;
	}
	public void setDepPlaceNm(String depPlaceNm) {
		this.depPlaceNm = depPlaceNm;
	}
	public String getDepPlandTime() {
		return depPlandTime;
	}
	public void setDepPlandTime(String depPlandTime) {
		this.depPlandTime = depPlandTime;
	}
	public String getArrPlaceNm() {
		return arrPlaceNm;
	}
	public void setArrPlaceNm(String arrPlaceNm) {
		this.arrPlaceNm = arrPlaceNm;
	}
	public String getArrPlandTime() {
		return arrPlandTime;
	}
	public void setArrPlandTime(String arrPlandTime) {
		this.arrPlandTime = arrPlandTime;
	}
	public String getGradeNm() {
		return gradeNm;
	}
	public void setGradeNm(String gradeNm) {
		this.gradeNm = gradeNm;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	@Override
	public String toString() {
		return "BusVo [depPlaceNm=" + depPlaceNm + ", depPlandTime=" + depPlandTime + ", arrPlaceNm=" + arrPlaceNm
				+ ", arrPlandTime=" + arrPlandTime + ", gradeNm=" + gradeNm + ", charge=" + charge + ", routeId="
				+ routeId + "]";
	}
	
	
}
