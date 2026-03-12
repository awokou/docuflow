package com.server.apidocuflow.service;

import com.server.apidocuflow.domain.dto.external.CategoryDto;
import com.server.apidocuflow.domain.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryDto saveCategory(CategoryDto categoryDto);

    List<CategoryResponse> getAllCategory();
}
