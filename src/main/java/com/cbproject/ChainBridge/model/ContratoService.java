package com.cbproject.ChainBridge.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratoService {

    @Autowired
    ContratoDAO cdao;

    public Map<String,Object> puxarContrato(String cdCnpj){
        return cdao.puxarContrato(cdCnpj);
    }

    public List<Map<String,Object>> puxarTodosContratos(){
        return cdao.puxarTodosContratos();
    }

}
