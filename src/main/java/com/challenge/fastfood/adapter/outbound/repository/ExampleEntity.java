package com.challenge.fastfood.adapter.outbound.repository;

import com.challenge.fastfood.domain.actor.Example;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "example")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ExampleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Example toDomain() {
        return new Example(name, description);
    }

    public Example toExample() {
        return new Example(name, description);
    }
}
