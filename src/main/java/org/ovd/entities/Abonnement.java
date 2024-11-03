package org.ovd.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "ABONNEMENTS")
@AllArgsConstructor
@NoArgsConstructor
public class Abonnement extends PanacheEntity {
    private LocalDate startDate;
    private LocalDate endDate;
    private String frequency;  // Ex: "semaine", "mois"

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Produit> products;

    @OneToMany(mappedBy = "abonnement")
    private List<Order> orders;

}
