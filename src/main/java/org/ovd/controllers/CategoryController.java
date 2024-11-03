package org.ovd.controllers;


import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.ovd.dto.CategoryDTO;
import org.ovd.entities.Category;
import org.ovd.services.inter.CategoryService;

import java.util.List;

@Path("/admin/categories")
@SecurityRequirement(name = "Keycloak")
@Authenticated
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryController {

    @Inject
    public CategoryService categoryService;

    /**
     * Récupère toutes les catégories.
     */
    @GET
    @SecurityRequirement(name = "Keycloak")
    @RolesAllowed("admin")
    public Response getAllCategories() {
        List<CategoryDTO> categories = categoryService.getAllCategory();
        return Response.ok(categories).build();
    }

    @GET
    @Path("/page")
    public Response getpageAllCategories(
            @QueryParam("page") @DefaultValue("0") int pageIndex,
            @QueryParam("size") @DefaultValue("20") int pageSize,
            @QueryParam("sort") String sort) {

        List<CategoryDTO> categories = categoryService.getAllCategories(pageIndex, pageSize, sort);

        // Compter le nombre total d'éléments pour construire la réponse
        long totalCount = Category.count();

        // Construire la réponse
        return Response.ok()
                .entity(categories)
                .header("X-Total-Count", totalCount)
                .header("X-Page-Size", pageSize)
                .header("X-Page-Index", pageIndex)
                .build();
    }

    /**
     * Récupère une catégorie par son ID.
     */
    @GET
    @Path("/{id}")
    public Response getCategoryById(@PathParam("id") Long id) {
        CategoryDTO categoryDTO = categoryService.getCategoryById(id);
        return Response.ok(categoryDTO).build();
    }

    /**
     * Crée une nouvelle catégorie.
     */
    @POST
    //@RolesAllowed("admin")
    public Response createCategory(CategoryDTO categoryDTO) {
        CategoryDTO createdCategory = categoryService.createCategory(categoryDTO);
        return Response.status(Response.Status.CREATED).entity(createdCategory).build();
    }

    /**
     * Supprime une catégorie par son ID.
     */
    @DELETE
    @Path("/{id}")
    //@RolesAllowed("admin")
    public Response deleteCategory(@PathParam("id") Long id) {
        categoryService.deleteCategory(id);
        return Response.noContent().build();
    }

    /**
     * Met à jour une catégorie existante par son ID.
     */
    @PUT
    @Path("/{id}")
    //@RolesAllowed("admin")
    public Response updateCategory(@PathParam("id") Long id, CategoryDTO categoryDTO) {
        categoryDTO.setId(id);  // Associe l'ID de la catégorie existante
        CategoryDTO updatedCategory = categoryService.updateCategory(id,categoryDTO);
        return Response.ok(updatedCategory).build();
    }
}
