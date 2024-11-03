package org.ovd.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ovd.entities.enu.StatutFrequence;

import java.time.LocalDate;
import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbonnementDTO {

    private Long id;

    @NotNull(message = "Date de debut d'abonnement ne doit pas etre nulle")
    private LocalDate startDate;

    @NotNull(message = "Date de fin d'abonnement ne doit pas etre nulle")
    private LocalDate endDate;

    @NotNull(message = "La fréquence ne doit pas etre nulle")
    private StatutFrequence frequency;
    private List<ProduitDTO> products;


}

