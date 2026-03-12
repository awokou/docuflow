package com.server.apidocuflow.domain.mapper;

import org.springframework.stereotype.Component;

import com.server.apidocuflow.domain.dto.external.CategoryDto;
import com.server.apidocuflow.domain.entity.Category;

@Component
public class CategoryMapper {

    private CategoryDto mapToCategoryDto(Category category) {

        CategoryDto categoryDto = new CategoryDto();

        return categoryDto;
    }

}
