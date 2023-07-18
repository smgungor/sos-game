package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayGround {

    // Creating a playground
    public static char [][] createBoard() {

        Scanner scan = new Scanner(System.in);
        int boardSize;

        System.out.println("\n********************************** THE GAME HAS STARTED ************************************************\n");
        while(true){

            System.out.print("----------> Please enter the size of the game board (3-7): ");
            boardSize = scan.nextInt();

            //Size check for entered
            if(3<=boardSize && boardSize<=7){
                break;
            }

            System.out.println("\n!!!!Please enter within limits!!!\n");
        }

        int horizontal = (boardSize);
        int vertical = (boardSize);

        char[][] gameBoard = new char[vertical][horizontal];

        for(int i=0; i<vertical; i++) {
            for(int j=0;j<horizontal;j++) {
                gameBoard[i][j] = '-';
            }
        }

        System.out.println("\n::::::The Created Playground:::::\n");
        printBoard(gameBoard);

        return gameBoard;
    }

    public static void printBoard(char [][] gameBoard){
        System.out.print("      ");
        for(int i=0;i<gameBoard.length;i++) {
            System.out.print((i+1)+"   ");
        }
        System.out.print("\n");
        for(int i=0; i<gameBoard.length; i++) {
            System.out.print((i+1)+"->");
            System.out.print(" | ");
            for(int j=0; j<gameBoard.length; j++){
                System.out.print(gameBoard[i][j]);
                System.out.print(" | ");
            }
            System.out.println("\n");
        }
    }


    //All frames are thrown into arraylist
    public static ArrayList<Area> areaListCreated(int boardSize) {
        ArrayList<Area> boardAreaList = new ArrayList<Area>();

        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize;j++) {
                boardAreaList.add(new Area(i, j));
            }
        }

        return boardAreaList;
    }

}
