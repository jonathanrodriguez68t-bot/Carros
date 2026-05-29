package com.museo.repositories;

import com.museo.models.Marca;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
	
	List<Marca> findByIdCategoria(Integer idCategoria);
}