package com.be_casemodule5.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double total;
    private Date dateCreate;

    @ManyToOne
    private Account account;

}
