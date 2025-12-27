package com.myspring.demospringboot.model;

import net.datafaker.Faker;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Document("tarjetas")
public class Tarjeta {

    @Id
    private String id;
    private String titulo;
    private String descripcion;
    private String urlProyecto;
    private String lenguaje;
    private String urlImagen;
    private int contadorEstrellas;
    private String color_lenguaje;

    public Tarjeta(String titulo, String descripcion, String urlProyecto,
                   String lenguaje, String urlImagen, String color_lenguaje, int contadorEstrellas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlProyecto = urlProyecto;
        this.lenguaje = lenguaje;
        this.urlImagen = urlImagen;
        this.color_lenguaje = color_lenguaje;
        this.contadorEstrellas = contadorEstrellas;
    }

    public static List<Tarjeta> proyectos() {
        List<Tarjeta> returnProyectos = new ArrayList<>();

        Tarjeta tarjeta1 = new Tarjeta(
                "Gestor de restaurante",
                "App Móvil y App Escritorio para la gestión, servicio y liberación de mesas de un restaurante. Conecta con MongoDB a través de una API Rest.",
                "https://github.com/santimartinezzgb/gestion-mesas-restaurante",
                "Java",
                "/images/tacopaco.png",
                "red",
                0
        );
        returnProyectos.add(tarjeta1);

        Tarjeta tarjeta2 = new Tarjeta(
                "Docker Info",
                "Script escrito en shell para mostrar la información básica de Docker: imágenes, contenedores, volúmenes y redes.",
                "https://github.com/santimartinezzgb/dockerinfo",
                "Shell",
                "/images/docker_info.png",
                "green",
                0
        );
        returnProyectos.add(tarjeta2);

        Tarjeta tarjeta3 = new Tarjeta(
                "Sudoku",
                "App móvil con total jugabilidad de un sudoku, con 3 niveles de dificultad y con ranking de puntuaciones. Conecta con MongoDB a través de una API Rest.",
                "https://github.com/santimartinezzgb/sudoku",
                "Java",
                "/images/sudoku.png",
                "red",
                0
        );
        returnProyectos.add(tarjeta3);

        Tarjeta tarjeta4 = new Tarjeta(
                "Docker Manager",
                "Gestor de docker tipo CRUD para administrar imágenes, contenedores, volúmenes y redes.",
                "https://github.com/santimartinezzgb/Docker-manager",
                "Shell",
                "/images/docker_manager.png",
                "green",
                0
        );
        returnProyectos.add(tarjeta4);

        return returnProyectos;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getUrlProyecto() { return urlProyecto; }
    public void setUrlProyecto(String urlProyecto) { this.urlProyecto = urlProyecto; }

    public String getLenguaje() { return lenguaje; }
    public void setLenguaje(String lenguaje) { this.lenguaje = lenguaje; }

    public String getUrlImagen() { return urlImagen; }
    public void setUrlImagen(String urlImagen) { this.urlImagen = urlImagen; }

    public int getContadorEstrellas() { return contadorEstrellas; }
    public void setContadorEstrellas(int contadorEstrellas) {
        this.contadorEstrellas = contadorEstrellas;
    }

    // ¡FALTABA ESTE GETTER!
    public String getColor_lenguaje() { return color_lenguaje; }
    public void setColor_lenguaje(String color_lenguaje) { this.color_lenguaje = color_lenguaje; }

    public void incrementarEstrellas() {
        this.contadorEstrellas++;
    }
}