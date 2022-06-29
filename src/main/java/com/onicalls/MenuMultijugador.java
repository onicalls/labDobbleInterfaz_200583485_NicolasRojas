package com.onicalls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Clase MenuMultijugador.
 */
public class MenuMultijugador extends JFrame implements ActionListener{
    private JLabel nElms;
    private JLabel nCards;
    private JLabel nPlays;
    private JButton nNext;

    public MenuMultijugador(){
        super("Dobble 0.1");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nElms = new JLabel("Número de Elementos:");
        nCards = new JLabel("Número de Cartas:");
        nPlays = new JLabel("Número de Jugadores");
        nNext = new JButton("Salir");
        nNext.setSize(100,110);
        add(nElms);
        add(nCards);
        add(nPlays);
        add(nNext);
        setLayout(new GridLayout(0, 1));
        nNext.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == nNext) {
                this.dispose();
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }

    public static void menuMultijugador(){
        System.out.println("Inserte número de jugadores: ");
        int numPlayers;
        Scanner numPlayersIn = new Scanner(System.in);
        numPlayers = numPlayersIn.nextInt();
        DobbleGame dobbleGame = new DobbleGame();
        dobbleGame.register(numPlayers);
        System.out.println("Inserte número de elementos por carta:");
        Scanner numElmIn = new Scanner(System.in);
        int numElm = numElmIn.nextInt();
        System.out.println("Inserte número máximo de cartas (Si coloca 0 se generarán todas las posibles):");
        Scanner numCardsIn = new Scanner(System.in);
        int numCards = numCardsIn.nextInt();
        Dobble dobble = new Dobble(numElm, numCards);
        dobble.generateCards(numCards);
        dobbleGame.setCardsSet(dobble);
        dobbleGame.setNumPlayers(numPlayers);
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
                case 1: dobbleGame.play(); dobbleGame.nextTurn(); break;
                case 2: dobbleGame.printPoints(); break;
            }
        }
    }
}
