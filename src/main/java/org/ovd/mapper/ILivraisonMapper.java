package org.ovd.mapper;

import org.mapstruct.Mapper;
import org.ovd.dto.LivraisonDTO;
import org.ovd.entities.Livraison;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ILivraisonMapper {
    LivraisonDTO toLivraisonDTO(Livraison livraison);
    Livraison toLivraison(LivraisonDTO livraisonDTO);


    List<LivraisonDTO> toLivraisonDTOs(List<Livraison> livraisons);
    List<Livraison> toLivraisons(List<LivraisonDTO> livraisonDTOs);
}
