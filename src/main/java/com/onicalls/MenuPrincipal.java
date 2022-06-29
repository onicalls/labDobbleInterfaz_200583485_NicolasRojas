package com.onicalls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Clase MenuPrincipal.
 */
public class MenuPrincipal extends JFrame implements ActionListener {
    //Opción principal del menú
    static int option = 0;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    /**
     * Función que muestra el menú princial del juego.
     */

    public MenuPrincipal(){
        super("Dobble Interfaz");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        label1 = new JLabel("Seleccione una opción:");
        button1 = new JButton("Partida Multijugador");
        button2 = new JButton("Partida VS CPU");
        button3 = new JButton("Salir");
        button1.setSize(100,110);
        button2.setSize(100,110);
        button3.setSize(100,110);
        add(label1);
        add(button1);
        add(button2);
        add(button3);
        setLayout(new GridLayout(0, 1));
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == button1){
                this.setVisible(false);
                new MenuMultijugador().setVisible(true);
            }
            if(e.getSource() == button3){
                this.dispose();
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}
