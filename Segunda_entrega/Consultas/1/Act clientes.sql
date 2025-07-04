--Actualizar clientes
UPDATE Cliente
SET tipoCliente = 'VIP'
WHERE DNI = '1001';

SELECT * FROM Cliente