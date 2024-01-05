package br.com.labparadise.labbeach.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.*;

@Entity
@Table(name = "tbl_Neighborhood")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Neighborhood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Name
    @Column(nullable =  false, unique = true)
    @NotBlank
    private String name;

    //Description
    private String description;

    //Visitors
    private Integer visitors;
}
