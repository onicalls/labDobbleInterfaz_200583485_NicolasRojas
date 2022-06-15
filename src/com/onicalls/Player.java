package com.onicalls;

public class Player {
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

    public boolean isTurn() {
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

    public void changeTurn(boolean turn){
        if(isTurn()){
            setTurn(false);
        }
        else{
            setTurn(true);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                ", name='" + name + '\'' +
                ", turn=" + turn +
                ", points=" + points +
                '}';
    }
}