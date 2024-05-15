package com.challenge.fastfood.domain.entities;

import com.challenge.fastfood.domain.valueObjects.Accompaniment;
import com.challenge.fastfood.domain.valueObjects.Dessert;
import com.challenge.fastfood.domain.valueObjects.Drink;
import com.challenge.fastfood.domain.valueObjects.Snack;

public class Lunch {

    private Client client;
    private Snack snack;
    private Accompaniment accompaniment;
    private Drink drink;
    private Dessert dessert;
    private double priceTotal;

    public Lunch(Client client, Snack snack, Accompaniment accompaniment, Drink drink, Dessert dessert) {
        this.client = client;
        this.snack = snack;
        this.accompaniment = accompaniment;
        this.drink = drink;
        this.dessert = dessert;
        this.priceTotal = snack.getTotalPrice() + accompaniment.getTotalPrice() + drink.getTotalPrice() + dessert.getTotalPrice();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Snack getSnack() {
        return snack;
    }

    public void setSnack(Snack snack) {
        this.snack = snack;
    }

    public Accompaniment getAccompaniment() {
        return accompaniment;
    }

    public void setAccompaniment(Accompaniment accompaniment) {
        this.accompaniment = accompaniment;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }


    public double getTotalPrice() {
        return snack.getTotalPrice() +
                accompaniment.getTotalPrice() +
                drink.getTotalPrice() +
                dessert.getTotalPrice();
    }

}
