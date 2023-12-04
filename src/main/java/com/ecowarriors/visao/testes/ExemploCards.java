package com.ecowarriors.visao.testes;

import com.ecowarriors.modelos.Denuncia;
import com.ecowarriors.persistencia.DenunciaDao;
import com.ecowarriors.persistencia.IDenunciaDao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExemploCards extends JFrame {

    private JPanel cardsPanel;

    public ExemploCards() {
        try {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Cards Clicáveis");
            
            cardsPanel = new JPanel(new GridLayout(0, 3));
            add(cardsPanel);
            

            IDenunciaDao denunciaDao = new DenunciaDao();
            List<Denuncia> denuncia = denunciaDao.listagemDenuncia();
            
            for (Denuncia denunciasGet : denuncia) {
                JButton card = new JButton("Protocolo: "+ denunciasGet.getProtocolo()+ "\n Denunciante: " + denunciasGet.getDenuciante());
                card.addActionListener(new CardClickListener(denunciasGet.getId()));
                cardsPanel.add(card);
            }
            
            pack();
            setLocationRelativeTo(null);
            
        } catch (Exception ex) {
            Logger.getLogger(ExemploCards.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class CardClickListener implements ActionListener {
        private int produtoId;

        public CardClickListener(int produtoId) {
            this.produtoId = produtoId;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(ExemploCards.this, "Clicou no card do produto " + produtoId);
            
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ExemploCards().setVisible(true));
    }
}
