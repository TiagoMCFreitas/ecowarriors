package com.ecowarriors.visao;

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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jRadioButton1_nao = new javax.swing.JRadioButton();
        jRadioButton2_sim = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1_nao1 = new javax.swing.JRadioButton();
        jRadioButton2_sim1 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jButton3_cadastrar = new javax.swing.JButton();
        jButton3_entrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
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

            jRadioButton2_sim.setSelected(false);
            jButton3_cadastrar.setVisible(false);
            jButton3_entrar.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButton1_naoActionPerformed

    private void jRadioButton1_nao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_nao1ActionPerformed
        if(jRadioButton1_nao1.isSelected()){
            
            
            jButton3_cadastrar.setVisible(true);
            jRadioButton2_sim1.setSelected(false);
            jButton3_entrar.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButton1_nao1ActionPerformed

    private void jRadioButton2_sim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2_sim1ActionPerformed
        if(jRadioButton2_sim1.isSelected()){
            
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3_cadastrar;
    private javax.swing.JButton jButton3_entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1_nao;
    private javax.swing.JRadioButton jRadioButton1_nao1;
    private javax.swing.JRadioButton jRadioButton2_sim;
    private javax.swing.JRadioButton jRadioButton2_sim1;
    // End of variables declaration//GEN-END:variables
}
