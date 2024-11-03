package org.ovd.repositories;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ovd.entities.Livraison;

@ApplicationScoped
public class LivraisonRepository  implements PanacheRepository<Livraison> {
}
