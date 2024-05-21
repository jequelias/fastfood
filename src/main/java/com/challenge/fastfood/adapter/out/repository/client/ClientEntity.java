package com.challenge.fastfood.adapter.out.repository.client;

import com.challenge.fastfood.adapter.out.repository.lunch.LunchEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany
    private List<LunchEntity> lunches;


}
