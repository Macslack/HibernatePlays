package com.codeclan.example1.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    private int id;
    private String name;
    private Set<Play> plays;

    public Author(String name) {
        this.name = name;
        this.plays =  new HashSet<Play>();
    }

    public Author() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "author")
    public Set<Play> getPlays() {
        return plays;
    }

    public void setPlays(Set<Play> plays) {
        this.plays = plays;
    }
}
