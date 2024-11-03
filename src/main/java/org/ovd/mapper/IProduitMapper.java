package org.ovd.mapper;

import org.mapstruct.Mapper;
import org.ovd.dto.ProduitDTO;
import org.ovd.entities.Produit;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface IProduitMapper {
        ProduitDTO toProduitDTO(Produit product);
        Produit toProduit(ProduitDTO productDTO);


        List<ProduitDTO> toProduitDTOs(List<Produit> produits);
        List<Produit> toProduits(List<ProduitDTO> produitDTOs);

}
