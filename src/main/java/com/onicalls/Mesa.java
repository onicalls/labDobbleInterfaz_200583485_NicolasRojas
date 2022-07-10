package com.onicalls;

import java.util.ArrayList;

/**
 * Intefaz Mesa que contiene los métodos que utilizará la clase DobbleGame.
 */
public interface Mesa {
    void register(ArrayList<String> namePlayerList);
    String play(int element);
    String playCPU();
    void nextTurn();
}
