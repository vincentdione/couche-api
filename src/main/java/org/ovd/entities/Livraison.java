package org.ovd.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ovd.entities.enu.StatusLivraison;

import java.time.LocalDate;

@Data
@Builder
@Entity
@Table(name = "LIVRAISONS")
@AllArgsConstructor
@NoArgsConstructor
public class Livraison extends PanacheEntity {

    private Adresse deliveryAddress;
    private LocalDate deliveryDate;
    private StatusLivraison status;  // "EN_COURS", "LIVRER", "ANNULER"

    @ManyToOne
    private Order order;

}

