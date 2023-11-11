-- Registro 1
INSERT INTO Cliente
VALUES ('1',  'Apellido 1', 'cliente1@correo.com', 'Dirección 1', 'Cliente 1','123456789', 'CEDULA_CIUDADANIA');

-- Registro 2
INSERT INTO Cliente
VALUES ('2',  'Apellido 2', 'cliente2@correo.com', 'Dirección 2', 'Cliente 2','987654321', 'TARJETA_IDENTIDAD');

-- Registro 3
INSERT INTO Cliente
VALUES ('3',  'Apellido 3', 'cliente3@correo.com', 'Dirección 3', 'Cliente 4', '555555555', 'CEDULA_CIUDADANIA');

-- Registro 4
INSERT INTO Cliente
VALUES ('4',  'Apellido 4', 'cliente4@correo.com', 'Dirección 4', 'Cliente 4', '111111111', 'CEDULA_CIUDADANIA');

-- Registro 5
INSERT INTO Cliente
VALUES ('5',  'Apellido 5', 'cliente5@correo.com', 'Dirección 5', 'Cliente 4', '222222222', 'TARJETA_IDENTIDAD');

-- Registro 1
INSERT INTO Empleado
VALUES ('1', 'Apellido 1', 'password123', 'empleado1@correo.com', 'Dirección 1', 'Juan', '123456789', 'CEDULA_CIUDADANIA');

-- Registro 2
INSERT INTO Empleado
VALUES ('2', 'Apellido 2', 'secret456', 'empleado2@correo.com', 'Dirección 2', 'Empleado 2', '987654321', 'TARJETA_IDENTIDAD');

-- Registro 3
INSERT INTO Empleado
VALUES ('3', 'Apellido 3', 'confidential789', 'empleado3@correo.com', 'Dirección 3', 'Juan', '555555555', 'CEDULA_CIUDADANIA');

-- Registro 4
INSERT INTO Empleado
VALUES ('4', 'Apellido 4', 'securePwd123', 'empleado4@correo.com', 'Dirección 4', 'Empleado 4', '111111111', 'CEDULA_CIUDADANIA');

-- Registro 5
INSERT INTO Empleado
VALUES ('5', 'Apellido 5', 'strongPassword', 'empleado5@correo.com', 'Dirección 5', 'Empleado 5', '222222222', 'TARJETA_IDENTIDAD');
-- Registros de Proveedor
-- Insertar el primer registro
INSERT INTO Proveedor
VALUES ('1', 'proveedor1@correo.com', 'Dirección 1', 'Proveedor 1', '123456789', 'CEDULA_CIUDADANIA');

-- Insertar el segundo registro
INSERT INTO Proveedor
VALUES ('2', 'proveedor2@correo.com', 'Dirección 2', 'Proveedor 2', '987654321', 'PASAPORTE');

-- Insertar el tercer registro
INSERT INTO Proveedor
VALUES ('3', 'proveedor3@correo.com', 'Dirección 3', 'Proveedor 3', '555555555', 'CEDULA_CIUDADANIA');

-- Insertar el cuarto registro
INSERT INTO Proveedor
VALUES ('4', 'proveedor4@correo.com', 'Dirección 4', 'Proveedor 4', '777777777', 'PASAPORTE');

-- Insertar el quinto registro
INSERT INTO Proveedor
VALUES ('5', 'proveedor5@correo.com', 'Dirección 5', 'Proveedor 5', '999999999', 'CEDULA_CIUDADANIA');


-- Registros de Producto
-- Insertar el primer registro con valor de enum
INSERT INTO Producto VALUES (1, 'MAQUILLAJE', 'Producto 1', 100.0, 50.0, 10, '1');

-- Insertar el segundo registro con valor de enum
INSERT INTO Producto VALUES (2, 'CUIDADO_CABELLO', 'Producto 2', 200.0, 100.0, 20, '2');

-- Insertar el tercer registro con valor de enum
INSERT INTO Producto VALUES (3, 'MAQUILLAJE', 'Producto 3', 150.0, 75.0, 15, '3');

-- Insertar el cuarto registro con valor de enum
INSERT INTO Producto VALUES (4, 'CUIDADO_PIEL', 'Producto 4', 300.0, 150.0, 30, '4');

-- Insertar el quinto registro con valor de enum
INSERT INTO Producto VALUES (5, 'CUIDADO_CABELLO', 'Producto 5', 250.0, 125.0, 25, '5');


-- FACTURAS
INSERT INTO Factura VALUES (1,NOW(),'FISICA', 150.0, '1', '1');
INSERT INTO Factura VALUES (2,NOW(),'ELECTRONICA', 120.0, '2', '2');
INSERT INTO Factura VALUES (3,NOW(),'ELECTRONICA', 80.0, '3', '3');
INSERT INTO Factura VALUES (4,NOW(),'ELECTRONICA', 90.0, '4', '4');
INSERT INTO Factura VALUES (5, NOW(),'FISICA', 110.0, '5', '5');


-- DETALLE_FACTURAS

INSERT INTO Detalle_Factura  VALUES (1,1, 20.0, 1, 1);
INSERT INTO Detalle_Factura  VALUES (2,2, 15.0, 2, 2);
INSERT INTO Detalle_Factura  VALUES (3,3, 10.0, 3, 3);
INSERT INTO Detalle_Factura  VALUES (4,1, 30.0, 4, 4);
INSERT INTO Detalle_Factura  VALUES (5,4, 25.0, 5, 5);