package org.ovd.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {

    private Long id;
    @NotNull(message = "Quantité ne doit pas etre nulle")
    private int quantity;
    private ProduitDTO product;
    private OrderDTO orderDTO;


}
