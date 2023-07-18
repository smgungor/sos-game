package com.company;

public class Computer extends Character{

    private char character;

    public Computer(){

    }

    public Computer(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        //System.out.println("->Computer icin "+character+" karakteri secildi...\n");
        this.character = character;
    }

}
