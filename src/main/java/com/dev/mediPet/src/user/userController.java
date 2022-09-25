package com.dev.mediPet.src.user;

import java.lang.String;
import java.util.List;

import com.dev.mediPet.config.BaseException;
import com.dev.mediPet.src.user.model.KakaoUserInfo;
import com.dev.mediPet.src.user.model.PostKakaoLoginReq;
import com.dev.mediPet.src.user.utils.KakaoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private userDao userDao;
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
            // 액세스 토큰으로 사용자 정보 받아온다.
            KakaoUserInfo kakaoUserInfo = KakaoApiService.getKakaoUserInfo(postKakaoLogin.getAccessToken());
            // DB에 해당 이메일이 가입되어 있는지 확인
            //System.out.println(kakaoUserInfo.getEmail());
            KakaoUserInfo kakaoUserInfo1 = userDao.getUsers().get(0);

            System.out.println("여기?" + kakaoUserInfo1.getNickName() + "\t 이메일: " + kakaoUserInfo1.getEmail());


            // Service에서 할 일 : 1. 있으면 그대로 로그인 (JWT토큰을 클라이언트에게 전달)
            // 2. 가입x면 강아지 정보 입력을 받아서 디비에 저장


            
            System.out.println(kakaoUserInfo);

        } catch (BaseException e) {
            throw new RuntimeException(e);
        }
        return "SUCCESS";
    }


    /**
     * - 카카오로그인 성공 
     * 1) DB에 정보가 있는지 확인
     * 2) 없으면 정보 넣기 
     * 3) 로그인 성공시 jwt 토큰 주기
     * 
     * Controller는 Service를 불러옴 
     * Service는 DAO를 불러옴
     */




}


