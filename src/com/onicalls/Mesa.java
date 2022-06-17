package com.onicalls;

/**
 * Intefaz Mesa que contiene los métodos que utilizará la clase DobbleGame.
 */
public interface Mesa {
    void register(int numPlayers);
    void registerCPU(int numPlayers);
    void play();
    void playCPU();
    void nextTurn();
}
