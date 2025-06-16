package com.cbproject.ChainBridge.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ContratoDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public Map<String,Object> puxarContrato(String cdCnpj){
        String sql = "SELECT * FROM contratos WHERE cd_Cnpj = ?;";
        return jdbc.queryForMap(sql);
    }

    public List<Map<String, Object>> puxarTodosContratos(){
        String sql = "SELECT * FROM contratos WHERE cd_Cnpj = ?;";
        return jdbc.queryForList(sql);
    }

}
