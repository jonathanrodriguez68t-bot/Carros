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
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/")
    public String mostrarHome(
            @RequestParam(value = "buscar", required = false, defaultValue = "") String buscar,
            @RequestParam(value = "idCategoria", required = false) Integer idCategoria,
            Model model) {

        List<Marca> lista;

        if (idCategoria != null) {
            lista = marcaServices.buscarPorCategoria(idCategoria);
        } else {
            lista = marcaServices.buscarTodo();
        }

        // Filtrar por nombre si escribieron algo
        if (!buscar.isEmpty()) {
            lista = lista.stream()
                    .filter(m -> m.getNombre().toLowerCase().contains(buscar.toLowerCase()))
                    .collect(java.util.stream.Collectors.toList());
        }

        List<Categoria> categorias = categoriaServices.buscarTodo();
        model.addAttribute("marcas", lista);
        model.addAttribute("categorias", categorias);
        model.addAttribute("buscar", buscar);
        model.addAttribute("idCategoria", idCategoria);
        return "home";
    }

    
    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Marca> lista = marcaServices.buscarTodo();
        model.addAttribute("marcas", lista);
        return "tabla";
    }

    
    @GetMapping("/tablaCategorias")
    public String mostrarTablaCategorias(Model model) {
        List<Categoria> lista = categoriaServices.buscarTodo();
        model.addAttribute("categorias", lista);
        return "categorias/listCategorias";
    }
}
