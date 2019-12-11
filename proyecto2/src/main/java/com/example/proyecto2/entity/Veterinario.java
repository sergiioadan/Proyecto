package com.example.proyecto2.entity;

import com.example.proyecto2.controller.VeterinarioController;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import javax.persistence.*;
import java.util.Date;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Entity
@Table(name = "veterinarios")
public class Veterinario extends EntityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String observacion;
    @Temporal(TemporalType.DATE)
    @Column(name = "createdat")
    private Date fechacreacion;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @PostLoad
    public void linkSelf(){
        Link link=linkTo(methodOn(VeterinarioController.class).detalle(String.valueOf(id))).withSelfRel();
        Link link2=linkTo(methodOn(VeterinarioController.class).listar()).withRel("todos");
        this.add(link);
        this.add(link2);
    }
}
