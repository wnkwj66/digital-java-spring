package kr.green.Test1.Util;
/* Java 샘플 코드 */


import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.green.Test1.vo.busVo;

import java.io.BufferedReader;

public class ApiExplorer {
	
    public static String getTicketingData(String depTerminalId,String arrTerminalId,String depPlandTime) throws Exception {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/ExpBusInfoService/getStrtpntAlocFndExpbusInfo"); /*URL*/
        
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=io%2BAwzXnXAqMhpqXqEbVq3AGk1cLF98zwAFmW7nBqnKMJ8wmryzTJ39SGi9fBG1gvXFg9aFeEremKPtRM5bPfQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("200", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("depTerminalId","UTF-8") + "=" + URLEncoder.encode(depTerminalId, "UTF-8")); /*출발터미널ID*/
        urlBuilder.append("&" + URLEncoder.encode("arrTerminalId","UTF-8") + "=" + URLEncoder.encode(arrTerminalId, "UTF-8")); /*도착터미널ID*/
        urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode(depPlandTime, "UTF-8")); /*출발일*/
//        urlBuilder.append("&" + URLEncoder.encode("busGradeId","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*버스등급ID*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*버스등급ID*/
        
        URL url = new URL(urlBuilder.toString());
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println("----------");
        return sb.toString();
    }
    
    public static List<busVo> getBusJson(String depTerminalId, String arrTerminalId, String depPlandTime) throws Exception{ //BusVo값을 List<>로 저장
    	String result = getTicketingData(depTerminalId,arrTerminalId,depPlandTime); //getTicketingData(매개변수로 출발터미널 ,도착 터미널, 도착시간을 참조하는)메서드 를 String result에 넣음
    	//json처럼 생긴 String을 Json으로 만들기
    	List<busVo> list = null;
    	JSONParser parser = new JSONParser();
    	//jsonObj = parser가 참조한 parse(result) // result값을 참조함(파싱) // 의 값
    	JSONObject jsonObj = (JSONObject) parser.parse(result); //리턴값이 오브젝트이기 때문에 json오브젝트로 다운캐스팅

    	//response : 응답
    	JSONObject j_response = (JSONObject) jsonObj.get("response"); //jsonObj.get("key")값이기 때문에 response객체 가져옴(결과값).
    	System.out.println("response:"+j_response );
    	JSONObject j_body = (JSONObject) j_response.get("body");
    	System.out.println("body:"+j_body);
    	System.out.println("totalCount:"+j_body.get("totalCount"));
    	
    	if((Long)j_body.get("totalCount") !=0) {
    		JSONObject j_items = (JSONObject) j_body.get("items");
        	System.out.println("items: "+j_items);
        	JSONArray a_item = (JSONArray) j_items.get("item");
        	
        	
//        	a_item.remove(0);//0번재 필요x
        	System.out.println("item:" + a_item); // 이 값을 사용
        	
        	Gson gson = new Gson();
        	
        	list = gson.fromJson(a_item.toString(),new TypeToken<List<busVo>>() {}.getType());
        	
        	for(busVo busVo : list) {
        		System.out.println(busVo);
        	}
    	}
    	return list;
    	
    }
}