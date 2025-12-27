package com.myspring.demospringboot.controller;

import com.myspring.demospringboot.model.Tarjeta;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Controlador {

    @GetMapping("/")
    public String mostrarProyectos(Model model) {
        List<Tarjeta> tarjetas = Tarjeta.proyectos();

        // Debug: imprime para verificar
        System.out.println("Número de tarjetas: " + tarjetas.size());
        tarjetas.forEach(t -> System.out.println("Tarjeta: " + t.getTitulo()));

        model.addAttribute("tarjetas", tarjetas);
        return "index";
    }
}