package com.museo.services;

import java.util.List;
import com.museo.models.Marca;

public interface IMarcaServices {
    List<Marca> buscarTodo();
    List<Marca> buscarPorCategoria(Integer idCategoria);
    Marca buscarPorId(Integer idMarca);
    void guardar(Marca marca);
    void eliminar(Integer idMarca); 
}
