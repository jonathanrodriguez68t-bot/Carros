# Museo Sport Cars 🏎️
## Laboratorio 4 - Arquitectura MVC con Spring Boot

Proyecto basado en **TripAN**, adaptado para un museo de marcas de autos deportivos.

---

## Estructura del Proyecto (MVC)

```
MuseoCarros/
├── src/main/java/com/museo/
│   ├── MuseoCarrosApplication.java       ← Main (antes: TripsAnApplication)
│   ├── controllers/
│   │   ├── HomeController.java           ← Rutas /, /tabla, /tablaCategorias
│   │   ├── MarcaController.java          ← CRUD /marcas/** (antes: TripController)
│   │   └── CategoriaController.java      ← CRUD /categorias/** (antes: CategoriaTripController)
│   ├── models/
│   │   ├── Marca.java                    ← Entidad marca (antes: Trip.java)
│   │   └── Categoria.java               ← Entidad categoría (igual estructura)
│   └── services/
│       ├── IMarcaServices.java           ← Interface (antes: ITripServices)
│       ├── MarcaServicesImpl.java        ← Implementación con datos de ejemplo
│       ├── ICategoriaServices.java       ← Interface (nuevo, antes no implementado)
│       └── CategoriaServicesImpl.java    ← Implementación categorías
├── src/main/resources/
│   ├── templates/
│   │   ├── home.html                     ← Página principal (museo hero)
│   │   ├── tabla.html                    ← Tabla de marcas con CRUD
│   │   ├── marcas/
│   │   │   ├── formMarca.html            ← Crear / Editar marca (antes: formTrip.html)
│   │   │   └── detalle.html             ← Detalle de una marca
│   │   ├── categorias/
│   │   │   ├── formCategoria.html       ← Crear / Editar categoría
│   │   │   └── listCategorias.html      ← Lista de categorías con CRUD
│   │   └── fragments/
│   │       ├── menu.html                ← Navbar del museo
│   │       └── footer.html             ← Footer del museo
│   ├── static/images/                   ← Logos de las marcas aquí
│   └── application.properties
├── museo_carros.sql                     ← Script de base de datos MySQL
└── pom.xml
```

---

## Cambios respecto a TripAN

| Elemento TripAN | Equivalente Museo | Cambio |
|---|---|---|
| Trip.java | Marca.java | nombre, fecha→anioFundacion, costo→velocidadMax, +paisOrigen |
| TripController | MarcaController | URLs /trips → /marcas, CRUD completo con delete real |
| ITripServices | IMarcaServices | Misma estructura, adaptada a Marca |
| tripServicesImpl | MarcaServicesImpl | Datos: 7 marcas deportivas reales |
| CategoriaTripController | CategoriaController | Ahora con servicio inyectado y CRUD real |
| home.html | home.html | Hero section en vez de jumbotron, cards de marcas |
| tabla.html | tabla.html | Columnas adaptadas, 3 botones por fila (Ver/Editar/Eliminar) |
| formTrip.html | marcas/formMarca.html | Campos adaptados, funciona para crear Y editar |
| Bootstrap 4 local | Bootstrap 5 CDN | Más moderno, dark theme nativo |
| Colores: negro/blanco | Negro (#0a0a0a) + Rojo Ferrari (#CC0000) | Tema museo deportivo |

---

## Ejecutar el proyecto

```bash
# En la raíz del proyecto
./mvnw spring-boot:run
```

Abre el navegador en: **http://localhost:8080**

---

## Base de Datos

1. Ejecutar `museo_carros.sql` en MySQL Workbench
2. Descomentar la configuración en `application.properties`
3. Ajustar usuario/contraseña

---

## Rutas disponibles

| Ruta | Descripción |
|---|---|
| GET / | Página principal (home del museo) |
| GET /tabla | Tabla CRUD de marcas |
| GET /marcas/create | Formulario nueva marca |
| POST /marcas/save | Guardar marca |
| GET /marcas/view/{id} | Detalle de una marca |
| GET /marcas/edit/{id} | Formulario editar marca |
| GET /marcas/delete/{id} | Eliminar marca |
| GET /categorias/index | Lista de categorías |
| GET /categorias/create | Formulario nueva categoría |
| POST /categorias/save | Guardar categoría |
| GET /categorias/edit/{id} | Formulario editar categoría |
| GET /categorias/delete/{id} | Eliminar categoría |
