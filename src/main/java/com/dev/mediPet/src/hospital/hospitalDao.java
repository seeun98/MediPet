package com.dev.mediPet.src.hospital;

import com.dev.mediPet.src.hospital.model.GetMainHospitalRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class hospitalDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<GetMainHospitalRes> selectMainHospital(String latitude, String longitude) {
        String query = "SELECT name, address, telephone, (" +
                "6371 * acos(" +
                "cos(radians(?)) " +
                "* cos(radians(latitude)) " +
                "* cos(radians(longitude) - radians(?)) " +
                "+ sin(radians(?)) " +
                "* sin(radians(latitude)))) AS distance, latitude, longitude " +
                "FROM hospital " +
                "ORDER BY distance " +
                "LIMIT 5";

        Object[] params = new Object[]{latitude, longitude, latitude};

        return this.jdbcTemplate.query(query,
                (rs,rowNum) -> new GetMainHospitalRes(
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("telephone"),
                        rs.getString("distance"),
                        rs.getString("latitude"),
                        rs.getString("longitude")), params);
    }
}
