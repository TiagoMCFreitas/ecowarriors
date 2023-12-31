/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ecowarriors.visao;

import com.ecowarriors.ferramentas.ConexaoBD;
import com.ecowarriors.ferramentas.JTableRenderer;
import com.ecowarriors.modelos.Denuncia;
import com.ecowarriors.persistencia.DenunciaDao;
import com.ecowarriors.persistencia.IDenunciaDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class tAnaliseDenuncias extends javax.swing.JFrame {
    private Connection conexao = null;
    String cpf = "";
    /**
     * Creates new form tAnaliseDenuncias
     */
    
    public tAnaliseDenuncias() {
        try {
            initComponents();
            conexao = ConexaoBD.getConexao();
            IDenunciaDao objetoDao = new DenunciaDao();
            System.out.println((cpf));
        } catch (Exception ex) {
            Logger.getLogger(tAnaliseDenuncias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
 public void imprimirDadosNaGrid(List<Denuncia> listaDeModelos) {
     try{
        System.out.println(listaDeModelos.get(0).getStatusDenuncia());
        
        } catch (Exception e) {
            System.out.println(e);
        }
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_DenunciasUsuario = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jTextField1_protocoloEscondido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 770, 190, 50));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoEcoWarriorsTelas.png"))); // NOI18N
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 20, 200, 200));

        jLabel22.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 0));
        jLabel22.setText("AVALIAR DENUNCIAS");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 400, 50));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DENÚNCIAS DISPONÍVEIS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 26), new java.awt.Color(0, 102, 0))); // NOI18N
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N

        jTable1_DenunciasUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTable1_DenunciasUsuario.setFont(new java.awt.Font("Serif", 3, 22)); // NOI18N
        jTable1_DenunciasUsuario.setForeground(new java.awt.Color(0, 102, 0));
        jTable1_DenunciasUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1_DenunciasUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1_DenunciasUsuario.setGridColor(new java.awt.Color(153, 255, 0));
        jTable1_DenunciasUsuario.setRowHeight(45);
        jTable1_DenunciasUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_DenunciasUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_DenunciasUsuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 1040, 370));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));
        getContentPane().add(jTextField1_protocoloEscondido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 140, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        tAnaliseDenuncias telaAnalise = new tAnaliseDenuncias();
        telaAnalise.dispose();
        tUsuarioLogado usuarioLogado = new tUsuarioLogado();
        usuarioLogado.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1_DenunciasUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_DenunciasUsuarioMouseClicked
//        try {
//            jTextField1_protocoloEscondido.setText(jTable1_Denuncias.getValueAt(jTable1_Denuncias.getSelectedRow(), 0).toString());
//            String protocolo = jTable1_Denuncias.getValueAt(jTable1_Denuncias.getSelectedRow(), 0).toString();
//            System.out.println(protocolo);
//
//            IDenunciaDao objetoDao = new DenunciaDao();
//
//            if (jTable1_Denuncias.getValueAt(jTable1_Denuncias.getSelectedRow(), 5).toString().equals("EM_PROCESSAMENTO")) {
//                imprimirDadosNaGrid();
//                jFrame1_avaliacaoFinalDenuncia.setBounds(WIDTH, WIDTH, 1600, 900);
//                jFrame1_avaliacaoFinalDenuncia.setLocationRelativeTo(null);
//                jFrame1_avaliacaoFinalDenuncia.setVisible(true);
//                jFrame1_avaliarDenuncia.dispose();
//
//            } else {
//                objetoDao.atualizarDenuncia(StatusDenuncia.EM_PROCESSAMENTO.toString(), protocolo);
//                jFrame1_avaliacaoFinalDenuncia.setBounds(WIDTH, WIDTH, 1600, 900);
//                jFrame1_avaliacaoFinalDenuncia.setLocationRelativeTo(null);
//                jFrame1_avaliacaoFinalDenuncia.setVisible(true);
//                jFrame1_avaliarDenuncia.dispose();
//            }
//
//        } catch (Exception ex) {
//            Logger.getLogger(tGestorLogado.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jTable1_DenunciasUsuarioMouseClicked

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
            java.util.logging.Logger.getLogger(tAnaliseDenuncias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tAnaliseDenuncias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tAnaliseDenuncias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tAnaliseDenuncias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tAnaliseDenuncias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_DenunciasUsuario;
    private javax.swing.JTextField jTextField1_protocoloEscondido;
    // End of variables declaration//GEN-END:variables
}
