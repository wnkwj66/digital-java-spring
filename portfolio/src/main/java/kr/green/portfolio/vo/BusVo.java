package kr.green.portfolio.vo;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class BusVo {
// Json을 java에서 활용하기위해 vo활용
	private String buslineNm;
	private String arrTerminalNm;
	private String arrPlandTime;
	private String depTerminalNm;
	private String depPlandTime;
	private String economyCharge;
	private String prestigeCharge;
	private String vihicleId;
	public String getBuslineNm() {
		return buslineNm;
	}
	public void setBuslineNm(String buslineNm) {
		this.buslineNm = buslineNm;
	}
	public String getArrTerminalNm() {
		return arrTerminalNm;
	}
	public void setArrTerminalNm(String arrTerminalNm) {
		this.arrTerminalNm = arrTerminalNm;
	}
	public String getArrPlandTime() {
		return arrPlandTime;
	}
	public void setArrPlandTime(String arrPlandTime) {
		this.arrPlandTime = arrPlandTime;
	}
	public String getDepTerminalNm() {
		return depTerminalNm;
	}
	public void setDepTerminalNm(String depTerminalNm) {
		this.depTerminalNm = depTerminalNm;
	}
	public String getDepPlandTime() {
		return depPlandTime;
	}
	public void setDepPlandTime(String depPlandTime) {
		this.depPlandTime = depPlandTime;
	}
	public String getEconomyCharge() {
		return economyCharge;
	}
	public void setEconomyCharge(String economyCharge) {
		this.economyCharge = economyCharge;
	}
	public String getPrestigeCharge() {
		return prestigeCharge;
	}
	public void setPrestigeCharge(String prestigeCharge) {
		this.prestigeCharge = prestigeCharge;
	}
	public String getVihicleId() {
		return vihicleId;
	}
	public void setVihicleId(String vihicleId) {
		this.vihicleId = vihicleId;
	}
	@Override
	public String toString() {
		return "BusVo [buslineNm=" + buslineNm + ", arrTerminalNm=" + arrTerminalNm + ", arrPlandTime=" + arrPlandTime
				+ ", depTerminalNm=" + depTerminalNm + ", depPlandTime=" + depPlandTime + ", economyCharge="
				+ economyCharge + ", prestigeCharge=" + prestigeCharge + ", vihicleId=" + vihicleId + "]";
	}
	
	
}