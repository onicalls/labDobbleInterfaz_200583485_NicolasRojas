package com.onicalls;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int option = 0;
        int idPlayer = 1;
        ArrayList<Player> playerList = new ArrayList<>();
        while (option<2) {
            System.out.println("### ¡BIENVENIDO A DOBBLE! ###\n");
            System.out.println("Seleccione un número:\n1. Nueva Partida\n2. Salir");
            Scanner in = new Scanner(System.in);
            option = in.nextInt();
            switch (option){
                case 1:
                    System.out.println("Inserte número de jugadores: ");
                    int numPlayers;
                    Scanner numPlayersIn = new Scanner(System.in);
                    numPlayers = numPlayersIn.nextInt();
                    while (numPlayers>0) {
                        System.out.println("Inserte nombre del jugador: ");
                        String playerName;
                        Scanner playerNameIn = new Scanner(System.in);
                        playerName = playerNameIn.nextLine();
                        Player player = new Player(idPlayer , playerName, false, 0);
                        idPlayer = idPlayer+1;
                        numPlayers = numPlayers-1;
                        playerList.add(player);
                    }
                    System.out.println("Inserte número de elementos por carta:");
                    Scanner numElmIn = new Scanner(System.in);
                    int numElm = numPlayersIn.nextInt();
                    Scanner numCardsIn = new Scanner(System.in);
                    int numCards = numCardsIn.nextInt();
                    Dobble dobble = new Dobble(numElm,numCards);
                    dobble.createCards();
                    break;
                case 2:
                    System.out.println("¡Gracias por jugar!");
                    break;
            }
            System.out.println("La opción elegida es: " + option);
        }

    }
}
