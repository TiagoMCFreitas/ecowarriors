package com.ecowarriors.visao.testes;

import com.ecowarriors.ferramentas.ConexaoBD;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainFrame extends JFrame {

    private JTextField nomeImagemTextField;
    private JButton selecionarImagemButton;
    private JButton salvarImagemButton;
    private Connection conexao = null;

    public MainFrame() {
        try {
            initComponents();
            initListeners();
            conexao = ConexaoBD.getConexao();
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initComponents() {
        nomeImagemTextField = new JTextField();
        selecionarImagemButton = new JButton("Selecionar Imagem");
        salvarImagemButton = new JButton("Salvar Imagem");

        setLayout(new java.awt.FlowLayout());

        add(new JLabel("Nome da Imagem:"));
        add(nomeImagemTextField);
        add(selecionarImagemButton);
        add(salvarImagemButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void initListeners() {
        selecionarImagemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(MainFrame.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Lógica para obter a imagem selecionada
                }
            }
        });

        salvarImagemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    salvarImagem();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(MainFrame.this, "Erro ao salvar imagem no banco de dados.");
                }
            }
        });
    }

    private void salvarImagem() throws SQLException {

        String nomeImagem = nomeImagemTextField.getText();
        byte[] imagemBytes = obterBytesDaImagem(); // Implemente esta lógica

        String sql = "INSERT INTO imagens (nome, imagem) VALUES (?, ?)";
        try ( PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, nomeImagem);
            preparedStatement.setBytes(2, imagemBytes);
            preparedStatement.executeUpdate();
        } finally {
            conexao.close();
        }

        JOptionPane.showMessageDialog(this, "Imagem salva com sucesso!");
    }

    private byte[] obterBytesDaImagem() {
        // Implemente a lógica para converter a imagem em um array de bytes
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}
