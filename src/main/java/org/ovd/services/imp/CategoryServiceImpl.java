package org.ovd.services.imp;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.ovd.dto.CategoryDTO;
import org.ovd.exceptions.DuplicateResourceException;
import org.ovd.exceptions.ResourceNotFoundException;
import org.ovd.mapper.ICategoryMapper;
import org.ovd.repositories.CategoryRepository;
import org.ovd.entities.Category;
import org.ovd.services.inter.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ApplicationScoped
public class CategoryServiceImpl implements CategoryService {

    @Inject
    CategoryRepository categoryRepository;

    @Inject
    ICategoryMapper categoryMapper;

    @Override
    @Transactional
    public List<CategoryDTO> getAllCategory() {
        return categoryMapper.toCategoryDTOs(categoryRepository.listAll());
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        if (categoryRepository.findByIdOptional(id).isEmpty()) {
            throw new ResourceNotFoundException("Impossible de supprimer : catégorie introuvable avec l'ID "+ id);
        }
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CategoryDTO getCategoryById(Long id) {
        return categoryRepository.findByIdOptional(id)
                .map(categoryMapper::toCategoryDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Catégorie introuvable avec l'ID "+ id));
    }

    @Override
    @Transactional
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        if (categoryRepository.existsByName(categoryDTO.getName())) {
            throw new DuplicateResourceException("Une catégorie avec le même nom existe déjà : " + categoryDTO.getName());
        }
        Category category = categoryMapper.toCategory(categoryDTO);
        categoryRepository.persist(category);  // Utilisez persist() avec Panache
        // Ensure it's a new entity

        return categoryMapper.toCategoryDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories(int pageIndex, int pageSize, String sort) {
        PanacheQuery<Category> query= Category.findAll();;

        // Créer une requête avec tri
        if (sort != null && !sort.isEmpty()) {
            query = Category.find("ORDER BY " + sort);
        } else {
            query = Category.findAll();
        }

        // Récupérer la page de catégories
        List<Category> categories = query.page(pageIndex, pageSize).list();

        // Mapper les entités en DTOs
        return categories.stream()
                .map(category -> new CategoryDTO(category.id, category.getName()))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findByIdOptional(id)
                .orElseThrow(() -> new ResourceNotFoundException("Catégorie introuvable avec l'ID " + id));
        // Mise à jour des champs de la catégorie
        category.setName(categoryDTO.getName());

        // Si le repository utilise Panache, la modification est automatique après `flush`
        categoryRepository.flush();

        return categoryMapper.toCategoryDTO(category);
    }
}
