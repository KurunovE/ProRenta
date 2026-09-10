package com.prorenta.financeservice.service;

import com.prorenta.financeservice.model.dto.CategoryResponseDto;
import com.prorenta.financeservice.model.dto.CreateCategoryRequestDto;
import com.prorenta.financeservice.model.dto.GetAllCategoriesResponseDto;
import com.prorenta.financeservice.model.entity.Category;

import java.util.UUID;

public interface CategoryService {
    Category findAvailableCategoryById(UUID id);
    CategoryResponseDto createCategory(CreateCategoryRequestDto dto);
    GetAllCategoriesResponseDto getCurrentUserCategories();
    void softRemoveCategory(UUID categoryId);
}
