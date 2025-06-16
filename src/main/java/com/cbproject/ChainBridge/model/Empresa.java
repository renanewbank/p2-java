package com.cbproject.ChainBridge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Empresa {
    private String cdCnpj;
    private String nmEmpresa;
    private String dsEmail;

    public Empresa() {
    }

    public Empresa(String cdCnpj, String nmEmpresa, String dsEmail) {
        this.cdCnpj = cdCnpj;
        this.nmEmpresa = nmEmpresa;
        this.dsEmail = dsEmail;
    }

    public String getCdCnpj() {
        return cdCnpj;
    }

    public void setCdCnpj(String cdCnpj) {
        this.cdCnpj = cdCnpj;
    }

    public String getNmEmpresa() {
        return nmEmpresa;
    }

    public void setNmEmpresa(String nmEmpresa) {
        this.nmEmpresa = nmEmpresa;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }
    
    public static Empresa converterUmaEmpresa(Map<String,Object> registro){
        String cdCnpj = (String) registro.get("cd_Cnpj");
        String nmEmpresa = (String) registro.get("nm_Empresa");
        String dsEmail = (String) registro.get("ds_Email");
        Empresa emp = new Empresa(cdCnpj, nmEmpresa, dsEmail);
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

