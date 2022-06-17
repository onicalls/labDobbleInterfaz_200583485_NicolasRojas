package com.onicalls;

import java.util.Scanner;

/**
 * Clase MenuCPU.
 */
public class MenuCPU {
        public static void menuCPU() {
            DobbleGame dobbleGame = new DobbleGame();
            dobbleGame.registerCPU(1);
            System.out.println("Inserte número de elementos por carta:");
            Scanner numElmIn = new Scanner(System.in);
            int numElm = numElmIn.nextInt();
            System.out.println("Inserte número máximo de cartas (Si coloca 0 se generarán todas las posibles):");
            Scanner numCardsIn = new Scanner(System.in);
            int numCards = numCardsIn.nextInt();
            Dobble dobble = new Dobble(numElm, numCards);
            dobble.generateCards(numCards);
            dobbleGame.setCardsSet(dobble);
            dobbleGame.setNumPlayers(2);
            dobbleGame.setNumCards(numCards);
            dobbleGame.setNumElm(numElm);
            int optionGame = 0;
            dobbleGame.playerList.get(0).setTurn(true);
            System.out.println("\n### ¡COMIENZA A JUGAR! ###");
            while (optionGame < 3) {
                System.out.println("\nSeleccione un número:\n1. Hacer Jugada\n2. Ver puntuación\n3. Finalizar Juego.");
                Scanner in = new Scanner(System.in);
                optionGame = in.nextInt();
                switch (optionGame) {
                    case 1:
                        dobbleGame.playCPU();
                        break;
                    case 2:
                        dobbleGame.printPoints();
                        break;
                }
            }
        }
    }
