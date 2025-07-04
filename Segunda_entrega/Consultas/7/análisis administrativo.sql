-- Cliente
DROP VIEW IF EXISTS InfoCliente;
CREATE VIEW InfoCliente AS
SELECT DNI, primerNombre, segundoNombre, primerApellido, segundoApellido,
		carrera || ' ' || calle || ' # ' || numero AS direccion,
		tipoCliente
FROM Cliente;

SELECT * FROM InfoCliente

-- Consumos
DROP VIEW IF EXISTS ConsumoCliente;
CREATE VIEW ConsumoCliente AS
SELECT DNI, primerNombre || ' ' || primerApellido AS nombreCliente,
       nombreServicio, precioServicio, fechaUso
FROM Consume
NATURAL JOIN Cliente
NATURAL JOIN Servicio
ORDER BY DNI, fechaUso;

SELECT * FROM ConsumoCliente

-- Reserva
DROP VIEW IF EXISTS InfoReserva;
CREATE VIEW InfoReserva AS 
SELECT DNI, primerNombre || ' ' || primerApellido AS nombreCliente,
       fechaLlegada, fechaSalida
FROM Reserva
NATURAL JOIN Cliente
ORDER BY DNI, fechaLlegada, fechaSalida;

SELECT * FROM InfoReserva

-- Servicio Mas usado
DROP VIEW IF EXISTS ServicioMasUsado;
CREATE VIEW ServicioMasUsado AS
SELECT idServicio, COUNT(idServicio) AS conteoServicio, nombreServicio, precioServicio 
FROM Consume NATURAL JOIN Servicio
GROUP BY idServicio, nombreServicio, precioServicio
ORDER BY conteoServicio DESC;

SELECT * FROM ServicioMasUsado

-- Habitaciones mas reservadas
DROP VIEW IF EXISTS HabitacionMasReservada
CREATE VIEW HabitacionMasReservada AS
SELECT idHabitacion, COUNT(idHabitacion) AS conteoHabitacion, nombreCategoria, precioNoche
FROM Reserva NATURAL JOIN Habitacion NATURAL JOIN Categoria
GROUP BY idHabitacion, nombreCategoria, precioNoche
ORDER BY conteoHabitacion DESC;

SELECT * FROM HabitacionMasReservada