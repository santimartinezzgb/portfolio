// archivo: src/main/java/com/myspring/demospringboot/controller/UsuarioController.java
package com.myspring.demospringboot.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "¡Bienvenido a la página de inicio!");
        return "index";
    }

    @GetMapping("/otraRuta")
    public String otraRuta(Model model) {
        model.addAttribute("message", "¡Has accedido a otra ruta!");
        return "index2";
    }
}
