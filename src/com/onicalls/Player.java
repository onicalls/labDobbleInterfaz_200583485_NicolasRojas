package com.onicalls;

import java.util.Objects;

/**
 * Clase Player que implementa los métodos de la interfaz Jugador.
 */
public class Player implements Jugador{
    //Nombre del jugador
    String name = "";
    //Estado del turno
    boolean turn = false;
    //Puntos del jugador
    int points = 0;

    public Player(String name, boolean turn, int points) {
        this.name = name;
        this.turn = turn;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public boolean getTurn() {
        return turn;
    }

    public int getPoints() {
        return points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Función que añade puntos a un jugador.
     * Entrada: points (int), pointsToAdd (int)
     * Salida: puntos del jugador actualizados
     */
    public void addPoints(int points, int pointsToAdd) {
        setPoints(points+pointsToAdd);
    }

    @Override
    public String toString() {
        return "Jugador: [" + name + ", Turno=" + turn + ", Puntos=" + points + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return turn == player.turn && points == player.points && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, turn, points);
    }
}