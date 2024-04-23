package com.utdallas.capstone.vo;

import lombok.Data;

@Data
public class EventDonationVO {
    private String donorName;
    private String creditCardNumber;
    private int cvv;
    private int donationAmount;
    private String expiryDate;

}
