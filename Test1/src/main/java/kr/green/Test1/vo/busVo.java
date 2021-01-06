package kr.green.Test1.vo;

/**
 * @author wonjoong
 *
 */
public class busVo {
	
	private String depPlaceNm; //출발터미널 이름
	private String depPlandTime; //출발시간
	private String arrPlaceNm; //도착 터미널
	private String arrPlandTime; //도착시간
	private String charge;
	private String gradeNm;
	private String routeId;
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
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getGradeNm() {
		return gradeNm;
	}
	public void setGradeNm(String gradeNm) {
		this.gradeNm = gradeNm;
	}
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	@Override
	public String toString() {
		return "busVo [depPlaceNm=" + depPlaceNm + ", depPlandTime=" + depPlandTime + ", arrPlaceNm=" + arrPlaceNm
				+ ", arrPlandTime=" + arrPlandTime + ", charge=" + charge + ", gradeNm=" + gradeNm + ", routeId="
				+ routeId + "]";
	}
	
}
