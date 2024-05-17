package com.challenge.fastfood.domain.entities;


import com.challenge.fastfood.adapter.out.repository.LunchItemEntity;

import java.util.List;

public class Lunch {

    private Client client;
    private List<LunchItemEntity> lunchItems;
    private double priceTotal;
    private String status;
    private Long id;

    public Lunch(Client client, List<LunchItemEntity> lunchItems, Long id) {
        this.client = client;
        this.lunchItems = lunchItems;
        this.priceTotal = 0;
        for (LunchItemEntity lunchItem : lunchItems) {
            this.priceTotal += lunchItem.getPrice();
        }
        this.status = "PENDENTE";
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public List<LunchItemEntity> getLunchItems() {
            return lunchItems;
        }

    public double getPriceTotal() {
            return priceTotal;
        }

    public String getStatus() {
            return status;
        }

    public void setStatus(String status) {
            this.status = status;
        }

    public void setClient(Client client) {
            this.client = client;
        }

    public void setLunchItems(List<LunchItemEntity> lunchItems) {
            this.lunchItems = lunchItems;
        }

    public void setPriceTotal(double priceTotal) {
            this.priceTotal = priceTotal;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }






}
