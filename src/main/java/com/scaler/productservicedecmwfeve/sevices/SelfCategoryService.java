package com.scaler.productservicedecmwfeve.sevices;

import com.scaler.productservicedecmwfeve.exceptions.CategoryNotExistsException;
import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfCategoryService")
public class SelfCategoryService implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public SelfCategoryService(CategoryRepository categoryRepository){
        this.categoryRepository =  categoryRepository;
    }
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

}
