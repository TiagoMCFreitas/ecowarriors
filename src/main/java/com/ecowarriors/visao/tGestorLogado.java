package com.ecowarriors.visao;

import com.ecowarriors.Enum.*;
import com.ecowarriors.ferramentas.ConexaoBD;
import com.ecowarriors.ferramentas.JTableRenderer;
import com.ecowarriors.modelos.Denuncia;
import com.ecowarriors.modelos.Usuarios;
import com.ecowarriors.persistencia.DenunciaDao;
import com.ecowarriors.persistencia.IDenunciaDao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class tGestorLogado extends javax.swing.JFrame {

    private Connection conexao = null;
    String protocoloGeral;
    String categoriaDenuncia;

    public tGestorLogado() {
        try {
            initComponents();
            conexao = ConexaoBD.getConexao();

            jTextArea1_avaliacaoAnalista.setLineWrap(true);
            jTextArea1_avaliacaoAnalista.setWrapStyleWord(true);
            jTextArea1_descricaoDenuncia.setLineWrap(true);
            jTextArea1_descricaoDenuncia.setWrapStyleWord(true);

            jTextField1_Email.setEnabled(false);
            jTextField1_nomeCompleto.setEnabled(false);
            jFormattedTextField1_Telefone.setEnabled(false);
            jFormattedTextField1_CPF.setEnabled(false);

            imprimirDadosNaGrid();
            setLocationRelativeTo(null);

            jFormattedTextField1_CEP.setEnabled(false);
            jTextField1_bairro.setEnabled(false);
            jTextField1_rua.setEnabled(false);
            jTextField1_pontoReferencia.setEnabled(false);
            jTextArea1_descricaoDenuncia.setEnabled(false);
            jTextField1_tipoDaDenunciaSelecionada.setEnabled(false);
            jTextField1_DATA.setEnabled(false);
            jTextField1_PROTOCOLO.setEnabled(false);

            carregarComboBoxTipoDenuncia();

            jLabel44.setVisible(false);
            jComboBox1_tipoDenuncia.setVisible(false);

        } catch (Exception ex) {
            Logger.getLogger(tGestorLogado.class.getName()).log(Level.SEVERE, null, ex);
        }

        categoriaDenuncia = Categoria.ADMINISTRACAO_AMBIENTAL + "";
    }

    public void personalizarTabela() throws Exception {

    }

    public void ExportarDados(Usuarios usuario) {
        jTextField1_Email.setText(usuario.getEmail());
    }

    private void imprimirListaDeDenuncias() {

        try {

            DefaultTableModel model = (DefaultTableModel) jTable1_ListaDeDenuncias.getModel();
            JTableRenderer JtableRenderer = new JTableRenderer();
            conexao = ConexaoBD.getConexao();
            Statement statement = conexao.createStatement();
            String query = "select protocolo as Protocolo, \n"
                    + "	denunciante as Denunciante, \n"
                    + "	categoria as Categoria, \n"
                    + "	data as Data, \n"
                    + "	status_denuncia as Status \n"
                    + "from denuncia";
            ResultSet resultSet = statement.executeQuery(query);

            DefaultTableModel tableModel = new DefaultTableModel();
            jTable1_ListaDeDenuncias.setModel(tableModel);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(row);
            }
            resultSet.close();
            statement.close();

            jTable1_ListaDeDenuncias.getColumnModel().getColumn(0).setWidth(140);
            jTable1_ListaDeDenuncias.getColumnModel().getColumn(0).setMinWidth(140);
            jTable1_ListaDeDenuncias.getColumnModel().getColumn(0).setMaxWidth(140);

        } catch (Exception e) {

        }
    }

    private void imprimirDadosNaGrid() {

        try {

            DefaultTableModel model = (DefaultTableModel) jTable1_Denuncias.getModel();
            JTableRenderer JtableRenderer = new JTableRenderer();
            conexao = ConexaoBD.getConexao();
            Statement statement = conexao.createStatement();
            String query = "select protocolo as Protocolo, \n"
                    + "	denunciante as Denunciante, \n"
                    + "	descricao_incidente as \"Descrição do Incidente\", \n"
                    + "	categoria as Categoria, \n"
                    + "	data as Data, \n"
                    + "	status_denuncia as Status \n"
                    + "from denuncia where status_denuncia = 'CRIADA' or status_denuncia = 'EM_PROCESSAMENTO'";
            ResultSet resultSet = statement.executeQuery(query);

            DefaultTableModel tableModel = new DefaultTableModel();
            jTable1_Denuncias.setModel(tableModel);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(row);
            }
            resultSet.close();
            statement.close();

            jTable1_Denuncias.getColumnModel().getColumn(3).setWidth(140);
            jTable1_Denuncias.getColumnModel().getColumn(3).setMinWidth(140);
            jTable1_Denuncias.getColumnModel().getColumn(3).setMaxWidth(140);
            jTable1_Denuncias.getColumnModel().getColumn(0).setWidth(140);
            jTable1_Denuncias.getColumnModel().getColumn(0).setMinWidth(140);
            jTable1_Denuncias.getColumnModel().getColumn(0).setMaxWidth(140);
            jTable1_Denuncias.getColumnModel().getColumn(7).setWidth(130);
            jTable1_Denuncias.getColumnModel().getColumn(7).setMinWidth(130);
            jTable1_Denuncias.getColumnModel().getColumn(7).setMaxWidth(130);

        } catch (Exception e) {

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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1_PERFIL = new javax.swing.JMenuItem();
        jMenuItem2_SAIR = new javax.swing.JMenuItem();
        jFrame1_perfilGestor = new javax.swing.JFrame();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jFormattedTextField1_Telefone = new javax.swing.JFormattedTextField();
        jTextField1_nomeCompleto = new javax.swing.JTextField();
        jTextField1_Email = new javax.swing.JTextField();
        jFormattedTextField1_CPF = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jFrame1_avaliarDenuncia = new javax.swing.JFrame();
        jButton3 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_Denuncias = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jTextField1_protocoloEscondido = new javax.swing.JTextField();
        jFrame1_avaliacaoFinalDenuncia = new javax.swing.JFrame();
        jButton4 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField1_DATA = new javax.swing.JTextField();
        jTextField1_tipoDaDenunciaSelecionada = new javax.swing.JTextField();
        jTextField1_pontoReferencia = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField1_PROTOCOLO = new javax.swing.JTextField();
        jTextField1_rua = new javax.swing.JTextField();
        jTextField1_bairro = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jFormattedTextField1_CEP = new javax.swing.JFormattedTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1_descricaoDenuncia = new javax.swing.JTextArea();
        jComboBox1_tipoDenuncia = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1_avaliacaoAnalista = new javax.swing.JTextArea();
        jRadioButton1_naoAlterarDenuncia = new javax.swing.JRadioButton();
        jRadioButton2_simAlterarDenuncia = new javax.swing.JRadioButton();
        jButton6_verImagensAnexo = new javax.swing.JButton();
        jButton1_concluir = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jFrame1_listaDeDenuncias = new javax.swing.JFrame();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1_ListaDeDenuncias = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jMenuItem1_PERFIL.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jMenuItem1_PERFIL.setForeground(new java.awt.Color(0, 102, 0));
        jMenuItem1_PERFIL.setText("PERFIL");
        jMenuItem1_PERFIL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem1_PERFIL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1_PERFILActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1_PERFIL);

        jMenuItem2_SAIR.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jMenuItem2_SAIR.setForeground(new java.awt.Color(0, 102, 0));
        jMenuItem2_SAIR.setText("SAIR");
        jMenuItem2_SAIR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem2_SAIR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2_SAIRMouseClicked(evt);
            }
        });
        jMenuItem2_SAIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2_SAIRActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2_SAIR);

        jFrame1_perfilGestor.setUndecorated(true);
        jFrame1_perfilGestor.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DADOS PESSOAIS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 32), new java.awt.Color(0, 102, 0))); // NOI18N
        jFrame1_perfilGestor.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 830, 170));

        jLabel17.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 0));
        jLabel17.setText("EMAIL");
        jFrame1_perfilGestor.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 100, 40));

        jLabel13.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 0));
        jLabel13.setText("NOME COMPLETO");
        jFrame1_perfilGestor.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 250, 40));

        jLabel14.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 0));
        jLabel14.setText("TELEFONE");
        jFrame1_perfilGestor.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 150, 40));

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
        jFrame1_perfilGestor.getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 770, 190, 50));

        jLabel19.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 0));
        jLabel19.setText("ALTERAR SENHA");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jFrame1_perfilGestor.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, -1, -1));

        jFormattedTextField1_Telefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jFormattedTextField1_Telefone.setForeground(new java.awt.Color(0, 102, 0));
        try {
            jFormattedTextField1_Telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_Telefone.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jFrame1_perfilGestor.getContentPane().add(jFormattedTextField1_Telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 270, 230, 40));

        jTextField1_nomeCompleto.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_nomeCompleto.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_nomeCompleto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        jTextField1_nomeCompleto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_nomeCompletoKeyPressed(evt);
            }
        });
        jFrame1_perfilGestor.getContentPane().add(jTextField1_nomeCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, 440, 40));

        jTextField1_Email.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_Email.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_Email.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        jFrame1_perfilGestor.getContentPane().add(jTextField1_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 590, 40));

        jFormattedTextField1_CPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jFormattedTextField1_CPF.setForeground(new java.awt.Color(0, 102, 0));
        try {
            jFormattedTextField1_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_CPF.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jFrame1_perfilGestor.getContentPane().add(jFormattedTextField1_CPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 230, 40));

        jLabel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DADOS LOGIN", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 32), new java.awt.Color(0, 102, 0))); // NOI18N
        jFrame1_perfilGestor.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 830, 170));

        jLabel12.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 0));
        jLabel12.setText("CPF");
        jFrame1_perfilGestor.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 60, 40));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoEcoWarriorsTelas.png"))); // NOI18N
        jFrame1_perfilGestor.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 20, 200, 200));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        jFrame1_perfilGestor.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        jFrame1_avaliarDenuncia.setUndecorated(true);
        jFrame1_avaliarDenuncia.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jFrame1_avaliarDenuncia.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 770, 190, 50));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoEcoWarriorsTelas.png"))); // NOI18N
        jFrame1_avaliarDenuncia.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 20, 200, 200));

        jLabel22.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 0));
        jLabel22.setText("AVALIAR DENUNCIAS");
        jFrame1_avaliarDenuncia.getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 400, 50));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DENÚNCIAS DISPONÍVEIS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 26), new java.awt.Color(0, 102, 0))); // NOI18N
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N

        jTable1_Denuncias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTable1_Denuncias.setFont(new java.awt.Font("Serif", 3, 22)); // NOI18N
        jTable1_Denuncias.setForeground(new java.awt.Color(0, 102, 0));
        jTable1_Denuncias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1_Denuncias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1_Denuncias.setGridColor(new java.awt.Color(153, 255, 0));
        jTable1_Denuncias.setRowHeight(45);
        jTable1_Denuncias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_DenunciasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_Denuncias);

        jFrame1_avaliarDenuncia.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 1040, 370));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        jFrame1_avaliarDenuncia.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));
        jFrame1_avaliarDenuncia.getContentPane().add(jTextField1_protocoloEscondido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 140, 100));

        jFrame1_avaliacaoFinalDenuncia.setUndecorated(true);
        jFrame1_avaliacaoFinalDenuncia.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 102, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/voltar.png"))); // NOI18N
        jButton4.setText("  VOLTAR");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 770, 190, 50));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoEcoWarriorsTelas.png"))); // NOI18N
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 20, 200, 200));

        jLabel25.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 0));
        jLabel25.setText("AVALIAR DENUNCIAS");
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 400, 50));

        jTextField1_DATA.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_DATA.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_DATA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jTextField1_DATA, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 310, 220, 40));

        jTextField1_tipoDaDenunciaSelecionada.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_tipoDaDenunciaSelecionada.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_tipoDaDenunciaSelecionada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jTextField1_tipoDaDenunciaSelecionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 400, 580, 40));

        jTextField1_pontoReferencia.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_pontoReferencia.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_pontoReferencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jTextField1_pontoReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 580, 40));

        jLabel26.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 0));
        jLabel26.setText("PONTO DE REFERÊNCIA");
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 340, 30));

        jLabel27.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 0));
        jLabel27.setText("RUA");
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 60, 40));

        jTextField1_PROTOCOLO.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_PROTOCOLO.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_PROTOCOLO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jTextField1_PROTOCOLO, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 180, 40));

        jTextField1_rua.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_rua.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_rua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jTextField1_rua, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 340, 40));

        jTextField1_bairro.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_bairro.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_bairro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jTextField1_bairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 340, 40));

        jLabel28.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 0));
        jLabel28.setText("BAIRRO");
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 120, 40));

        jLabel34.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 102, 0));
        jLabel34.setText("PROTOCOLO");
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 180, 40));

        jLabel29.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 0));
        jLabel29.setText("CEP");
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 70, 40));

        jFormattedTextField1_CEP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jFormattedTextField1_CEP.setForeground(new java.awt.Color(0, 102, 0));
        try {
            jFormattedTextField1_CEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_CEP.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jFormattedTextField1_CEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 190, 40));

        jLabel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "ENDEREÇO DO INCIDENTE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 24), new java.awt.Color(0, 102, 0))); // NOI18N
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 620, 290));

        jLabel47.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 102, 0));
        jLabel47.setText("ALTERAR TIPO DA DENÚNCIA?");
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 500, 430, -1));

        jLabel44.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 102, 0));
        jLabel44.setText("TIPO DA DENÚNCIA");
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, 270, -1));

        jTextArea1_descricaoDenuncia.setEditable(false);
        jTextArea1_descricaoDenuncia.setColumns(20);
        jTextArea1_descricaoDenuncia.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextArea1_descricaoDenuncia.setForeground(new java.awt.Color(0, 102, 0));
        jTextArea1_descricaoDenuncia.setRows(5);
        jTextArea1_descricaoDenuncia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jScrollPane3.setViewportView(jTextArea1_descricaoDenuncia);

        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 580, 130));

        jComboBox1_tipoDenuncia.setFont(new java.awt.Font("Serif", 3, 22)); // NOI18N
        jComboBox1_tipoDenuncia.setForeground(new java.awt.Color(0, 102, 0));
        jComboBox1_tipoDenuncia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBox1_tipoDenuncia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jComboBox1_tipoDenuncia, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 630, 280, 50));

        jTextArea1_avaliacaoAnalista.setColumns(20);
        jTextArea1_avaliacaoAnalista.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jTextArea1_avaliacaoAnalista.setForeground(new java.awt.Color(0, 102, 0));
        jTextArea1_avaliacaoAnalista.setRows(5);
        jTextArea1_avaliacaoAnalista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jScrollPane2.setViewportView(jTextArea1_avaliacaoAnalista);

        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, 510, 150));

        jRadioButton1_naoAlterarDenuncia.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jRadioButton1_naoAlterarDenuncia.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton1_naoAlterarDenuncia.setText("NÃO");
        jRadioButton1_naoAlterarDenuncia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_naoAlterarDenunciaActionPerformed(evt);
            }
        });
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jRadioButton1_naoAlterarDenuncia, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 540, -1, -1));

        jRadioButton2_simAlterarDenuncia.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jRadioButton2_simAlterarDenuncia.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton2_simAlterarDenuncia.setText("SIM");
        jRadioButton2_simAlterarDenuncia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2_simAlterarDenunciaActionPerformed(evt);
            }
        });
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jRadioButton2_simAlterarDenuncia, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 540, -1, -1));

        jButton6_verImagensAnexo.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jButton6_verImagensAnexo.setForeground(new java.awt.Color(0, 102, 0));
        jButton6_verImagensAnexo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/verificado.png"))); // NOI18N
        jButton6_verImagensAnexo.setText("ANEXOS");
        jButton6_verImagensAnexo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jButton6_verImagensAnexo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6_verImagensAnexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6_verImagensAnexoActionPerformed(evt);
            }
        });
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jButton6_verImagensAnexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 690, 210, 50));

        jButton1_concluir.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jButton1_concluir.setForeground(new java.awt.Color(0, 102, 0));
        jButton1_concluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/verificado.png"))); // NOI18N
        jButton1_concluir.setText("   CONCLUIR");
        jButton1_concluir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jButton1_concluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_concluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_concluirActionPerformed(evt);
            }
        });
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jButton1_concluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 600, 210, 50));

        jLabel46.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 102, 0));
        jLabel46.setText("TIPO DA DENUNCIA SELECIONADA");
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, 480, -1));

        jLabel45.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 102, 0));
        jLabel45.setText("DATA DO OCORRIDO");
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, 290, -1));

        jLabel39.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 102, 0));
        jLabel39.setText("DESCRIÇÃO");
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 130, 170, 30));

        jLabel50.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DADOS DO INCIDENTE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 24), new java.awt.Color(0, 102, 0))); // NOI18N
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 630, 370));

        jLabel51.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "CONSIDERAÇÕES FINAIS DO ANALISTA", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 24), new java.awt.Color(0, 102, 0))); // NOI18N
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 1270, 280));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        jFrame1_avaliacaoFinalDenuncia.getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        jFrame1_listaDeDenuncias.setUndecorated(true);
        jFrame1_listaDeDenuncias.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 102, 0));
        jLabel32.setText("LISTA DE DENÚNCIAS");
        jFrame1_listaDeDenuncias.getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 400, 50));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoEcoWarriorsTelas.png"))); // NOI18N
        jFrame1_listaDeDenuncias.getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 20, 200, 200));

        jButton5.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 102, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/voltar.png"))); // NOI18N
        jButton5.setText("  VOLTAR");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jFrame1_listaDeDenuncias.getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 770, 190, 50));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "LISTA DE TODAS AS DENÚNCIAS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 26), new java.awt.Color(0, 102, 0))); // NOI18N
        jScrollPane4.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N

        jTable1_ListaDeDenuncias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTable1_ListaDeDenuncias.setFont(new java.awt.Font("Serif", 3, 22)); // NOI18N
        jTable1_ListaDeDenuncias.setForeground(new java.awt.Color(0, 102, 0));
        jTable1_ListaDeDenuncias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1_ListaDeDenuncias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1_ListaDeDenuncias.setGridColor(new java.awt.Color(153, 255, 0));
        jTable1_ListaDeDenuncias.setRowHeight(45);
        jTable1_ListaDeDenuncias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_ListaDeDenunciasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable1_ListaDeDenuncias);

        jFrame1_listaDeDenuncias.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 1040, 370));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        jFrame1_listaDeDenuncias.getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoPrincipall.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 0, 310, 300));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/usuarioLogadoFundoPreto.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 60, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/setinhaBaixo.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 90, -1, 20));

        jLabel4.setFont(new java.awt.Font("Sitka Text", 3, 32)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("LISTA DE DENÚNCIAS");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 720, 370, 40));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/novaDenuncia.png"))); // NOI18N
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 570, 135, 140));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/novaDenuncia.png"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 360, 135, 140));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 3, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("AVALIAR DENUNCIAS");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 510, 370, 40));

        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "OPÇÕES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 3, 24), new java.awt.Color(0, 102, 0))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, 430, 530));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        jLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    // Exibe o JPopupMenu no local onde o mouse foi pressionado
                    jPopupMenu1.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        jLabel9.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    // Exibe o JPopupMenu no local onde o mouse foi pressionado
                    jPopupMenu1.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        try {
            jFrame1_avaliarDenuncia.setBounds(WIDTH, WIDTH, 1600, 900);
            jFrame1_avaliarDenuncia.setLocationRelativeTo(null);
            jFrame1_avaliarDenuncia.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(tGestorLogado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jMenuItem1_PERFILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1_PERFILActionPerformed
        try {

            jFrame1_perfilGestor.setVisible(true);
            jFrame1_perfilGestor.setBounds(WIDTH, WIDTH, 1600, 900);
            jFrame1_perfilGestor.setLocationRelativeTo(null);
            this.setVisible(false);
            buscarDadosUsuarioLogado();
            BuscarDadosUsuarioEmail();

        } catch (SQLException ex) {
            Logger.getLogger(tUsuarioLogado.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1_PERFILActionPerformed

    public void buscarDadosUsuarioLogado() throws SQLException {
        String cpf = jTextField1_Email.getText();
        String sql = "SELECT * from usuarios where cpf = ?";
        try ( PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, cpf);
            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    jTextField1_nomeCompleto.setText(nome);
                    String email = resultSet.getString("email");
                    jTextField1_Email.setText(email);
                    String telefone = resultSet.getString("telefone");
                    jFormattedTextField1_CPF.setText(cpf);
                    jFormattedTextField1_Telefone.setText(telefone);
                } else {

                }
            }
        }
    }

    public void BuscarDadosUsuarioEmail() throws SQLException {
        String email = jTextField1_Email.getText();
        String sql = "SELECT * from usuarios where EMAIL = ?";
        try ( PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    jTextField1_nomeCompleto.setText(nome);
                    String emailL = resultSet.getString("email");
                    jTextField1_Email.setText(emailL);
                    String cpf = resultSet.getString("cpf");
                    jFormattedTextField1_CPF.setText(cpf);
                    String telefone = resultSet.getString("telefone");
                    jFormattedTextField1_Telefone.setText(telefone);
                } else {

                }
            }
        }
    }

    private void jMenuItem2_SAIRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2_SAIRMouseClicked

    }//GEN-LAST:event_jMenuItem2_SAIRMouseClicked

    private void jMenuItem2_SAIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2_SAIRActionPerformed
        tLoginGestor loginGestores = new tLoginGestor();
        loginGestores.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2_SAIRActionPerformed

    private void jTextField1_nomeCompletoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_nomeCompletoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_nomeCompletoKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jFrame1_perfilGestor.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jFrame1_avaliarDenuncia.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        imprimirListaDeDenuncias();
        jFrame1_listaDeDenuncias.setBounds(WIDTH, WIDTH, 1600, 900);
        jFrame1_listaDeDenuncias.setLocationRelativeTo(null);
        jFrame1_listaDeDenuncias.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        imprimirListaDeDenuncias();
        jFrame1_listaDeDenuncias.setBounds(WIDTH, WIDTH, 1600, 900);
        jFrame1_listaDeDenuncias.setLocationRelativeTo(null);
        jFrame1_listaDeDenuncias.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jTable1_DenunciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_DenunciasMouseClicked
        try {
            protocoloGeral = "";
            jTextField1_protocoloEscondido.setText(jTable1_Denuncias.getValueAt(jTable1_Denuncias.getSelectedRow(), 0).toString());
            String protocolo = jTable1_Denuncias.getValueAt(jTable1_Denuncias.getSelectedRow(), 0).toString();
            protocoloGeral = protocolo;

            IDenunciaDao objetoDao = new DenunciaDao();

            if (jTable1_Denuncias.getValueAt(jTable1_Denuncias.getSelectedRow(), 5).toString().equals("EM_PROCESSAMENTO")) {
                imprimirDadosNaGrid();
                jFrame1_avaliacaoFinalDenuncia.setBounds(WIDTH, WIDTH, 1600, 900);
                jFrame1_avaliacaoFinalDenuncia.setLocationRelativeTo(null);
                jFrame1_avaliacaoFinalDenuncia.setVisible(true);
                jFrame1_avaliarDenuncia.dispose();

            } else {
                objetoDao.atualizarDenuncia(StatusDenuncia.EM_PROCESSAMENTO.toString(), protocolo);
                jFrame1_avaliacaoFinalDenuncia.setBounds(WIDTH, WIDTH, 1600, 900);
                jFrame1_avaliacaoFinalDenuncia.setLocationRelativeTo(null);
                jFrame1_avaliacaoFinalDenuncia.setVisible(true);
                jFrame1_avaliarDenuncia.dispose();
            }

            String queryEndereco = "select * from endereco where protocolo_denuncia = ?";
            String queryDenuncia = "select * from denuncia where protocolo = ?";

            PreparedStatement statment = conexao.prepareStatement(queryEndereco);
            PreparedStatement statment2 = conexao.prepareStatement(queryDenuncia);

            statment.setString(1, protocoloGeral);

            ResultSet resultSet = statment.executeQuery();

            while (resultSet.next()) {
                jFormattedTextField1_CEP.setText(resultSet.getString("cep"));
                jTextField1_bairro.setText(resultSet.getString("bairro"));
                jTextField1_rua.setText(resultSet.getString("rua"));
                jTextField1_pontoReferencia.setText(resultSet.getString("ponto_referencia"));
            }

            statment2.setString(1, protocoloGeral);
            ResultSet rs = statment2.executeQuery();
            while (rs.next()) {
                jTextArea1_descricaoDenuncia.setText(rs.getString("descricao_incidente"));
                jTextField1_DATA.setText(rs.getString("data"));
                jTextField1_tipoDaDenunciaSelecionada.setText(rs.getString("categoria"));
                jTextField1_PROTOCOLO.setText(rs.getString("protocolo"));
            }

        } catch (Exception ex) {
            Logger.getLogger(tGestorLogado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1_DenunciasMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        imprimirDadosNaGrid();
        jFrame1_avaliarDenuncia.setBounds(WIDTH, WIDTH, 1600, 900);
        jFrame1_avaliarDenuncia.setLocationRelativeTo(null);
        jFrame1_avaliarDenuncia.setVisible(true);
        jFrame1_avaliacaoFinalDenuncia.dispose();
        jTextField1_protocoloEscondido.setText("");

        jFormattedTextField1_CEP.setText("");
        jTextField1_bairro.setText("");
        jTextField1_rua.setText("");
        jTextField1_pontoReferencia.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(true);
        jFrame1_listaDeDenuncias.dispose();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1_ListaDeDenunciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_ListaDeDenunciasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1_ListaDeDenunciasMouseClicked

    private void jRadioButton2_simAlterarDenunciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2_simAlterarDenunciaActionPerformed
        if (jRadioButton2_simAlterarDenuncia.isSelected()) {
            jRadioButton1_naoAlterarDenuncia.setSelected(false);
            jLabel44.setVisible(true);
            jComboBox1_tipoDenuncia.setVisible(true);
        }
    }//GEN-LAST:event_jRadioButton2_simAlterarDenunciaActionPerformed

    private void jRadioButton1_naoAlterarDenunciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_naoAlterarDenunciaActionPerformed
        if (jRadioButton1_naoAlterarDenuncia.isSelected()) {
            jRadioButton2_simAlterarDenuncia.setSelected(false);
            jLabel44.setVisible(false);
            jComboBox1_tipoDenuncia.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButton1_naoAlterarDenunciaActionPerformed

    private void jButton1_concluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_concluirActionPerformed
        try {
            
            
            IDenunciaDao objetoDao = new DenunciaDao();
            objetoDao.atualizarDenuncia(StatusDenuncia.RESPONDIDA.toString(), jTextField1_PROTOCOLO.getText());
        } catch (Exception ex) {
            Logger.getLogger(tGestorLogado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1_concluirActionPerformed

    private void jButton6_verImagensAnexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6_verImagensAnexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6_verImagensAnexoActionPerformed

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
            java.util.logging.Logger.getLogger(tGestorLogado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tGestorLogado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tGestorLogado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tGestorLogado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tGestorLogado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_concluir;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6_verImagensAnexo;
    private javax.swing.JComboBox<String> jComboBox1_tipoDenuncia;
    private javax.swing.JFormattedTextField jFormattedTextField1_CEP;
    private javax.swing.JFormattedTextField jFormattedTextField1_CPF;
    private javax.swing.JFormattedTextField jFormattedTextField1_Telefone;
    private javax.swing.JFrame jFrame1_avaliacaoFinalDenuncia;
    private javax.swing.JFrame jFrame1_avaliarDenuncia;
    private javax.swing.JFrame jFrame1_listaDeDenuncias;
    private javax.swing.JFrame jFrame1_perfilGestor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1_PERFIL;
    private javax.swing.JMenuItem jMenuItem2_SAIR;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1_naoAlterarDenuncia;
    private javax.swing.JRadioButton jRadioButton2_simAlterarDenuncia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1_Denuncias;
    private javax.swing.JTable jTable1_ListaDeDenuncias;
    private javax.swing.JTextArea jTextArea1_avaliacaoAnalista;
    private javax.swing.JTextArea jTextArea1_descricaoDenuncia;
    private javax.swing.JTextField jTextField1_DATA;
    private javax.swing.JTextField jTextField1_Email;
    private javax.swing.JTextField jTextField1_PROTOCOLO;
    private javax.swing.JTextField jTextField1_bairro;
    private javax.swing.JTextField jTextField1_nomeCompleto;
    private javax.swing.JTextField jTextField1_pontoReferencia;
    private javax.swing.JTextField jTextField1_protocoloEscondido;
    private javax.swing.JTextField jTextField1_rua;
    private javax.swing.JTextField jTextField1_tipoDaDenunciaSelecionada;
    // End of variables declaration//GEN-END:variables

    private void carregarComboBoxTipoDenuncia() {
        Categoria[] values = Categoria.values();
        String[] categoriaString = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            categoriaString[i] = values[i].toString();
        }
        jComboBox1_tipoDenuncia.setModel(new DefaultComboBoxModel<>(categoriaString));
    }

}
