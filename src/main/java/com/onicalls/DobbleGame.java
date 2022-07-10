package com.onicalls;

import java.util.*;

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

    /** Función play que tomar 2 cartas aleatorias y pregunta un elemento al jugador para añadir puntaje.
     * @return*/
    public String play(int element){
        for(Player p: playerList){
            if (p.getTurn()){
                Collections.shuffle(cardsSet.getCardSet());
                String win = "El jugador " + p.getName() + " ha acertado. Las cartas eran: ";
                Card C1 = cardsSet.getCardSet().get(0);
                Card C2 = cardsSet.getCardSet().get(1);
                if(Dobble.compareCards(element, C1, C2)) {System.out.println("El jugador ha ganado 2 puntos.");p.addPoints(p.getPoints(),2);}
                else{win = "El jugador "+ p.getName() +" se ha equivocado. Las cartas eran: ";}
                return win + C1.toString() + " y "  + C2.toString();
                }
            }
        return "";
    }

    public String getNameTurn(){
        for(Player p: playerList) {
            if (p.getTurn()) {
                return p.getName();
            }
        }
        return "Error";
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
    public String playCPU() {
        for(Player p : playerList) {
            if (p.getTurn()) {
                Random rand = new Random();
                int randomNum = rand.nextInt((cardsSet.cardSet.size() - 1) + 1) + 1;
                Collections.shuffle(cardsSet.getCardSet());
                String win = "El jugador CPU ha acertado. Las cartas eran: ";
                Card C1 = cardsSet.getCardSet().get(0);
                Card C2 = cardsSet.getCardSet().get(1);
                if (Dobble.compareCards(randomNum, C1, C2)) {
                    p.addPoints(p.getPoints(), 2);
                } else {
                    win = "El jugador CPU se ha equivocado. Las cartas eran: ";
                }
                return win + C1.toString() + " y " + C2.toString();
            }
        }
        return "";
    }

    /** Función que registra jugadores en el modo multijugador. */
    public void register(ArrayList<String> namePlayerList){
        for(String playerName : namePlayerList){
            Player player = new Player(playerName, false, 0);
            playerList.add(player);
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
