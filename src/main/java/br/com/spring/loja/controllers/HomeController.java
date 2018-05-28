package br.com.spring.loja.controllers;

import br.com.spring.loja.dao.ProdutoDAO;
import br.com.spring.loja.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProdutoDAO produtoDAO;

	@RequestMapping("/")
    @Cacheable(value = "produtosHome")
	public ModelAndView index() {
//		System.out.println("Entrando na home no casa de código");
        List<Produto> produtos = produtoDAO.listar();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("produtos", produtos);
		return modelAndView;
	}
}
