package com.onicalls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DobbleGame implements Mesa{
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

    public void play(){
        for(Player p: playerList){
            if (p.getTurn()){
                Collections.shuffle(cardsSet.getCardSet());
                System.out.println("Se han dado vuelta 2 cartas. \nEl jugador " + p.getName() + " debe indicar el número que tienen en común:");
                Card C1 = cardsSet.getCardSet().get(0);
                Card C2 = cardsSet.getCardSet().get(1);
                int element;
                Scanner elementIn = new Scanner(System.in);
                element = elementIn.nextInt();
                if(Dobble.compareCards(element, C1, C2)) {System.out.println("El jugador ha ganado 2 puntos.");}
                else{System.out.println("El jugador se ha equivocado.");}
                System.out.println("Las cartas eran: " +  C1.toString() + " y "  + C2.toString());
                }
            }
        }

    public void nextTurn(){
        int k = playerList.size() - 1;
        int i = 0;
        int j = 0;
        for(Player p: playerList){
            if (p.getTurn()){
                j=i;
                p.setTurn(false);
            }
            i++;
        }
        if(j==k){j=0;}
        else{j++;}
        i=0;
        for(Player p: playerList){
            if(i==j){
                p.setTurn(true);
                break;
            }
            i++;
        }
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
