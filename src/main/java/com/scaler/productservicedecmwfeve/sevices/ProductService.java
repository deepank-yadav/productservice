package com.scaler.productservicedecmwfeve.sevices;

import com.scaler.productservicedecmwfeve.exceptions.ProductNotExistsException;
import com.scaler.productservicedecmwfeve.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotExistsException;
    Page<Product> getAllProduct(int pageNumber, int sizeOfPage, String sortBy, String order) throws ProductNotExistsException;

    Product addProduct(Product p);

    Product deleteProduct(Long id) throws ProductNotExistsException;
}
