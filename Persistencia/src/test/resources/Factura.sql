-- Registro 1
INSERT INTO Factura (fecha, valor_total, cliente_id, empleado_id, tipoFactura)
VALUES (NOW(), 150.0, '1', 'EMP1', 'FISICA');

INSERT INTO Detalle_Factura (cantidad, precio_unidad, factura_id, producto_id)
VALUES (1, 20.0, 1, 1);

-- Registro 2
INSERT INTO Factura (fecha, valor_total, cliente_id, empleado_id, tipoFactura)
VALUES (NOW(), 120.0, '2', '2', 'ELECTRONICA');

INSERT INTO Detalle_Factura (cantidad, precio_unidad, factura_id, producto_id)
VALUES (2, 15.0, 2, 2);

-- Registro 3
INSERT INTO Factura (fecha, valor_total, cliente_id, empleado_id, tipoFactura)
VALUES (NOW(), 80.0, '3', '3', 'FISICA');

INSERT INTO Detalle_Factura (cantidad, precio_unidad, factura_id, producto_id)
VALUES (3, 10.0, 3, 3);

-- Registro 4
INSERT INTO Factura (fecha, valor_total, cliente_id, empleado_id, tipoFactura)
VALUES (NOW(), 90.0, '4', '4', 'ELECTRONICA');

INSERT INTO Detalle_Factura (cantidad, precio_unidad, factura_id, producto_id)
VALUES (1, 30.0, 4, 4);

-- Registro 5
INSERT INTO Factura (fecha, valor_total, cliente_id, empleado_id, tipoFactura)
VALUES (NOW(), 110.0, '5', '5', 'FISICA');

INSERT INTO Detalle_Factura (cantidad, precio_unidad, factura_id, producto_id)
VALUES (4, 25.0, 5, 5);
