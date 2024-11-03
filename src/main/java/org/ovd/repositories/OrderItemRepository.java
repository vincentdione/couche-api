package org.ovd.repositories;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ovd.entities.OrderItem;

import java.util.List;

@ApplicationScoped
public class OrderItemRepository implements PanacheRepository<OrderItem> {
    public List<OrderItem> findByOrderId(Long id) {
        return find("orderId", id).list();
    }
}
