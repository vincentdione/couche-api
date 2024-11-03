package org.ovd.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ovd.entities.Category;

@ApplicationScoped
public class CategoryRepository  implements PanacheRepository<Category> {

    // Méthode de recherche par nom
    public Category findByName(String name) {
        return find("name", name).firstResult();
    }

    // Méthode de recherche pour vérifier l'existence d'une catégorie
    public boolean existsByName(String name) {
        return find("name", name).firstResultOptional().isPresent();
    }



}
