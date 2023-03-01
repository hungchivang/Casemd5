package com.be_casemodule5.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class StatusRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}
