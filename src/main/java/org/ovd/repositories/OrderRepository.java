package org.ovd.repositories;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ovd.entities.Order;

@ApplicationScoped
public class OrderRepository  implements PanacheRepository<Order> {

}
