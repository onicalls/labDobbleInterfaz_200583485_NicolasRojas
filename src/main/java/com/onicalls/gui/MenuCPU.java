package com.onicalls.gui;

import com.onicalls.Dobble;
import com.onicalls.DobbleGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Clase MenuCPU.
 */
public class MenuCPU extends JFrame implements ActionListener{
    ArrayList<String> namePlayerList = new ArrayList<>();
    private JLabel nElms;
    private JTextField nElmsText;
    private JLabel nCards;
    private JTextField nCardsText;
    private JLabel PlayerName;
    private JTextField PlayerNameText;
    private JButton nNext;

    public MenuCPU(){
        super("Dobble 0.1");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nElms = new JLabel("Numero de Elementos:");
        nElmsText = new JTextField(2);
        nCards = new JLabel("Numero de Cartas:");
        nCardsText = new JTextField(2);
        PlayerName = new JLabel("Inserte nombre del jugador:");
        PlayerNameText = new JTextField(10);
        nNext = new JButton("Continuar");
        nNext.setSize(100,110);
        add(nElms);
        add(nElmsText);
        add(nCards);
        add(nCardsText);
        add(PlayerName);
        add(PlayerNameText);
        add(nNext);
        setLayout(new GridLayout(0, 1));
        nNext.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == nNext){
                var plName = PlayerNameText.getText();
                if (plName==null) {
                    JOptionPane.showMessageDialog(this, "Error: Debe ingresar un nombre.");
                } else {
                    int nElms = Integer.parseInt(nElmsText.getText());
                    int nCards = Integer.parseInt(nCardsText.getText());
                    DobbleGame dobbleGame = new DobbleGame();
                    namePlayerList.add(plName);
                    namePlayerList.add("CPU");
                    dobbleGame.register(namePlayerList);
                    Dobble dobble = new Dobble(nElms, nCards);
                    dobble.generateCards(nCards);
                    dobbleGame.setCardsSet(dobble);
                    dobbleGame.setNumPlayers(2);
                    dobbleGame.setNumCards(nCards);
                    dobbleGame.setNumElm(nElms);
                    dobbleGame.getPlayerList().get(0).setTurn(true);
                    new MenuPlay(dobbleGame).setVisible(true);
                    this.dispose();
                }
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Error!");
        }
    }
}
