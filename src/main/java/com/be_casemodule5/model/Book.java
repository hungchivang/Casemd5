package com.be_casemodule5.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date checkin;
    private Date checkout;

    private String status;



    @ManyToOne
    private Account account;

    @ManyToOne
    private Bill bill;
}
