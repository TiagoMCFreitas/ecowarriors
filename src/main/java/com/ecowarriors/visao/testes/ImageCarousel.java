package com.ecowarriors.visao.testes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class ImageCarousel extends JFrame {

    private List<ImageIcon> images;
    private int currentIndex;
    private JLabel imageLabel;

    public ImageCarousel() {
        // Configuração da janela
        setTitle("Image Carousel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        // Carregamento de imagens
        loadImages();

        // Configuração do rótulo da imagem
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        updateImage();

        // Configuração do temporizador para avançar para a próxima imagem
        Timer timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextImage();
            }
        });
        timer.start();

        // Adiciona o rótulo da imagem à janela
        add(imageLabel);

        // Exibição da janela
        setVisible(true);
    }

    private void loadImages() {
        images = new ArrayList<>();
        // Substitua "path/to/images" pelo caminho real para o diretório das imagens
        File directory = new File("./src\\main\\java\\com\\ecowarriors\\visao\\icons");

        // Verifica se o diretório existe
        if (directory.exists() && directory.isDirectory()) {
            // Carrega todas as imagens do diretório
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    try {
                        Image image = ImageIO.read(file);
                        ImageIcon icon = new ImageIcon(image);
                        images.add(icon);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void updateImage() {
        if (!images.isEmpty()) {
            ImageIcon currentImage = images.get(currentIndex);
            imageLabel.setIcon(currentImage);
        }
    }

    private void nextImage() {
        if (!images.isEmpty()) {
            currentIndex = (currentIndex + 1) % images.size();
            updateImage();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageCarousel();
            }
        });
    }
}
