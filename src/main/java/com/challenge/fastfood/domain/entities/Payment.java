package com.challenge.fastfood.domain.entities;

public class Payment {
    private Long idLunch;
    private double value;
    private String status;



    public Payment(Long idLunch, double value) {
        this.idLunch = idLunch;
        this.value = value;
        this.status = "PENDING";
    }

    public Long getIdLunch() {
        return idLunch;
    }

    public double getValue() {
        return value;
    }

    public void setPaymentStatus(String paymentProcessedSuccessfully) {
        this.status = paymentProcessedSuccessfully;
    }

    public String getStatus() {
        return status;
    }
}
