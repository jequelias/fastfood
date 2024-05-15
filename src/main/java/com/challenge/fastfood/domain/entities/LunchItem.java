package com.challenge.fastfood.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LunchItem {

    private Long id;
    private String name;
    private Float price;
    private LunchItemType type;

    public LunchItem(String name, Float price, LunchItemType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
