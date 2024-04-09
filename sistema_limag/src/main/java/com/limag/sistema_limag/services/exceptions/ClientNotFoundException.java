package com.limag.sistema_limag.services.exceptions;

public class ClientNotFoundException extends  RuntimeException{

    public ClientNotFoundException(String msg) {
        super(msg);
    }
}
