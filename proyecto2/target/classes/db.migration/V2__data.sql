INSERT INTO `clientes` (`id`, `apellidos`, `email`, `createdat`, `nombre`,`animal`) VALUES
(1, 'Gomez', 'p.gomez@geekshubs.com', '2017-08-28', 'Paco','gato'),
(2, 'Doe', 'john.doe@gmail.com', '2018-08-28', 'John','perro');

INSERT INTO `veterinarios` (`id`, `descripcion`, `createdat`, `observacion`, `cliente_id`) VALUES
(1, 'Primera factura', NULL, 'ESta es una observacion', 1),
(2, 'Segunda factura', NULL, 'ESta es una observacion', 1);