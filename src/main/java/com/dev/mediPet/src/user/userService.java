package com.dev.mediPet.src.user;

import com.dev.mediPet.src.user.model.KakaoAbleUser;
import com.dev.mediPet.src.user.model.KakaoUserInfo;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private userDao userDao;

    public  KakaoAbleUser getLogin(KakaoUserInfo kakaoUserInfo1) {
        KakaoAbleUser kakaoAbleUser = new KakaoAbleUser();
        if (userDao.checkKakaoId(kakaoUserInfo1.getEmail()) == 1){
            //로그인 처리
            kakaoAbleUser.setEmail(kakaoUserInfo1.getEmail());
            kakaoAbleUser.setResult("Success");
            //jwt
        }
        else{
            kakaoAbleUser.setResult("Fail"); //카카오 가능 함수에 set해서 필요한 정보를 넣어줌
            kakaoAbleUser.setEmail(kakaoUserInfo1.getEmail());
        }

        return kakaoAbleUser;
    }
}
