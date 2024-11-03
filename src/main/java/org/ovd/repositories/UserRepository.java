package org.ovd.repositories;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ovd.entities.User;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}
