package com.BackTienda.dtos;

public record PaymentIntentRequest(String description,int amount, Currency currency) {
    public enum Currency{
        usd, eur;
    }
}
