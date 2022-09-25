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
public class GetMainHospitalRes {
    private String name;
    private String address;
    private String telephone;
    private String distance;
    private String latitude;
    private String longitude;
}
