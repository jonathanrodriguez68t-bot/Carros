-- =====================================================
-- MUSEO SPORT CARS - Script de Base de Datos
-- Equivalente al esquema de TripAN pero para carros
-- =====================================================

-- Crear y usar la base de datos
CREATE DATABASE IF NOT EXISTS museo_carros
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE museo_carros;

-- =====================================================
-- TABLA: categorias
-- CAMBIO: Equivalente a la tabla de categorías de TripAN
-- CAMBIO: Campos adaptados al museo de carros deportivos
-- =====================================================
CREATE TABLE IF NOT EXISTS categorias (
    id           INT AUTO_INCREMENT PRIMARY KEY,
    nom_categoria VARCHAR(100) NOT NULL,
    descripcion  TEXT,
    activo       TINYINT(1) DEFAULT 1,
    CONSTRAINT uk_nom_categoria UNIQUE (nom_categoria)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- =====================================================
-- TABLA: marcas
-- CAMBIO: Equivalente a la tabla trips de TripAN
-- CAMBIO: nombre/descripcion mantienen misma lógica
-- CAMBIO: anio_fundacion reemplaza a fecha
-- CAMBIO: pais_origen es campo nuevo
-- CAMBIO: velocidad_max reemplaza a costo
-- CAMBIO: destacado mantiene misma lógica (0/1)
-- CAMBIO: imagen mantiene misma lógica
-- NUEVO: id_categoria como FK a categorias
-- =====================================================
CREATE TABLE IF NOT EXISTS marcas (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    nombre          VARCHAR(100)   NOT NULL,
    descripcion     TEXT,
    anio_fundacion  INT            NOT NULL,
    pais_origen     VARCHAR(80)    NOT NULL,
    destacado       TINYINT(1)     DEFAULT 0,
    imagen          VARCHAR(255)   DEFAULT 'no-image.png',
    velocidad_max   DECIMAL(6,1)   DEFAULT 0.0,
    id_categoria    INT,
    CONSTRAINT fk_marca_categoria
        FOREIGN KEY (id_categoria) REFERENCES categorias(id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- =====================================================
-- DATOS DE EJEMPLO
-- CAMBIO: En lugar de trips de El Salvador, marcas deportivas
-- =====================================================

-- Insertar categorías
INSERT INTO categorias (nom_categoria, descripcion, activo) VALUES
('Superdeportivo',    'Vehículos de alto rendimiento con +500 CV. Ej: Ferrari F8, Lamborghini Huracán.', 1),
('Hypercar',          'La cima de la ingeniería automotriz. Producción limitada y rendimiento extremo.', 1),
('Gran Turismo (GT)', 'Diseñados para larga distancia con alto rendimiento y confort.', 1),
('Berlina Deportiva', 'Sedanes de 4 puertas con motores potentes y manejo dinámico.', 1),
('Clásico Deportivo', 'Íconos históricos que definieron la cultura automotriz.', 0);

-- Insertar marcas
INSERT INTO marcas (nombre, descripcion, anio_fundacion, pais_origen, destacado, imagen, velocidad_max, id_categoria) VALUES
('Ferrari',
 'Fundada por Enzo Ferrari, es sinónimo de velocidad, lujo y pasión italiana. Sus modelos icónicos han dominado la Fórmula 1.',
 1939, 'Italia', 1, 'ferrari.png', 340.0, 1),

('Porsche',
 'Ingeniería alemana de precisión. El 911 es uno de los autos deportivos más reconocidos del mundo.',
 1931, 'Alemania', 1, 'porsche.png', 330.0, 3),

('Lamborghini',
 'Diseño atrevido y potencia extrema. Redefinió lo que significa un superdeportivo con el mítico Miura y el Aventador.',
 1963, 'Italia', 1, 'lamborghini.png', 350.0, 1),

('BMW',
 'La máquina de conducción definitiva. BMW combina tecnología avanzada con dinamismo y berlinas de alto rendimiento.',
 1916, 'Alemania', 0, 'bmw.png', 305.0, 4),

('Maserati',
 'Elegancia italiana con alma deportiva. Ofrece el equilibrio perfecto entre lujo refinado y rendimiento en pista.',
 1914, 'Italia', 0, 'maserati.png', 325.0, 3),

('Audi',
 'Tecnología Quattro y diseño vanguardista. El R8 es considerado el superdeportivo más democrático del mundo.',
 1909, 'Alemania', 1, 'audi.png', 320.0, 1),

('Mercedes-AMG',
 'Rendimiento de ingeniería pura. La división AMG transforma berlinas de lujo en bestias de alto rendimiento.',
 1967, 'Alemania', 0, 'mercedes.png', 315.0, 4);

-- Verificar datos
SELECT m.id, m.nombre, m.pais_origen, m.anio_fundacion, m.velocidad_max, m.destacado, c.nom_categoria
FROM marcas m
LEFT JOIN categorias c ON m.id_categoria = c.id
ORDER BY m.id;
