package com.cbproject.ChainBridge.model;

// import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanosService {

    @Autowired
    PlanosDAO pdao;

    public Map<String,Object> puxarPlano(int id){
        return pdao.puxarPlano(id);
    }

}
