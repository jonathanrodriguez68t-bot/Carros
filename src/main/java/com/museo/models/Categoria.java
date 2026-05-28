package com.museo.models;

// CAMBIO: Package cambiado de com.trips.models a com.museo.models
// CAMBIO: Atributos adaptados:
//   - nomCategoria -> mantiene el mismo nombre
//   - descripcion  -> mantiene el mismo nombre
//   - activo       -> mantiene la misma lógica
// Las categorías son: Superdeportivo, GT, Clásico Deportivo, Hypercar, Berlina Deportiva
public class Categoria {

    private Integer id;
    private String nomCategoria;
    private String descripcion;
    private boolean activo;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNomCategoria() {
        return nomCategoria;
    }
    public void setNomCategoria(String nomCategoria) {
        this.nomCategoria = nomCategoria;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
