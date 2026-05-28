package com.museo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.museo.models.Marca;
import com.museo.services.IMarcaServices;

// CAMBIO: Clase renombrada de TripController a MarcaController
// CAMBIO: @RequestMapping cambiado de "/trips" a "/marcas"
// CAMBIO: Método guardar ahora llama marcaServices (antes tripServices)
// CAMBIO: Método eliminar ahora SÍ elimina de la lista (en TripAN solo mostraba mensaje)
// CAMBIO: Nuevo método editarForm y editar para actualizar (CRUD completo)
@Controller
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private IMarcaServices marcaServices;

    // CREATE - mostrar formulario vacío
    @GetMapping("/create")
    public String crear(Model model) {
        model.addAttribute("marca", new Marca());
        model.addAttribute("accion", "Nueva Marca");
        return "marcas/formMarca";
    }

    // CREATE - guardar nueva marca (POST)
    @PostMapping("/save")
    public String guardar(Marca marca, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "marcas/formMarca";
        }
        marcaServices.guardar(marca);
        System.out.println("Marca guardada: " + marca);
        return "redirect:/tabla";
    }

    // READ - ver detalle de una marca
    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idMarca, Model model) {
        Marca marca = marcaServices.buscarPorId(idMarca);
        System.out.println("IdMarca es: " + idMarca);
        model.addAttribute("marca", marca);
        return "marcas/detalle";
    }

    // UPDATE - mostrar formulario con datos precargados
    // NUEVO: En TripAN no estaba implementado el edit
    @GetMapping("/edit/{id}")
    public String editarForm(@PathVariable("id") int idMarca, Model model) {
        Marca marca = marcaServices.buscarPorId(idMarca);
        model.addAttribute("marca", marca);
        model.addAttribute("accion", "Editar Marca");
        return "marcas/formMarca";
    }

    // DELETE - eliminar marca por id
    // CAMBIO: En TripAN "/delete" solo mostraba un mensaje; aquí SÍ elimina
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idMarca, Model model) {
        marcaServices.eliminar(idMarca);
        System.out.println("Marca eliminada id: " + idMarca);
        return "redirect:/tabla";
    }
}
