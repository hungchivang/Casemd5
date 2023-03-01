package com.be_casemodule5.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String area;
    private int bed;
    private int people;
    private String describe1;

    @ManyToOne
    private TypeRoom typeRoom;

    @ManyToOne
    private StatusRoom statusRoom;

}
