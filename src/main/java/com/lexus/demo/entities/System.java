package com.lexus.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "system" )
public class System {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long systemId;
    private String name;

    public long getId_system() {
        return systemId;
    }

    public void setId_system(long id_system) {
        this.systemId = systemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
