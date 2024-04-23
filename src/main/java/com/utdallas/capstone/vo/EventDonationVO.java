package com.utdallas.capstone.vo;

import lombok.Data;

@Data
public class EventDonationVO {
    private String cardHolder;
    private String cardNumber;
    private int cvv;
    private int amount;
    private String expiryDate;
    private int blogID;
}
