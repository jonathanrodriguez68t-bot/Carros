package com.museo.services;

import java.util.List;
import com.museo.models.Categoria;

// NUEVO: Interface para el servicio de categorías (en TripAN esto no estaba implementado)
public interface ICategoriaServices {
    List<Categoria> buscarTodo();
    Categoria buscarPorId(Integer idCategoria);
    void guardar(Categoria categoria);
    void eliminar(Integer idCategoria);
}
