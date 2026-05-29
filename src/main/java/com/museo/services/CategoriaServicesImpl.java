package com.museo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.museo.models.Categoria;
import com.museo.repositories.CategoriaRepository;

@Service
public class CategoriaServicesImpl implements ICategoriaServices {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> buscarTodo() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        return categoriaRepository.findById(idCategoria).orElse(null);
    }

    @Override
    public void guardar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void eliminar(Integer idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }
}