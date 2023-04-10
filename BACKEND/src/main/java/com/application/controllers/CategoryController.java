package com.application.controllers;

import com.application.classes.HttpResponse;
import com.application.entities.Category;
import com.application.services.specifications.CategoryServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api")
public class CategoryController {
   private final CategoryServiceSpecification categoryServiceBean;

   @Autowired
    public CategoryController(CategoryServiceSpecification categoryServiceBean) {
        this.categoryServiceBean = categoryServiceBean;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getHotels() {
        List<Category> hotels = categoryServiceBean.getCategories();
        return new ResponseEntity<>(hotels, OK);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus);
    }
}
