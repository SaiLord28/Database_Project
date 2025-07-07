-- Inserciones para la tabla Categoria
INSERT INTO Categoria VALUES (1, 'Sencilla', 'Habitación con una cama individual', 100000);
INSERT INTO Categoria VALUES (2, 'Doble', 'Habitación con cama doble', 140000);
INSERT INTO Categoria VALUES (3, 'Familiar', 'Habitación amplia con dos camas dobles y una individual', 200000);
INSERT INTO Categoria VALUES (4, 'Suite	', 'Habitación de lujo, cama doble y jacuzzi', 250000);

-- Inserciones para la tabla Area
INSERT INTO Area VALUES (1, 'Recepcion');
INSERT INTO Area VALUES (2, 'Limpieza');
INSERT INTO Area VALUES (3, 'Servicios Generales');
INSERT INTO Area VALUES (4, 'Restaurante');
INSERT INTO Area VALUES (5, 'Piscina y Spa');
INSERT INTO Area VALUES (6, 'Seguridad');

-- Inserciones para la tabla Cliente
INSERT INTO Cliente VALUES (1001, 'Gabriela', NULL, 'Castro', 'Granados', 'Calle 10', 'Carrera 5', '23-45');
INSERT INTO Cliente VALUES (1002, 'Laura', NULL, 'Rodriguez', 'Salazar', 'Calle 45', 'Carrera 8', '45-67');
INSERT INTO Cliente VALUES (1003, 'Santiago', 'Miguel', 'Martinez', 'Herrera', 'Calle 12', 'Carrera 6', '115-3');
INSERT INTO Cliente VALUES (1004, 'Valentina', 'Isabel', 'Garcia', 'Ramirez', 'Calle 30', 'Carrera 14', '30-55');
INSERT INTO Cliente VALUES (1005, 'Paola', NULL, 'Vargas', 'Torres', 'Calle 18', 'Carrera 9', '18-33');
INSERT INTO Cliente VALUES (1006, 'Paula', 'Juliana', 'Moreno', 'Ortega', 'Calle 22', 'Carrera 7', '22-88');
INSERT INTO Cliente VALUES (1007, 'Juan', NULL, 'Felipe', 'Castillo', 'Calle 5', 'Carrera 3', '19-34');
INSERT INTO Cliente VALUES (1008, 'Milena', 'Camila', 'Gomez', 'Rivera', 'Calle 16', 'Carrera 12', '16-20');
INSERT INTO Cliente VALUES (1009, 'Diego', 'Armando', 'Rojas', 'Mendoza', 'Calle 8', 'Carrera 4', '90-100');
INSERT INTO Cliente VALUES (1010, 'Natalia', NULL, 'Cardenas', 'Pineda', 'Calle 25', 'Carrera 15', '25-90');

-- Inserciones para la tabla EmailCliente
INSERT INTO EmailCliente VALUES (1001, 'gabriela.castro@example.com');
INSERT INTO EmailCliente VALUES (1001, 'g.castrog@example.com');
INSERT INTO EmailCliente VALUES (1002, 'laura.rodriguez@example.com');
INSERT INTO EmailCliente VALUES (1003, 'santiago.martinez@example.com');
INSERT INTO EmailCliente VALUES (1004, 'valentina.garcia@example.com');
INSERT INTO EmailCliente VALUES (1004, 'v.garcia.r@example.com');
INSERT INTO EmailCliente VALUES (1005, 'paola.vargas@example.com');
INSERT INTO EmailCliente VALUES (1006, 'paula.moreno@example.com');
INSERT INTO EmailCliente VALUES (1007, 'juan.castillo@example.com');
INSERT INTO EmailCliente VALUES (1007, 'j.felipe@example.com');
INSERT INTO EmailCliente VALUES (1008, 'milena.gomez@example.com');
INSERT INTO EmailCliente VALUES (1009, 'diego.rojas@example.com');
INSERT INTO EmailCliente VALUES (1010, 'natalia.cardenas@example.com');
INSERT INTO EmailCliente VALUES (1010, 'n.cardenas.p@example.com');

-- Inserciones para la tabla Empleado
INSERT INTO Empleado VALUES (2001, 'Ana', 'Lucia', 'Martinez', 'Lopez', 'Calle 12', 'Carrera 3', '23-54', 'Limpieza zonas comunes', 2);
INSERT INTO Empleado VALUES (2002, 'Javier', NULL, 'Gonzalez', 'Torres', 'Calle 20', 'Carrera 10', '29-56', 'Limpieza habitaciones', 2);
INSERT INTO Empleado VALUES (2003, 'Jan', 'Henrik', 'Sanchez', 'Jerez', 'Calle 15', 'Carrera 7', '15-50', 'Recepcionista', 1);
INSERT INTO Empleado VALUES (2004, 'Carlos', NULL, 'Salazar', NULL, 'Calle 8', 'Carrera 5', '67-2', 'Chef', 3);
INSERT INTO Empleado VALUES (2005, 'Mariana', NULL, 'Fernandez', 'Ortega', 'Calle 30', 'Carrera 12', '23-45', 'Chef', 3);
INSERT INTO Empleado VALUES (2006, 'Sergio', NULL, 'Mendi', NULL, 'Calle 25', 'Carrera 15', '25-60', 'Mesero', 3);
INSERT INTO Empleado VALUES (2007, 'Daniela', NULL, 'Pineda', NULL, 'Calle 18', 'Carrera 4', '18-45', 'Salvavidas y primeros auxilios', 4);
INSERT INTO Empleado VALUES (2008, 'Luis', 'Fernando', 'Ortiz', 'Rivera', 'Calle 5', 'Carrera 2', '76-1', 'Vigilante camaras ', 5);
INSERT INTO Empleado VALUES (2009, 'Valeria', NULL, 'Jimenez', 'Mendoza', 'Calle 22', 'Carrera 9', '22-99', 'Guardia de seguridad', 5);

-- Inserciones para la tabla EmailEmpleado
INSERT INTO EmailEmpleado VALUES (2001, 'ana.martinez@hotelstaff.com');
INSERT INTO EmailEmpleado VALUES (2002, 'javier.gonzalez@hotelstaff.com');
INSERT INTO EmailEmpleado VALUES (2002, 'j.gonzalez.t@hotelstaff.com');
INSERT INTO EmailEmpleado VALUES (2003, 'jan.sanchez@hotelstaff.com');
INSERT INTO EmailEmpleado VALUES (2004, 'carlos.salazar@hotelstaff.com');
INSERT INTO EmailEmpleado VALUES (2005, 'mariana.fernandez@hotelstaff.com');
INSERT INTO EmailEmpleado VALUES (2006, 'sergio.mendi@hotelstaff.com');
INSERT INTO EmailEmpleado VALUES (2007, 'daniela.pineda@hotelstaff.com');
INSERT INTO EmailEmpleado VALUES (2007, 'd.pineda@hotelstaff.com');
INSERT INTO EmailEmpleado VALUES (2008, 'luis.ortiz@hotelstaff.com');
INSERT INTO EmailEmpleado VALUES (2009, 'valeria.jimenez@hotelstaff.com');
INSERT INTO EmailEmpleado VALUES (2009, 'v.jimenez.mendoza@hotelstaff.com');

-- Inserciones para la tabla Habitacion
INSERT INTO Habitacion VALUES (101, 1);
INSERT INTO Habitacion VALUES (102, 1);
INSERT INTO Habitacion VALUES (103, 1);
INSERT INTO Habitacion VALUES (201, 2);
INSERT INTO Habitacion VALUES (202, 2);
INSERT INTO Habitacion VALUES (203, 2);
INSERT INTO Habitacion VALUES (301, 3);
INSERT INTO Habitacion VALUES (302, 3);
INSERT INTO Habitacion VALUES (303, 3);
INSERT INTO Habitacion VALUES (401, 4);
INSERT INTO Habitacion VALUES (402, 4);

-- Inserciones para la tabla Reserva
INSERT INTO Reserva VALUES (1001, 101, '1/07/2025 14:00', '3/07/2025 12:00');
INSERT INTO Reserva VALUES (1002, 102, '5/06/2025 15:00', '8/07/2025 12:00');
INSERT INTO Reserva VALUES (1003, 201, '10/07/2025 15:00', '14/07/2025 12:00');
INSERT INTO Reserva VALUES (1004, 202, '15/07/2025 16:00', '19/07/2025 12:00');
INSERT INTO Reserva VALUES (1005, 301, '20/06/2025 14:00', '10/07/2025 12:00');
INSERT INTO Reserva VALUES (1006, 302, '28/07/2025 13:00', '31/07/2025 12:00');
INSERT INTO Reserva VALUES (1007, 401, '1/08/2025 15:00', '4/08/2025 12:00');
INSERT INTO Reserva VALUES (1008, 402, '5/08/2025 16:00', '8/08/2025 12:00');
INSERT INTO Reserva VALUES (1009, 103, '3/07/2025 14:00', '13/07/2025 12:00');
INSERT INTO Reserva VALUES (1010, 203, '15/08/2025 15:00', '18/09/2025 12:00');

-- Inserciones para la tabla Consume
INSERT INTO Consume VALUES (1, '1/07/2025 14:00', 1001, 101, '2/07/2025 8:00');
INSERT INTO Consume VALUES (2, '5/06/2025 15:00', 1002, 102, '10/06/2025 17:00');
INSERT INTO Consume VALUES (3, '10/07/2025 15:00', 1003, 201, '12/07/2025 9:00');
INSERT INTO Consume VALUES (4, '15/07/2025 16:00', 1004, 202, '17/07/2025 10:00');
INSERT INTO Consume VALUES (5, '20/06/2025 14:00', 1005, 301, '22/06/2025 14:00');
INSERT INTO Consume VALUES (6, '28/07/2025 13:00', 1006, 302, '28/07/2025 15:00');
INSERT INTO Consume VALUES (1, '1/08/2025 15:00', 1007, 401, '2/08/2025 7:30');
INSERT INTO Consume VALUES (4, '5/08/2025 16:00', 1008, 402, '6/08/2025 18:00');
INSERT INTO Consume VALUES (5, '3/07/2025 14:00', 1009, 103, '11/07/2025 13:30');
INSERT INTO Consume VALUES (6, '15/08/2025 15:00', 1010, 203, '16/08/2025 10:00');

-- Inserciones para la tabla Atiende
INSERT INTO Atiende VALUES (1001, 2006, 3, 101, 1, '1/07/2025 14:00', '2/07/2025 8:00');
INSERT INTO Atiende VALUES (1002, 2001, 2, 102, 2, '5/06/2025 15:00', '10/06/2025 17:00');
INSERT INTO Atiende VALUES (1003, 2002, 2, 201, 3, '10/07/2025 15:00', '12/07/2025 9:00');
INSERT INTO Atiende VALUES (1004, 2009, 5, 202, 4, '15/07/2025 16:00', '17/07/2025 10:00');
INSERT INTO Atiende VALUES (1005, 2008, 5, 301, 5, '20/06/2025 14:00', '22/06/2025 14:00');
INSERT INTO Atiende VALUES (1006, 2007, 4, 302, 6, '28/07/2025 13:00', '28/07/2025 15:00');
INSERT INTO Atiende VALUES (1007, 2006, 3, 401, 1, '1/08/2025 15:00', '2/08/2025 7:30');
INSERT INTO Atiende VALUES (1008, 2009, 5, 402, 4, '5/08/2025 16:00', '6/08/2025 18:00');
INSERT INTO Atiende VALUES (1009, 2008, 5, 103, 5, '3/07/2025 14:00', '11/07/2025 13:30');
INSERT INTO Atiende VALUES (1010, 2007, 4, 203, 6, '15/08/2025 15:00', '16/08/2025 10:00');

-- Inserciones para la tabla TelefonoCliente
INSERT INTO TelefonoCliente (DNI, Telefono) VALUES
(1001, '3101234567'),
(1001, '3129876543'),
(1002, '3157654321'),
(1003, '3115556677'),
(1003, '3109988776');

-- Inserciones para la tabla TelefonoEmpleado
INSERT INTO TelefonoEmpleado (DNIEmpleado, Telefono) VALUES
(2001, '3115551234'),
(2002, '3126667890'),
(2003, '3134445678'),
(2004, '3141239876'),
(2005, '3158765432');

-- Inserciones para la tabla Servicio
INSERT INTO Servicio (idServicio, nombreServicio, detalleServicio, precioServicio) VALUES
(1, 'Desayuno', 'Desayuno tipo buffet', 30000),
(2, 'Spa', 'Acceso al spa por 2 horas', 50000),
(3, 'Lavandería', 'Lavado y planchado de ropa', 15000),
(4, 'Gimnasio', 'Acceso ilimitado al gimnasio', 50000),
(5, 'Parqueadero', 'Uso de parqueadero por 24 horas', 40000);
