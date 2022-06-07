package com.onicalls;

import java.util.ArrayList;

public class Card {
    ArrayList<Integer> elements;

    public ArrayList<Integer> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Integer> elements) {
        this.elements = elements;
    }

    public void addElements(int element){
        ArrayList<Integer> newElements = getElements();
        newElements.add(element);
        setElements(newElements);
    }

    @Override
    public String toString() {
        for(Integer element: elements){
            System.out.print(element+", ");
        }
        return "\n";
    }
}
