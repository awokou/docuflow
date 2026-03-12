package com.server.apidocuflow.service.impl;

import com.server.apidocuflow.repository.CategoryRepository;
import com.server.apidocuflow.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
}
