package com.dev.mediPet.src.user;

import java.lang.String;
import com.dev.mediPet.config.BaseException;
import com.dev.mediPet.config.BaseResponse;
import com.dev.mediPet.src.user.model.KakaoUserInfo;
import com.dev.mediPet.src.user.model.PostKakaoLoginReq;
import com.dev.mediPet.src.user.model.PostLoginRes;
import com.dev.mediPet.src.user.utils.KakaoApiService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.dev.mediPet.config.BaseResponseStatus.AUTH_KAKAO_EMPTY_TOKEN;

@RestController
@RequestMapping("/user")
public class userController {



    /**
     * 3. 카카오 로그인 API
     * [POST] /users/login/kakao
     *
     */
    @ResponseBody
    @PostMapping("/login/kakao")
    public String kakaoLogin(@RequestBody PostKakaoLoginReq postKakaoLogin) {

        if (postKakaoLogin.getAccessToken() == null || postKakaoLogin.getAccessToken().isEmpty()) { //accesstoken으로 유저정보 요청 , postman 카카오로그인 post로 확인
            return "FAILED";
            //return new BaseResponse<>(AUTH_KAKAO_EMPTY_TOKEN);
        }

        try{
            KakaoUserInfo kakaoUserInfo = KakaoApiService.getKakaoUserInfo(postKakaoLogin.getAccessToken());
            // DB에 해당 이메일이 가입되어 있는지 확인

            // Service에서 할 일 : 1. 있으면 그대로 로그인 (JWT토큰을 클라이언트에게 전달)
            // 2. 가입x면 강아지 정보 입력을 받아서 디비에 저장


            
            System.out.println(kakaoUserInfo);

        } catch (BaseException e) {
            throw new RuntimeException(e);
        }
        return "SUCCESS";
    }


    /**
    * 카카오로그인 성공
     *
     * 1) DB에 정보가 있는지 확인..
     * 2) 없으면 정보 넣기
    * **/



}


