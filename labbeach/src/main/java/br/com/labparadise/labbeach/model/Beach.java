package br.com.labparadise.labbeach.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tbl_Beach")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Beach implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "beach_id")
    private Long id;

    //Neighborhood
    @OneToOne
    @JoinColumn(name = "neighborhood_id")
    private Neighborhood neighborhood;

    //Name
    @Column(nullable =  false, unique = true)
    @NotBlank
    private String name;

    //Inclusiveness
    private Boolean inclusiveness;

    //Condition
    private String condition;
}
