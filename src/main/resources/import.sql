-- Insertar datos en la tabla paises
INSERT INTO paises (nombre) VALUES ('España'), ('México'), ('Argentina');

-- Insertar datos en la tabla regiones
INSERT INTO regiones (nombre, id_pais) VALUES ('Andalucía', 1), ('Cataluña', 1), ('Ciudad de México', 2), ('Buenos Aires', 3);

-- Insertar datos en la tabla ciudades
INSERT INTO ciudades (nombre, id_region) VALUES ('Sevilla', 1), ('Barcelona', 2), ('CDMX', 3), ('Buenos Aires', 4);

-- Insertar datos en la tabla empresa
INSERT INTO empresa (nombre) VALUES ('Empresa A'), ('Empresa B');

-- Insertar datos en la tabla categorias
INSERT INTO categorias (nombre) VALUES ('Muebles'), ('Relojes'), ('Pinturas');

-- Insertar datos en la tabla epocaantiguedad
INSERT INTO epocaantiguedad (nombre) VALUES ('Renacimiento'), ('Barroco'), ('Modernismo');

-- Insertar datos en la tabla rankingantiguedad
INSERT INTO rankingantiguedad (nombre, puntuacion) VALUES ('Excelente', 5), ('Bueno', 4), ('Regular', 3);

-- Insertar datos en la tabla galeria
INSERT INTO galeria (url) VALUES ('http://galeria1.com'), ('http://galeria2.com');

-- Insertar datos en la tabla genero
INSERT INTO genero (nombre) VALUES ('Masculino'), ('Femenino');

-- Insertar datos en la tabla estadopersona
INSERT INTO estadopersona (estado) VALUES ('Activo'), ('Inactivo');

-- Insertar datos en la tabla persona
INSERT INTO persona (nombre, id_genero, id_estado_persona) VALUES ('Juan Pérez', 1, 1), ('María López', 2, 1);

-- Insertar datos en la tabla sucursal
INSERT INTO sucursal (nombre, id_empresa, id_persona, id_ciudad) VALUES ('Sucursal A', 1, 1, 1), ('Sucursal B', 2, 2, 2);

-- Insertar datos en la tabla antiguedades
INSERT INTO antiguedades (nombre, id_categoria, id_sucursal, id_rankingantiguedad, id_galeria, id_epocaantiguedad) VALUES ('Mesa Renacentista', 1, 1, 1, 1, 1), ('Reloj Barroco', 2, 2, 2, 2, 2);

-- Insertar datos en la tabla clasecontacto
INSERT INTO clasecontacto (tipo) VALUES ('Teléfono'), ('Correo Electrónico');

-- Insertar datos en la tabla contactopersona
INSERT INTO contactopersona (id_clase_contacto, id_persona) VALUES (1, 1), (2, 2);

-- Insertar datos en la tabla tipodireccion
INSERT INTO tipodireccion (tipo) VALUES ('Domicilio'), ('Oficina');

-- Insertar datos en la tabla direccionpersona
INSERT INTO direccionpersona (direccion, id_tipodireccion, id_persona) VALUES ('Calle A', 1, 1), ('Avenida B', 2, 2);

-- Insertar datos en la tabla coleccionistas
INSERT INTO coleccionistas (id_persona) VALUES (1), (2);

-- Insertar datos en la tabla tipo_persona
INSERT INTO tipo_persona (tipo) VALUES ('Cliente'), ('Proveedor');

-- Insertar datos en la tabla personatipopersona
INSERT INTO personatipopersona (id_persona, id_tipopersona) VALUES (1, 1), (2, 2);

-- Insertar datos en la tabla historialpropiedad
INSERT INTO historialpropiedad (id_persona, id_antiguedad, fecha) VALUES (1, 1, '2023-01-01'), (2, 2, '2023-02-01');

-- Insertar datos en la tabla tipotransaccion
INSERT INTO tipotransaccion (tipo) VALUES ('Compra'), ('Venta');

-- Insertar datos en la tabla mediopago
INSERT INTO mediopago (nombre) VALUES ('Tarjeta de Crédito'), ('PayPal');

-- Insertar datos en la tabla transaccionmediopago
INSERT INTO transaccionmediopago (id_mediopago) VALUES (1), (2);

-- Insertar datos en la tabla tipomovcaja
INSERT INTO tipomovcaja (tipo) VALUES ('Entrada'), ('Salida');

-- Insertar datos en la tabla movcaja
INSERT INTO movcaja (id_tipomovcaja) VALUES (1), (2);

-- Insertar datos en la tabla estacionpago
INSERT INTO estacionpago (id_movcaja) VALUES (1), (2);

-- Insertar datos en la tabla transacciones
INSERT INTO transacciones (id_persona, id_tipotransaccion, id_transaccionmediopago, id_estacionpago) VALUES (1, 1, 1, 1), (2, 2, 2, 2);

-- Insertar datos en la tabla empleados
INSERT INTO empleados (id_persona, puesto, salario) VALUES (1, 'Gerente', 5000.00), (2, 'Asistente', 3000.00);

-- Insertar datos en la tabla detalle_transaccion
INSERT INTO detalle_transaccion (id_antiguedad, id_transaccion, cantidad, precio)  VALUES (1, 1, 2, 1500.00), (2, 2, 1, 2500.00);

-- Insertar datos en la tabla despachos
INSERT INTO despachos (id_transaccion, fecha_despacho, direccion) VALUES (1, '2023-01-02', 'Calle A 123'), (2, '2023-02-02', 'Avenida B 456');
