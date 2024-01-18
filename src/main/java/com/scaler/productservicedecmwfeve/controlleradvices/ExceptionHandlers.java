package com.scaler.productservicedecmwfeve.controlleradvices;

import com.scaler.productservicedecmwfeve.dto.ExceptionDto;
import com.scaler.productservicedecmwfeve.exceptions.CategoryNotExistsException;
import com.scaler.productservicedecmwfeve.exceptions.ProductNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<ExceptionDto> handleProductNotExistsException(
            ProductNotExistsException exception
    ) {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(exception.getMessage());
        dto.setDetail("Check the product id. It probably doesn't exist.");

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @ExceptionHandler(CategoryNotExistsException.class)
    public ResponseEntity<ExceptionDto> handleCategoryNotExistsException(
            CategoryNotExistsException exception
    ){
        ExceptionDto dto =  new ExceptionDto();
        dto.setMessage(exception.getMessage());
        dto.setDetail("Check the category id. It probably doesn't exist.");

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
