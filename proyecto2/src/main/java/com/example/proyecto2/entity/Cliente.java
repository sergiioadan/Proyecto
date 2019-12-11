package com.example.proyecto2.entity;

import com.example.proyecto2.controller.ClienteController;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
@Table(name="clientes")
public class Cliente extends EntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;
    private String email;
    private String animal;



    @Column(name = "createdat")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonIgnore
    private Date fechacreacion;

    @JsonManagedReference
    @JsonProperty("veterinarios")
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "cliente")
    private List<Veterinario> veterinarios;

    public Cliente() {
        veterinarios=new ArrayList<Veterinario>();
    }

    @PrePersist
    public void prePersist(){
        fechacreacion=new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }
    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }
    public void setVeterinarios(List<Veterinario> veterinarios) {
        this.veterinarios = veterinarios;
    }

    public String toString(){
        return "[id] "+id+" [nombre] " + nombre + " [apellidos] " + apellidos;
    }

    @PostLoad
    public void addLink(){
        Link link = linkTo(methodOn(ClienteController.class).detalle(String.valueOf(id))).withSelfRel();
        add(link);
    }
}
