CREATE TABLE `clientes` (
  `id` bigint(20) NOT NULL,
  `apellidos` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
    `animal` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `createdat` date DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

CREATE TABLE `veterinarios` (
  `id` bigint(20) NOT NULL,
  `descripcion` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `createdat` date DEFAULT NULL,
  `observacion` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

ALTER TABLE `clientes`
    ADD PRIMARY KEY (`id`);

ALTER TABLE `veterinarios`
    ADD PRIMARY KEY (`id`),
    ADD KEY `FK1qiuk10rfkovhlfpsk7oic0v8` (`cliente_id`);

ALTER TABLE `clientes`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `veterinarios`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

