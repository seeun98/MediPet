package com.dev.mediPet.src.user.utils;

import com.dev.mediPet.config.BaseException;
import com.dev.mediPet.src.user.model.KakaoUserInfo;
import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;


import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import static com.dev.mediPet.config.BaseResponseStatus.FAILED_TO_KAKAO_AUTH;
import static com.dev.mediPet.config.BaseResponseStatus.FAILED_TO_KAKAO_EMAIL;

/*
프론트엔드로부터 토큰을 받았다고 가정.
그 토큰으로부터 카카오에게 사용자정보를 요청하는 클래스
관련 model 파일 (user/model/KakaoUserInfo)
관련 controller (userController)

[동의항목 나는 3가지]
kakao developers / 사용자 정보 가져오기 (https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#req-user-info)
* */
public class KakaoApiService {
    public static KakaoUserInfo getKakaoUserInfo(String accessToken) throws BaseException {
        // TODO 지우기
        System.out.println("카카오 들어옴");
        String api = "https://kapi.kakao.com/v2/user/me"; //기본정보
        String authorization_header = "Bearer " + accessToken;
        KakaoUserInfo kakaoUserInfo; // 정보 받아서 넘겨줄 변수
        StringBuffer sb = new StringBuffer();
        try{
            URL url = new URL(api);
            HttpsURLConnection http = (HttpsURLConnection) url.openConnection();
            /*
            URLConnection : 사용자 인증이나 보안이 설정되어 있지 않은 웹서버에 접속하여 파일 등을 다운로드하는데 사용, 재사용될 수 없음
            HttpsURLConnection : Java 소스 내에서 SSL 적용된 사이트에 접근하기 위해, REST api를 호출하기 위해 사용.
            * */
// TODO 지우기
            System.out.println("두번째");
            http.setRequestProperty("Authorization", authorization_header); //Request Header 값 세팅 (response data를 2번째값으로 전달)
            http.setRequestMethod("GET");
            http.connect();
// TODO 지우기
            System.out.println("3번째");
            int responseCode = http.getResponseCode(); //http response 404 에러 등등 값 가지기
            System.out.println("responseCode: " + responseCode);

            InputStreamReader in = new InputStreamReader(http.getInputStream(), "utf-8");
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
// TODO 지우기
            System.out.println("dd  " + sb.toString());
            JSONParser parser = new JSONParser(sb.toString());
            JSONObject jsonObjectMain;
            System.out.println("here1");
            //TODO
            //parse 확인
            jsonObjectMain = (JSONObject) parser.parse();
            System.out.println("here");
            JSONObject kakao_account = (JSONObject) jsonObjectMain.get("kakao_account");
            JSONObject profile = (JSONObject) kakao_account.get("profile");
            String nickname = (String) profile.get("nickname");
            //boolean has_email = (boolean) kakao_account.get("email");
            //String email = (String) kakao_account.get("email");
// TODO 지우기
            System.out.println("52번째");
            System.out.println("nickname : " + nickname);
            br.close();
            in.close();
            http.disconnect();
            kakaoUserInfo = new KakaoUserInfo(nickname);
            // TODO 지우기
            System.out.println("5번째");
        } catch (Exception exception) {
            throw new BaseException(FAILED_TO_KAKAO_AUTH);
        }
        return kakaoUserInfo;

    }
}