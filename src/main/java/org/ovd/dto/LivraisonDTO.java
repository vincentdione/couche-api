package org.ovd.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ovd.entities.Adresse;
import org.ovd.entities.enu.StatusLivraison;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivraisonDTO {

    private Long id;


    private Adresse deliveryAddress;

    @NotNull(message = "Date de livraison ne doit pas etre nulle")
    private LocalDate deliveryDate;

    @NotNull(message = "Status de livraison ne doit pas etre nul")
    private StatusLivraison status;

}
