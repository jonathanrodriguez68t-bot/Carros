package com.museo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.museo.models.Marca;
import com.museo.repositories.MarcaRepository;

@Service
public class MarcaServicesImpl implements IMarcaServices {
	
	@Override
	public List<Marca> buscarPorCategoria(Integer idCategoria) {
	    return marcaRepository.findByIdCategoria(idCategoria);
	}

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<Marca> buscarTodo() {
        return marcaRepository.findAll();
    }

    @Override
    public Marca buscarPorId(Integer idMarca) {
        return marcaRepository.findById(idMarca).orElse(null);
    }

    @Override
    public void guardar(Marca marca) {
        marcaRepository.save(marca);
    }

    @Override
    public void eliminar(Integer idMarca) {
        marcaRepository.deleteById(idMarca);
    }
}