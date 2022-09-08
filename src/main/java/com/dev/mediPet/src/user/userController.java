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

//    @Autowired
//    //카카오로그인 Get 프론트로부터 토큰 받았다고 가정 -> 토큰 번호 확인
//    @ResponseBody
//    @GetMapping("/login/GetKakao")
//    @JsonProperty("code")
//    public void kakaoCallback(@RequestParam String code)
//    {
//        System.out.println(code);
//    }

    /**
     * 3. 카카오 로그인 API
     * [POST] /users/login/kakao
     */
    @ResponseBody
    @PostMapping("/login/kakao")
    public String kakaoLogin(@RequestBody PostKakaoLoginReq postKakaoLogin) {
        System.out.println("컨트롤러들어옴");
        if (postKakaoLogin.getAccessToken() == null || postKakaoLogin.getAccessToken().isEmpty()) {
            return "getAccessToken FAILED";
            //return new BaseResponse<>(AUTH_KAKAO_EMPTY_TOKEN);
        }

        try{
            System.out.println("try");
            KakaoUserInfo kakaoUserInfo = KakaoApiService.getKakaoUserInfo(postKakaoLogin.getAccessToken());
            // TODO 지우기
            System.out.println("끝남");
            System.out.println(kakaoUserInfo);
        } catch (BaseException e) {
            throw new RuntimeException(e);
        }
        return "SUCCESS";
    }
}


