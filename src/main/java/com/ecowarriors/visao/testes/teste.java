package com.ecowarriors.visao.testes;

import com.ecowarriors.ferramentas.ConexaoBD;
import com.ecowarriors.modelos.Denuncia;
import com.ecowarriors.persistencia.DenunciaDao;
import com.ecowarriors.persistencia.IDenunciaDao;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ecowarriors.visao.testes.Card;

public class teste extends JFrame {

    private Connection conexao = null;
    PreparedStatement st;
    private JPanel cardPanel;

    public teste() throws Exception {
        conexao = ConexaoBD.getConexao();
        
        setTitle("Cards Clicáveis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        cardPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(new JScrollPane(cardPanel));

        carregarDadosDoBanco();

        setVisible(true);
    }

    public void carregarDadosDoBanco() throws Exception {
        try {
            st = conexao.prepareStatement("SELECT * FROM denuncia");
            ResultSet resultSet = st.executeQuery();

            // Processar os resultados e criar cards
            while (resultSet.next()) {
                String nome = resultSet.getString("protocolo");
                String informacao = resultSet.getString("denunciante");

                // Criar um card clicável
                Card card = new Card(nome, informacao);
                cardPanel.add(card);
            }

            // Fechar recursos
            resultSet.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new teste();
            } catch (Exception ex) {
                Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
