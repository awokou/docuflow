package com.server.apidocuflow.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.server.apidocuflow.domain.dto.external.CategoryDto;
import com.server.apidocuflow.domain.dto.response.CategoryResponse;
import com.server.apidocuflow.domain.mapper.CategoryMapper;
import com.server.apidocuflow.repository.CategoryRepository;
import com.server.apidocuflow.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveCategory'");
    }

    @Override
    public List<CategoryResponse> getAllCategory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCategory'");
    }
}
