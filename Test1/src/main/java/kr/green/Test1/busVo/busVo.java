package kr.green.Test1.busVo;

public class busVo {
	private String arrPlaceNm;
	private String arrPlandTime;
	private String depPlaceNm;
	private String depPlandTime;
	private String charge;
	private String gradeNm;
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
	@Override
	public String toString() {
		return "busVo [arrPlaceNm=" + arrPlaceNm + ", arrPlandTime=" + arrPlandTime + ", depPlaceNm=" + depPlaceNm
				+ ", depPlandTime=" + depPlandTime + ", charge=" + charge + ", gradeNm=" + gradeNm + "]";
	}
}
