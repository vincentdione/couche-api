package org.ovd.mapper;

import org.mapstruct.Mapper;
import org.ovd.dto.CategoryDTO;
import org.ovd.entities.Category;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ICategoryMapper {
    CategoryDTO toCategoryDTO(Category category);
    Category toCategory(CategoryDTO categoryDTO);

    // Gestion des listes
    List<CategoryDTO> toCategoryDTOs(List<Category> categories);

    List<Category> toCategories(List<CategoryDTO> categoryDTOs);
}
