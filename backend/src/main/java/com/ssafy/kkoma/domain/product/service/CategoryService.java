package com.ssafy.kkoma.domain.product.service;

import com.ssafy.kkoma.domain.product.entity.Category;
import com.ssafy.kkoma.domain.product.repository.CategoryRepository;
import com.ssafy.kkoma.global.error.ErrorCode;
import com.ssafy.kkoma.global.error.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public String getCategoryName(Integer categoryId){
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.CATEGORY_NOT_EXISTS));

        return category.getName();
    }

}