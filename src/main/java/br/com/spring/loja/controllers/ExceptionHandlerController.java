package br.com.spring.loja.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public ModelAndView trataDetalheNaoEncontrado(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("error");
//        exception.printStackTrace();

        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}
