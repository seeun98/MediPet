package com.dev.mediPet.config;

import lombok.Getter;

/*
프론트에 어떤 오류인지 말해주려고 에러내용 모아놓은 파일
* */

@Getter
public enum BaseResponseStatus {
    SUCCESS(true, 1000, "요청에 성공하였습니다."),


    //users
    AUTH_KAKAO_EMPTY_TOKEN(false,2013,"액세스토큰을 입력해주세요."),
    
    // [POST] /users
    FAILED_TO_KAKAO_AUTH(false, 3019, "카카오 유저 정보 조회에 실패하였습니다."),
    FAILED_TO_KAKAO_EMAIL(false, 3020, "카카오 정보에 등록된 이메일이 없습니다. 이메일을 추가 입력해주세요.");

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

}
