package com.scaler.productservicedecmwfeve.sevices;

import com.scaler.productservicedecmwfeve.dto.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    public Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setId(fakeStoreProductDto.getId());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());

        return product;

    }
    @Override
    public Product getSingleProduct(Long id){
        FakeStoreProductDto productDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class
        );
        return convertFakeStoreProductToProduct(productDto);
    }

    @Override
    public List<Product> getAllProduct(){
        return null;
    }

    @Override
    public Product addProduct(Product p){

      /*  FakeStoreProductDto productDto = restTemplate.postForObject("https://fakestoreapi.com/products"
                    ,FakeStoreProductDto.class);
        restTemplate.
        return convertFakeStoreProductToProduct(productDto);*/
        return new Product();
    }

    @Override
    public Product deleteProduct(Long id){
        return new Product();
    }

}
