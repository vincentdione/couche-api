package org.ovd.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    @NotNull(message = "Date de livraison ne doit pas etre nulle")
    @Size(min = 5, max = 100, message = "Nom de catégorie doit contenir au moins 5 caracteres")
    private String name;
}

