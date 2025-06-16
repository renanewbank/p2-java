package com.cbproject.ChainBridge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Planos {

    private int id;    
    private String nome, descricao;
    private Double valor;

    public Planos(int id, String nome, String descricao,Double valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public static Planos converterUmPlano (Map<String,Object> registro){
        int id = (Integer) registro.get("cd_plano");
        String nome = (String) registro.get("nm_plano");
        String descricao = (String) registro.get("ds_plano");
        Double preco = (Double) registro.get("vl_plano");
        Planos plano = new Planos(id, nome, descricao, preco);
        return plano;
    }

    public static List<Planos> converterNPlanos(List<Map<String,Object>> registros){
        List<Planos> aux = new ArrayList<Planos>();
        for(Map<String,Object> reg : registros) {
            aux.add(converterUmPlano(reg));
        }
        return aux;
    }
}
