package org.ovd.entities;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ovd.entities.enu.StatusCommande;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "ORDERS")
@AllArgsConstructor
@NoArgsConstructor
public class Order extends PanacheEntity {

    private LocalDate orderDate;
    private StatusCommande status;

    @ManyToOne
    private Abonnement abonnement;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

}
