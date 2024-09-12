package fr.eni.demoheritage.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
@SuperBuilder

@Entity
@Table(name = "patients")
public class Patient extends Personne {

    private String nss;


}
