package com.example.proyecto2.repository;

import com.example.proyecto2.entity.Cliente;
import com.example.proyecto2.entity.ClienteSimplificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClienteRepository extends JpaRepository<Cliente,Long> {
    @Query("SELECT c FROM Cliente c")
    List<ClienteSimplificado> findClienteSimplificado();




}
