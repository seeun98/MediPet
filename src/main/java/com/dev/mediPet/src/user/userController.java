package com.dev.mediPet.src.user;

import java.lang.String;
import java.util.List;

import com.dev.mediPet.config.BaseException;
import com.dev.mediPet.config.BaseResponse;
import com.dev.mediPet.src.user.model.KakaoAbleUser;
import com.dev.mediPet.src.user.model.KakaoUserInfo;
import com.dev.mediPet.src.user.model.PostKakaoLoginReq;
import com.dev.mediPet.src.user.utils.KakaoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.dev.mediPet.config.BaseResponseStatus.AUTH_KAKAO_EMPTY_TOKEN;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private userDao userDao;
    @Autowired
    private userService userService;
    /**
     * 3. 카카오 로그인 API
     * [POST] /users/login/kakao
     *
     */
    @ResponseBody
    @PostMapping("/login/kakao")
    public BaseResponse<KakaoAbleUser> kakaoLogin(@RequestBody PostKakaoLoginReq postKakaoLogin) { //BaseREsponse로 반환하기!!

        if (postKakaoLogin.getAccessToken() == null || postKakaoLogin.getAccessToken().isEmpty()) { //accesstoken으로 유저정보 요청 , postman 카카오로그인 post로 확인
            return new BaseResponse<>(AUTH_KAKAO_EMPTY_TOKEN);
            //return new BaseResponse<>(AUTH_KAKAO_EMPTY_TOKEN);
        }

        try{
            // 액세스 토큰으로 사용자 정보 받아온다.
            KakaoUserInfo kakaoUserInfo = KakaoApiService.getKakaoUserInfo(postKakaoLogin.getAccessToken());
            // DB에 해당 이메일이 가입되어 있는지 확인
            //System.out.println(kakaoUserInfo.getEmail());
            KakaoUserInfo kakaoUserInfo1 = userDao.getUsers().get(0);

            System.out.println("여기?" + kakaoUserInfo1.getNickName() + "\t 이메일: " + kakaoUserInfo1.getEmail());

            KakaoAbleUser result = userService.getLogin(kakaoUserInfo1); //service에서 해 와란
            //result을 프론트에 리턴하기
            return new BaseResponse<>(result);

        } catch (BaseException e) {
            throw new RuntimeException(e);
        }
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


