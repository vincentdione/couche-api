package org.ovd.repositories;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ovd.entities.Produit;

@ApplicationScoped
public class ProduitRepository  implements PanacheRepository<Produit> {
}
