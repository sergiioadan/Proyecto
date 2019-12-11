package com.example.proyecto2.service;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class ClienteException {
    private String message;
    private String detalles;
    @JsonIgnore
    private int tipo;
    private boolean extraer;

    public ClienteException(String message, String details) {
        super();
        this.message = message;
        this.detalles = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String details) {
        this.detalles = details;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isExtraer() {
        return extraer;
    }

    public void setExtraer(boolean extraer) {
        this.extraer = extraer;
    }
}

