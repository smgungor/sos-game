package com.company;

public class Player extends Character{

    private char character;

    public Player(){

    }

    public Player(char character) {
        this.character = character;
    }


    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        //System.out.println("-> Player icin "+character+" karakteri secildi...\n");
        this.character = character;
    }

}
