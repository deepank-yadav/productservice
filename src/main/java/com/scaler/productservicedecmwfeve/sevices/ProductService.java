package com.scaler.productservicedecmwfeve.sevices;

import com.scaler.productservicedecmwfeve.exceptions.ProductNotExistsException;
import com.scaler.productservicedecmwfeve.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotExistsException;
    List<Product> getAllProduct() throws ProductNotExistsException;

    Product addProduct(Product p);

    Product deleteProduct(Long id) throws ProductNotExistsException;
}
