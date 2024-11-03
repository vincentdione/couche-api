package org.ovd.services.inter;



import org.ovd.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    public List<CategoryDTO> getAllCategory();
    public void deleteCategory(Long id);

    public CategoryDTO getCategoryById(Long id);

    public CategoryDTO createCategory(CategoryDTO categoryDto);

    List<CategoryDTO> getAllCategories(int pageIndex, int pageSize, String sort);

    CategoryDTO updateCategory(Long id, CategoryDTO categoryDto);


}
