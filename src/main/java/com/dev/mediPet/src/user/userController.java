package com.dev.mediPet.src.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {

    //카카오로그인 Get
    @ResponseBody
    @GetMapping("/login/GetKakao")
    @JsonProperty("code")
    public void kakaoCallback(@RequestParam String code)
    {
        System.out.println(code);
    }

    //카카오로그인 Post

}


