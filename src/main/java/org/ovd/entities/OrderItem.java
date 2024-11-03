package org.ovd.entities;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "ORDERITEMS")
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends PanacheEntity {

    private int quantity;

    @ManyToOne
    private Produit product;

    @ManyToOne
    private Order order;

}