package com.museo.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.museo.models.Categoria;

// NUEVO: Servicio de categorías implementado (en TripAN solo había controller vacío)
// Las categorías son los tipos de carros deportivos del museo
@Service
public class CategoriaServicesImpl implements ICategoriaServices {

    List<Categoria> lista = null;

    public CategoriaServicesImpl() {
        lista = new LinkedList<Categoria>();

        Categoria cat1 = new Categoria();
        cat1.setId(1);
        cat1.setNomCategoria("Superdeportivo");
        cat1.setDescripcion("Vehículos de alto rendimiento con potencia superior a 500 CV, diseño aerodinámico y tecnología de punta. Ej: Ferrari F8, Lamborghini Huracán.");
        cat1.setActivo(true);

        Categoria cat2 = new Categoria();
        cat2.setId(2);
        cat2.setNomCategoria("Hypercar");
        cat2.setDescripcion("La cima de la ingeniería automotriz. Producción limitada, precios millonarios y rendimiento extremo. Ej: Bugatti Chiron, Koenigsegg Jesko.");
        cat2.setActivo(true);

        Categoria cat3 = new Categoria();
        cat3.setId(3);
        cat3.setNomCategoria("Gran Turismo (GT)");
        cat3.setDescripcion("Diseñados para viajes de larga distancia con alto rendimiento y confort. Combinan velocidad con lujo. Ej: Porsche 911, Aston Martin DB11.");
        cat3.setActivo(true);

        Categoria cat4 = new Categoria();
        cat4.setId(4);
        cat4.setNomCategoria("Berlina Deportiva");
        cat4.setDescripcion("Sedanes de 4 puertas con motores potentes y manejo dinámico. El lujo cotidiano con alma de carreras. Ej: BMW M5, Mercedes-AMG E63.");
        cat4.setActivo(true);

        Categoria cat5 = new Categoria();
        cat5.setId(5);
        cat5.setNomCategoria("Clásico Deportivo");
        cat5.setDescripcion("Íconos históricos que definieron la cultura automotriz. Modelos de colección con historia y valor patrimonial. Ej: Ferrari 250 GTO, Porsche 356.");
        cat5.setActivo(false);

        lista.add(cat1);
        lista.add(cat2);
        lista.add(cat3);
        lista.add(cat4);
        lista.add(cat5);
    }

    @Override
    public List<Categoria> buscarTodo() {
        return lista;
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        for (Categoria cat : lista) {
            if (cat.getId().equals(idCategoria)) {
                return cat;
            }
        }
        return null;
    }

    @Override
    public void guardar(Categoria categoria) {
        if (categoria.getId() != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId().equals(categoria.getId())) {
                    lista.set(i, categoria);
                    return;
                }
            }
        } else {
            int nuevoId = lista.stream().mapToInt(Categoria::getId).max().orElse(0) + 1;
            categoria.setId(nuevoId);
        }
        lista.add(categoria);
    }

    @Override
    public void eliminar(Integer idCategoria) {
        lista.removeIf(c -> c.getId().equals(idCategoria));
    }
}
