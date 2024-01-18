package com.scaler.productservicedecmwfeve.sevices;

import com.scaler.productservicedecmwfeve.exceptions.CategoryNotExistsException;
import com.scaler.productservicedecmwfeve.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory();

}
