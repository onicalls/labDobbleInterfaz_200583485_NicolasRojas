package com.onicalls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Clase Dobble que implementa los métodos de la interfaz Cartas.
 */
public class Dobble implements Cartas{
    //Número de elementos
    int numElm;
    //Número de cartas
    int numCards;
    //Lista de elementos disponibles del 1 al 100 para la generación de cartas
    List<Integer> elements = IntStream.range(1, 100).boxed().collect(Collectors.toList());
    //Mazo de cartas
    ArrayList<Card> cardSet = new ArrayList<>();

    public Dobble(int numElm, int numCards) {
        this.numElm = numElm;
        this.numCards = numCards;
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

    public List<Integer> getElements() {
        return elements;
    }

    public void setElements(List<Integer> elements) {
        this.elements = elements;
    }

    public ArrayList<Card> getCardSet() {
        return cardSet;
    }

    public void setCardSet(ArrayList<Card> cardSet) {
        this.cardSet = cardSet;
    }

    /**
     * Función que crea un conjunto de cartas válidos.
     */
    public void createCards(){
        Card card = new Card();
        for (int i = 1; i<= numElm; i++) {
            card.addElements(i);
        }
        cardSet.add(card);
        for (int j=1; j<numElm; j++) {
            card = new Card();
            card.addElements(1);
            for (int k=1; k<numElm; k++) {
                    card.addElements(((numElm-1) * j + (k+1)));
                }
            cardSet.add(card);
        }
        for (int i= 1; i<numElm; i++) {
            for (int j=1; j<numElm; j++) {
                card = new Card();
                card.addElements(i+1);
                for (int k=1; k<numElm; k++) {
                        card.addElements(((numElm-1)+2+(numElm-1)*(k-1)+(((i-1)*(k-1)+j-1) % (numElm-1))));
                    }
                cardSet.add(card);
            }
        }
    }

    /**
     * Función que limita el número de cartas que puede tener un mazo y además aleatoriza.
     * Entrada: limit (int)
     * Salida: cartas actualizadas.
     */
    public void generateCards(int limit){
        if(limit==0){
            createCards();
        }
        else{
            createCards();
            cardSet = new ArrayList<>(cardSet.subList(0, limit));
            Collections.shuffle(cardSet);
        }
    }

    /**
     * Función estática que compara si el dato que ha colocado el jugador es el mismo en ambas cartas
     * Entrada: element (int), C1 (Card), C2 (Card)
     * Salida: verdadero o falso (boolean)
     */
    public static boolean compareCards(int element, Card C1, Card C2){
        return (C1.elements.contains(element) && C2.elements.contains(element));
    }

    @Override
    public String toString() {
        return "Dobble{" +
                "numElm=" + numElm +
                ", numCards=" + numCards +
                ", cardSet=" + cardSet.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dobble dobble = (Dobble) o;
        return numElm == dobble.numElm && numCards == dobble.numCards && Objects.equals(elements, dobble.elements) && Objects.equals(cardSet, dobble.cardSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numElm, numCards, elements, cardSet);
    }
}