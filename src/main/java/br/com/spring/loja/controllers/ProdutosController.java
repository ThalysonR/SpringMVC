package br.com.spring.loja.controllers;

import br.com.spring.loja.daos.ProdutoDAO;
import br.com.spring.loja.models.Produto;
import br.com.spring.loja.models.TipoPreco;
import br.com.spring.loja.validation.ProdutoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProdutoValidation());
    }

    @RequestMapping("/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView grava(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        System.out.println(request.getQueryString());
        if (result.hasErrors()) {
            return form();
        }

        produtoDAO.gravar(produto);
        redirectAttributes.addFlashAttribute("sucesso", "Produto adicionado com sucesso");
        return new ModelAndView("redirect:produtos");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView lista() {
        ModelAndView modelAndView = new ModelAndView("produtos/lista");
        List<Produto> lista = produtoDAO.lista();
        modelAndView.addObject("produtos", lista);
//        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }
}
