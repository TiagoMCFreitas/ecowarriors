package com.ecowarriors.visao.testes;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageSelectionExample extends JFrame {

    private List<File> selectedFiles;

    public ImageSelectionExample() {
        selectedFiles = new ArrayList<>();

        JButton selectButton = new JButton("Selecionar Imagens");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectImages();
            }
        });

        JButton saveButton = new JButton("Salvar no Banco de Dados");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveImagesToDatabase();
            }
        });

        JPanel panel = new JPanel();
        panel.add(selectButton);
        panel.add(saveButton);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void selectImages() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFiles.clear();
            File[] selected = fileChooser.getSelectedFiles();
            for (File file : selected) {
                selectedFiles.add(file);
            }
        }
    }

    private void saveImagesToDatabase() {
        // Aqui você implementaria a lógica para salvar as imagens no banco de dados.
        // Iterar sobre selectedFiles e realizar as operações necessárias.
        for (File file : selectedFiles) {
            // Implemente a lógica para salvar a imagem no banco de dados.
            // Por exemplo, você pode converter a imagem para bytes e salvar no banco.
            byte[] imageData = convertImageToBytes(file);
            // Faça a operação de salvar no banco de dados aqui.
            // Exemplo fictício:
            System.out.println("Salvando no banco de dados: " + file.getName());
        }
    }

    private byte[] convertImageToBytes(File file) {
        // Implemente a lógica para converter a imagem para bytes.
        // Aqui você pode usar uma biblioteca como Apache Commons IO.
        // Exemplo fictício:
        // byte[] imageData = FileUtils.readFileToByteArray(file);
        // return imageData;

        // Como exemplo fictício, retornando um array vazio.
        return new byte[0];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageSelectionExample();
            }
        });
    }
}
