package com.crud.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.crud.crud.dao.CidadaoDAO;
import com.crud.crud.domain.Cidadao;

@Controller
public class CidadaoController {

    @Autowired
    private CidadaoDAO dao;

    @RequestMapping("lista")
        public String getCidadaos(Model model) {
            model.addAttribute("cidadaos", dao.getCidadaos());
            model.addAttribute("cidadao", new Cidadao());
            return "index";
    }

    @PostMapping("cadastro")
        public String inserirCidadaos(Cidadao cidadao, Model model){
                if(cidadao.getId() != null){
                    dao.updateCidadao(cidadao);
                }else{
                    dao.insertCidadao(cidadao);
                }
            return getCidadaos(model);
        }

    @RequestMapping("cadastro")
    public String cadastrarCidadao(Model model){
        return "cadastro";
    }

    @RequestMapping("cidadaosParametro")
    public String getCidadaos(@RequestParam(value = "nome", required = true) String nome, Model model) {
        model.addAttribute("cidadaos",dao.getCidadaos(nome));
        model.addAttribute("cidadao",new Cidadao());
        model.addAttribute("edit",false);
        return "index";
    }

    @RequestMapping("editarCidadao")
        public String editarCidadao(@RequestParam(value = "id", required = true) int id, Model model){
            model.addAttribute("cidadao", dao.getCidadaos(id));
            return "editar";
    }

    @RequestMapping("excluirCidadao")
    public String deteleCidadao(@RequestParam(value = "id", required = true) int id, Model model){
        dao.deleteCidadao(id);
        return getCidadaos(model);
    }
}
