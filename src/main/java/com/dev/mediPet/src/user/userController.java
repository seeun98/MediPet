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
     */
    @ResponseBody
    @PostMapping("/login/kakao")
    public String kakaoLogin(@RequestBody PostKakaoLoginReq postKakaoLogin) {

        if (postKakaoLogin.getAccessToken() == null || postKakaoLogin.getAccessToken().isEmpty()) {
            return "FAILED";
            //return new BaseResponse<>(AUTH_KAKAO_EMPTY_TOKEN);
        }

        try{
            KakaoUserInfo kakaoUserInfo = KakaoApiService.getKakaoUserInfo(postKakaoLogin.getAccessToken());
            System.out.println(kakaoUserInfo);

        } catch (BaseException e) {
            throw new RuntimeException(e);
        }
        return "SUCCESS";
    }
}


