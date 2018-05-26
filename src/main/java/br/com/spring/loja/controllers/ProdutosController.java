package br.com.spring.loja.controllers;

import br.com.spring.loja.daos.ProdutoDAO;
import br.com.spring.loja.models.Produto;
import br.com.spring.loja.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutosController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping("/produtos/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }

    @RequestMapping("/produtos")
    public String grava(Produto produto) {
        System.out.println(produto);
        produtoDAO.gravar(produto);
        return "produtos/ok";
    }
}
