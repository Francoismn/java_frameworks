package fr.eni.demoheritage.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
@SuperBuilder

@Entity
@DiscriminatorValue("patient")
public class Patient extends Personne {

    private String nss;


}
