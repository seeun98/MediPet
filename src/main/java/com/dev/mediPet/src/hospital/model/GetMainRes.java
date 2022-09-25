package com.dev.mediPet.src.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetMainRes {
    private String profileImg; // 회원 프로필 이미지
    private List<GetMainHospitalRes> hospitals = new ArrayList<>(); // 병원 List
}
