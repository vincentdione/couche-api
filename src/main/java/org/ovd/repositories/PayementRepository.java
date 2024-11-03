package org.ovd.repositories;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ovd.entities.Payement;

@ApplicationScoped
public class PayementRepository implements PanacheRepository<Payement> {
}
