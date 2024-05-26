package com.challenge.fastfood.adapter.out.repository.lunch;

import com.challenge.fastfood.adapter.out.repository.lunchItem.LunchItemEntity;
import com.challenge.fastfood.adapter.out.repository.client.ClientEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "lunch")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class LunchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private ClientEntity client;

    @ManyToMany
    @JoinTable(
            name="lunch_lunch_item",
            joinColumns = @JoinColumn(name = "lunch_id"),
            inverseJoinColumns = @JoinColumn(name = "lunch_item_id"))
    private List<LunchItemEntity> lunchItems;

    @Column(name="status")
    private String status;

    @Column(name= "price_total")
    private double priceTotal;
}
