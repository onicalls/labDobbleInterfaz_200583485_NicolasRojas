package com.onicalls;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dobble {
    int numElm;
    int numCards;
    List<Integer> elements = IntStream.range(1, 100).boxed().collect(Collectors.toList());
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

    public void createCards(){
        Card card = new Card();
        for (int i = 1; i<= numElm; i++) {
            card.addElements(i);
        }
        cardSet.add(card);
        for (int j=1; j<=numElm; j++) {
            card = new Card();
            card.addElements(1);
            for (int k=1; k<=numElm; k++) {
                    card.addElements(numElm * j + (k+1));
                }
            cardSet.add(card);
        }
        for (int i= 1; i<=numElm; i++) {
            for (int j=1; j<=numElm; j++) {
                card = new Card();
                card.addElements(i+1);
                for (int k=1; k<= numElm; k++) {
                        card.addElements(numElm+2+numElm*(k-1)+(((i-1)*(k-1)+j-1) % numElm));
                    }
                cardSet.add(card);
            }
        }
    }
}
