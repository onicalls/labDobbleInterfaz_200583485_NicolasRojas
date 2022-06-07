package com.onicalls;

public class Player {
    int id = 0;
    String name = "";
    boolean turn = false;
    int points = 0;

    public Player(int id, String name, boolean turn, int points) {
        this.id = id;
        this.name = name;
        this.turn = turn;
        this.points = points;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", turn=" + turn +
                ", points=" + points +
                '}';
    }
}