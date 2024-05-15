package com.javaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "rentarea")
public class RentAreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="buildingid")
    private BuildingEntity buildingEntity;


    @Column(name ="value")
    private String value;

    @Column(name ="createddate")
    private Date createddate;

    @Column(name ="modifieddate")
    private Date modifieddate;

    @Column(name ="createdby")
    private Date createdby;

    @Column(name ="modifiedby")
    private Date modifiedby;

}
