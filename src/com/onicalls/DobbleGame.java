package com.onicalls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

/**
 * Clase DobbleGame que implementa los métodos de la interfaz Mesa.
 */
public class DobbleGame implements Mesa{
    //Lista de jugadores
    ArrayList<Player> playerList = new ArrayList<>();
    //Número de jugadores
    int numPlayers;
    //Número de elementos
    int numElm;
    //Número de cartas
    int numCards;
    //Clase cardsSet (El mazo)
    Dobble cardsSet;
    //Estado de la partida
    String state = "En partida";

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

    /** Función play que tomar 2 cartas aleatorias y pregunta un elemento al jugador para añadir puntaje. */
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

    /** Función nextTurn que termina el turno del jugador y actualiza el estado del siguiente jugador. */
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

    /** Función que imprime en pantalla los puntajes de los jugadores registrados. */
    public void printPoints(){
        for(Player p: playerList){
            System.out.println("Jugador " + p.getName() + " tiene " + p.getPoints() + " puntos.");
        }
    }

    /** Función play que tomar 2 cartas aleatorias y pregunta un elemento al jugador para añadir puntaje, y luego la CPU juega automáticamente. */
    public void playCPU(){
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
            else{
                Collections.shuffle(cardsSet.getCardSet());
                Random rand = new Random();
                int randomNum = rand.nextInt((cardsSet.cardSet.size() - 1) + 1) + 1;
                System.out.println("\nSe han dado vuelta 2 cartas. \nEl jugador CPU ha indicado el número: " + randomNum);
                Card C1 = cardsSet.getCardSet().get(0);
                Card C2 = cardsSet.getCardSet().get(1);
                if(Dobble.compareCards(randomNum, C1, C2)) {System.out.println("El jugador ha ganado 2 puntos.");}
                else{System.out.println("El jugador se ha equivocado.");}
                System.out.println("Las cartas eran: " +  C1.toString() + " y "  + C2.toString());
            }
        }
    }

    /** Función que registra jugadores en el modo multijugador. */
    public void register(int numPlayers){
        while (numPlayers>0) {
            System.out.println("Inserte nombre del jugador: ");
            String playerName;
            Scanner playerNameIn = new Scanner(System.in);
            playerName = playerNameIn.nextLine();
            Player player = new Player(playerName, false, 0);
            numPlayers = numPlayers - 1;
            playerList.add(player);
        }
    }

    /** Función que registra un único jugador en el modo VS CPU. */
    public void registerCPU(int numPlayers){
            System.out.println("Inserte nombre del jugador: ");
            String playerName;
            String CPUName = "CPU";
            Scanner playerNameIn = new Scanner(System.in);
            playerName = playerNameIn.nextLine();
            Player player = new Player(playerName, false, 0);
            Player cpu = new Player(CPUName, false, 0);
            playerList.add(player);
            playerList.add(cpu);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DobbleGame that = (DobbleGame) o;
        return numPlayers == that.numPlayers && numElm == that.numElm && numCards == that.numCards && Objects.equals(playerList, that.playerList) && Objects.equals(cardsSet, that.cardsSet) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerList, numPlayers, numElm, numCards, cardsSet, state);
    }
}
