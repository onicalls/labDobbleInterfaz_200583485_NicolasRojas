package com.onicalls;

import java.net.Inet4Address;
import java.util.ArrayList;

public class Card {
    ArrayList<Integer> elements = new ArrayList<>();

    public ArrayList<Integer> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Integer> elements) {
        this.elements = elements;
    }

    public void addElements(int element){
        elements.add(element);
    }

    @Override
    public String toString() {
        return "Card{" +
                "elements=" + elements +
                '}';
    }
}