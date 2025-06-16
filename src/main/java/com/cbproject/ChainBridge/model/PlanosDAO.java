package com.cbproject.ChainBridge.model;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;


@Repository
public class PlanosDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public Map<String, Object> puxarPlano(int id){
        String sql = "SELECT * FROM planos WHERE cd_plano = ?";
        return jdbc.queryForMap(sql, id);
    }

}

