package com.onicalls;

import java.util.Scanner;

/**
 * Clase MenuPrincipal.
 */
public class MenuPrincipal {
    //Opción principal del menú
    static int option = 0;

    /**
     * Función que muestra el menú princial del juego.
     */
    public static void mainMenu(){
        while (option<3) {
            System.out.println("\n### ¡BIENVENIDO A DOBBLE! ###");
            System.out.println("Seleccione un número:\n1. Partida Multijugador\n2. Partida VS CPU\n3. Salir");
            Scanner in = new Scanner(System.in);
            option = in.nextInt();
            switch (option) {
                case 1:
                    MenuMultijugador.menuMultijugador(); break;
                case 2:
                    MenuCPU.menuCPU(); break;
                case 3:
                    System.out.println("¡Gracias por jugar!");
                    break;
            }
        }
    }

}
