package org.ovd.entities;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "USERS") // Nom de la table dans la base de données
@AllArgsConstructor
@NoArgsConstructor
public class User extends PanacheEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String userName;

    private String password;
}
