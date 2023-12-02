package com.ecowarriors.visao;

import com.ecowarriors.CEP.ViaCEP;
import com.ecowarriors.CEP.ViaCEPException;
import com.ecowarriors.Enum.Categoria;
import com.ecowarriors.Enum.StatusDenuncia;
import com.ecowarriors.ferramentas.limitaCaracteres;
import com.ecowarriors.modelos.Denuncia;
import com.ecowarriors.modelos.Endereco;
import com.ecowarriors.persistencia.DenunciaDao;
import com.ecowarriors.persistencia.IDenunciaDao;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class tCadastroDenunciante extends javax.swing.JFrame {

    public tCadastroDenunciante() {
        initComponents();
        setLocationRelativeTo(null);

        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jRadioButton1_nao1.setVisible(false);
        jRadioButton2_sim1.setVisible(false);
        jButton3_cadastrar.setVisible(false);
        jButton3_entrar.setVisible(false);
        jButton3_denunciaAnonima.setVisible(false);

        jTextField1_rua.setDocument(new limitaCaracteres(30, limitaCaracteres.tipoEntrada.ENDERECO));
        jTextField1_bairro.setDocument(new limitaCaracteres(30, limitaCaracteres.tipoEntrada.ENDERECO));
        jTextArea1_descricao.setLineWrap(true);
        jTextArea1_descricao.setWrapStyleWord(true);

        jLabel21.setVisible(false);
        jTextField1_possivel_criminoso.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1_telaAnonima = new javax.swing.JFrame();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextField1_CEP = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField1_Municipios = new javax.swing.JTextField();
        jTextField1_possivel_criminoso = new javax.swing.JTextField();
        jTextField1_pontoReferencia = new javax.swing.JTextField();
        jTextField1_rua = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jTextField1_bairro = new javax.swing.JTextField();
        jButton3_denunciar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1_descricao = new javax.swing.JTextArea();
        jFormattedTextField1_data = new javax.swing.JFormattedTextField();
        jRadioButton1_simm = new javax.swing.JRadioButton();
        jRadioButton2_naoo = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jRadioButton1_nao = new javax.swing.JRadioButton();
        jRadioButton2_sim = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1_nao1 = new javax.swing.JRadioButton();
        jRadioButton2_sim1 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jButton3_denunciaAnonima = new javax.swing.JButton();
        jButton3_cadastrar = new javax.swing.JButton();
        jButton3_entrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jFrame1_telaAnonima.setUndecorated(true);
        jFrame1_telaAnonima.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoEcoWarriorsTelas.png"))); // NOI18N
        jFrame1_telaAnonima.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 20, 200, 200));

        jLabel18.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 0));
        jLabel18.setText("DESCRIÇÃO");
        jFrame1_telaAnonima.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 240, 170, 30));

        jLabel9.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 0));
        jLabel9.setText("DENÚNCIA ANÔNIMA");
        jFrame1_telaAnonima.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 400, 50));

        jFormattedTextField1_CEP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jFormattedTextField1_CEP.setForeground(new java.awt.Color(0, 102, 0));
        try {
            jFormattedTextField1_CEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_CEP.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jFrame1_telaAnonima.getContentPane().add(jFormattedTextField1_CEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 190, 40));

        jLabel14.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 0));
        jLabel14.setText("RUA");
        jFrame1_telaAnonima.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 60, 40));

        jTextField1_Municipios.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_Municipios.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_Municipios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_telaAnonima.getContentPane().add(jTextField1_Municipios, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 340, 40));

        jTextField1_possivel_criminoso.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_possivel_criminoso.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_possivel_criminoso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_telaAnonima.getContentPane().add(jTextField1_possivel_criminoso, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 570, 580, 40));

        jTextField1_pontoReferencia.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_pontoReferencia.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_pontoReferencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_telaAnonima.getContentPane().add(jTextField1_pontoReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, 580, 40));

        jTextField1_rua.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_rua.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_rua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_telaAnonima.getContentPane().add(jTextField1_rua, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 340, 40));

        jButton3.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/voltar.png"))); // NOI18N
        jButton3.setText("  VOLTAR");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jFrame1_telaAnonima.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 770, 190, 50));

        jLabel21.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 0));
        jLabel21.setText("POSSÍVEL CRIMINOSO");
        jFrame1_telaAnonima.getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 530, 310, -1));

        jLabel20.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 0));
        jLabel20.setText("RECONHECE O AUTOR DO CRIME?");
        jFrame1_telaAnonima.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 450, 480, -1));

        jLabel19.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 0));
        jLabel19.setText("DATA DO OCORRIDO");
        jFrame1_telaAnonima.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 390, 290, -1));

        jLabel15.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 0));
        jLabel15.setText("PONTO DE REFERÊNCIA");
        jFrame1_telaAnonima.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 340, 30));

        jLabel13.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 0));
        jLabel13.setText("BAIRRO");
        jFrame1_telaAnonima.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 120, 40));

        jLabel12.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 0));
        jLabel12.setText("CEP");
        jFrame1_telaAnonima.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 70, 40));

        jButton1.setFont(new java.awt.Font("Serif", 3, 22)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/lupa.png"))); // NOI18N
        jButton1.setText(" BUSCAR");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jFrame1_telaAnonima.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 140, 40));

        jLabel16.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 0));
        jLabel16.setText("MUNICIPIO");
        jFrame1_telaAnonima.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 160, 40));

        jTextField1_bairro.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_bairro.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_bairro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_telaAnonima.getContentPane().add(jTextField1_bairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 340, 40));

        jButton3_denunciar.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jButton3_denunciar.setForeground(new java.awt.Color(0, 102, 0));
        jButton3_denunciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/botaoAnonimo.png"))); // NOI18N
        jButton3_denunciar.setText("  DENUNCIAR");
        jButton3_denunciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton3_denunciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3_denunciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_denunciarActionPerformed(evt);
            }
        });
        jFrame1_telaAnonima.getContentPane().add(jButton3_denunciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 680, 230, 70));

        jTextArea1_descricao.setColumns(20);
        jTextArea1_descricao.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextArea1_descricao.setForeground(new java.awt.Color(0, 102, 0));
        jTextArea1_descricao.setRows(5);
        jTextArea1_descricao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jScrollPane1.setViewportView(jTextArea1_descricao);

        jFrame1_telaAnonima.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 280, 580, 100));

        jFormattedTextField1_data.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFormattedTextField1_data.setForeground(new java.awt.Color(0, 102, 0));
        try {
            jFormattedTextField1_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_data.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jFrame1_telaAnonima.getContentPane().add(jFormattedTextField1_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 390, 130, 40));

        jRadioButton1_simm.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jRadioButton1_simm.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton1_simm.setText("SIM");
        jRadioButton1_simm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_simmActionPerformed(evt);
            }
        });
        jFrame1_telaAnonima.getContentPane().add(jRadioButton1_simm, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 490, -1, -1));

        jRadioButton2_naoo.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jRadioButton2_naoo.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton2_naoo.setText("NÃO");
        jRadioButton2_naoo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2_naooActionPerformed(evt);
            }
        });
        jFrame1_telaAnonima.getContentPane().add(jRadioButton2_naoo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 490, -1, -1));

        jLabel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DADOS DO INCIDENTE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 24), new java.awt.Color(0, 102, 0))); // NOI18N
        jFrame1_telaAnonima.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, 620, 450));

        jLabel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "ENDEREÇO DO INCIDENTE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 24), new java.awt.Color(0, 102, 0))); // NOI18N
        jFrame1_telaAnonima.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 620, 450));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        jFrame1_telaAnonima.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/voltar.png"))); // NOI18N
        jButton2.setText("  VOLTAR");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 770, 190, 50));

        jRadioButton1_nao.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jRadioButton1_nao.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton1_nao.setText("NÃO");
        jRadioButton1_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_naoActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1_nao, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, 80, 30));

        jRadioButton2_sim.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jRadioButton2_sim.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton2_sim.setText("SIM");
        jRadioButton2_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2_simActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2_sim, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 80, 30));

        jLabel4.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("DENÚNCIA ANÔNIMA?");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 400, 50));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 410, 110));

        jLabel6.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));
        jLabel6.setText("POSSUI CADASTRO?");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 370, 50));

        jRadioButton1_nao1.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jRadioButton1_nao1.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton1_nao1.setText("NÃO");
        jRadioButton1_nao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_nao1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1_nao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, 80, 30));

        jRadioButton2_sim1.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jRadioButton2_sim1.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton2_sim1.setText("SIM");
        jRadioButton2_sim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2_sim1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2_sim1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 80, 30));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 270, 410, 110));

        jButton3_denunciaAnonima.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jButton3_denunciaAnonima.setForeground(new java.awt.Color(0, 102, 0));
        jButton3_denunciaAnonima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/botaoAnonimo.png"))); // NOI18N
        jButton3_denunciaAnonima.setText("  DENUNCIAR");
        jButton3_denunciaAnonima.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton3_denunciaAnonima.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3_denunciaAnonima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_denunciaAnonimaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3_denunciaAnonima, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 230, 70));

        jButton3_cadastrar.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jButton3_cadastrar.setForeground(new java.awt.Color(0, 102, 0));
        jButton3_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/CadastrarDenunciante.png"))); // NOI18N
        jButton3_cadastrar.setText("CADASTRAR");
        jButton3_cadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton3_cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_cadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 250, 80));

        jButton3_entrar.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jButton3_entrar.setForeground(new java.awt.Color(0, 102, 0));
        jButton3_entrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/entrarDenunciante.png"))); // NOI18N
        jButton3_entrar.setText("    ENTRAR ");
        jButton3_entrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton3_entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_entrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3_entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 250, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoEcoWarriorsTelas.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 20, 200, 200));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tPrincipal telaPrincipal = new tPrincipal();
        telaPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton2_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2_simActionPerformed
        if (jRadioButton2_sim.isSelected()) {
            jLabel5.setVisible(false);
            jLabel6.setVisible(false);
            jRadioButton1_nao1.setVisible(false);
            jRadioButton2_sim1.setVisible(false);

            jButton3_denunciaAnonima.setVisible(true);

            jRadioButton1_nao.setSelected(false);
            jRadioButton1_nao1.setSelected(false);
            jRadioButton2_sim1.setSelected(false);
            jButton3_cadastrar.setVisible(false);
            jButton3_entrar.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButton2_simActionPerformed

    private void jRadioButton1_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_naoActionPerformed
        if (jRadioButton1_nao.isSelected()) {
            jLabel5.setVisible(true);
            jLabel6.setVisible(true);
            jRadioButton1_nao1.setVisible(true);
            jRadioButton2_sim1.setVisible(true);

            jButton3_denunciaAnonima.setVisible(false);

            jRadioButton2_sim.setSelected(false);
            jButton3_cadastrar.setVisible(false);
            jButton3_entrar.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButton1_naoActionPerformed

    private void jRadioButton1_nao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_nao1ActionPerformed
        if (jRadioButton1_nao1.isSelected()) {

            jButton3_cadastrar.setVisible(true);
            jRadioButton2_sim1.setSelected(false);
            jButton3_entrar.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButton1_nao1ActionPerformed

    private void jRadioButton2_sim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2_sim1ActionPerformed
        if (jRadioButton2_sim1.isSelected()) {

            jButton3_entrar.setVisible(true);
            jRadioButton1_nao1.setSelected(false);
            jButton3_cadastrar.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButton2_sim1ActionPerformed

    private void jButton3_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_cadastrarActionPerformed
        CadastrarDenunciantes cadastrarDenunciantes = new CadastrarDenunciantes();
        cadastrarDenunciantes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3_cadastrarActionPerformed

    private void jButton3_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_entrarActionPerformed
        tLoginDenunciantes loginDenunciante = new tLoginDenunciantes();
        loginDenunciante.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3_entrarActionPerformed

    private void jButton3_denunciaAnonimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_denunciaAnonimaActionPerformed
        jFrame1_telaAnonima.setBounds(WIDTH, WIDTH, 1600, 900);
        jFrame1_telaAnonima.setLocationRelativeTo(null);
        jFrame1_telaAnonima.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3_denunciaAnonimaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(true);
        jFrame1_telaAnonima.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ViaCEP cep = new ViaCEP();
            cep.buscar(jFormattedTextField1_CEP.getText());
            jTextField1_bairro.setText(cep.getBairro());
            jTextField1_rua.setText(cep.getLogradouro());
            jTextField1_Municipios.setText(cep.getLocalidade());

        } catch (ViaCEPException ex) {
            Logger.getLogger(tCadastroDenunciante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3_denunciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_denunciarActionPerformed
        try {
            File fotos = new File("./src\\main\\java\\com\\ecowarriors\\images\\logoEcoWarriorsTelas.png");

            if (jRadioButton1_simm.isSelected()) {
                IDenunciaDao denunciaDAO = new DenunciaDao();
                Endereco endereco = new Endereco(jTextField1_rua.getText(), jTextField1_bairro.getText(), jTextField1_Municipios.getText(), jFormattedTextField1_CEP.getText(),
                        jTextField1_pontoReferencia.getText());
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                data = new java.sql.Date(formatter.parse(jFormattedTextField1_data.getText()).getTime());
                Denuncia denuncia = new Denuncia("", fotos, "ANÔNIMO", endereco, jTextArea1_descricao.getText(), Categoria.FLORA, data, jTextField1_possivel_criminoso.getText(), StatusDenuncia.CRIADA);

                denunciaDAO.cadastroDenuncia(denuncia, endereco);
                denunciaDAO.atualizarProtocolo();
            } else if (jRadioButton2_naoo.isSelected()) {
                
                IDenunciaDao denunciaDAO = new DenunciaDao();
                Endereco enderecoo = new Endereco(jTextField1_rua.getText(), jTextField1_bairro.getText(), jTextField1_Municipios.getText(), jFormattedTextField1_CEP.getText(),
                        jTextField1_pontoReferencia.getText());
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                data = new java.sql.Date(formatter.parse(jFormattedTextField1_data.getText()).getTime());
                Denuncia denunciaa = new Denuncia("", fotos, "ANÔNIMO", enderecoo, jTextArea1_descricao.getText(), Categoria.FLORA, data, "Nao_identificado", StatusDenuncia.CRIADA);
                denunciaDAO.cadastroDenuncia(denunciaa, enderecoo);
                denunciaDAO.atualizarProtocolo();
            }

        } catch (Exception ex) {
            Logger.getLogger(tCadastroDenunciante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3_denunciarActionPerformed

    private void jRadioButton1_simmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_simmActionPerformed
        if (jRadioButton1_simm.isSelected()) {
            jLabel21.setVisible(true);
            jTextField1_possivel_criminoso.setVisible(true);
            jRadioButton2_naoo.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton1_simmActionPerformed

    private void jRadioButton2_naooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2_naooActionPerformed
        if (jRadioButton2_naoo.isSelected()) {
            jLabel21.setVisible(false);
            jTextField1_possivel_criminoso.setVisible(false);
            jRadioButton1_simm.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton2_naooActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tCadastroDenunciante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tCadastroDenunciante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tCadastroDenunciante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tCadastroDenunciante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tCadastroDenunciante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton3_cadastrar;
    private javax.swing.JButton jButton3_denunciaAnonima;
    private javax.swing.JButton jButton3_denunciar;
    private javax.swing.JButton jButton3_entrar;
    private javax.swing.JFormattedTextField jFormattedTextField1_CEP;
    private javax.swing.JFormattedTextField jFormattedTextField1_data;
    private javax.swing.JFrame jFrame1_telaAnonima;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1_nao;
    private javax.swing.JRadioButton jRadioButton1_nao1;
    private javax.swing.JRadioButton jRadioButton1_simm;
    private javax.swing.JRadioButton jRadioButton2_naoo;
    private javax.swing.JRadioButton jRadioButton2_sim;
    private javax.swing.JRadioButton jRadioButton2_sim1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1_descricao;
    private javax.swing.JTextField jTextField1_Municipios;
    private javax.swing.JTextField jTextField1_bairro;
    private javax.swing.JTextField jTextField1_pontoReferencia;
    private javax.swing.JTextField jTextField1_possivel_criminoso;
    private javax.swing.JTextField jTextField1_rua;
    // End of variables declaration//GEN-END:variables
}
