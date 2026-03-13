package com.server.apidocuflow.service;

import com.server.apidocuflow.domain.dto.external.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto saveCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategory();

    CategoryDto getCategoryById(Long id);

    CategoryDto updateCategory(Long id,CategoryDto categoryDto);

    void deleteCategoryById(Long id);
}
