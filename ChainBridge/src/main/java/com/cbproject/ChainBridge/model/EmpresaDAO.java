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
        String sql = "INSERT INTO empresas(cnpj, nome, email, telefone, endereco) VALUES (?,?,?,?,?)";
        Object[] parametros = new Object [5];
        parametros[0] = emp.getCnpj();
        parametros[1] = emp.getNome();
        parametros[2] = emp.getEmail();
        parametros[3] = emp.getTelefone();
        parametros[4] = emp.getEndereco();
        jdbc.update(sql, parametros);
    }

    public Map<String,Object> puxarEmpresa(int id){
        String sql = "SELECT * FROM empresas WHERE id = ?;";
        return jdbc.queryForMap(sql, id);
    }

     public List<Map<String,Object>> puxarTodasEmpresas(){
        String sql = "SELECT * FROM empresas;";
        return jdbc.queryForList(sql);
    } 

   public void atualizarEmpresa(Empresa emp, int id){
    String sql = "UPDATE empresas SET cnpj = ?, nome = ?, email = ?, telefone = ?, endereco = ? WHERE id = ?";
    Object[] parametros = new Object[6];
    parametros[0] = emp.getCnpj();
    parametros[1] = emp.getNome();
    parametros[2] = emp.getEmail();
    parametros[3] = emp.getTelefone();
    parametros[4] = emp.getEndereco();
    parametros[5] = id;
    jdbc.update(sql, parametros);
   }

    public void deletar(int id){
        String sql = "DELETE FROM empresas WHERE id = ?;";
        jdbc.update(sql, id);
    }
}
