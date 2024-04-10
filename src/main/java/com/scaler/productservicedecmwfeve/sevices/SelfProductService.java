package com.scaler.productservicedecmwfeve.sevices;

import com.scaler.productservicedecmwfeve.exceptions.ProductNotExistsException;
import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.repositories.CategoryRepository;
import com.scaler.productservicedecmwfeve.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Primary
@Service("selfProductService")
public class SelfProductService implements ProductService{

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    @Autowired
    public SelfProductService(CategoryRepository categoryRepository, ProductRepository productRepository){
        this.categoryRepository =  categoryRepository;
        this.productRepository = productRepository;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotExistsException("Product with the id:"+id+" does not exists.");
        }
        Product product = productOptional.get();
        return product;
    }

    @Override
    public List<Product> getAllProduct() throws ProductNotExistsException {
        Optional<List<Product>> productsOptional = Optional.of(productRepository.findAll());
        if(productsOptional.isEmpty()){
            throw new ProductNotExistsException("No products available");
        }
        List<Product> products = productsOptional.get();
        return products;

    }

    @Override
    public Product addProduct(Product product) {
        Optional<Category> categoryOptional = categoryRepository.findByName(product.getCategory().getName());

        if(categoryOptional.isEmpty()){

        }else{
            product.setCategory(categoryOptional.get());
            product.setDeleted(false);
        }
        return productRepository.save(product);
    }

    @Override
    public Product deleteProduct(Long id) throws ProductNotExistsException {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotExistsException("Product with the id:"+id+" does not exists.");
        }
        Product product = productOptional.get();
        product.setDeleted(true);
        return productRepository.save(product);
    }
}
