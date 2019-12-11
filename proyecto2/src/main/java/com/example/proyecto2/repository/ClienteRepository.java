package com.example.proyecto2.repository;

import com.example.proyecto2.entity.Cliente;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ClienteRepository implements IClienteDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll(){
        return em.createQuery("SELECT c FROM Cliente c").getResultList();

    }

    @Override
    @Transactional
    public void save(Cliente cliente){
        if(cliente.getId()>0)
            em.merge(cliente);
        else
            em.persist(cliente);
    }


    @Override
    @Transactional(readOnly = true)
    public Cliente findBy(Long id){
        return em.find(Cliente.class,id);
    }


    @Override
    @Transactional
    public void delete(Long id){
        em.remove(findBy(id));
    }
}
