package com.application.services.implementations;

import com.application.entities.Category;
import com.application.repositories.CategoryRepository;
import com.application.services.specifications.CategoryServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryServiceSpecification {
    private final CategoryRepository categoryRepositoryBean;

    @Autowired
    public CategoryServiceImplementation(CategoryRepository categoryRepositoryBean) {
        this.categoryRepositoryBean = categoryRepositoryBean;
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepositoryBean.findAll();
    }
}
