package com.dev.mediPet.src.test;

import com.dev.mediPet.config.BaseException;
import com.dev.mediPet.config.BaseResponse;
import com.dev.mediPet.src.test.model.GetTestHospital;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class TestController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final TestDao testDao;

    public TestController(TestDao testDao) {
        this.testDao = testDao;
    }

    @ResponseBody
    @GetMapping("/test")
    public BaseResponse<GetTestHospital> getTestName() {
        try {
            String result = testDao.getTestName();
            return new BaseResponse<>(new GetTestHospital(result));
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }


    //카카오 로그인 API
    //Get 확인
    @ResponseBody
    @GetMapping("/login/GetKakao")
    @JsonProperty("code")
    public void kakaoCallback(@RequestParam String code)
    {
        System.out.println(code);
    }

    //카카오 로그인 API
    //Post 참고
//    @ResponseBody
//    @PostMapping("/login/kakao")
//    public BaseResponse<PostLoginRes> kakaoLogin(@RequestBody PostKakaoLoginReq postKakaoLoginReq){
//        if (postKakaoLogin.getAccessToken() == null || postKakaoLogin.getAccessToken().isEmpty()) {
//            return new BaseResponse<> (AUTH_KAKAO_EMPTY_TOKEN);
//        }
//    }

}
