package org.ovd.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "PRODUITS")
@AllArgsConstructor
@NoArgsConstructor
public class Produit extends PanacheEntity {


    private String name;
    private String description;
    private BigDecimal price;

    @ManyToOne
    private Category category;  // Catégorie: couches, lait

}
