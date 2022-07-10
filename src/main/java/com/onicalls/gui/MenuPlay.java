package com.onicalls.gui;

import com.onicalls.Dobble;
import com.onicalls.DobbleGame;
import com.onicalls.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase MenuPlay.
 */
public class MenuPlay extends JFrame implements ActionListener {
    DobbleGame dobbleGame;
    DefaultListModel playerInfoGUI;
    private JLabel playerTurnLabel;
    private JLabel makePlayLabel;
    private JTextField makePlayText;
    private JButton okButton;
    private JButton endGame;
    private JLabel playerPoints;
    private String playerPointsList = "";

    public MenuPlay(DobbleGame x){
        super("Dobble 0.1");
        dobbleGame = x;
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        playerTurnLabel = new JLabel("Turno del jugador: " + dobbleGame.getNameTurn());
        makePlayLabel = new JLabel("Inserte numero: ");
        makePlayText = new JTextField(2);
        okButton = new JButton("OK");
        okButton.setSize(20,20);
        endGame = new JButton("Terminar Partida");
        endGame.setSize(100,50);
        add(playerTurnLabel);
        add(makePlayLabel);
        add(makePlayText);
        add(okButton);
        add(endGame);
        setLayout(new GridLayout(0, 1));
        okButton.addActionListener(this);
        endGame.addActionListener(this);
        for(Player player : dobbleGame.getPlayerList()){
            playerPointsList = playerPointsList + "Jugador: " + player.getName() + ", Puntos: " + player.getPoints() + " | ";
        }
        playerPoints = new JLabel();
        add(playerPoints);
        playerPoints.setText(playerPointsList);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == okButton) {
                int element = Integer.parseInt(makePlayText.getText());
                String resultado = dobbleGame.play(element);
                dobbleGame.nextTurn();
                playerTurnLabel.setText("Turno del jugador: "+ dobbleGame.getNameTurn());
                makePlayText.setText("");
                playerPointsList = "";
                for(Player player : dobbleGame.getPlayerList()){
                    playerPointsList = playerPointsList + "Jugador: " + player.getName() + ", Puntos: " + player.getPoints() + " | ";
                }
                playerPoints.setText(playerPointsList);
                JOptionPane.showMessageDialog(this, resultado);
                if (dobbleGame.getNameTurn() == "CPU"){
                    resultado = dobbleGame.playCPU();
                    dobbleGame.nextTurn();
                    playerTurnLabel.setText("Turno del jugador: "+ dobbleGame.getNameTurn());
                    makePlayText.setText("");
                    playerPointsList = "";
                    for(Player player : dobbleGame.getPlayerList()){
                        playerPointsList = playerPointsList + "Jugador: " + player.getName() + ", Puntos: " + player.getPoints() + " | ";
                    }
                    playerPoints.setText(playerPointsList);
                    JOptionPane.showMessageDialog(this, resultado);
                }
            }
            else if (e.getSource() == endGame){
                this.setVisible(false);
                this.dispose();
                new MenuPrincipal().setVisible(true);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}
