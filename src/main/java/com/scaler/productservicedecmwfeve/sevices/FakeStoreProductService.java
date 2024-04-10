package com.scaler.productservicedecmwfeve.sevices;

import com.scaler.productservicedecmwfeve.dto.FakeStoreProductDto;
import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;

    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate, RedisTemplate<String, Object> redisTemplate){
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
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

        Product p = (Product) redisTemplate.opsForHash().get("PRODUCT", "PRODUCT_"+id);

        if(p != null){
            return p;
        }
        ResponseEntity<FakeStoreProductDto> productDto = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class
        );
        Product p1 = convertFakeStoreProductToProduct(productDto.getBody());
        redisTemplate.opsForHash().put("PRODUCT", "PRODUCT_"+id, p1);
    //    return convertFakeStoreProductToProduct(productDto);
        return p1;
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
