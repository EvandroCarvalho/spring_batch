package com.spring.batch.Entity;

import com.spring.batch.Entity.Cep;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Evandro Carvalho
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Person {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String cpf;
    @OneToOne
    @JoinColumn(name = "id_cep", referencedColumnName = "id")
    private Cep cep;
}
