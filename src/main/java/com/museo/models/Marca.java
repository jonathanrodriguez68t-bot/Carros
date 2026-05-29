package com.museo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;

    @Column(name = "anio_fundacion")
    private Integer anioFundacion;

    @Column(name = "pais_origen")
    private String paisOrigen;

    private Integer destacado;
    private String imagen;

    @Column(name = "velocidad_max")
    private double velocidadMax;
    
    @Column(name = "id_categoria")
    private Integer idCategoria;

    public Integer getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Integer idCategoria) { this.idCategoria = idCategoria; }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Integer getAnioFundacion() { return anioFundacion; }
    public void setAnioFundacion(Integer anioFundacion) { this.anioFundacion = anioFundacion; }
    public String getPaisOrigen() { return paisOrigen; }
    public void setPaisOrigen(String paisOrigen) { this.paisOrigen = paisOrigen; }
    public Integer getDestacado() { return destacado; }
    public void setDestacado(Integer destacado) { this.destacado = destacado; }
    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    public double getVelocidadMax() { return velocidadMax; }
    public void setVelocidadMax(double velocidadMax) { this.velocidadMax = velocidadMax; }

    @Override
    public String toString() {
        return "Marca [id=" + id + ", nombre=" + nombre + ", paisOrigen=" + paisOrigen + "]";
    }
}