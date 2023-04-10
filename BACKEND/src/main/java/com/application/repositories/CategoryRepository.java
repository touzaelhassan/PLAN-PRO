package com.application.repositories;

import com.application.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("categoryRepositoryBean")
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
