package com.example.proyecto2.controller;

import com.example.proyecto2.entity.Cliente;
import com.example.proyecto2.entity.ClienteSimplificado;
import com.example.proyecto2.repository.IClienteDao;
import com.example.proyecto2.repository.IClienteRepository;
import com.example.proyecto2.service.ClienteErrorException;
import com.example.proyecto2.service.ClienteException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@ControllerAdvice
@RestController
@RequestMapping("${proyecto.version}")

public class ClienteController extends ResponseEntityExceptionHandler {



    @ExceptionHandler({ClienteErrorException.class,NumberFormatException.class})
    public final ResponseEntity<ClienteException>
    clienteError(Exception ex) throws JsonProcessingException {
        ClienteException exceptionResponse=null;
        if(ex.getClass()==NumberFormatException.class){
            exceptionResponse =
                    new ClienteException("id no numerico",
                            "Los detalles que queramos devolver");
        }else {
            exceptionResponse =
                    new ClienteException(ex.getMessage(),
                            "Los detalles que queramos devolver");
        }

        return new ResponseEntity<ClienteException>
                (exceptionResponse, new HttpHeaders(),
                        HttpStatus.NOT_FOUND);
    }


    @Autowired
    IClienteRepository clienteR;
    IClienteDao clienteDao;


    @CrossOrigin(origins = "http://localhost")
    @GetMapping("/clientes")
    public List<Cliente> listar(){
        System.out.println("PETICION DE LISTADO DE CLIENTES");
        return clienteR.findAll();
    }

    @CrossOrigin(origins = "http://localhost")
    @GetMapping("/clientesSolo")
    public List<ClienteSimplificado> listarSolo(){
        System.out.println("PETICION DE SOLO LISTADO DE CLIENTES");
        return clienteR.findClienteSimplificado();
    }

    @GetMapping("/clientesDetalle")
    public Cliente detalle() {
        throw new ClienteErrorException("id No se ha enviado");
    }

    @GetMapping("/clientesDetalle/{id}")
    public Cliente detalle(@PathVariable String id){
        System.out.println("PETICION DE DETALLE DE CLIENTE");
        if(Integer.parseInt(id)<0) throw new ClienteErrorException("id negativo");
        Cliente cliente=clienteR.findById(Long.parseLong(id)).orElse(null);
        Link link = linkTo(methodOn(ClienteController.class).detalle(String.valueOf(id))).withSelfRel();
        cliente.add(link);
        return cliente;
    }

    @GetMapping("/clientes/error")
    public String errorService() {
        throw new RuntimeException("Un error ha sucedido");
    }


    @PostMapping("/add")
    public List<Cliente> add(@RequestBody Cliente cliente) {
        System.out.println(cliente);
        clienteR.save(cliente);
        return clienteR.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public List<Cliente> delete(@PathVariable String id) {
        clienteR.deleteById(Long.parseLong(id));
        return clienteR.findAll();
    }
    @PutMapping("/update/{id}")
    public List<Cliente> update(@PathVariable String id , @RequestBody Cliente cliente) {
        cliente.setId(Long.parseLong( id));
        clienteR.save(cliente);
        return clienteR.findAll();
    }
}
