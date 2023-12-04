package com.ecowarriors.visao.testes;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Card extends JPanel {

    public Card(String nome, String informacao) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEtchedBorder());

        JLabel nameLabel = new JLabel(nome);
        JLabel infoLabel = new JLabel(informacao);

        nameLabel.setSize(50, 50);
        add(nameLabel);
        add(infoLabel);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lógica para lidar com o clique no card
                JOptionPane.showMessageDialog(null, "Card clicado: " + nome);
            }
        });
    }
}
