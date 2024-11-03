package org.ovd.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ovd.entities.enu.PayementMethod;

import java.math.BigDecimal;
import java.time.LocalDate;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayementDTO {

    private Long id;

    @NotNull(message = "Méthode de payement ne doit pas etre nulle")
    private PayementMethod paymentMethod;

    @NotNull(message = "Date de payement ne doit pas etre null")
    private LocalDate paymentDate;

    @NotNull(message = "Montant ne doit pas etre null")
    @Positive(message = "Montant doit etre positif")
    private BigDecimal amount;

    private Long abonnementId;
}
