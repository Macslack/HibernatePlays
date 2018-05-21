package com.codeclan.example1.models;

import javax.persistence.*;
@Entity
@Table(name = "characters")
public class Character {

    private int id;
    private  String name;
    private Play play;
    private boolean availability;

    public Character() {
    }

    public Character(String name, Play play, boolean availability) {
        this.name = name;
        this.play = play;
        this.availability = availability;
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

    @ManyToOne
    @JoinColumn(name = "play_id", nullable = false)
    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    @Column(name = "availability")
    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
