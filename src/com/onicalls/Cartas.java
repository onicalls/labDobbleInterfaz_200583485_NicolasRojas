package com.onicalls;

/**
 * Intefaz Cartas que contiene los métodos que utilizará la clase Dobble.
 */
public interface Cartas {
    void createCards();
    void generateCards(int limit);
    static boolean compareCards(int element, Card C1, Card C2) {
        return false;
    }
}
