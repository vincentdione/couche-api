package org.ovd.mapper;

import org.ovd.entities.Abonnement;
import org.mapstruct.Mapper;
import org.ovd.dto.AbonnementDTO;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface IAbonnementMapper {
    AbonnementDTO toAbonnementDTO(Abonnement abonnement);
    Abonnement toAbonnement(AbonnementDTO abonnementDTO);

    // Gestion des listes
    List<AbonnementDTO> toAbonnementDTOs(List<Abonnement> abonnements);
    List<Abonnement> toAbonnements(List<AbonnementDTO> abonnementDTOs);

}