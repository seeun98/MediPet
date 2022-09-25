package com.dev.mediPet.src.hospital;

import com.dev.mediPet.config.BaseException;
import com.dev.mediPet.config.BaseResponse;
import com.dev.mediPet.src.hospital.model.GetMainRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class hospitalController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final hospitalService hospitalService;

    public hospitalController(hospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    /**
     * 메인화면 조회 API
     */
    @ResponseBody
    @GetMapping("/hospital/main")
    public BaseResponse<GetMainRes> getMain(@RequestParam String latitude, @RequestParam String longitude) {
        try {
            // todo jwt 토큰 확인
            // todo getMain(userIdx, latitude, longitude); 변경
            GetMainRes getMainRes = hospitalService.getMain(latitude, longitude);
            return new BaseResponse<>(getMainRes);
        } catch (BaseException exception) {

            return new BaseResponse<>(exception.getStatus());
        }
    }


}
