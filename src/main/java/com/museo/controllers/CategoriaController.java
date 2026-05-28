package com.museo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museo.models.Categoria;
import com.museo.services.ICategoriaServices;

// CAMBIO: Clase renombrada de CategoriaTripController a CategoriaController
// CAMBIO: @RequestMapping cambiado de "/categorias" mantiene el mismo
// CAMBIO: Ahora sí tiene servicio inyectado (en TripAN el controller de categorías no tenía servicio)
// CAMBIO: CRUD completo implementado (crear, listar, editar, eliminar)
@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private ICategoriaServices categoriaServices;

    // READ - listar todas las categorías
    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Categoria> lista = categoriaServices.buscarTodo();
        model.addAttribute("categorias", lista);
        return "categorias/listCategorias";
    }

    // CREATE - formulario nuevo
    @GetMapping("/create")
    public String crear(Model model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("accion", "Nueva Categoría");
        return "categorias/formCategoria";
    }

    // CREATE - guardar (POST)
    @PostMapping("/save")
    public String guardar(Categoria categoria) {
        System.out.println("Nombre Categoría: " + categoria.getNomCategoria());
        System.out.println("Descripción: " + categoria.getDescripcion());
        categoriaServices.guardar(categoria);
        return "redirect:/categorias/index";
    }

    // UPDATE - formulario editar
    @GetMapping("/edit/{id}")
    public String editarForm(@PathVariable("id") int idCategoria, Model model) {
        Categoria categoria = categoriaServices.buscarPorId(idCategoria);
        model.addAttribute("categoria", categoria);
        model.addAttribute("accion", "Editar Categoría");
        return "categorias/formCategoria";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idCategoria) {
        categoriaServices.eliminar(idCategoria);
        return "redirect:/categorias/index";
    }
}
