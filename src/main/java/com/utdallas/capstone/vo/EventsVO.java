package com.utdallas.capstone.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventsVO {

    private String title;
    private String description;
    private String author;
    private String address;
    private String phone;
    private String hours;
    private String email;
    private int id;

}
