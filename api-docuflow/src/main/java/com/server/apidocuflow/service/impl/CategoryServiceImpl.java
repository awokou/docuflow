package com.server.apidocuflow.service.impl;

import java.util.List;

import com.server.apidocuflow.domain.entity.Category;
import com.server.apidocuflow.exception.AlreadyExistException;
import com.server.apidocuflow.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.server.apidocuflow.domain.dto.external.CategoryDto;
import com.server.apidocuflow.domain.mapper.CategoryMapper;
import com.server.apidocuflow.repository.CategoryRepository;
import com.server.apidocuflow.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    @Transactional
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        log.info("Saving category with name: {}", categoryDto.getName());
        if (categoryRepository.existsByName(categoryDto.getName())) {
            throw new AlreadyExistException("Oops!" + categoryDto.getName() + " already exists!");
        }

        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDto> getAllCategory() {
        log.info("Fetching all category");
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::mapToCategoryDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryDto getCategoryById(Long id) {
        log.info("Fetching category with id: {}", id);
        return categoryRepository.findById(id)
                .map(categoryMapper::mapToCategoryDto)
                .orElseThrow(() -> new ResourceNotFoundException("Category does not exist with given id: " + id));
    }

    @Override
    @Transactional
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        log.info("Updating category with id: {}", id);
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category is not exists with given id:" + id));

        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        Category updatedCategory = categoryRepository.save(category);

        return categoryMapper.mapToCategoryDto(updatedCategory);
    }

    @Override
    @Transactional
    public void deleteCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id " + id + " does not exist"));

        categoryRepository.delete(category);
    }
}
