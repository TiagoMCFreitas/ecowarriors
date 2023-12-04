package com.ecowarriors.visao;

import com.ecowarriors.Enum.Usuario;
import com.ecowarriors.modelos.Usuarios;
import com.ecowarriors.persistencia.IUsuarioDao;
import com.ecowarriors.persistencia.UsuarioDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class tLoginGestor extends javax.swing.JFrame {

    public tLoginGestor() {
        initComponents();

        jTextField1_Senha.setVisible(false);
        jTextField1_Usuario.setVisible(false);
        jLabel9.setVisible(false);
        jPasswordField1.setVisible(false);
        jButton1_verSenha.setVisible(false);
        jButton1_ocultarSenha.setVisible(false);
        jButton3_entrar.setVisible(false);
        jLabel4.setVisible(false);
        jLabel10.setVisible(false);
        jLabel7.setVisible(false);

        jPasswordField2.setVisible(false);
        jTextField1_NOME.setVisible(false);
        jFormattedTextField1_CPF.setVisible(false);
        jTextField1_Sobrenome.setVisible(false);
        jFormattedTextField1_Telefone.setVisible(false);
        jTextField1_Senha1.setVisible(false);
        jTextField1_Email.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel8.setVisible(false);
        jButton1_verSenha1.setVisible(false);
        jButton1_ocultarSenha1.setVisible(false);
        jFormattedTextField1_Telefone.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        jLabel16.setVisible(false);
        jLabel17.setVisible(false);
        jButton3_cadastrar.setVisible(false);
        
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton2_sim1 = new javax.swing.JRadioButton();
        jRadioButton1_nao1 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3_entrar = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1_Senha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1_Usuario = new javax.swing.JTextField();
        jButton1_ocultarSenha = new javax.swing.JButton();
        jButton1_verSenha = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1_Email = new javax.swing.JTextField();
        jTextField1_Senha1 = new javax.swing.JTextField();
        jButton1_verSenha1 = new javax.swing.JButton();
        jFormattedTextField1_Telefone = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1_Sobrenome = new javax.swing.JTextField();
        jFormattedTextField1_CPF = new javax.swing.JFormattedTextField();
        jTextField1_NOME = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton3_cadastrar = new javax.swing.JButton();
        jButton1_ocultarSenha1 = new javax.swing.JButton();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoEcoWarriorsTelas.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 20, 200, 200));

        jLabel6.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));
        jLabel6.setText("POSSUI CADASTRO?");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 370, 50));

        jRadioButton2_sim1.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jRadioButton2_sim1.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton2_sim1.setText("SIM");
        jRadioButton2_sim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2_sim1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2_sim1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 80, 30));

        jRadioButton1_nao1.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jRadioButton1_nao1.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton1_nao1.setText("NÃO");
        jRadioButton1_nao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_nao1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1_nao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 80, 30));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 410, 110));

        jLabel4.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("ESQUECI MINHA SENHA");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, 290, 20));

        jButton3_entrar.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jButton3_entrar.setForeground(new java.awt.Color(0, 102, 0));
        jButton3_entrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/entrarDenunciante.png"))); // NOI18N
        jButton3_entrar.setText("  ENTRAR ");
        jButton3_entrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton3_entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_entrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3_entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 190, 70));

        jPasswordField1.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(0, 102, 0));
        jPasswordField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 400, 40));

        jTextField1_Senha.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_Senha.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_Senha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        getContentPane().add(jTextField1_Senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 400, 40));

        jLabel10.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 0));
        jLabel10.setText("SENHA");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 100, 40));

        jLabel7.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 0));
        jLabel7.setText("USUÁRIO");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 140, 40));

        jTextField1_Usuario.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_Usuario.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_Usuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        getContentPane().add(jTextField1_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 400, 40));

        jButton1_ocultarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/ocultarSenha.png"))); // NOI18N
        jButton1_ocultarSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jButton1_ocultarSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_ocultarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_ocultarSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_ocultarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 360, 50, 40));

        jButton1_verSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/verSenha.png"))); // NOI18N
        jButton1_verSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jButton1_verSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_verSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_verSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_verSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 360, 50, 40));

        jLabel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DADOS LOGIN", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 32), new java.awt.Color(0, 102, 0))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 700, 300));

        jLabel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DADOS LOGIN", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 32), new java.awt.Color(0, 102, 0))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 830, 170));

        jLabel12.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 0));
        jLabel12.setText("SENHA");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 100, 40));

        jLabel8.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 0));
        jLabel8.setText("EMAIL");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 100, 40));

        jTextField1_Email.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_Email.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_Email.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        getContentPane().add(jTextField1_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 460, 590, 40));

        jTextField1_Senha1.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_Senha1.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_Senha1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        getContentPane().add(jTextField1_Senha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 290, 40));

        jButton1_verSenha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/verSenha.png"))); // NOI18N
        jButton1_verSenha1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jButton1_verSenha1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_verSenha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_verSenha1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_verSenha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 510, 50, 40));

        jFormattedTextField1_Telefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jFormattedTextField1_Telefone.setForeground(new java.awt.Color(0, 102, 0));
        try {
            jFormattedTextField1_Telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_Telefone.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        getContentPane().add(jFormattedTextField1_Telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 310, 230, 40));

        jLabel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DADOS PESSOAIS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 32), new java.awt.Color(0, 102, 0))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 830, 170));

        jLabel14.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 0));
        jLabel14.setText("TELEFONE");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 310, 150, 40));

        jLabel15.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 0));
        jLabel15.setText("SOBRENOME");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 180, 40));

        jTextField1_Sobrenome.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_Sobrenome.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_Sobrenome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        jTextField1_Sobrenome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_SobrenomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1_Sobrenome, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 260, 230, 40));

        jFormattedTextField1_CPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jFormattedTextField1_CPF.setForeground(new java.awt.Color(0, 102, 0));
        try {
            jFormattedTextField1_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_CPF.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        getContentPane().add(jFormattedTextField1_CPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 230, 40));

        jTextField1_NOME.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_NOME.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_NOME.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        jTextField1_NOME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_NOMEKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1_NOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 230, 40));

        jLabel16.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 0));
        jLabel16.setText("CPF");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 60, 40));

        jLabel17.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 0));
        jLabel17.setText("NOME");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 90, 40));

        jButton3_cadastrar.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jButton3_cadastrar.setForeground(new java.awt.Color(0, 102, 0));
        jButton3_cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/botaoCadastrar.png"))); // NOI18N
        jButton3_cadastrar.setText("   CADASTRAR");
        jButton3_cadastrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton3_cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_cadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 610, 230, 70));

        jButton1_ocultarSenha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/ocultarSenha.png"))); // NOI18N
        jButton1_ocultarSenha1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jButton1_ocultarSenha1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_ocultarSenha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_ocultarSenha1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_ocultarSenha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 510, 50, 40));

        jPasswordField2.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jPasswordField2.setForeground(new java.awt.Color(0, 102, 0));
        jPasswordField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        getContentPane().add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 290, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tPrincipal telaPrincipal = new tPrincipal();
        telaPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton2_sim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2_sim1ActionPerformed
        if (jRadioButton2_sim1.isSelected()) {
            jTextField1_Usuario.setVisible(true);
            jLabel9.setVisible(true);
            jPasswordField1.setVisible(true);
            jButton1_verSenha.setVisible(true);
            jButton3_entrar.setVisible(true);
            jLabel4.setVisible(true);
            jLabel10.setVisible(true);
            jLabel7.setVisible(true);

            jPasswordField2.setVisible(false);
            jTextField1_NOME.setVisible(false);
            jFormattedTextField1_CPF.setVisible(false);
            jTextField1_Sobrenome.setVisible(false);
            jFormattedTextField1_Telefone.setVisible(false);
            jTextField1_Senha1.setVisible(false);
            jTextField1_Email.setVisible(false);
            jLabel11.setVisible(false);
            jLabel12.setVisible(false);
            jLabel8.setVisible(false);
            jButton1_verSenha1.setVisible(false);
            jFormattedTextField1_Telefone.setVisible(false);
            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
            jLabel15.setVisible(false);
            jLabel16.setVisible(false);
            jLabel17.setVisible(false);
            jButton1_ocultarSenha1.setVisible(false);
            jButton3_cadastrar.setVisible(false);
            limparCampos();

            jRadioButton1_nao1.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton2_sim1ActionPerformed

    private void jRadioButton1_nao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_nao1ActionPerformed
        if (jRadioButton1_nao1.isSelected()) {

            jTextField1_Senha.setVisible(false);
            jTextField1_Usuario.setVisible(false);
            jLabel9.setVisible(false);
            jPasswordField1.setVisible(false);
            jButton1_verSenha.setVisible(false);
            jButton1_ocultarSenha.setVisible(false);
            jButton3_entrar.setVisible(false);
            jLabel4.setVisible(false);
            jLabel10.setVisible(false);
            jLabel7.setVisible(false);
            jTextField1_Senha.setText("");
            jTextField1_Usuario.setText("");
            jPasswordField1.setText("");

            jPasswordField2.setVisible(true);
            jTextField1_NOME.setVisible(true);
            jFormattedTextField1_CPF.setVisible(true);
            jTextField1_Sobrenome.setVisible(true);
            jFormattedTextField1_Telefone.setVisible(true);
            jTextField1_Email.setVisible(true);
            jLabel11.setVisible(true);
            jLabel12.setVisible(true);
            jLabel8.setVisible(true);
            jButton1_verSenha1.setVisible(true);
            jFormattedTextField1_Telefone.setVisible(true);
            jLabel13.setVisible(true);
            jLabel14.setVisible(true);
            jLabel15.setVisible(true);
            jLabel16.setVisible(true);
            jLabel17.setVisible(true);
            jButton3_cadastrar.setVisible(true);

            jRadioButton2_sim1.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton1_nao1ActionPerformed

    private void jButton3_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_entrarActionPerformed
        try {
            IUsuarioDao usuarioDao = new UsuarioDao();
            String senha = "";
            if (jTextField1_Usuario.getText().isEmpty() && jPasswordField1.getText().isEmpty() && jTextField1_Senha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Nenhum dos campos foram preechidos!");
            } else if (jTextField1_Usuario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Preencha o campo de usuário!");
            } else if (jPasswordField1.getText().isEmpty() && jTextField1_Senha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Preencha o campo de senha!");
            } else {
                if (jTextField1_Senha.getText().isEmpty()) {
                    senha = jPasswordField1.getText();
                } else {
                    senha = jTextField1_Senha.getText();
                }
                boolean isLiberado = usuarioDao.logarUsuarios(jTextField1_Usuario.getText(), senha);
                if (isLiberado) {

                    String dadoParaPesquisa = jTextField1_Usuario.getText();
                    tGestorLogado gestorLogado = new tGestorLogado();
                    Usuarios usuario = new Usuarios();
                    usuario.setEmail(dadoParaPesquisa);
                    gestorLogado.ExportarDados(usuario);
                    gestorLogado.setVisible(true);
                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Usuario ou senha incorretos!");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Usuario ou senha incorretos");
        }
    }//GEN-LAST:event_jButton3_entrarActionPerformed

    private void jButton1_ocultarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_ocultarSenhaActionPerformed
        jPasswordField1.setVisible(true);
        jPasswordField1.setText(jTextField1_Senha.getText());
        jTextField1_Senha.setText("");
        jTextField1_Senha.setVisible(false);
        jButton1_ocultarSenha.setVisible(false);
        jButton1_verSenha.setVisible(true);
    }//GEN-LAST:event_jButton1_ocultarSenhaActionPerformed

    private void jButton1_verSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_verSenhaActionPerformed
        jTextField1_Senha.setVisible(true);
        jTextField1_Senha.setText(jPasswordField1.getText().toString());
        jPasswordField1.setVisible(false);
        jPasswordField1.setText("");
        jButton1_verSenha.setVisible(false);
        jButton1_ocultarSenha.setVisible(true);
    }//GEN-LAST:event_jButton1_verSenhaActionPerformed

    private void jButton1_verSenha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_verSenha1ActionPerformed

        jTextField1_Senha1.setText(jPasswordField2.getText().toString());
        jPasswordField2.setVisible(false);
        jPasswordField2.setText("");
        jTextField1_Senha1.setVisible(true);
        jButton1_verSenha1.setVisible(false);
        jButton1_ocultarSenha1.setVisible(true);
    }//GEN-LAST:event_jButton1_verSenha1ActionPerformed

    private void jTextField1_SobrenomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_SobrenomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_SobrenomeActionPerformed

    private void jTextField1_NOMEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_NOMEKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_NOMEKeyPressed

    private void jButton3_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_cadastrarActionPerformed
        if (jTextField1_Email.getText().isEmpty() || jTextField1_NOME.getText().isEmpty()
                || jTextField1_Sobrenome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos!");
        } else {
            String cpfFormatado = jFormattedTextField1_CPF.getText().replace(".", "").replace("-", "");
            try {
                if (jPasswordField2.getText().isEmpty()) {
                    Usuarios usuario = new Usuarios(cpfFormatado, jTextField1_Senha1.getText(),
                            jTextField1_NOME.getText() + " " + jTextField1_Sobrenome.getText(),
                            jTextField1_Email.getText(), Usuario.GESTOR, jFormattedTextField1_Telefone.getText());

                    IUsuarioDao usuarioDao = new UsuarioDao();
                    usuarioDao.cadastrarUsuarios(usuario);
                    JOptionPane.showMessageDialog(rootPane, "usuario Cadastrado!");
                    limparCampos();
                } else if (jTextField1_Senha1.getText().isEmpty()) {
                    Usuarios usuario = new Usuarios(cpfFormatado, jPasswordField2.getText().toString(),
                            jTextField1_NOME.getText() + " " + jTextField1_Sobrenome.getText(),
                            jTextField1_Email.getText(), Usuario.GESTOR, jFormattedTextField1_Telefone.getText());

                    IUsuarioDao usuarioDao = new UsuarioDao();
                    usuarioDao.cadastrarUsuarios(usuario);
                    JOptionPane.showMessageDialog(rootPane, "usuario Cadastrado!");
                    limparCampos();

                    jPasswordField2.setVisible(false);
                    jTextField1_NOME.setVisible(false);
                    jFormattedTextField1_CPF.setVisible(false);
                    jTextField1_Sobrenome.setVisible(false);
                    jFormattedTextField1_Telefone.setVisible(false);
                    jTextField1_Senha1.setVisible(false);
                    jTextField1_Email.setVisible(false);
                    jLabel11.setVisible(false);
                    jLabel12.setVisible(false);
                    jLabel8.setVisible(false);
                    jButton1_verSenha1.setVisible(false);
                    jButton1_ocultarSenha1.setVisible(false);
                    jFormattedTextField1_Telefone.setVisible(false);
                    jLabel13.setVisible(false);
                    jLabel14.setVisible(false);
                    jLabel15.setVisible(false);
                    jLabel16.setVisible(false);
                    jLabel17.setVisible(false);
                    jButton3_cadastrar.setVisible(false);

                    jTextField1_Usuario.setVisible(true);
                    jLabel9.setVisible(true);
                    jPasswordField1.setVisible(true);
                    jButton1_verSenha.setVisible(true);
                    jButton3_entrar.setVisible(true);
                    jLabel4.setVisible(true);
                    jLabel10.setVisible(true);
                    jLabel7.setVisible(true);
                    jRadioButton1_nao1.setSelected(false);
                    jRadioButton2_sim1.setSelected(true);
                    
                }
            } catch (Exception ex) {
                Logger.getLogger(CadastrarDenunciantes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3_cadastrarActionPerformed

    public void limparCampos() {
        jPasswordField2.setText("");
        jTextField1_NOME.setText("");
        jFormattedTextField1_CPF.setText("");
        jTextField1_Sobrenome.setText("");
        jFormattedTextField1_Telefone.setText("");
        jTextField1_Senha1.setText("");
        jTextField1_Email.setText("");
    }

    private void jButton1_ocultarSenha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_ocultarSenha1ActionPerformed

        jPasswordField2.setText(jTextField1_Senha1.getText());
        jTextField1_Senha1.setText("");
        jTextField1_Senha1.setVisible(false);
        jPasswordField2.setVisible(true);
        jButton1_ocultarSenha1.setVisible(false);
        jButton1_verSenha1.setVisible(true);
    }//GEN-LAST:event_jButton1_ocultarSenha1ActionPerformed

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
            java.util.logging.Logger.getLogger(tLoginGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tLoginGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tLoginGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tLoginGestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tLoginGestor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_ocultarSenha;
    private javax.swing.JButton jButton1_ocultarSenha1;
    private javax.swing.JButton jButton1_verSenha;
    private javax.swing.JButton jButton1_verSenha1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3_cadastrar;
    private javax.swing.JButton jButton3_entrar;
    private javax.swing.JFormattedTextField jFormattedTextField1_CPF;
    private javax.swing.JFormattedTextField jFormattedTextField1_Telefone;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JRadioButton jRadioButton1_nao1;
    private javax.swing.JRadioButton jRadioButton2_sim1;
    private javax.swing.JTextField jTextField1_Email;
    private javax.swing.JTextField jTextField1_NOME;
    private javax.swing.JTextField jTextField1_Senha;
    private javax.swing.JTextField jTextField1_Senha1;
    private javax.swing.JTextField jTextField1_Sobrenome;
    private javax.swing.JTextField jTextField1_Usuario;
    // End of variables declaration//GEN-END:variables
}
