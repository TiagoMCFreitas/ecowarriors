package com.ecowarriors.visao;

import com.ecowarriors.Enum.Usuario;
import com.ecowarriors.modelos.Usuarios;
import com.ecowarriors.persistencia.IUsuarioDao;
import com.ecowarriors.persistencia.UsuarioDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class CadastrarDenunciantes extends javax.swing.JFrame {

    public CadastrarDenunciantes() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField1_Senha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1_Sobrenome = new javax.swing.JTextField();
        jTextField1_Email = new javax.swing.JTextField();
        jTextField1_NOME = new javax.swing.JTextField();
        jFormattedTextField1_Telefone = new javax.swing.JFormattedTextField();
        jFormattedTextField1_CPF = new javax.swing.JFormattedTextField();
        jButton3_cadastrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1600, 900));
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

        jLabel10.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 0));
        jLabel10.setText("SENHA");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 100, 40));

        jTextField1_Senha.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1_Senha.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_Senha.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_Senha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        getContentPane().add(jTextField1_Senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 290, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoEcoWarriorsTelas.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 20, 200, 200));

        jLabel7.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 0));
        jLabel7.setText("SOBRENOME");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, 180, 40));

        jLabel6.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));
        jLabel6.setText("TELEFONE");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 150, 40));

        jLabel5.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));
        jLabel5.setText("EMAIL");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 100, 40));

        jLabel4.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("CPF");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 60, 40));

        jLabel2.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("NOME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 90, 40));

        jTextField1_Sobrenome.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1_Sobrenome.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_Sobrenome.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_Sobrenome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        jTextField1_Sobrenome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_SobrenomeActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1_Sobrenome, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 220, 230, 40));

        jTextField1_Email.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1_Email.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_Email.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_Email.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        getContentPane().add(jTextField1_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 590, 40));

        jTextField1_NOME.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1_NOME.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_NOME.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_NOME.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        jTextField1_NOME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_NOMEKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1_NOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 230, 40));

        jFormattedTextField1_Telefone.setBackground(new java.awt.Color(255, 255, 255));
        jFormattedTextField1_Telefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jFormattedTextField1_Telefone.setForeground(new java.awt.Color(0, 102, 0));
        try {
            jFormattedTextField1_Telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_Telefone.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        getContentPane().add(jFormattedTextField1_Telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 270, 230, 40));

        jFormattedTextField1_CPF.setBackground(new java.awt.Color(255, 255, 255));
        jFormattedTextField1_CPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jFormattedTextField1_CPF.setForeground(new java.awt.Color(0, 102, 0));
        try {
            jFormattedTextField1_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_CPF.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        getContentPane().add(jFormattedTextField1_CPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 230, 40));

        jButton3_cadastrar.setBackground(new java.awt.Color(255, 255, 255));
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
        getContentPane().add(jButton3_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 570, 230, 70));

        jLabel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DADOS LOGIN", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 32), new java.awt.Color(0, 102, 0))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 830, 170));

        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DADOS PESSOAIS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 32), new java.awt.Color(0, 102, 0))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 830, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1780, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tCadastroDenunciante tiposDenunciantes = new tCadastroDenunciante();
        tiposDenunciantes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1_SobrenomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_SobrenomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_SobrenomeActionPerformed

    private void jButton3_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_cadastrarActionPerformed
        if(jTextField1_Email.getText().isEmpty()|| jTextField1_NOME.getText().isEmpty()|| jTextField1_Senha.getText().isEmpty()|| 
                jTextField1_Sobrenome.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos!");
        }else{
            try {
                Usuarios usuario = new Usuarios(jFormattedTextField1_CPF.getText(), jTextField1_Senha.getText(),
                        jTextField1_NOME.getText() + " " + jTextField1_Sobrenome.getText(),
                        jTextField1_Email.getText(), Usuario.DENUNCIANTE, jFormattedTextField1_Telefone.getText());
                
                IUsuarioDao usuarioDao = new UsuarioDao();
                usuarioDao.cadastrarUsuarios(usuario);
                JOptionPane.showMessageDialog(rootPane, "usuario Cadastrado!");
                limparCampos();
            } catch (Exception ex) {
                Logger.getLogger(CadastrarDenunciantes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jButton3_cadastrarActionPerformed

    private void jTextField1_NOMEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_NOMEKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_NOMEKeyPressed

    public void limparCampos(){
        jTextField1_Email.setText("");
        jTextField1_NOME.setText("");
        jTextField1_Senha.setText("");
        jTextField1_Sobrenome.setText("");
        jFormattedTextField1_CPF.setText("");
        jFormattedTextField1_Telefone.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(CadastrarDenunciantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarDenunciantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarDenunciantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarDenunciantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarDenunciantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3_cadastrar;
    private javax.swing.JFormattedTextField jFormattedTextField1_CPF;
    private javax.swing.JFormattedTextField jFormattedTextField1_Telefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1_Email;
    private javax.swing.JTextField jTextField1_NOME;
    private javax.swing.JTextField jTextField1_Senha;
    private javax.swing.JTextField jTextField1_Sobrenome;
    // End of variables declaration//GEN-END:variables
}
