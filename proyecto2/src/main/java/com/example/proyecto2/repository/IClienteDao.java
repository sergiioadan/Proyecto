package com.example.proyecto2.repository;

import com.example.proyecto2.entity.Cliente;

import java.util.List;

public interface IClienteDao {

    public List<Cliente> findAll();
    public void save(Cliente cliente);
    public Cliente findBy(Long id);
    public void delete(Long id);
}
