package kr.green.springtest.utils;

import java.util.HashMap;
import java.util.Map;

public class MyUtils {
	// 버스목록 - HashMap으로 정의
	public static Map<String, String> getTerminalId() {

		Map<String, String> result = new HashMap<String, String>();

		result.put("센트럴시티(서울)", "NAEK020");
		result.put("서울경부", "NAEK010");
		result.put("청주(센트럴)", "NAEK401");
		result.put("센트럴", "NAEK020");
		result.put("대구공항", "NAEK861");
		result.put("아주대", "NAEK113");
		result.put("안성중대", "NAEK131");
		result.put("안성대림", "NAEK137");
		result.put("대전복합", "NAEK300");
		result.put("대전복합", "NAEK301");
		result.put("천안", "NAEK310");
		return result;

	}
}
