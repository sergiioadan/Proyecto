package com.example.proyecto2.controller;

import com.example.proyecto2.entity.Cliente;
import com.example.proyecto2.entity.Veterinario;
import com.example.proyecto2.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/v1")

public class VeterinarioController {


    @Autowired
    VeterinarioRepository veterinarioR;

    @GetMapping("/veterinarios")
    public List<Veterinario> listar(){
        System.out.println("PETICION DE LISTADO DE Veterinarios");
        return veterinarioR.findAll();
    }

    @GetMapping("/veterinarioDetalle/{id}")
    public Veterinario detalle(@PathVariable String id){
        System.out.println("PETICION DE DETALLE DE VETERINARIO");
        Veterinario veterinario=veterinarioR.findById(Long.parseLong(id)).orElse(null);
        //Link link=linkTo(FacturaController.class).withRel("prueba");
        Link link=linkTo(methodOn(VeterinarioController.class).detalle(String.valueOf(veterinario.getId()))).withSelfRel();
        veterinario.add(link);
        return veterinario;
    }
/*
    @PostMapping("/add")
    public List<Veterinario> add(@RequestBody Veterinario veterinario) {
        System.out.println(veterinario);
        veterinarioR.save(veterinario);
        return veterinarioR.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public List<Veterinario> delete(@PathVariable String id) {
        veterinarioR.deleteById(Long.parseLong(id));
        return veterinarioR.findAll();
    }
    @PutMapping("/update/{id}")
    public List<Veterinario> update(@PathVariable String id , @RequestBody Veterinario veterinario) {
        veterinario.setId(Long.parseLong( id));
        veterinarioR.save(veterinario);
        return veterinarioR.findAll();
    }
    */
}
