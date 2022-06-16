package com.onicalls;

public interface Cartas {
    void createCards();
    void generateCards(int limit);
    static boolean compareCards(int element, Card C1, Card C2) {
        return false;
    }
}
