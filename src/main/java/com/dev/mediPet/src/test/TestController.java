package com.dev.mediPet.src.test;

import com.dev.mediPet.config.BaseException;
import com.dev.mediPet.config.BaseResponse;
import com.dev.mediPet.src.test.model.GetTestHospital;
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
    @ResponseBody
    @GetMapping("/kakaoLogin")
    public void kakaoCallback(@RequestBody String code)
    {

    }
    //public void kakaoCallback(@RequestParam String code) throws BaseException {
      //  System.out.println(code);
    //}

}
