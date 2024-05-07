package com.challenge.fastfood.adapter.out.repository;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "client")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;


}
