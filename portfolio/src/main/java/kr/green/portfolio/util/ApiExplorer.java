package kr.green.portfolio.util;
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

import kr.green.portfolio.vo.BusVo;

import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
	
    public static String getTicketingData(String depTerminalId, String arrTerminalId, String depPlandTime) throws Exception {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/ExpBusInfoService/getStrtpntAlocFndExpbusInfo"); /*URL*/
//      urlBuilder에 서비스URL 정보 넣고 .append로 뒤의 값들 추가
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=io%2BAwzXnXAqMhpqXqEbVq3AGk1cLF98zwAFmW7nBqnKMJ8wmryzTJ39SGi9fBG1gvXFg9aFeEremKPtRM5bPfQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("depTerminalId","UTF-8") + "=" + URLEncoder.encode(depTerminalId, "UTF-8")); /*출발터미널ID*/
        urlBuilder.append("&" + URLEncoder.encode("arrTerminalId","UTF-8") + "=" + URLEncoder.encode(arrTerminalId, "UTF-8")); /*도착터미널ID*/
        urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode(depPlandTime, "UTF-8")); /*출발일*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*json으로 받기위해*/
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //객체 생성 ,URL연결 
        conn.setRequestMethod("GET"); //요청 방식 선택 
        //타입설정(application/json) 형식으로 전송 (Request Body 전달 시 application/json으로 서버에 전달)
        conn.setRequestProperty("Content-type", "application/json"); 
        //실제 서버로 request 요청 하는 부분.(응답 코드를 받는다.200성공 / 나머지에러)?
        System.out.println("Response code: " + conn.getResponseCode());
        //BufferedReader : 스캐너와 비슷한 기능 /많은양의 데이터 입력받을 때 효과적
        BufferedReader rd;
        //if(conn 인스턴스의 getResponseCode() 메서드를 호출함 )
        // 호출 된 conn인스턴스의 getResponseCode()가  200보다 크거나 같고 300보다 작거나 같으면 아래 조건 실행
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
        	// BuffereadReader rd = BuffereadReader 객체 생성  
        	//(매개변수로 InputStreamReader(conn 인스턴스의 getInputStream()메서드를 호출하는 매개변수)가지고 있다)
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder(); // 객체 생성
        String line; //String line 변수 선언
        //BufferedReader가 호출하는 .readLine이 Null값이 아닐때 동안 StringBuilder sb.가 호출하는 append(line);이 반복 실행
        // = 버퍼 rd가 호출한 .readLine()//파일 내용 한줄씩 읽어옴  값이 Null이 아닐때 
        //   stringBuilder 뒤에 line값을 append(추가) 해준다. (반복)
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close(); //버퍼 닫아줌
        conn.disconnect(); //서버 ?연결 끊어줌
        System.out.println("-------------");
        return sb.toString();
    }
    // 매소드
    //접근제한자(public) 리턴타입(static) 메서드명 (List<BusVo> 타입의 getBusJson(매개변수)) 
    public static List<BusVo> getBusJson(String depTerminalId, String arrTerminalId, String depPlandTime) throws Exception{ //BusVo값을 List<>로 저장
    	String result = getTicketingData(depTerminalId, arrTerminalId, depPlandTime); //getTicketingData(매개변수로 출발터미널 ,도착 터미널, 도착시간을 참조하는)메서드 를 String result에 넣음
    	//json처럼 생긴 String을 Json으로 만들기
    	List<BusVo> list = null; // list객체 생성 (List<BusVo>)
    	JSONParser parser = new JSONParser();
    	//jsonObj = parser가 참조한 parse(result) // result값을 참조함(파싱) // 의 값
    	JSONObject jsonObj = (JSONObject) parser.parse(result); //리턴값이 오브젝트이기 때문에 json오브젝트로 다운캐스팅

    	//response : 응답
    	JSONObject j_response = (JSONObject) jsonObj.get("response"); //jsonObj.get("key")값이기 때문에 response객체 가져옴(결과값).
//    	그러니까 위에 샘플 코드 결과값을 가지고 응답하는 과정
    	System.out.println("response:"+j_response );
    	JSONObject j_body = (JSONObject) j_response.get("body");
    	System.out.println("body:"+j_body);
    	System.out.println("totalCount:"+j_body.get("totalCount").getClass());
    	
    	if((Long)j_body.get("totalCount") !=0) {
	    	JSONObject j_items = (JSONObject) j_body.get("items"); //생성 ,선언
	    	System.out.println("items:"+j_items);
	    	JSONArray a_item = (JSONArray) j_items.get("item");
//    		a_item.remove(0); //0번째 필요없음
	    	System.out.println("item: "+a_item);// 이 값을 사용
	    	
	    	//1.Gson을 클래스로 (BusVo)
	    	//2. Gson을 배열로 (List타입의 <BusVo>)
	    	
	    	Gson gson = new Gson();
	    	//1. 클래스로 바꿀 때
	    	// gson.fromJson(j_item.toString(),BusVo.class); // json을 class로
	    	
	    	//2. 배열로 바꿀 때
	    	// BusVo[] busVoarr = gson.fromJson(a_item.toString(),busVo[].class);
	    	
	    	//List<BusVo> list = 에서 위에 List<BusVo>list = null; 로 초기화 한 뒤에 list값믄 바꿔줌
	    	list = gson.fromJson(a_item.toString(),new TypeToken<List<BusVo>>(){}.getType());
			
	    	for(BusVo busVo : list) {
	    		System.out.println(busVo);
	    	}
	    	
    	}
    	return list;
    }
}
