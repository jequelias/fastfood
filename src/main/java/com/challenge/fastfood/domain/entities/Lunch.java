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
    private String status;

    public Lunch(Client client, Snack snack, Accompaniment accompaniment, Drink drink, Dessert dessert) {
        this.client = client;
        this.snack = snack;
        this.accompaniment = accompaniment;
        this.drink = drink;
        this.dessert = dessert;
        this.priceTotal = 0;
        if (snack != null) this.priceTotal += snack.getTotalPrice();
        if (accompaniment != null) this.priceTotal += accompaniment.getTotalPrice();
        if (drink != null) this.priceTotal += drink.getTotalPrice();
        if (dessert != null) this.priceTotal += dessert.getTotalPrice();
        this.status = "PENDENTE";
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public double getTotalPrice() {
        priceTotal = 0;
        if (snack != null) priceTotal += snack.getTotalPrice();
        if (accompaniment != null) priceTotal += accompaniment.getTotalPrice();
        if (drink != null) priceTotal += drink.getTotalPrice();
        if (dessert != null) priceTotal += dessert.getTotalPrice();
        return priceTotal;
    }

}
