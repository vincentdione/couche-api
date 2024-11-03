package org.ovd.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ovd.entities.enu.StatusCommande;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;

    @NotNull(message = "Date de commande ne doit pas etre null")
    private LocalDate orderDate;

    @NotNull(message = "Status ne doit pas etre null")
    private StatusCommande status;
    private List<OrderItemDTO> orderItems;

}
