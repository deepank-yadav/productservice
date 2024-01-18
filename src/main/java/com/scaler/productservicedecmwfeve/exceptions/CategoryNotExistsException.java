package com.scaler.productservicedecmwfeve.exceptions;

import ch.qos.logback.core.encoder.EchoEncoder;

public class CategoryNotExistsException extends Exception {

    public CategoryNotExistsException(String message){
        super(message);
    }
}
