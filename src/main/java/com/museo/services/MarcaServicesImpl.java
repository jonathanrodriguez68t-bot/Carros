package com.museo.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.museo.models.Marca;

// CAMBIO: Clase renombrada de tripServicesImpl a MarcaServicesImpl
// CAMBIO: Datos de ejemplo cambiados de viajes a marcas de carros deportivos reales
// CAMBIO: Campos adaptados: anioFundacion, paisOrigen, velocidadMax en vez de fecha, costo
// CAMBIO: Agregado método eliminar (CRUD completo)
// CAMBIO: Se usan datos reales de marcas icónicas deportivas
@Service
public class MarcaServicesImpl implements IMarcaServices {

    List<Marca> lista = null;

    public MarcaServicesImpl() {
        lista = new LinkedList<Marca>();

        // Ferrari - fundada 1939, Italia
        Marca marca1 = new Marca();
        marca1.setId(1);
        marca1.setNombre("Ferrari");
        marca1.setDescripcion("Fundada por Enzo Ferrari, es sinónimo de velocidad, lujo y pasión italiana. Sus modelos icónicos han dominado la Fórmula 1 y las pistas del mundo entero.");
        marca1.setAnioFundacion(1939);
        marca1.setPaisOrigen("Italia");
        marca1.setDestacado(1);
        marca1.setImagen("ferrari.png");
        marca1.setVelocidadMax(340.0);

        // Porsche - fundada 1931, Alemania
        Marca marca2 = new Marca();
        marca2.setId(2);
        marca2.setNombre("Porsche");
        marca2.setDescripcion("Ingeniería alemana de precisión. El 911 es uno de los autos deportivos más reconocidos del mundo, combinando rendimiento extremo con usabilidad cotidiana.");
        marca2.setAnioFundacion(1931);
        marca2.setPaisOrigen("Alemania");
        marca2.setDestacado(1);
        marca2.setImagen("porsche.png");
        marca2.setVelocidadMax(330.0);

        // Lamborghini - fundada 1963, Italia
        Marca marca3 = new Marca();
        marca3.setId(3);
        marca3.setNombre("Lamborghini");
        marca3.setDescripcion("Diseño atrevido y potencia extrema. Nacida de una rivalidad con Ferrari, Lamborghini redefinió lo que significa un superdeportivo con el mítico Miura y el Aventador.");
        marca3.setAnioFundacion(1963);
        marca3.setPaisOrigen("Italia");
        marca3.setDestacado(1);
        marca3.setImagen("lamborghini.png");
        marca3.setVelocidadMax(350.0);

        // BMW - fundada 1916, Alemania
        Marca marca4 = new Marca();
        marca4.setId(4);
        marca4.setNombre("BMW");
        marca4.setDescripcion("La máquina de conducción definitiva. BMW combina tecnología avanzada con dinamismo, siendo líder en berlinas deportivas y coches GT de alto rendimiento.");
        marca4.setAnioFundacion(1916);
        marca4.setPaisOrigen("Alemania");
        marca4.setDestacado(0);
        marca4.setImagen("bmw.png");
        marca4.setVelocidadMax(305.0);

        // Maserati - fundada 1914, Italia
        Marca marca5 = new Marca();
        marca5.setId(5);
        marca5.setNombre("Maserati");
        marca5.setDescripcion("Elegancia italiana con alma deportiva. Maserati ofrece el equilibrio perfecto entre lujo refinado y rendimiento en pista, con un sonido de motor inconfundible.");
        marca5.setAnioFundacion(1914);
        marca5.setPaisOrigen("Italia");
        marca5.setDestacado(0);
        marca5.setImagen("maserati.png");
        marca5.setVelocidadMax(325.0);

        // Audi Sport - fundada 1909, Alemania
        Marca marca6 = new Marca();
        marca6.setId(6);
        marca6.setNombre("Audi");
        marca6.setDescripcion("Tecnología Quattro y diseño vanguardista. Audi ha redefinido el concepto de GT deportivo con modelos como el R8, el superdeportivo más democrático del mundo.");
        marca6.setAnioFundacion(1909);
        marca6.setPaisOrigen("Alemania");
        marca6.setDestacado(1);
        marca6.setImagen("audi.png");
        marca6.setVelocidadMax(320.0);

        // Mercedes-AMG - fundada 1926, Alemania
        Marca marca7 = new Marca();
        marca7.setId(7);
        marca7.setNombre("Mercedes-AMG");
        marca7.setDescripcion("Rendimiento de ingeniería pura. La división AMG de Mercedes-Benz transforma berlinas de lujo en bestias de alto rendimiento con motores handbuilt one man one engine.");
        marca7.setAnioFundacion(1967);
        marca7.setPaisOrigen("Alemania");
        marca7.setDestacado(0);
        marca7.setImagen("mercedes.png");
        marca7.setVelocidadMax(315.0);

        lista.add(marca1);
        lista.add(marca2);
        lista.add(marca3);
        lista.add(marca4);
        lista.add(marca5);
        lista.add(marca6);
        lista.add(marca7);
    }

    @Override
    public List<Marca> buscarTodo() {
        return lista;
    }

    @Override
    public Marca buscarPorId(Integer idMarca) {
        for (Marca marca : lista) {
            if (marca.getId().equals(idMarca)) {
                return marca;
            }
        }
        return null;
    }

    @Override
    public void guardar(Marca marca) {
        // Si tiene id, actualizar (Edit); si no, agregar nuevo (Create)
        if (marca.getId() != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId().equals(marca.getId())) {
                    lista.set(i, marca);
                    return;
                }
            }
        } else {
            // Asignar nuevo id
            int nuevoId = lista.stream().mapToInt(Marca::getId).max().orElse(0) + 1;
            marca.setId(nuevoId);
        }
        lista.add(marca);
    }

    // NUEVO: Método eliminar - en TripAN no estaba implementado
    @Override
    public void eliminar(Integer idMarca) {
        lista.removeIf(m -> m.getId().equals(idMarca));
    }
}
