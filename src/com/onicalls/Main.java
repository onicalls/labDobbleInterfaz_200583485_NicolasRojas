package com.onicalls;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int option = 0;
        ArrayList<Player> playerList = new ArrayList<>();
        while (option<2) {
            System.out.println("### ¡BIENVENIDO A DOBBLE! ###\n");
            System.out.println("Seleccione un número:\n1. Nueva Partida\n2. Salir");
            Scanner in = new Scanner(System.in);
            option = in.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Inserte número de jugadores: ");
                    int numPlayers;
                    Scanner numPlayersIn = new Scanner(System.in);
                    numPlayers = numPlayersIn.nextInt();
                    DobbleGame dobbleGame = new DobbleGame();
                    dobbleGame.register(numPlayers);
                    System.out.println("Inserte número de elementos por carta:");
                    Scanner numElmIn = new Scanner(System.in);
                    int numElm = numElmIn.nextInt();
                    System.out.println("Inserte número máximo de cartas:");
                    Scanner numCardsIn = new Scanner(System.in);
                    int numCards = numCardsIn.nextInt();
                    Dobble dobble = new Dobble(numElm, numCards);
                    dobble.generateCards(numCards);
                    String dobbleString = dobble.toString();
                    dobbleGame.setCardsSet(dobble);
                    dobbleGame.setNumPlayers(numPlayers);
                    dobbleGame.setNumCards(numCards);
                    dobbleGame.setNumElm(numElm);
                    System.out.println(dobbleGame);
                    int optionGame = 0;
                    while (optionGame < 4) {
                        System.out.println("### ¡COMIENZA A GUGAR! ###\n");
                        System.out.println("Seleccione un número:\n1. Hacer Jugada\n2. Mostrar Turno\n3. Finalizar Juego.");
                        in = new Scanner(System.in);
                        optionGame = in.nextInt();
                        switch (option) {
                            case 1:
                                dobbleGame.play();
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("¡Gracias por jugar!");
                    break;
            }
            System.out.println("La opción elegida es: " + option);
        }

    }
}
