package com.museo.models;

// CAMBIO: Clase renombrada de Trip a Marca
// CAMBIO: Atributos adaptados al dominio de carros deportivos:
//   - nombre          -> nombre de la marca (ej: Ferrari, BMW)
//   - descripcion     -> historia/descripción de la marca
//   - anioFundacion   -> año en que fue fundada (reemplaza a fecha)
//   - paisOrigen      -> país de origen de la marca (nuevo campo)
//   - destacado       -> mantiene misma lógica que TripAN (1=destacado, 0=no)
//   - imagen          -> nombre del archivo de imagen (igual que TripAN)
//   - velocidadMax    -> velocidad máxima del modelo icónico (reemplaza a costo)
public class Marca {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer anioFundacion;
    private String paisOrigen;
    private Integer destacado;
    private String imagen;
    private double velocidadMax;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getAnioFundacion() {
        return anioFundacion;
    }
    public void setAnioFundacion(Integer anioFundacion) {
        this.anioFundacion = anioFundacion;
    }
    public String getPaisOrigen() {
        return paisOrigen;
    }
    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    public Integer getDestacado() {
        return destacado;
    }
    public void setDestacado(Integer destacado) {
        this.destacado = destacado;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public double getVelocidadMax() {
        return velocidadMax;
    }
    public void setVelocidadMax(double velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    @Override
    public String toString() {
        return "Marca [id=" + id + ", nombre=" + nombre + ", paisOrigen=" + paisOrigen
                + ", anioFundacion=" + anioFundacion + ", velocidadMax=" + velocidadMax
                + ", destacado=" + destacado + ", imagen=" + imagen + "]";
    }
}
