package com.dev.mediPet.src.hospital;

import com.dev.mediPet.config.BaseException;
import com.dev.mediPet.config.BaseResponseStatus;
import com.dev.mediPet.src.hospital.model.GetMainHospitalRes;
import com.dev.mediPet.src.hospital.model.GetMainRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class hospitalService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final hospitalDao hospitalDao;

    @Autowired
    public hospitalService(hospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    public GetMainRes getMain(String latitude, String longitude) throws BaseException {
        try {
            GetMainRes getMainRes = new GetMainRes();
            // get 로그인 회원 프로필 이미지

            // get List<GetMainHospitalRes>
            List<GetMainHospitalRes> getMainHospitalRes = hospitalDao.selectMainHospital(latitude, longitude);
            getMainRes.setHospitals(getMainHospitalRes);
            return getMainRes;
        } catch (Exception exception){
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }
}
