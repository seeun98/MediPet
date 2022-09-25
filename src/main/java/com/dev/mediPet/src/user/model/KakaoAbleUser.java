package com.dev.mediPet.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor //기본생성자 대신
@AllArgsConstructor //전체 파라미터 포함한 생성자 대신
@Getter
@Setter
public class KakaoAbleUser {
    String result;
    String email;
    String jwt; //Disable이면 NULL 값 주기
}
