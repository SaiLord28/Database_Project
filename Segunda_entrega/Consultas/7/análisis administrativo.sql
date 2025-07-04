-- Cliente 
SELECT DNI, primerNombre, segundoNombre, primerApellido, segundoApellido,
		carrera || ' ' || calle || ' # ' || numero AS direccion,
		tipoCliente
FROM Cliente

-- Consumos
SELECT DNI, primerNombre || ' ' || primerApellido AS nombreCliente,
       nombreServicio, precioServicio, fechaUso
FROM Consume
NATURAL JOIN Cliente
NATURAL JOIN Servicio
ORDER BY DNI, fechaUso;

-- Reserva
SELECT DNI, primerNombre || ' ' || primerApellido AS nombreCliente,
       fechaLlegada, fechaSalida
FROM Reserva
NATURAL JOIN Cliente
ORDER BY DNI, fechaLlegada, fechaSalida;

-- Servicio Mas usado
SELECT idServicio, COUNT(idServicio) AS conteoServicio, nombreServicio, precioServicio 
FROM Consume NATURAL JOIN Servicio
GROUP BY idServicio, nombreServicio, precioServicio
ORDER BY conteoServicio DESC

-- Habitaciones mas reservadas
SELECT idHabitacion, COUNT(idHabitacion) AS conteoHabitacion, nombreCategoria, precioNoche
FROM Reserva NATURAL JOIN Habitacion NATURAL JOIN Categoria
GROUP BY idHabitacion, nombreCategoria, precioNoche
ORDER BY conteoHabitacion DESC