package com.cbproject.ChainBridge.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    EmpresaDAO edao;

    public void inserirEmpresa(Empresa emp){
        edao.inserirEmpresa(emp);
    }

    public Map<String,Object> puxarEmpresa(String cdCnpj){
        return edao.puxarEmpresa(cdCnpj);
    }

    public List<Map<String,Object>> puxarTodasEmpresas(){
        return edao.puxarTodasEmpresas();
    }

    public void atualizarEmpresa(Empresa emp, String cdCnpj){
        edao.atualizarEmpresa(emp, cdCnpj);
    }

      public void deletar(String cdCnp){
        edao.deletar(cdCnp);
    }
}