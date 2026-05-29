package com.museo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom_categoria")
    private String nomCategoria;

    private String descripcion;
    private boolean activo;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNomCategoria() { return nomCategoria; }
    public void setNomCategoria(String nomCategoria) { this.nomCategoria = nomCategoria; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}