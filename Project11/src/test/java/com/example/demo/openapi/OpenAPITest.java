package com.example.demo.openapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class OpenAPITest {
	
	String servicekey = "aCpzXtiNVznGIGJi7P7gc3lL71W%2FoTnxVRotq6%2FMGrWpEcyKbkPka7olKmSdCgJyJN3OuUmpmnkvNFf9xPNevw%3D%3D";
	
	String dataType = "JSON";
	
	String code = "11B20201";		//인천
	
//	날씨 예보 API를 호출하는 테스트 
//	--- 그리고 void String 키워드로 바꿔서 메소드로 변환
//	@Test
	public String getWeather() throws IOException {
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstMsgService/getLandFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + servicekey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode(dataType, "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode(code, "UTF-8")); /*11A00101(백령도), 11B10101 (서울), 11B20201(인천) 등... 별첨 엑셀자료 참조(‘육상’ 구분 값 참고)*/
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
//        System.out.println(sb.toString());
        
        return sb.toString();	//응답 받은 메세지 반환
    }

	@Test
	public void jsontoDto() throws IOException {
		
//		매퍼 객체생성 **파싱** 
		ObjectMapper mapper = new ObjectMapper();
		
//		분석할 수 없는 구문을 무시하는 옵션
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
//		날씨 데이터 조회
		String weather = getWeather();
		
//		JSON문자열 -> 객체로 변환
		Root root = mapper.readValue(weather, Root.class);
		
//		응답데이터에서 결과코드만 꺼내기
		System.out.println(root.response.header.resultCode);
		
		System.out.println(root.response.body.items.item.get(0));
	}
}
