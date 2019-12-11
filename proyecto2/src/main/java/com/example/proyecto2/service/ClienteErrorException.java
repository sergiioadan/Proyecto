package com.example.proyecto2.service;

public class ClienteErrorException extends RuntimeException {
    public ClienteErrorException(String msg) {
        super(msg);
    }
}
