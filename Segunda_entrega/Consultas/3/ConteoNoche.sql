DROP VIEW IF EXISTS cantidadNoches;
-- Cantidad de noches en el hotel
SELECT DNI, idHabitacion, fechaLlegada, fechaSalida, fechaSalida::date - fechaLlegada::date AS CantidadDeNoches
FROM Reserva

-- Con vista
CREATE VIEW cantidadNoches AS
	-- Cantidad de noches en el hotel
	SELECT DNI, idHabitacion, fechaLlegada, fechaSalida, fechaSalida::date - fechaLlegada::date AS CantidadDeNoches
	FROM Reserva;