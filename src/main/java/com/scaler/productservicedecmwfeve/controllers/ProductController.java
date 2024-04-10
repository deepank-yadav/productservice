package com.scaler.productservicedecmwfeve.controllers;

import com.scaler.productservicedecmwfeve.commons.AuthenticationCommons;
import com.scaler.productservicedecmwfeve.dto.Role;
import com.scaler.productservicedecmwfeve.dto.UserDto;
import com.scaler.productservicedecmwfeve.exceptions.ProductNotExistsException;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.sevices.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private RestTemplate restTemplate;

    private AuthenticationCommons authenticationCommons;

    @Autowired
    //public ProductController(@Qualifier("selfProductService") ProductService productService, RestTemplate restTemplate, AuthenticationCommons authenticationCommons) {
        public ProductController(@Qualifier("fakeStoreProductService") ProductService productService, RestTemplate restTemplate, AuthenticationCommons authenticationCommons) {
        this.productService = productService;
        this.restTemplate = restTemplate;
        this.authenticationCommons = authenticationCommons;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() throws ProductNotExistsException {
//
//        UserDto userDto = authenticationCommons.validateToken(token);
//        if(userDto == null){
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//
//        boolean isAdmin = false;
//
//        for(Role role: userDto.getRole()){
//            if(role.getName().equals("ADMIN")){
//                isAdmin = true;
//                break;
//            }
//        }
//        if(!isAdmin){
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//        List<Product> products = productService.getAllProduct();
        List<Product> products = productService.getAllProduct(); // o p q

        List<Product> finalProducts = new ArrayList<>();

        for (Product p: products) { // o  p q
            p.setTitle("Hello" + p.getTitle());
            finalProducts.add(p);
        }

        ResponseEntity<List<Product>> response = new ResponseEntity<>(
                finalProducts, HttpStatus.FORBIDDEN
        );
        return response;
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) throws ProductNotExistsException {
        return productService.getSingleProduct(id);
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product){

        return productService.addProduct(product);
    }
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product p){
        return new Product();
    }
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product p){
        return new Product();
    }
    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") Long id) throws ProductNotExistsException {
        return productService.deleteProduct(id);
    }

}

