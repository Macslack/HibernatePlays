package com.codeclan.example1.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "plays")
public class Play {

    private int id;
    private String name;
    private Set<Theater> theaters;
    private Set<Character> characters;
    private Author author;
    private double markup;


    public Play() {
    }

    public Play(String name, Author author, double markup) {
        this.name = name;
        this.theaters =  new HashSet<Theater>();
        this.characters = new HashSet<Character>();
        this.author = author;
        this.markup = markup;
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




    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "play_theater",
            inverseJoinColumns = {@JoinColumn(name = "theater_id" , nullable = false, updatable = false)},
            joinColumns = {@JoinColumn (name = "play_id", nullable = false  , updatable = false)})
    public Set<Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(Set<Theater> theaters) {
        this.theaters = theaters;
    }

    @OneToMany(mappedBy = "play")
    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Column(name = "markup")
    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }

    public List<Character> getCharacterFromPlay(){
        List<Character> characterList = null;
        for (Character character : characters){
            characterList.add(character);
        }
        return characterList;
    }

    public double getTotalMarkUp(List<Play> plays){
        double total = 0.00;
        for (Play play : plays){
            play.markup += total;
        }
        return total;
    }
}
