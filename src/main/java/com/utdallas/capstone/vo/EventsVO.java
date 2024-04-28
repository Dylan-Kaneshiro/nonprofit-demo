package com.utdallas.capstone.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventsVO {

    private String title;
    @JsonProperty("body")
    private String description;
    private String author;
    private String address;
    private String phone;
    private String hours;
    private String email;
    private int id;
    private String city;
    private String code;
    private int donationAmount;

}
