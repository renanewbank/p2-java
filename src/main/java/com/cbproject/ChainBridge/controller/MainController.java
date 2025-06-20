package com.cbproject.ChainBridge.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cbproject.ChainBridge.model.Contratos;
import com.cbproject.ChainBridge.model.Empresa;
import com.cbproject.ChainBridge.model.EmpresaService;

@Controller
public class MainController {

    @Autowired
    private ApplicationContext context;


    @GetMapping("/")
    public String index(){
        return "index";
    }
    
    @GetMapping("/sucesso")
   public String sucesso(){
       return "sucesso";
   }

    @GetMapping("/form")
    public String mostrarFormulario(Model model){
        model.addAttribute("empresas", new Empresa());
        model.addAttribute("link", "/form");
        model.addAttribute("nomePag", "Cadastro de Empresas");
        model.addAttribute("valorBtn", "Criar conta");
        return "form";
    }

    @PostMapping("/form")
    public String create(Model model, @ModelAttribute Empresa emp){
        EmpresaService es = context.getBean(EmpresaService.class);
        es.inserirEmpresa(emp);
        return "redirect:listar";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        EmpresaService es = context.getBean(EmpresaService.class);
        List<Map<String,Object>> lr = es.puxarTodasEmpresas();
        List<Empresa> le = Empresa.converterNEmpresas(lr);
        model.addAttribute("empresas",le);
        return "lista";
    }

    @GetMapping("/editar/{cdCnpj}")
    public String editar(Model model, @PathVariable String cdCnpj){
        EmpresaService es = context.getBean(EmpresaService.class);
        Map<String,Object> reg = es.puxarEmpresa(cdCnpj);
        Empresa emp = Empresa.converterUmaEmpresa(reg);
        model.addAttribute("empresas", emp);
        model.addAttribute("link", "/editar/" + cdCnpj);
        model.addAttribute("nomePag", "Atualizar Informações");
        model.addAttribute("valorBtn", "Salvar alterações");
        return "form";
    }

    @PostMapping("/editar/{cdCnpj}")
    public String editar(@ModelAttribute Empresa emp, @PathVariable String cdCnpj){
        EmpresaService es = context.getBean(EmpresaService.class);
        es.atualizarEmpresa(emp, cdCnpj);
        return "redirect:/listar";
    }

    @PostMapping("/deletar/{cdCnpj}")
    public String deletar(@PathVariable String cdCnpj){
        EmpresaService es = context.getBean(EmpresaService.class);
        es.deletar(cdCnpj);
        return "redirect:/listar";
    }

    // @GetMapping("/planos/{id}")
    // public String puxarPlano(@PathVariable int id, Model model) {
    //     Map<String,Object> plano = planosService.puxarPlano(id);
    //     model.addAttribute("plano", plano);
    //     model.addAttribute("planoId", id);
    //     return "planos";
    // }

    @GetMapping("/planos")
    public String Planos(){
        return "planos";
    }

    

    @GetMapping("/contratos")
    public String mostrarBusca(Model model){
        model.addAttribute("contratos", new Contratos());
        return "contratos";
    }

    // @PostMapping("/contratos")
    // public String mostrarContratos(Model model, @ModelAttribute Contratos cont){
    //     ContratoService cs = context.getBean(ContratoService.class);
    //     cs.puxarContrato(String cdCnpj);
    //     return "redirect:";
    // }
    

}
