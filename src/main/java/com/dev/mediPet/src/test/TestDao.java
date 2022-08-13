package com.dev.mediPet.src.test;

import com.dev.mediPet.config.BaseException;
import com.dev.mediPet.src.test.model.GetTestHospital;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestDao {
    String getTestName() throws BaseException;
}
