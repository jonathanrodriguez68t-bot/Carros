package com.museo.services;

import java.util.List;
import com.museo.models.Categoria;


public interface ICategoriaServices {
    List<Categoria> buscarTodo();
    Categoria buscarPorId(Integer idCategoria);
    void guardar(Categoria categoria);
    void eliminar(Integer idCategoria);
}
