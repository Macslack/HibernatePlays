package com.codeclan.example1.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "theaters")
public class Theater {

    private String name;
    private int id;
    private Set<Play> plays;

    public Theater() {
    }

    public Theater(String name) {
        this.name = name;
        this.plays = new HashSet<Play>();
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "play_theater",
            joinColumns = {@JoinColumn(name = "theater_id" , nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn (name = "play_id", nullable = false  , updatable = false)})
    public Set<Play> getPlays() {
        return plays;
    }

    public void setPlays(Set<Play> plays) {
        this.plays = plays;
    }

    public List<Play> getPlayFromTheater(){
        List<Play> playList = null;
        for (Play play : plays){
            playList.add(play);
        }
        return playList;
    }
}
