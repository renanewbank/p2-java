package com.cbproject.ChainBridge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Empresa {

    
    private int id;
    private String cnpj, nome, email, telefone, endereco;

    public Empresa(){

    }
    
    public Empresa(int id, String cnpj, String nome, String email, String telefone, String endereco) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

     public static Empresa converterUmaEmpresa (Map<String,Object> registro){
        int id = (Integer) registro.get("id");
        String cnpj = (String) registro.get("cnpj");
        String nome = (String) registro.get("nome");
        String email = (String) registro.get("email");
        String telefone = (String) registro.get("telefone");
        String endereco = (String) registro.get("endereco");
        Empresa emp = new Empresa(id, cnpj, nome, email, telefone, endereco);
        return emp;
    }

    public static List<Empresa> converterNEmpresas(List<Map<String,Object>> registros){
        List<Empresa> aux = new ArrayList<Empresa>();
        for(Map<String,Object> reg : registros){
            aux.add(converterUmaEmpresa(reg));
        }
        return aux;
    }
}
