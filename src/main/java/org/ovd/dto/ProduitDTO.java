package org.ovd.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitDTO {

    private Long id;

    @NotNull(message = "Product name cannot be null")
    @Size(min = 5, max = 100, message = "Nom de produit doit contenir au moins 5 caracteres")
    private String name;

    @Size(max = 500, message = "Description doit contenir au maximum 500 caracteres")
    private String description;

    @NotNull(message = "Prix ne peut pas etre null")
    @Min(value = 0, message = "Prix doit etre superieur a 0")
    private BigDecimal price;
}

