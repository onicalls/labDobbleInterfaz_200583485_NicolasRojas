package com.onicalls;

public class Player implements Jugador{
    String name = "";
    boolean turn = false;
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

    public void addPoints(int points, int pointsToAdd) {
        setPoints(points+pointsToAdd);
    }

    @Override
    public String toString() {
        return "Jugador: [" + name + ", Turno=" + turn + ", Puntos=" + points + ']';
    }
}