package com.ecowarriors.visao;

import com.ecowarriors.modelos.Usuarios;
import com.ecowarriors.persistencia.IUsuarioDao;
import com.ecowarriors.persistencia.UsuarioDao;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import java.util.Base64;

public class tLoginDenunciantes extends javax.swing.JFrame {

    
    public tLoginDenunciantes() {
        initComponents();
        jTextField1_Senha.setVisible(false);
        jButton1_ocultarSenha.setVisible(false);
        setLocationRelativeTo(null);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField1_Senha = new javax.swing.JTextField();
        jTextField1_Usuario = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1_ocultarSenha = new javax.swing.JButton();
        jButton1_verSenha = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3_entrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoPrincipall.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 0, 310, 300));

        jTextField1_Senha.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_Senha.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_Senha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        getContentPane().add(jTextField1_Senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 470, 400, 40));

        jTextField1_Usuario.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_Usuario.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_Usuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        getContentPane().add(jTextField1_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 400, 40));

        jPasswordField1.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(0, 102, 0));
        jPasswordField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 470, 400, 40));

        jButton1_ocultarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/ocultarSenha.png"))); // NOI18N
        jButton1_ocultarSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jButton1_ocultarSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_ocultarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_ocultarSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_ocultarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 470, 50, 40));

        jButton1_verSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/verSenha.png"))); // NOI18N
        jButton1_verSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jButton1_verSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_verSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_verSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_verSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 470, 50, 40));

        jLabel10.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 0));
        jLabel10.setText("SENHA");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 100, 40));

        jLabel5.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));
        jLabel5.setText("USUÁRIO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 140, 40));

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
        getContentPane().add(jButton3_entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 530, 190, 70));

        jLabel2.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("ESQUECI MINHA SENHA");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 630, 290, 20));

        jLabel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DADOS LOGIN", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 32), new java.awt.Color(0, 102, 0))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 700, 300));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tCadastroDenunciante denunciantes = new tCadastroDenunciante();
        denunciantes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void jButton3_entrarActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_jButton3_entrarActionPerformed
        try{
            IUsuarioDao usuarioDao = new UsuarioDao();
            String senha = "";
            if(jTextField1_Senha.getText().isEmpty()){
                senha = jPasswordField1.getText();
            }
            else{
                senha = jTextField1_Senha.getText();
            }
            boolean isLiberado = usuarioDao.logarUsuarios(jTextField1_Usuario.getText(),senha);
            if(isLiberado){
                
                String dadoParaPesquisa = jTextField1_Usuario.getText();
                tUsuarioLogado usuarioLogado = new tUsuarioLogado();
                Usuarios usuario = new Usuarios();
                usuario.setEmail(dadoParaPesquisa);
                usuarioLogado.ExportarDados(usuario);
                usuarioLogado.setVisible(true);
                this.dispose();
           
            }else{
                JOptionPane.showMessageDialog(rootPane, "Usuario ou senha incorretos!");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"Usuario ou senha incorretos");
        }
    }//GEN-LAST:event_jButton3_entrarActionPerformed

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
            java.util.logging.Logger.getLogger(tLoginDenunciantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tLoginDenunciantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tLoginDenunciantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tLoginDenunciantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tLoginDenunciantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_ocultarSenha;
    private javax.swing.JButton jButton1_verSenha;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3_entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1_Senha;
    private javax.swing.JTextField jTextField1_Usuario;
    // End of variables declaration//GEN-END:variables
}
