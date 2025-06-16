
package com.cbproject.ChainBridge.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Contratos {

    private String cdCnpj;  // FK para empresa
    private Integer cdPlano; // FK para plano
    private Date dtInicio;
    private Date dtVencimento;

    public Contratos(){

    }

    public String getCdCnpj() {
        return cdCnpj;
    }

    public void setCdCnpj(String cdCnpj) {
        this.cdCnpj = cdCnpj;
    }

    public Integer getCdPlano() {
        return cdPlano;
    }

    public void setCdPlano(Integer cdPlano) {
        this.cdPlano = cdPlano;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Contratos(String cdCnpj, Integer cdPlano, Date dtInicio, Date dtVencimento) {
        this.cdCnpj = cdCnpj;
        this.cdPlano = cdPlano;
        this.dtInicio = dtInicio;
        this.dtVencimento = dtVencimento;
    }

     public static Contratos converterUmContrato(Map<String,Object> registro){
        String cdCnpj = (String) registro.get("cd_Cnpj");
        Integer cdPlano = (Integer) registro.get("cd_Plano");
        Date dtInicio = (Date) registro.get("dt_Inicio");
        Date dtVencimento = (Date) registro.get("dt_Vencimento");
        Contratos cont = new Contratos(cdCnpj, cdPlano, dtInicio, dtVencimento);
        return cont;
    }

    public static List<Contratos> converterNContratos(List<Map<String,Object>> registros){
        List<Contratos> aux = new ArrayList<Contratos>();
        for(Map<String,Object> reg : registros){
            aux.add(converterUmContrato(reg));
        }
        return aux;
    }
}
