package com.company;

import java.util.ArrayList;
import java.util.Random;

import static com.company.Play.play;
import static com.company.PlayGround.areaListCreated;
import static com.company.PlayGround.createBoard;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        char[][] gameBoard = createBoard();
        ArrayList<Area> areaList = areaListCreated(gameBoard.length);

        Player player = new Player();
        Computer computer = new Computer();

        play(areaList, gameBoard, player, computer);
    }
}
