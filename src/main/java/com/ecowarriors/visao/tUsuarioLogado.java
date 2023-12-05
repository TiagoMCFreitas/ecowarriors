package com.ecowarriors.visao;

import com.ecowarriors.CEP.ViaCEP;
import com.ecowarriors.CEP.ViaCEPException;
import com.ecowarriors.Enum.Categoria;
import com.ecowarriors.Enum.StatusDenuncia;
import com.ecowarriors.ferramentas.ConexaoBD;
import com.ecowarriors.ferramentas.JTableRenderer;
import com.ecowarriors.modelos.Denuncia;
import com.ecowarriors.modelos.Endereco;
import com.ecowarriors.modelos.Usuarios;
import com.ecowarriors.persistencia.DenunciaDao;
import com.ecowarriors.persistencia.IDenunciaDao;
import com.ecowarriors.services.ApiIBGEService;
import com.google.common.io.Files;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.table.DefaultTableModel;

public class tUsuarioLogado extends javax.swing.JFrame {

    private Connection conexao = null;
    String categoriaDenuncia;

    public tUsuarioLogado() {
        try {
            carregarComboBox();
            categoriaDenuncia = Categoria.ADMINISTRACAO_AMBIENTAL + "";
            ApiIBGEService service = new ApiIBGEService();
            List<String> lista = service.listaDeMunicipios();
            for (int i = 0; i < lista.size(); i++) {
                jComboBoxMunicipios.addItem(lista.get(i));
            }
            conexao = ConexaoBD.getConexao();
            initComponents();
            setLocationRelativeTo(null);
            jTextField1_nomeCompleto.setEnabled(false);
            ImageIcon icon = new ImageIcon("./src/main/java/com/ecowarriors/visao/icons/barraVermelha.png");
            jTextField1_Email.setEnabled(false);
            jFormattedTextField1_Telefone.setEnabled(false);
            jFormattedTextField1_CPF.setEnabled(false);
            jLabel23.setVisible(false);
            jTextField1_possivel_criminoso.setVisible(false);
            IDenunciaDao objetoDao = new DenunciaDao();
            String cpfUsuario = jFormattedTextField1_CPF.getText().replace(".", "").replace("-", "");
            imprimirDadosNaGrid();
            jTextArea1_descricao.setLineWrap(true);
            jTextArea1_descricao.setWrapStyleWord(true);

        } catch (Exception ex) {
            Logger.getLogger(tUsuarioLogado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void imprimirDadosNaGrid() {

        try {

            DefaultTableModel model = (DefaultTableModel) jTable1_Denuncias.getModel();
            JTableRenderer JtableRenderer = new JTableRenderer();
            conexao = ConexaoBD.getConexao();
            Statement statement = conexao.createStatement();
            String cpf = jFormattedTextField1_CPF.getText().replace(".", "").replace("-", "");
            String query = "select denuncia.protocolo, \n"
                    + "denuncia.denunciante, \n"
                    + "denuncia.status_denuncia as Status \n"
                    + "from denuncia where denuncia.denunciante = " + "'" + cpf + "'";
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

        } catch (Exception e) {

        }
    }

    public void ExportarDados(Usuarios usuario) {
        jTextField1_Email.setText(usuario.getEmail());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1_DenunciaRespondida = new javax.swing.JFrame();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jFormattedTextField1_CEPDenunciaRespondida = new javax.swing.JFormattedTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField1_pontoReferenciaDenunciaRespondida = new javax.swing.JTextField();
        jTextField1_ruaDenunciaRespondida = new javax.swing.JTextField();
        jTextField1_RESPOSTADenunciaRespondida = new javax.swing.JTextField();
        jComboBoxTipoDenunciaRespondida = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jComboBoxMunicipiosDenunciaRespondida = new javax.swing.JComboBox<>();
        jTextField1_bairroDenunciaRespondida = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1_descricaoDenunciaRespondida = new javax.swing.JTextArea();
        jFormattedTextField1_dataDenunciaRespondida = new javax.swing.JFormattedTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1_PERFIL = new javax.swing.JMenuItem();
        jMenuItem2_SAIR = new javax.swing.JMenuItem();
        jFrame1_perfilUsuario = new javax.swing.JFrame();
        jFormattedTextField1_CPF = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField1_nomeCompleto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jFormattedTextField1_Telefone = new javax.swing.JFormattedTextField();
        jTextField1_Email = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jFrame1_CadastrarDenuncia = new javax.swing.JFrame();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jFormattedTextField1_CEP = new javax.swing.JFormattedTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField1_possivel_criminoso = new javax.swing.JTextField();
        jTextField1_pontoReferencia = new javax.swing.JTextField();
        jTextField1_rua = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jComboBox_categoriaDenuncia = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jComboBoxMunicipios = new javax.swing.JComboBox<>();
        jTextField1_bairro = new javax.swing.JTextField();
        jButton3_denunciar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1_descricao = new javax.swing.JTextArea();
        jFormattedTextField1_data = new javax.swing.JFormattedTextField();
        jRadioButton1_simm = new javax.swing.JRadioButton();
        jRadioButton2_naoo = new javax.swing.JRadioButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jFrame1_avaliarDenuncia = new javax.swing.JFrame();
        jButtonVerDenuncia = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1_Denuncias = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        jTextField1_protocoloEscondido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jFrame1_DenunciaRespondida.setUndecorated(true);
        jFrame1_DenunciaRespondida.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoEcoWarriorsTelas.png"))); // NOI18N
        jFrame1_DenunciaRespondida.getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 20, 200, 200));

        jLabel38.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 102, 0));
        jLabel38.setText("DESCRIÇÃO");
        jFrame1_DenunciaRespondida.getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 200, 170, 30));

        jLabel39.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 102, 0));
        jLabel39.setText("CONSULTAR DENUNCIA");
        jFrame1_DenunciaRespondida.getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 430, 50));

        jFormattedTextField1_CEPDenunciaRespondida.setEditable(false);
        jFormattedTextField1_CEPDenunciaRespondida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jFormattedTextField1_CEPDenunciaRespondida.setForeground(new java.awt.Color(0, 102, 0));
        try {
            jFormattedTextField1_CEPDenunciaRespondida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_CEPDenunciaRespondida.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jFrame1_DenunciaRespondida.getContentPane().add(jFormattedTextField1_CEPDenunciaRespondida, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 190, 40));

        jLabel40.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 102, 0));
        jLabel40.setText("RUA");
        jFrame1_DenunciaRespondida.getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 60, 40));

        jTextField1_pontoReferenciaDenunciaRespondida.setEditable(false);
        jTextField1_pontoReferenciaDenunciaRespondida.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_pontoReferenciaDenunciaRespondida.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_pontoReferenciaDenunciaRespondida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_DenunciaRespondida.getContentPane().add(jTextField1_pontoReferenciaDenunciaRespondida, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, 580, 40));

        jTextField1_ruaDenunciaRespondida.setEditable(false);
        jTextField1_ruaDenunciaRespondida.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_ruaDenunciaRespondida.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_ruaDenunciaRespondida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_DenunciaRespondida.getContentPane().add(jTextField1_ruaDenunciaRespondida, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 340, 40));

        jTextField1_RESPOSTADenunciaRespondida.setEditable(false);
        jTextField1_RESPOSTADenunciaRespondida.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_RESPOSTADenunciaRespondida.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_RESPOSTADenunciaRespondida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_DenunciaRespondida.getContentPane().add(jTextField1_RESPOSTADenunciaRespondida, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 580, 150));

        jComboBoxTipoDenunciaRespondida.setFont(new java.awt.Font("Segoe UI", 2, 26)); // NOI18N
        jComboBoxTipoDenunciaRespondida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBoxTipoDenunciaRespondida.setDoubleBuffered(true);
        jFrame1_DenunciaRespondida.getContentPane().add(jComboBoxTipoDenunciaRespondida, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 550, 330, 40));

        jLabel53.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 102, 0));
        jLabel53.setText("TIPO");
        jFrame1_DenunciaRespondida.getContentPane().add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, 160, 40));

        jLabel52.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 0));
        jLabel52.setText("RESPOSTA DO ANALISTA");
        jFrame1_DenunciaRespondida.getContentPane().add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 380, 340, 30));

        jButton6.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 102, 0));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/voltar.png"))); // NOI18N
        jButton6.setText("  VOLTAR");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jFrame1_DenunciaRespondida.getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 770, 190, 50));

        jLabel44.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 102, 0));
        jLabel44.setText("DATA DO OCORRIDO");
        jFrame1_DenunciaRespondida.getContentPane().add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 580, 290, -1));

        jLabel45.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 102, 0));
        jLabel45.setText("PONTO DE REFERÊNCIA");
        jFrame1_DenunciaRespondida.getContentPane().add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 340, 30));

        jLabel46.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 102, 0));
        jLabel46.setText("BAIRRO");
        jFrame1_DenunciaRespondida.getContentPane().add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 120, 40));

        jLabel47.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 102, 0));
        jLabel47.setText("CEP");
        jFrame1_DenunciaRespondida.getContentPane().add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 70, 40));

        jButton8.setFont(new java.awt.Font("Serif", 3, 22)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 102, 0));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/lupa.png"))); // NOI18N
        jButton8.setText(" BUSCAR");
        jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jFrame1_DenunciaRespondida.getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 140, 40));

        jLabel48.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 102, 0));
        jLabel48.setText("MUNICIPIO");
        jFrame1_DenunciaRespondida.getContentPane().add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 160, 40));

        jComboBoxMunicipiosDenunciaRespondida.setFont(new java.awt.Font("Segoe UI", 2, 26)); // NOI18N
        jComboBoxMunicipiosDenunciaRespondida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBoxMunicipiosDenunciaRespondida.setDoubleBuffered(true);
        jFrame1_DenunciaRespondida.getContentPane().add(jComboBoxMunicipiosDenunciaRespondida, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 330, 40));

        jTextField1_bairroDenunciaRespondida.setEditable(false);
        jTextField1_bairroDenunciaRespondida.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_bairroDenunciaRespondida.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_bairroDenunciaRespondida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_DenunciaRespondida.getContentPane().add(jTextField1_bairroDenunciaRespondida, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 340, 40));

        jTextArea1_descricaoDenunciaRespondida.setEditable(false);
        jTextArea1_descricaoDenunciaRespondida.setColumns(20);
        jTextArea1_descricaoDenunciaRespondida.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextArea1_descricaoDenunciaRespondida.setForeground(new java.awt.Color(0, 102, 0));
        jTextArea1_descricaoDenunciaRespondida.setRows(5);
        jTextArea1_descricaoDenunciaRespondida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jScrollPane3.setViewportView(jTextArea1_descricaoDenunciaRespondida);

        jFrame1_DenunciaRespondida.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 580, 130));

        jFormattedTextField1_dataDenunciaRespondida.setEditable(false);
        jFormattedTextField1_dataDenunciaRespondida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFormattedTextField1_dataDenunciaRespondida.setForeground(new java.awt.Color(0, 102, 0));
        try {
            jFormattedTextField1_dataDenunciaRespondida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_dataDenunciaRespondida.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jFrame1_DenunciaRespondida.getContentPane().add(jFormattedTextField1_dataDenunciaRespondida, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 580, 130, 40));

        jLabel49.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "ENDEREÇO DO INCIDENTE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 24), new java.awt.Color(0, 102, 0))); // NOI18N
        jFrame1_DenunciaRespondida.getContentPane().add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 620, 500));

        jLabel50.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DADOS DO INCIDENTE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 24), new java.awt.Color(0, 102, 0))); // NOI18N
        jFrame1_DenunciaRespondida.getContentPane().add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 690, 500));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        jFrame1_DenunciaRespondida.getContentPane().add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        jMenuItem1_PERFIL.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jMenuItem1_PERFIL.setForeground(new java.awt.Color(0, 102, 0));
        jMenuItem1_PERFIL.setText("PERFIL");
        jMenuItem1_PERFIL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem1_PERFIL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1_PERFILMouseClicked(evt);
            }
        });
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

        jFrame1_perfilUsuario.setUndecorated(true);
        jFrame1_perfilUsuario.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jFormattedTextField1_CPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jFormattedTextField1_CPF.setForeground(new java.awt.Color(0, 102, 0));
        try {
            jFormattedTextField1_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_CPF.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jFrame1_perfilUsuario.getContentPane().add(jFormattedTextField1_CPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 230, 40));

        jLabel12.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 0));
        jLabel12.setText("CPF");
        jFrame1_perfilUsuario.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 60, 40));

        jLabel13.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 0));
        jLabel13.setText("NOME COMPLETO");
        jFrame1_perfilUsuario.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 250, 40));

        jTextField1_nomeCompleto.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_nomeCompleto.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_nomeCompleto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        jTextField1_nomeCompleto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1_nomeCompletoKeyPressed(evt);
            }
        });
        jFrame1_perfilUsuario.getContentPane().add(jTextField1_nomeCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, 440, 40));

        jLabel14.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 0));
        jLabel14.setText("TELEFONE");
        jFrame1_perfilUsuario.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 150, 40));

        jFormattedTextField1_Telefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 3));
        jFormattedTextField1_Telefone.setForeground(new java.awt.Color(0, 102, 0));
        try {
            jFormattedTextField1_Telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_Telefone.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jFrame1_perfilUsuario.getContentPane().add(jFormattedTextField1_Telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 270, 230, 40));

        jTextField1_Email.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_Email.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_Email.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        jFrame1_perfilUsuario.getContentPane().add(jTextField1_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 590, 40));

        jLabel17.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 0));
        jLabel17.setText("EMAIL");
        jFrame1_perfilUsuario.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 100, 40));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoEcoWarriorsTelas.png"))); // NOI18N
        jFrame1_perfilUsuario.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 20, 200, 200));

        jLabel19.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 0));
        jLabel19.setText("ALTERAR SENHA");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jFrame1_perfilUsuario.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, -1, -1));

        jLabel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DADOS LOGIN", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 32), new java.awt.Color(0, 102, 0))); // NOI18N
        jFrame1_perfilUsuario.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 830, 170));

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
        jFrame1_perfilUsuario.getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 770, 190, 50));

        jLabel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DADOS PESSOAIS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 32), new java.awt.Color(0, 102, 0))); // NOI18N
        jFrame1_perfilUsuario.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 830, 170));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        jFrame1_perfilUsuario.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        jFrame1_CadastrarDenuncia.setUndecorated(true);
        jFrame1_CadastrarDenuncia.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoEcoWarriorsTelas.png"))); // NOI18N
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 20, 200, 200));

        jLabel20.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 0));
        jLabel20.setText("DESCRIÇÃO");
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 150, 170, 30));

        jLabel21.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 0));
        jLabel21.setText("CADASTRAR DENÚNCIA");
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 430, 50));

        jFormattedTextField1_CEP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jFormattedTextField1_CEP.setForeground(new java.awt.Color(0, 102, 0));
        try {
            jFormattedTextField1_CEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_CEP.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jFrame1_CadastrarDenuncia.getContentPane().add(jFormattedTextField1_CEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 190, 40));

        jLabel22.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 0));
        jLabel22.setText("RUA");
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 60, 40));

        jTextField1_possivel_criminoso.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_possivel_criminoso.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_possivel_criminoso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_CadastrarDenuncia.getContentPane().add(jTextField1_possivel_criminoso, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 600, 580, 40));

        jTextField1_pontoReferencia.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_pontoReferencia.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_pontoReferencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_CadastrarDenuncia.getContentPane().add(jTextField1_pontoReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 580, 40));

        jTextField1_rua.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_rua.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_rua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_CadastrarDenuncia.getContentPane().add(jTextField1_rua, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 340, 40));

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
        jFrame1_CadastrarDenuncia.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 770, 190, 50));

        jLabel33.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 102, 0));
        jLabel33.setText("SELECIONAR PROVAS");
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 310, 320, -1));

        jLabel23.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 0));
        jLabel23.setText("POSSÍVEL CRIMINOSO");
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 560, 310, -1));

        jLabel24.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 0));
        jLabel24.setText("RECONHECE O AUTOR DO CRIME?");
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 480, 480, -1));

        jComboBox_categoriaDenuncia.setFont(new java.awt.Font("Segoe UI", 2, 26)); // NOI18N
        jComboBox_categoriaDenuncia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBox_categoriaDenuncia.setDoubleBuffered(true);
        jComboBox_categoriaDenuncia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_categoriaDenunciaActionPerformed(evt);
            }
        });
        jFrame1_CadastrarDenuncia.getContentPane().add(jComboBox_categoriaDenuncia, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 420, 330, 40));

        jLabel54.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 102, 0));
        jLabel54.setText("TIPO");
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 420, 80, 40));

        jLabel25.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 0));
        jLabel25.setText("DATA DO OCORRIDO");
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 370, 290, -1));

        jLabel26.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 0));
        jLabel26.setText("PONTO DE REFERÊNCIA");
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 340, 30));

        jLabel27.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 0));
        jLabel27.setText("BAIRRO");
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 120, 40));

        jButton4.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 102, 0));
        jButton4.setText("SELEC");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jFrame1_CadastrarDenuncia.getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 310, 110, 40));

        jLabel28.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 0));
        jLabel28.setText("CEP");
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 70, 40));

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
        jFrame1_CadastrarDenuncia.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 140, 40));

        jLabel29.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 0));
        jLabel29.setText("MUNICIPIO");
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 160, 40));

        jComboBoxMunicipios.setFont(new java.awt.Font("Segoe UI", 2, 26)); // NOI18N
        jComboBoxMunicipios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBoxMunicipios.setDoubleBuffered(true);
        jComboBoxMunicipios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMunicipiosActionPerformed(evt);
            }
        });
        jFrame1_CadastrarDenuncia.getContentPane().add(jComboBoxMunicipios, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 330, 40));

        jTextField1_bairro.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextField1_bairro.setForeground(new java.awt.Color(0, 102, 0));
        jTextField1_bairro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_CadastrarDenuncia.getContentPane().add(jTextField1_bairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 340, 40));

        jButton3_denunciar.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jButton3_denunciar.setForeground(new java.awt.Color(0, 102, 0));
        jButton3_denunciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/cadastroDenuncias.png"))); // NOI18N
        jButton3_denunciar.setText("  DENUNCIAR");
        jButton3_denunciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton3_denunciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3_denunciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_denunciarActionPerformed(evt);
            }
        });
        jFrame1_CadastrarDenuncia.getContentPane().add(jButton3_denunciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 680, 230, 70));

        jTextArea1_descricao.setColumns(20);
        jTextArea1_descricao.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jTextArea1_descricao.setForeground(new java.awt.Color(0, 102, 0));
        jTextArea1_descricao.setRows(5);
        jTextArea1_descricao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jScrollPane1.setViewportView(jTextArea1_descricao);

        jFrame1_CadastrarDenuncia.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 580, 100));

        jFormattedTextField1_data.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFormattedTextField1_data.setForeground(new java.awt.Color(0, 102, 0));
        try {
            jFormattedTextField1_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_data.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jFrame1_CadastrarDenuncia.getContentPane().add(jFormattedTextField1_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 370, 130, 40));

        jRadioButton1_simm.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jRadioButton1_simm.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton1_simm.setText("SIM");
        jRadioButton1_simm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1_simmActionPerformed(evt);
            }
        });
        jFrame1_CadastrarDenuncia.getContentPane().add(jRadioButton1_simm, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 520, -1, -1));

        jRadioButton2_naoo.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jRadioButton2_naoo.setForeground(new java.awt.Color(0, 102, 0));
        jRadioButton2_naoo.setText("NÃO");
        jRadioButton2_naoo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2_naooActionPerformed(evt);
            }
        });
        jFrame1_CadastrarDenuncia.getContentPane().add(jRadioButton2_naoo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 520, -1, -1));

        jLabel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "ENDEREÇO DO INCIDENTE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 24), new java.awt.Color(0, 102, 0))); // NOI18N
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 620, 550));

        jLabel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DADOS DO INCIDENTE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 24), new java.awt.Color(0, 102, 0))); // NOI18N
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 620, 550));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        jFrame1_CadastrarDenuncia.getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        jFrame1_avaliarDenuncia.setUndecorated(true);
        jFrame1_avaliarDenuncia.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonVerDenuncia.setFont(new java.awt.Font("Serif", 3, 28)); // NOI18N
        jButtonVerDenuncia.setForeground(new java.awt.Color(0, 102, 0));
        jButtonVerDenuncia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/entrarDenunciante.png"))); // NOI18N
        jButtonVerDenuncia.setText("  ACESSAR");
        jButtonVerDenuncia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButtonVerDenuncia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVerDenuncia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerDenunciaActionPerformed(evt);
            }
        });
        jFrame1_avaliarDenuncia.getContentPane().add(jButtonVerDenuncia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 760, 250, 50));

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
        jFrame1_avaliarDenuncia.getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 770, 190, 50));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoEcoWarriorsTelas.png"))); // NOI18N
        jFrame1_avaliarDenuncia.getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 20, 200, 200));

        jLabel35.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 102, 0));
        jLabel35.setText("CONSULTAR DENUNCIA");
        jFrame1_avaliarDenuncia.getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 440, 50));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DENÚNCIAS DISPONÍVEIS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Serif", 3, 26), new java.awt.Color(0, 102, 0))); // NOI18N
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N

        jTable1_Denuncias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTable1_Denuncias.setFont(new java.awt.Font("Serif", 3, 22)); // NOI18N
        jTable1_Denuncias.setForeground(new java.awt.Color(0, 102, 0));
        jTable1_Denuncias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Protocolo", "Denunciante", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1_Denuncias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1_Denuncias.setGridColor(new java.awt.Color(153, 255, 0));
        jTable1_Denuncias.setRowHeight(45);
        jTable1_Denuncias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_DenunciasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1_Denuncias);

        jFrame1_avaliarDenuncia.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 1040, 370));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        jFrame1_avaliarDenuncia.getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));
        jFrame1_avaliarDenuncia.getContentPane().add(jTextField1_protocoloEscondido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 140, 100));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/consultarDenuncia.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 530, 135, 140));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 3, 32)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));
        jLabel5.setText("CONSULTAR DENÚNCIA ");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 680, 400, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/novaDenuncia.png"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 320, 135, 140));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/logoPrincipall.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 0, 310, 300));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 3, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("NOVA DENÚNCIA");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, 290, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/usuarioLogadoFundoPreto.png"))); // NOI18N
        jLabel2.setComponentPopupMenu(jPopupMenu1);
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 60, -1, -1));

        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "OPÇÕES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 3, 24), new java.awt.Color(0, 102, 0))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 430, 440));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/setinhaBaixo.png"))); // NOI18N
        jLabel9.setComponentPopupMenu(jPopupMenu1);
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 90, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ecowarriors/visao/icons/5333978.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        try {
            buscarDadosUsuarioLogado();
            BuscarDadosUsuarioEmail();
            jFrame1_avaliarDenuncia.setBounds(WIDTH, WIDTH, 1600, 900);
            jFrame1_avaliarDenuncia.setLocationRelativeTo(null);
            jFrame1_avaliarDenuncia.setVisible(true);

            String cpfUsuario = jFormattedTextField1_CPF.getText().replace(".", "").replace("-", "");
            jButtonVerDenuncia.setEnabled(false);
            IDenunciaDao objetoDao = new DenunciaDao();
            imprimirDadosNaGrid();
        } catch (Exception ex) {
            Logger.getLogger(tUsuarioLogado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        try {
            buscarDadosUsuarioLogado();
            BuscarDadosUsuarioEmail();
            jFrame1_avaliarDenuncia.setBounds(WIDTH, WIDTH, 1600, 900);
            jFrame1_avaliarDenuncia.setLocationRelativeTo(null);
            jFrame1_avaliarDenuncia.setVisible(true);
            String cpfUsuario = jFormattedTextField1_CPF.getText().replace(".", "").replace("-", "");
            jButtonVerDenuncia.setEnabled(false);
            IDenunciaDao objetoDao = new DenunciaDao();
            imprimirDadosNaGrid();
        } catch (Exception ex) {
            Logger.getLogger(tUsuarioLogado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

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

    private void jMenuItem1_PERFILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1_PERFILActionPerformed
        try {
            buscarDadosUsuarioLogado();
            BuscarDadosUsuarioEmail();
            jFrame1_perfilUsuario.setVisible(true);
            jFrame1_perfilUsuario.setBounds(WIDTH, WIDTH, 1600, 900);
            jFrame1_perfilUsuario.setLocationRelativeTo(null);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(tUsuarioLogado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1_PERFILActionPerformed

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
        tLoginDenunciantes loginDenunciante = new tLoginDenunciantes();
        loginDenunciante.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2_SAIRActionPerformed

    private void jTextField1_nomeCompletoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_nomeCompletoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_nomeCompletoKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jFrame1_perfilUsuario.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        try {
            buscarDadosUsuarioLogado();
            BuscarDadosUsuarioEmail();
            IDenunciaDao objetoDao = new DenunciaDao();
            List<Denuncia> lista = objetoDao.listagemDenunciaOrdernada();
            String protocoloNovo = "";
            System.out.println(protocoloNovo);
            if (lista.isEmpty()) {
                protocoloNovo = "1-" + LocalDate.now().getYear();
            } else {
                String protocolo = lista.get(0).getProtocolo();
                String splitProtocolo = protocolo.split("/")[0];
                int anoAtual = LocalDate.now().getYear();
                int idNovo = Integer.parseInt(splitProtocolo);
                idNovo++;
                protocoloNovo = idNovo + "-" + anoAtual;
            }
            String caminhoDaPasta = "./src/main/java/com/ecowarriors/pasta_protocolo/" + protocoloNovo;
            System.out.println(caminhoDaPasta);
            File novaPasta = new File(caminhoDaPasta);
            if (!novaPasta.exists()) {
                boolean pastaCriada = novaPasta.mkdirs();
            }
            jFrame1_CadastrarDenuncia.setBounds(WIDTH, WIDTH, 1600, 900);
            jFrame1_CadastrarDenuncia.setLocationRelativeTo(null);
            jFrame1_CadastrarDenuncia.setVisible(true);
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(tUsuarioLogado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        try {
            buscarDadosUsuarioLogado();
            BuscarDadosUsuarioEmail();
            IDenunciaDao objetoDao = new DenunciaDao();
            List<Denuncia> lista = objetoDao.listagemDenunciaOrdernada();
            String protocoloNovo = "";
            System.out.println(protocoloNovo);
            if (lista.isEmpty()) {
                protocoloNovo = "1-" + LocalDate.now().getYear();
            } else {
                String protocolo = lista.get(0).getProtocolo();
                String splitProtocolo = protocolo.split("/")[0];
                int anoAtual = LocalDate.now().getYear();
                int idNovo = Integer.parseInt(splitProtocolo);
                idNovo++;
                protocoloNovo = idNovo + "-" + anoAtual;
            }
            String caminhoDaPasta = "./src/main/java/com/ecowarriors/pasta_protocolo/" + protocoloNovo;
            System.out.println(caminhoDaPasta);
            File novaPasta = new File(caminhoDaPasta);
            if (!novaPasta.exists()) {
                boolean pastaCriada = novaPasta.mkdirs();
            }
            jFrame1_CadastrarDenuncia.setBounds(WIDTH, WIDTH, 1600, 900);
            jFrame1_CadastrarDenuncia.setLocationRelativeTo(null);
            jFrame1_CadastrarDenuncia.setVisible(true);
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(tUsuarioLogado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            IDenunciaDao objetoDao = new DenunciaDao();
            List<Denuncia> lista = objetoDao.listagemDenunciaOrdernada();
            String protocoloNovo = "";
            System.out.println(protocoloNovo);
            if (lista.isEmpty()) {
                protocoloNovo = "1-" + LocalDate.now().getYear();
            } else {
                String protocolo = lista.get(0).getProtocolo();
                String splitProtocolo = protocolo.split("/")[0];
                int anoAtual = LocalDate.now().getYear();
                int idNovo = Integer.parseInt(splitProtocolo);
                idNovo++;
                protocoloNovo = idNovo + "-" + anoAtual;
            }
            String caminhoDaPasta = "./src/main/java/com/ecowarriors/pasta_protocolo/" + protocoloNovo;
            System.out.println(caminhoDaPasta);
            File novaPasta = new File(caminhoDaPasta);
            boolean apagar = novaPasta.delete();
            this.setVisible(true);
            jFrame1_CadastrarDenuncia.dispose();
        } catch (Exception ex) {
            Logger.getLogger(tUsuarioLogado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ViaCEP cep = new ViaCEP();
            cep.buscar(jFormattedTextField1_CEP.getText());
            jTextField1_bairro.setText(cep.getBairro());
            jTextField1_rua.setText(cep.getLogradouro());
            jComboBoxMunicipios.setSelectedItem(cep.getLocalidade());

        } catch (ViaCEPException ex) {
            Logger.getLogger(tCadastroDenunciante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3_denunciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_denunciarActionPerformed
        try {
            File fotos = new File("./src\\main\\java\\com\\ecowarriors\\images\\logoEcoWarriorsTelas.png");
            String cpfUsuario = jFormattedTextField1_CPF.getText().replace(".", "").replace("-", "");
            Denuncia denuncia = null;
            Endereco endereco = null;
            IDenunciaDao denunciaDAO = null;
            if (jComboBox_categoriaDenuncia.getSelectedIndex() == 0) {
                categoriaDenuncia = Categoria.FAUNA + "";
            } else if (jComboBox_categoriaDenuncia.getSelectedIndex() == 1) {
                categoriaDenuncia = Categoria.FLORA + "";
            } else if (jComboBox_categoriaDenuncia.getSelectedIndex() == 2) {
                categoriaDenuncia = Categoria.POLUICAO + "";
            } else if (jComboBox_categoriaDenuncia.getSelectedIndex() == 3) {
                categoriaDenuncia = Categoria.ODENAMENTO_URBANO_E_PATRIMONIO_CULTURAL + "";
            } else if (jComboBox_categoriaDenuncia.getSelectedIndex() == 4) {
                categoriaDenuncia = Categoria.ADMINISTRACAO_AMBIENTAL + "";
            }

            if (jRadioButton1_simm.isSelected()) {
                denunciaDAO = new DenunciaDao();
                endereco = new Endereco(jTextField1_rua.getText(), jTextField1_bairro.getText(), jComboBoxMunicipios.getSelectedItem().toString(), jFormattedTextField1_CEP.getText(),
                        jTextField1_pontoReferencia.getText());
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                data = new java.sql.Date(formatter.parse(jFormattedTextField1_data.getText()).getTime());
                denuncia = new Denuncia("", fotos, cpfUsuario, jTextArea1_descricao.getText(), Categoria.valueOf(categoriaDenuncia), data, jTextField1_possivel_criminoso.getText(), StatusDenuncia.CRIADA);

                denunciaDAO.cadastroDenuncia(denuncia, endereco);
                JOptionPane.showMessageDialog(rootPane, "Denuncia cadastrado com sucesso!");
                limparCamposDenuncia();
            } else if (jRadioButton2_naoo.isSelected()) {

                denunciaDAO = new DenunciaDao();
                endereco = new Endereco(jTextField1_rua.getText(), jTextField1_bairro.getText(), jComboBoxMunicipios.getSelectedItem().toString(), jFormattedTextField1_CEP.getText(),
                        jTextField1_pontoReferencia.getText());
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = null;
                data = new java.sql.Date(formatter.parse(jFormattedTextField1_data.getText()).getTime());
                denuncia = new Denuncia("", fotos, cpfUsuario, jTextArea1_descricao.getText(), Categoria.valueOf(categoriaDenuncia), data, "Nao_identificado", StatusDenuncia.CRIADA);

                denunciaDAO.cadastroDenuncia(denuncia, endereco);
                JOptionPane.showMessageDialog(rootPane, "Denuncia cadastrado com sucesso!");
                limparCamposDenuncia();

            }
        } catch (Exception ex) {
            Logger.getLogger(tCadastroDenunciante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3_denunciarActionPerformed

    private void limparCamposDenuncia() {
        jTextArea1_descricao.setText("");
        jFormattedTextField1_CEP.setText("");
        jTextField1_bairro.setText("");
        jComboBoxMunicipios.setSelectedIndex(0);
        jTextField1_possivel_criminoso.setText("");
        jTextField1_pontoReferencia.setText("");
        jFormattedTextField1_data.setText("");
        jTextField1_rua.setText("");
        jRadioButton1_simm.setSelected(false);
        jRadioButton2_naoo.setSelected(false);
        jLabel23.setVisible(false);
        jTextField1_possivel_criminoso.setVisible(false);

    }

    private void jRadioButton1_simmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1_simmActionPerformed
        if (jRadioButton1_simm.isSelected()) {
            jLabel23.setVisible(true);
            jTextField1_possivel_criminoso.setVisible(true);
            jRadioButton2_naoo.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton1_simmActionPerformed

    private void jRadioButton2_naooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2_naooActionPerformed
        if (jRadioButton2_naoo.isSelected()) {
            jLabel23.setVisible(false);
            jTextField1_possivel_criminoso.setVisible(false);
            jRadioButton1_simm.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton2_naooActionPerformed

    private void jMenuItem1_PERFILMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1_PERFILMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1_PERFILMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            IDenunciaDao objetoDao = new DenunciaDao();
            List<Denuncia> lista = objetoDao.listagemDenunciaOrdernada();
            String protocoloNovo = "";
            System.out.println(protocoloNovo);
            if (lista.isEmpty()) {
                protocoloNovo = "1-" + LocalDate.now().getYear();
            } else {
                String protocolo = lista.get(0).getProtocolo();
                String splitProtocolo = protocolo.split("/")[0];
                int anoAtual = LocalDate.now().getYear();
                int idNovo = Integer.parseInt(splitProtocolo);
                idNovo++;
                protocoloNovo = idNovo + "-" + anoAtual;
            }
            String caminhoDaPasta = "./src/main/java/com/ecowarriors/pasta_protocolo/" + protocoloNovo;
            JFileChooser fc = new JFileChooser("");
            File buscar = new File("");
            fc.setCurrentDirectory(buscar);
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.showOpenDialog(this);
            File arquivo = fc.getSelectedFile();
            String nomeDoArquivo = arquivo.getPath();
            Random random = new Random();

            int numero1 = random.nextInt(101);
            int numero2 = random.nextInt(101);
            int numero3 = random.nextInt(101);
            int numero4 = random.nextInt(101);
            int numero5 = random.nextInt(101);
            int numero6 = random.nextInt(101);

            // Concatenar os números em uma String
            String concatenacao = String.valueOf(numero1)
                    + String.valueOf(numero2)
                    + String.valueOf(numero3)
                    + String.valueOf(numero4)
                    + String.valueOf(numero5)
                    + String.valueOf(numero6);
            BufferedImage imagem = ImageIO.read(new File(nomeDoArquivo));

            File arquivoDestino = new File(caminhoDaPasta, concatenacao + ".jpg");
            ImageIO.write(imagem, "jpg", arquivoDestino);

//            String nomeDoArquivo = arquivo.getPath();;
//            ImageIcon iconLogo = new ImageIcon(nomeDoArquivo);
//            File arquivoDestino = new File(caminhoDaPasta, arquivo.getName()); 
//            
//            Files.copy(arquivo.to, arquivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            iconLogo.setImage(iconLogo.getImage().getScaledInstance(
            //                    jLabel7_logo.getWidth(), jLabel7_logo.getHeight(), 1));
            //            jLabel7_logo.setIcon(iconLogo);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jFrame1_avaliarDenuncia.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1_DenunciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_DenunciasMouseClicked
        String status = jTable1_Denuncias.getValueAt(jTable1_Denuncias.getSelectedRow(), 2).toString();
        if (status.equals("RESPONDIDA")) {
        } else if (status.equals("EM_PROCESSAMENTO")) {
            JOptionPane.showMessageDialog(rootPane, "Analista ainda não respondeu sua denúncia!");
        } else if (status.equals("CRIADA")) {
            JOptionPane.showMessageDialog(rootPane, "Analista ainda não respondeu sua denúncia!");
        }
    }//GEN-LAST:event_jTable1_DenunciasMouseClicked

    private void jButtonVerDenunciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerDenunciaActionPerformed
        try {
            jFrame1_DenunciaRespondida.setBounds(WIDTH, WIDTH, 1600, 900);
            jFrame1_DenunciaRespondida.setLocationRelativeTo(null);
            jFrame1_DenunciaRespondida.setVisible(true);
            IDenunciaDao objetoDao = new DenunciaDao();
            System.out.println(jTable1_Denuncias.getValueAt(jTable1_Denuncias.getSelectedRow(), 0).toString());
            String[] listaDeCampos = objetoDao.respostaDenuncia(jTable1_Denuncias.getValueAt(jTable1_Denuncias.getSelectedRow(), 0).toString());
            jFormattedTextField1_CEPDenunciaRespondida.setText(listaDeCampos[0]);
            jTextField1_bairroDenunciaRespondida.setText(listaDeCampos[1]);
            jTextField1_ruaDenunciaRespondida.setText(listaDeCampos[2]);
            jComboBoxMunicipiosDenunciaRespondida.addItem(listaDeCampos[3]);
            jComboBoxMunicipiosDenunciaRespondida.setSelectedIndex(0);
            jTextField1_pontoReferenciaDenunciaRespondida.setText(listaDeCampos[4]);
            jComboBoxTipoDenunciaRespondida.addItem(listaDeCampos[5]);
            jComboBoxTipoDenunciaRespondida.setSelectedIndex(0);
            jTextArea1_descricaoDenunciaRespondida.setText(listaDeCampos[6]);
            jTextField1_RESPOSTADenunciaRespondida.setText(listaDeCampos[7]);
            jFormattedTextField1_dataDenunciaRespondida.setText(listaDeCampos[8]);

        } catch (Exception ex) {
            Logger.getLogger(tUsuarioLogado.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonVerDenunciaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jComboBoxMunicipiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMunicipiosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMunicipiosActionPerformed

    private void jComboBox_categoriaDenunciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_categoriaDenunciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_categoriaDenunciaActionPerformed

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
            java.util.logging.Logger.getLogger(tUsuarioLogado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tUsuarioLogado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tUsuarioLogado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tUsuarioLogado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tUsuarioLogado().setVisible(true);
            }
        });
    }

    private void carregarComboBox() {
        jComboBox_categoriaDenuncia.setModel(new DefaultComboBoxModel<>(Categoria.values()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton3_denunciar;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonVerDenuncia;
    private javax.swing.JComboBox<String> jComboBoxMunicipios;
    private javax.swing.JComboBox<String> jComboBoxMunicipiosDenunciaRespondida;
    private javax.swing.JComboBox<String> jComboBoxTipoDenunciaRespondida;
    private javax.swing.JComboBox<Categoria> jComboBox_categoriaDenuncia;
    private javax.swing.JFormattedTextField jFormattedTextField1_CEP;
    private javax.swing.JFormattedTextField jFormattedTextField1_CEPDenunciaRespondida;
    private javax.swing.JFormattedTextField jFormattedTextField1_CPF;
    private javax.swing.JFormattedTextField jFormattedTextField1_Telefone;
    private javax.swing.JFormattedTextField jFormattedTextField1_data;
    private javax.swing.JFormattedTextField jFormattedTextField1_dataDenunciaRespondida;
    private javax.swing.JFrame jFrame1_CadastrarDenuncia;
    private javax.swing.JFrame jFrame1_DenunciaRespondida;
    private javax.swing.JFrame jFrame1_avaliarDenuncia;
    private javax.swing.JFrame jFrame1_perfilUsuario;
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
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1_PERFIL;
    private javax.swing.JMenuItem jMenuItem2_SAIR;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1_simm;
    private javax.swing.JRadioButton jRadioButton2_naoo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1_Denuncias;
    private javax.swing.JTextArea jTextArea1_descricao;
    private javax.swing.JTextArea jTextArea1_descricaoDenunciaRespondida;
    private javax.swing.JTextField jTextField1_Email;
    private javax.swing.JTextField jTextField1_RESPOSTADenunciaRespondida;
    private javax.swing.JTextField jTextField1_bairro;
    private javax.swing.JTextField jTextField1_bairroDenunciaRespondida;
    private javax.swing.JTextField jTextField1_nomeCompleto;
    private javax.swing.JTextField jTextField1_pontoReferencia;
    private javax.swing.JTextField jTextField1_pontoReferenciaDenunciaRespondida;
    private javax.swing.JTextField jTextField1_possivel_criminoso;
    private javax.swing.JTextField jTextField1_protocoloEscondido;
    private javax.swing.JTextField jTextField1_rua;
    private javax.swing.JTextField jTextField1_ruaDenunciaRespondida;
    // End of variables declaration//GEN-END:variables
}
