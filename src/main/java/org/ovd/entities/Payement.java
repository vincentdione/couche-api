package org.ovd.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ovd.entities.enu.PayementMethod;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@Entity
@Table(name = "PAYEMENTS")
@AllArgsConstructor
@NoArgsConstructor
public class Payement extends PanacheEntity {

    private PayementMethod paymentMethod;  // "Credit Card", "PayPal", "Wave", "OM",  etc.
    private LocalDate paymentDate;
    private BigDecimal amount;

    @ManyToOne
    private Abonnement abonnement;

}
