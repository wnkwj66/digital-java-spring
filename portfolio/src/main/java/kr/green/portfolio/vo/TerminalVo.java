package kr.green.portfolio.vo;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author wonjoong
 *
 */
public class TerminalVo {
	private int numOfRows;
	private int pageNo;
	private String terminalNm;
	public int getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(int numOfRows) {
		this.numOfRows = numOfRows;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getTerminalNm() {
		return terminalNm;
	}
	public void setTerminalNm(String terminalNm) {
		this.terminalNm = terminalNm;
	}
	@Override
	public String toString() {
		return "TerminalVo [numOfRows=" + numOfRows + ", pageNo=" + pageNo + ", terminalNm=" + terminalNm + "]";
	}
	
}