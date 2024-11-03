package org.ovd.services;

import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectSpy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.ovd.controllers.CategoryController;
import org.ovd.dto.CategoryDTO;
import org.ovd.entities.Category;
import org.ovd.repositories.CategoryRepository;
import org.ovd.services.inter.CategoryService;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@QuarkusTest
@TestHTTPEndpoint(CategoryController.class)
public class CategoryResourceTest {

    @InjectSpy
    CategoryService categoryService;

    @InjectMock
    CategoryRepository categoryRepository;


    @Test
    public void testGetAllCategories() {
        given().when().get()
                .then()
                .statusCode(200);

        verify(categoryService, Mockito.times(1)).getAllCategory();
    }


    @Test
    public void testGetCategoryById_found() {
        // Mock de la catégorie existante
        Category mockCategory = new Category();
        mockCategory.setName("Category 1");

        // Configuration du mock du repository pour retourner cette catégorie
        when(categoryRepository.findByIdOptional(1L)).thenReturn(Optional.of(mockCategory));

        // Exécution de la méthode et vérification
        CategoryDTO categoryDTO = categoryService.getCategoryById(1L);
        assertEquals("Category 1", categoryDTO.getName());
    }


//    @Test
//    public void testCreateCategory() {
//        CategoryDTO categoryDTO = CategoryDTO.builder().name("New Category").build();
//        CategoryDTO createdCategory = CategoryDTO.builder().name("New Category").build();
//        when(categoryService.createCategory(categoryDTO)).thenReturn(createdCategory);
//
//        CategoryController controller = new CategoryController();
//        controller.categoryService = categoryService;
//        Response response = controller.createCategory(categoryDTO);
//
//        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
//        assertEquals(createdCategory, response.getEntity());
//    }

    @Test
    void testCreateCategory() {

        CategoryDTO categoryDTO = CategoryDTO.builder().name("New Category").build();

        given()
                .contentType("application/json")
                .body(categoryDTO)
                .when().post()
                .then().statusCode(201);

        verify(categoryService, Mockito.times(1))
                .createCategory(categoryDTO);
    }


    @Test
    public void testDeleteCategory_Success() {
        // Arrange
        final Long id = 1L; // Identifiant de la catégorie à supprimer
        final Category category = new Category("New Category"); // Créer une catégorie mockée avec l'ID
        // Simuler le comportement du repository pour renvoyer la catégorie quand on recherche par ID
        when(categoryRepository.findByIdOptional(id)).thenReturn(Optional.of(category));
        // Act : appeler la méthode de suppression
        categoryService.deleteCategory(id);
        // Assert : vérifier que deleteById a été appelé une fois avec l'ID correct
        verify(categoryRepository, times(1)).deleteById(id);
    }


//    @Test
//    void testUpdateCategoryEndpoint() {
//        CategoryDTO categoryDTO = CategoryDTO.builder().name("New Category").build();
//        var id = 1L;
//
//        given()
//                .contentType("application/json")
//                .body(categoryDTO)
//                .when().put("{id}",id)
//                .then()
//                .statusCode(200);
//
//        Mockito.verify(categoryService, Mockito.times(1))
//                .updateCategory(id, categoryDTO);
//    }


//    @Test
//    public void testUpdateCategory() {
//        Long id = 1L;
//        CategoryDTO categoryDTO = CategoryDTO.builder().name("Updated Category").build();
//        CategoryDTO updatedCategory = CategoryDTO.builder().name("Updated Category").build();
//        categoryDTO.setId(id);
//
//        when(categoryService.createCategory(categoryDTO)).thenReturn(updatedCategory);
//
//        CategoryController controller = new CategoryController();
//        controller.categoryService = categoryService;
//        Response response = controller.updateCategory(id, categoryDTO);
//
//        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
//        assertEquals(updatedCategory, response.getEntity());
//    }
}
