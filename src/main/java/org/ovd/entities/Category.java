package org.ovd.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@Table(name = "CATEGORIES")
@AllArgsConstructor
@NoArgsConstructor
public class Category extends PanacheEntity {
    private String name;  // "Couches", "Lait"

}
