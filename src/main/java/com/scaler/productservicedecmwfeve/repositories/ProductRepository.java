package com.scaler.productservicedecmwfeve.repositories;
import com.scaler.productservicedecmwfeve.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.scaler.productservicedecmwfeve.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    Page<Product> findByCategory_Id(Long id, Pageable pageable);

    //    List<Product> getProductsById();
    Page<Product> findAll(Pageable pageable);
}
