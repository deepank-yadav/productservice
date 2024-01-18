package com.scaler.productservicedecmwfeve.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.scaler.productservicedecmwfeve.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {



    //    List<Product> getProductsById();
}
