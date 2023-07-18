package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static com.company.PlayGround.printBoard;

public class Play {

    public static boolean winControl(int satir, int sutun, char [][] gameBoard, char character, Character player) {

        boolean scoreControl = false;

        if (character == 'S') {
            char midCharacter = 'O';

            //Horizontal Win Control
            if ((sutun+1)<gameBoard.length && (sutun+2)<gameBoard.length) {
                if(gameBoard[satir][sutun+1] == midCharacter && gameBoard[satir][sutun+2]==character){
                    player.scoreCountUp();
                    scoreControl = true;
                }
            }

            if ((sutun-1)>=0 && (sutun-2)>=0) {
                if (gameBoard[satir][sutun-1] == midCharacter && (sutun-1)>=0 && gameBoard[satir][sutun-2]==character) {
                    player.scoreCountUp();
                    scoreControl = true;
                }
            }

            //Vertical Win Control
            if (satir+1<gameBoard.length && satir+2<gameBoard.length) {
                if (gameBoard[satir+1][sutun] == midCharacter && gameBoard[satir+2][sutun]==character){
                    player.scoreCountUp();
                    scoreControl = true;
                }
            }

            if (satir-1>=0 && satir-2>=0) {
                if (gameBoard[satir-1][sutun] == midCharacter && gameBoard[satir-2][sutun]==character){
                    player.scoreCountUp();
                    scoreControl = true;
                }
            }

            //Diagonal Win
            if (satir+1<gameBoard.length && satir+2<gameBoard.length && sutun+1<gameBoard.length && sutun+2<gameBoard.length) {
                if (gameBoard[satir+1][sutun+1] == midCharacter && gameBoard[satir+2][sutun+2]==character){
                    player.scoreCountUp();
                    scoreControl = true;
                }
            }
            if (satir-1>=0 && satir-2>=0 && sutun-1>=0 && sutun-2>=0) {
                if (gameBoard[satir-1][sutun-1] == midCharacter && gameBoard[satir-2][sutun-2]==character){
                    player.scoreCountUp();
                    scoreControl = true;
                }
            }

            if (satir+1<gameBoard.length && satir+2<gameBoard.length && sutun-1>=0 && sutun-2>=0) {
                if (gameBoard[satir+1][sutun-1] == midCharacter && gameBoard[satir+2][sutun-2]==character){
                    player.scoreCountUp();
                    scoreControl = true;
                }
            }

            if (satir-1>=0 && satir-2>=0 && sutun+1<gameBoard.length && sutun+2<gameBoard.length) {
                if (gameBoard[satir-1][sutun+1] == midCharacter && gameBoard[satir-2][sutun+2]==character){
                    player.scoreCountUp();
                    scoreControl = true;
                }
            }


        } else {

            char cornerCharacter = 'S';

            if ((sutun-1)>=0 && (sutun+1)<gameBoard.length) {
                if(gameBoard[satir][sutun-1] == cornerCharacter && gameBoard[satir][sutun+1]==cornerCharacter){
                    player.scoreCountUp();
                    scoreControl = true;
                }
            }

            if (satir-1>=0 && satir+1<gameBoard.length) {
                if (gameBoard[satir-1][sutun] == cornerCharacter && gameBoard[satir+1][sutun]==cornerCharacter){
                    player.scoreCountUp();
                    scoreControl = true;
                }
            }

            if (satir+1<gameBoard.length && sutun+1<gameBoard.length && satir-1>=0 && sutun-1>=0) {
                if (gameBoard[satir+1][sutun+1] == cornerCharacter && gameBoard[satir-1][sutun-1]==cornerCharacter){
                    player.scoreCountUp();
                    scoreControl = true;
                }
            }

            if (satir-1>=0 && sutun+1<gameBoard.length && satir+1<gameBoard.length && sutun-1>=0) {
                if (gameBoard[satir-1][sutun+1] == cornerCharacter && gameBoard[satir+1][sutun-1]==cornerCharacter){
                    player.scoreCountUp();
                    scoreControl = true;
                }
            }

        }

        return scoreControl;
    }

    // The game is played with the entered parameters
    public static void play(ArrayList<Area> boardAreaList, char[][] gameBoard, Player player, Computer computer) {
        Random rand = new Random();
        boolean playControl = true;

        int willPlay = rand.nextInt(2);

        if (willPlay == 0) {

            while(true) {
                System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                playControl = true;

                if (boardAreaList.isEmpty()) {
                    System.out.println("\n..... Game Over .....\n");
                    System.out.println("Your Score: " + player.getScore() + " Computer Score: " + computer.getScore());
                    winCheckPrint(player, computer);
                    break;
                } else {
                    while (playControl && !boardAreaList.isEmpty()) {
                        //Player playing
                        playControl = playerPanelUpdate(gameBoard, boardAreaList, player);
                        System.out.println("PLAYER SCORE -> "+player.getScore());
                        printBoard(gameBoard);
                    }
                }
                System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

                playControl = true;

                if (boardAreaList.isEmpty()) {
                    System.out.println("\n..... Game Over .....\n");
                    System.out.println("Your Score: " + player.getScore() + "---"+" Computer Score: " + computer.getScore());
                    winCheckPrint(player, computer);
                    break;
                } else {
                    while (playControl && !boardAreaList.isEmpty()) {
                        //Computer Playing
                        Area area1 = choseRandomAreaPc(boardAreaList);
                        playControl = pcPanelUpdate(gameBoard, area1.getX(), area1.getY(), computer);
                        System.out.println("COMPUTER SCORE -> "+computer.getScore());
                        printBoard(gameBoard);
                    }

                }
            }
        } else {

            while(true) {
                System.out.println("\n*-*-**-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

                playControl = true;

                if (boardAreaList.isEmpty()) {
                    System.out.println("\n..... Game Over .....\n");
                    System.out.println("Your Score: " + player.getScore() + " Computer Score: " + computer.getScore());
                    winCheckPrint(player, computer);
                    break;
                } else {
                    while (playControl && !boardAreaList.isEmpty()) {
                        //Computer Playing
                        Area area1 = choseRandomAreaPc(boardAreaList);
                        playControl = pcPanelUpdate(gameBoard, area1.getX(), area1.getY(), computer);
                        System.out.println("COMPUTER SCORE -> "+computer.getScore());
                        printBoard(gameBoard);
                    }

                }
                System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                playControl = true;

                if (boardAreaList.isEmpty()) {
                    System.out.println("\n..... Game Over .....\n");
                    System.out.println("Your Score: " + player.getScore() + " Computer Score: " + computer.getScore());
                    winCheckPrint(player, computer);
                    break;
                } else {
                    while (playControl && !boardAreaList.isEmpty()) {
                        //Player playing
                        playControl = playerPanelUpdate(gameBoard, boardAreaList, player);
                        System.out.println("PLAYER SCORE -> "+player.getScore());
                        printBoard(gameBoard);
                    }
                }
            }
        }
    }

    public static void winCheckPrint(Player player, Computer computer) {
        if (player.getScore() > computer.getScore()) {
            System.out.println("\n!!!!!!!!!! PLAYER WIN !!!!!!!!!!\n");
        } else if(player.getScore() == computer.getScore()) {
            System.out.println("\n!!!!!!!!!! NO WINNER !!!!!!!!!!\n");
        } else {
            System.out.println("\n!!!!!!!!!! COMPUTER WIN !!!!!!!!!!\n");
        }
    }

    //A letter is placed in the selected field by taking the row and column from the user.
    public static boolean playerPanelUpdate(char [][] gameBoard, ArrayList<Area> boardAreaList, Player player) {

        Random rand = new Random();

        int willCharacter = rand.nextInt(2);

        if (willCharacter == 0) {
            player.setCharacter('S');
        } else {
            player.setCharacter('O');
        }

        Scanner scan = new Scanner(System.in);
        int satir,sutun;

        System.out.println("\n**************************** P L A Y E R ****************************");

        System.out.println("-> LETTER FOR PLAYER: "+"'"+player.getCharacter()+"'");

        while (true) {
            System.out.print("Please enter the row value: ");
            satir = scan.nextInt() -1;
            System.out.print("Please enter column value: ");
            sutun = scan.nextInt() -1;

            if(satir>gameBoard.length || sutun >gameBoard.length) {
                System.out.println("******************************************************************");
                System.out.println("Please enter existing row and column values!!!");
                System.out.println("wrong values entered: "+"ROW->"+(satir+1)+"COLUMN->"+(sutun+1));
                System.out.println("GAME BOARD LENGTH"+gameBoard.length);
                System.out.println("******************************************************************");
            } else {
                if (areaControl(satir, sutun, boardAreaList)) {
                    break;
                }
                System.out.println("\n");
                System.out.println("The selected field is full please select an empty field!");
            }
        }

        gameBoard[satir][sutun] = player.getCharacter();

        deletedArListAfterPlayer(satir, sutun, boardAreaList);

        if (winControl(satir, sutun, gameBoard, player.getCharacter(), player)) {
            System.out.println("*****PLAYER SCORED");
            return true;
        } else {
            return false;
        }

    }


    //Method for PC to choose a random frame
    public static Area choseRandomAreaPc(ArrayList<Area> areaList) {
        Random rand = new Random();
        int square = rand.nextInt(areaList.size());
        Area selectedArea = areaList.get(square);
        areaList.remove(square);
        return selectedArea;
    }

    //The field used by the PC to put letters in the selected random field.
    public static boolean pcPanelUpdate(char [][] gameBoard, int satir, int sutun, Computer computer) {
        Scanner scan = new Scanner(System.in);

        Random rand = new Random();

        int willCharacter = rand.nextInt(2);

        if (willCharacter == 0) {
            computer.setCharacter('S');
        } else {
            computer.setCharacter('O');
        }

        System.out.println("\n**************************** C O M P U T E R ****************************");

        System.out.println("-> LETTER FOR COMPUTER: "+"'"+computer.getCharacter()+"'");

        gameBoard[satir][sutun] = computer.getCharacter();

        if (winControl(satir, sutun, gameBoard, computer.getCharacter(), computer)) {
            System.out.println("*****COMPUTER SCORED ");
            return true;
        } else {
            return false;
        }
    }

    //After the player makes the move, that field is deleted from the arrayList, which contains the squares that can be moved.
    public static void deletedArListAfterPlayer(int satir, int sutun, ArrayList<Area> areaList) {
        for(int i=0;i<areaList.size();i++) {
            if(areaList.get(i).getX()==satir && areaList.get(i).getY()==sutun){
                areaList.remove(i);
            }
        }
    }

    //We check if it has space. For Player
    public static boolean areaControl(int satir, int sutun, ArrayList<Area> areaList) {
        for(int i=0; i<areaList.size(); i++) {
            if (satir==areaList.get(i).getX() &&  sutun==areaList.get(i).getY()) {
                return true;
            }
        }
        return false;
    }


}
