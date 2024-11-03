package org.ovd.mapper;

import org.mapstruct.Mapper;
import org.ovd.dto.PayementDTO;
import org.ovd.entities.Payement;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface IPayementMapper {
    PayementDTO toPayementDTO(Payement payment);
    Payement toPayement(PayementDTO paymentDTO);


    List<PayementDTO> toPayementDTOs(List<Payement> payements);
    List<Payement> toPayements(List<PayementDTO> payementDTOs);
}
