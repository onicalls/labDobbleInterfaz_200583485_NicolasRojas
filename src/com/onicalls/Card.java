package com.onicalls;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase Card que implementa los métodos de la interfaz Carta.
 */
public class Card implements Carta{
    //Lista de elementos que contiene la carta
    ArrayList<Integer> elements = new ArrayList<>();

    public ArrayList<Integer> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Integer> elements) {
        this.elements = elements;
    }

    /**
     * Función que añade elementos a una carta
     * Entrada: elemento (int)
     * Salida: clase actualizada.
     */
    public void addElements(int element){
        elements.add(element);
    }

    @Override
    public String toString() {
        return "Carta: " + elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(elements, card.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}