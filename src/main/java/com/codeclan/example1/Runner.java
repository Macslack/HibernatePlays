package com.codeclan.example1;

import com.codeclan.example1.db.DBHelper;
import com.codeclan.example1.models.Author;
import com.codeclan.example1.models.Character;
import com.codeclan.example1.models.Play;
import com.codeclan.example1.models.Theater;

import java.util.List;

public class Runner {

    public static void main(String[] args) {


        Author author1 = new Author("testAuthor");
        DBHelper.save(author1);
        Author author2 = new Author("testAuthor2");
        DBHelper.save(author2);
        Play play2 = new Play("test2Play", author2, 100.00);
        DBHelper.save(play2);
        Play play1 = new Play("testPlay", author1, 50.00);
        DBHelper.save(play1);
        Character character1 = new Character("testCharacter1", play1 , false);
        DBHelper.save(character1);
        Character character2 = new Character("testCharacter2", play2, false);
        DBHelper.save(character2);
        Theater theater1 = new Theater("testTheater");
        DBHelper.save(theater1);
        Theater theater2 = new Theater("test2Theater");

        List<Play>  playlist  = theater2.getPlayFromTheater();
        play1.getTotalMarkUp(playlist);


    }

//    public static double calculateTotalMarkup(Play play){
//        double total = 0;
//
//    }
}
