package org.ovd.repositories;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ovd.entities.Abonnement;

@ApplicationScoped
public class AbonnementRepository implements PanacheRepository<Abonnement> {

}
