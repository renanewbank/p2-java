package com.cbproject.ChainBridge.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class EmpresaDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirEmpresa(Empresa emp){
        String sql = "INSERT INTO empresas (cd_Cnpj, nm_Empresa, ds_Email) VALUES (?,?,?)";
        Object[] parametros = new Object [3];
        parametros[0] = emp.getCdCnpj();
        parametros[1] = emp.getNmEmpresa();
        parametros[2] = emp.getDsEmail();
        jdbc.update(sql, parametros);
    }

    public Map<String,Object> puxarEmpresa(String cdCnpj){
        String sql = "SELECT * FROM empresas WHERE cd_Cnpj = ?;";
        return jdbc.queryForMap(sql, cdCnpj);
    }

     public List<Map<String,Object>> puxarTodasEmpresas(){
        String sql = "SELECT * FROM empresas;";
        return jdbc.queryForList(sql);
    } 

   public void atualizarEmpresa(Empresa emp, String cdCnpj){
    String sql = "UPDATE empresas SET cd_Cnpj = ?, nm_Empresa = ?, ds_Email = ? WHERE cd_Cnpj = ?";
    Object[] parametros = new Object[4];
    parametros[0] = emp.getCdCnpj();
    parametros[1] = emp.getNmEmpresa();
    parametros[2] = emp.getDsEmail();
    parametros[3] = cdCnpj;
    jdbc.update(sql, parametros);
   }

    public void deletar(String cdCnpj){
        String sql = "DELETE FROM empresas WHERE cd_Cnpj = ?;";
        jdbc.update(sql, cdCnpj);
    }
}
