package com.dev.mediPet.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class KakaoUserInfo {
    //kakao developer -> 제품설정 -> 카카오 로그인 -> 동의항목
    //닉네임, 이메일, 성별
    private String nickName;
    private String email;
    private String gender;
}
