package com.museo.controllers;

import java.util.List;

import com.museo.MuseoCarrosApplication;
import com.museo.models.Marca;
import com.museo.services.IMarcaServices;
import com.museo.services.ICategoriaServices;
import com.museo.models.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// CAMBIO: Clase renombrada de HomeController (misma lógica)
// CAMBIO: Usa IMarcaServices en vez de ITripServices
// CAMBIO: Ruta /tabla muestra marcas (antes mostraba trips)
// CAMBIO: Se elimina la referencia a RolService, se agrega CategoriaServices
@Controller
public class HomeController {

    private final MuseoCarrosApplication museoCarrosApplication;

    @Autowired
    private IMarcaServices marcaServices;

    @Autowired
    private ICategoriaServices categoriaServices;

    HomeController(MuseoCarrosApplication museoCarrosApplication) {
        this.museoCarrosApplication = museoCarrosApplication;
    }

    // CAMBIO: "/" ahora muestra marcas en lugar de trips
    @GetMapping("/")
    public String mostrarHome(Model model) {
        List<Marca> lista = marcaServices.buscarTodo();
        List<Categoria> categorias = categoriaServices.buscarTodo();
        model.addAttribute("marcas", lista);
        model.addAttribute("categorias", categorias);
        return "home";
    }

    // CAMBIO: "/tabla" ahora muestra tabla de marcas
    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Marca> lista = marcaServices.buscarTodo();
        model.addAttribute("marcas", lista);
        return "tabla";
    }

    // CAMBIO: "/categorias" muestra tabla de categorías
    @GetMapping("/tablaCategorias")
    public String mostrarTablaCategorias(Model model) {
        List<Categoria> lista = categoriaServices.buscarTodo();
        model.addAttribute("categorias", lista);
        return "categorias/listCategorias";
    }
}
