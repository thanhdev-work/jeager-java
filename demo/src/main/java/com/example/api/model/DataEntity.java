package com.example.api.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "data")
public class DataEntity {

    @Id
    private Long id;
    private String data;
}
