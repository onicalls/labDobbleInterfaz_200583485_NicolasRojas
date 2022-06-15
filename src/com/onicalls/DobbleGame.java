package com.onicalls;

import java.util.ArrayList;
import java.util.Scanner;

public class DobbleGame {
    ArrayList<Player> playerList = new ArrayList<>();
    int numPlayers;
    int numElm;
    int numCards;
    Dobble cardsSet;
    String state = "En partidaxd";

    public void register(int numPlayers){
        while (numPlayers>0) {
            System.out.println("Inserte nombre del jugador: ");
            String playerName;
            Scanner playerNameIn = new Scanner(System.in);
            playerName = playerNameIn.nextLine();
            Player player = new Player(playerName, false, 0);
            numPlayers = numPlayers - 1;
            playerList.add(player);
            for (Player p : playerList) {
                String playerString = p.toString();
                System.out.println(playerString);
            }
        }
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public int getNumElm() {
        return numElm;
    }

    public void setNumElm(int numElm) {
        this.numElm = numElm;
    }

    public int getNumCards() {
        return numCards;
    }

    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }

    public Dobble getCardsSet() {
        return cardsSet;
    }

    public void setCardsSet(Dobble cardsSet) {
        this.cardsSet = cardsSet;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DobbleGame{" +
                "playerList=" + playerList +
                ", numPlayers=" + numPlayers +
                ", numElm=" + numElm +
                ", numCards=" + numCards +
                ", state='" + state + '\'' +
                '}';
    }
}
