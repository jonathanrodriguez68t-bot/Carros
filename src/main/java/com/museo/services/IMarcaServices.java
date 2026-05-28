package com.museo.services;

import java.util.List;
import com.museo.models.Marca;

// CAMBIO: Interface renombrada de ITripServices a IMarcaServices
// CAMBIO: Tipo de retorno cambiado de Trip a Marca
// CAMBIO: Método buscarPorId recibe Integer idMarca en vez de Integer idTrip
// CAMBIO: Agregado método eliminar para completar el CRUD
public interface IMarcaServices {
    List<Marca> buscarTodo();
    Marca buscarPorId(Integer idMarca);
    void guardar(Marca marca);
    void eliminar(Integer idMarca);  // NUEVO: TripAN no tenía eliminar implementado
}
