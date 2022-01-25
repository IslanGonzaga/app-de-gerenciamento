/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.cajv.telas;

import java.sql.*;
import br.com.cajv.dal.ModuloConexao;
import javax.swing.*;
     
/**
 *
 * @author islan
 */

public class TelaFuncionario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public TelaFuncionario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    private void read(){
        String sql = "select * from funcionarios where idfunc = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtFunId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtFunNom.setText(rs.getString(2));
                cboFunCar.setSelectedItem(rs.getString(3));
                txtFunFon.setText(rs.getString(4));
                txtFunCpf.setText(rs.getString(5));
                txtFunDen.setText(rs.getString(6));
                txtFunDsa.setText(rs.getString(7));
                txtFunCep.setText(rs.getString(8));
                txtFunEnd.setText(rs.getString(9));
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro não encontrado.");
                txtFunNom.setText(null);
                cboFunCar.setSelectedItem(1);
                txtFunFon.setText(null);
                txtFunCpf.setText(null);
                txtFunDen.setText(null);
                txtFunDsa.setText(null);
                txtFunCep.setText(null);
                txtFunEnd.setText(null);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void create(){
        String sql = "insert into funcionarios (idfunc, nomefunc, cargo, fone, cpf, data_entrada, cep, endereco) values (?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtFunId.getText());
            pst.setString(2,txtFunNom.getText());
            pst.setString(3,cboFunCar.getSelectedItem().toString());
            pst.setString(4,txtFunFon.getText());
            pst.setString(5,txtFunCpf.getText());
            pst.setString(6,txtFunDen.getText());
            pst.setString(7,txtFunCep.getText());
            pst.setString(8,txtFunEnd.getText());
            
            if (txtFunId.getText().isEmpty()||txtFunNom.getText().isEmpty()||txtFunCpf.getText().isEmpty()||txtFunDen.getText().isEmpty()||txtFunEnd.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios.");
            }else{
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    txtFunId.setText(null);
                    txtFunNom.setText(null);
                    txtFunFon.setText(null);
                    txtFunCpf.setText(null);
                    txtFunDen.setText(null);
                    txtFunDsa.setText(null);
                    txtFunCep.setText(null);
                    txtFunEnd.setText(null);
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado.");
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void delete(){
        String sql = "delete from funcionarios where idfunc = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtFunId.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastro removido.");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void update(){
        String sql = "update funcionarios set nomefunc=?, cargo=?, fone=?, cpf=?, data_entrada=?, data_saida=?, cep=?, endereco=? where idfunc=?";
        try {
            pst = conexao.prepareStatement(sql);
            
            if (txtFunDsa.getText().isEmpty()) {
                sql = "update funcionarios set nomefunc=?, cargo=?, fone=?, cpf=?, data_entrada=?, cep=?, endereco=? where idfunc=?";
                pst = conexao.prepareStatement(sql);
                pst.setString(1,txtFunNom.getText());
                pst.setString(2,cboFunCar.getSelectedItem().toString());
                pst.setString(3,txtFunFon.getText());
                pst.setString(4,txtFunCpf.getText());
                pst.setString(5,txtFunDen.getText());
                pst.setString(6,txtFunCep.getText());
                pst.setString(7,txtFunEnd.getText());
                pst.setString(8,txtFunId.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cadastro alterado.");
            } else {
                pst.setString(1,txtFunNom.getText());
                pst.setString(2,cboFunCar.getSelectedItem().toString());
                pst.setString(3,txtFunFon.getText());
                pst.setString(4,txtFunCpf.getText());
                pst.setString(5,txtFunDen.getText());
                pst.setString(6,txtFunDsa.getText());
                pst.setString(7,txtFunCep.getText());
                pst.setString(8,txtFunEnd.getText());
                pst.setString(9,txtFunId.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cadastro alterado.");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        txtUsuNome = new javax.swing.JTextField();
        txtUsuFone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtUsuLogin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUsuSenha = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboUsuPerfil = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnUsuDelete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtUsuId = new javax.swing.JTextField();
        btnUsuCreate = new javax.swing.JButton();
        btnUsuUpdate = new javax.swing.JButton();
        btnUsuRead = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnFunCreate = new javax.swing.JButton();
        btnFunRead = new javax.swing.JButton();
        btnFunUpdate = new javax.swing.JButton();
        btnFunDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtFunId = new javax.swing.JTextField();
        txtFunNom = new javax.swing.JTextField();
        txtFunEnd = new javax.swing.JTextField();
        txtFunCep = new javax.swing.JTextField();
        txtFunCpf = new javax.swing.JTextField();
        txtFunFon = new javax.swing.JTextField();
        txtFunDen = new javax.swing.JTextField();
        txtFunDsa = new javax.swing.JTextField();
        cboFunCar = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de funcionarios");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cajv/icones/iconCajV.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(734, 460));
        setMinimumSize(new java.awt.Dimension(734, 460));
        setName("Funcionários"); // NOI18N

        jInternalFrame1.setBorder(null);
        jInternalFrame1.setClosable(true);
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setTitle("Usuários");
        jInternalFrame1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jInternalFrame1.setMaximumSize(new java.awt.Dimension(734, 460));
        jInternalFrame1.setMinimumSize(new java.awt.Dimension(734, 460));
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(734, 460));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("* Nome");

        txtUsuNome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtUsuNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuNomeActionPerformed(evt);
            }
        });

        txtUsuFone.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtUsuFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuFoneActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("* Login");

        txtUsuLogin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("* Senha");

        txtUsuSenha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText(" * Perfil");

        cboUsuPerfil.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cboUsuPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));
        cboUsuPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fone");

        btnUsuDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cajv/icones/delete.png"))); // NOI18N
        btnUsuDelete.setToolTipText("Remover");
        btnUsuDelete.setBorder(null);
        btnUsuDelete.setBorderPainted(false);
        btnUsuDelete.setContentAreaFilled(false);
        btnUsuDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuDeleteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("* ID");

        txtUsuId.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtUsuId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuIdActionPerformed(evt);
            }
        });

        btnUsuCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cajv/icones/create.png"))); // NOI18N
        btnUsuCreate.setToolTipText("Adicionar");
        btnUsuCreate.setBorder(null);
        btnUsuCreate.setBorderPainted(false);
        btnUsuCreate.setContentAreaFilled(false);
        btnUsuCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuCreateActionPerformed(evt);
            }
        });

        btnUsuUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cajv/icones/update.png"))); // NOI18N
        btnUsuUpdate.setToolTipText("Modificar");
        btnUsuUpdate.setBorder(null);
        btnUsuUpdate.setBorderPainted(false);
        btnUsuUpdate.setContentAreaFilled(false);
        btnUsuUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuUpdateActionPerformed(evt);
            }
        });

        btnUsuRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cajv/icones/read.png"))); // NOI18N
        btnUsuRead.setToolTipText("Procurar");
        btnUsuRead.setBorder(null);
        btnUsuRead.setBorderPainted(false);
        btnUsuRead.setContentAreaFilled(false);
        btnUsuRead.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuReadActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("* Campos obrigatórios");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(txtUsuSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(300, 300, 300))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(txtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboUsuPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtUsuFone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4))
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addComponent(btnUsuCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(122, 122, 122)
                                    .addComponent(btnUsuRead, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(115, 115, 115)
                                    .addComponent(btnUsuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(98, 98, 98)
                                    .addComponent(btnUsuDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuFone, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cboUsuPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUsuRead, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuCreate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        btnFunCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cajv/icones/create.png"))); // NOI18N
        btnFunCreate.setToolTipText("Adicionar");
        btnFunCreate.setBorder(null);
        btnFunCreate.setBorderPainted(false);
        btnFunCreate.setContentAreaFilled(false);
        btnFunCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFunCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFunCreateActionPerformed(evt);
            }
        });

        btnFunRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cajv/icones/read.png"))); // NOI18N
        btnFunRead.setToolTipText("Procurar");
        btnFunRead.setBorder(null);
        btnFunRead.setBorderPainted(false);
        btnFunRead.setContentAreaFilled(false);
        btnFunRead.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFunRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFunReadActionPerformed(evt);
            }
        });

        btnFunUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cajv/icones/update.png"))); // NOI18N
        btnFunUpdate.setToolTipText("Modificar");
        btnFunUpdate.setBorder(null);
        btnFunUpdate.setBorderPainted(false);
        btnFunUpdate.setContentAreaFilled(false);
        btnFunUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFunUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFunUpdateActionPerformed(evt);
            }
        });

        btnFunDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cajv/icones/delete.png"))); // NOI18N
        btnFunDelete.setToolTipText("Remover");
        btnFunDelete.setBorder(null);
        btnFunDelete.setBorderPainted(false);
        btnFunDelete.setContentAreaFilled(false);
        btnFunDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFunDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFunDeleteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("* ID");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("* Nome");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("* Cargo");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Fone");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("* Cpf");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("* Data de entrada");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Data de saída");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("* CEP");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("* Endereço");

        cboFunCar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RH", "Gerente de loja", "Coordenador", "Segurança", "Fiscal de caixa", "Operador de caixa", "Repositores", "Serviços gerais", "Estagiário" }));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel17.setText("* Campos obrigatórios");

        jLabel18.setText("( Formatação da data: AAAA/MM/DD )");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFunCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFunId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFunNom, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFunFon, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboFunCar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel16))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtFunEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFunCep, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnFunCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(122, 122, 122)
                                    .addComponent(btnFunRead, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(115, 115, 115)
                                    .addComponent(btnFunUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(98, 98, 98)
                                    .addComponent(btnFunDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel17)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel14)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFunDsa)
                                    .addComponent(txtFunDen, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel18))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 367, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 367, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFunId)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFunNom))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboFunCar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFunFon))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFunCpf)
                            .addComponent(jLabel18)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFunDen))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFunDsa))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFunCep))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFunEnd))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFunRead, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(btnFunDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(btnFunCreate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(btnFunUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addGap(49, 49, 49))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 219, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 218, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuNomeActionPerformed

    private void txtUsuFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuFoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuFoneActionPerformed

    private void btnUsuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuDeleteActionPerformed
    }//GEN-LAST:event_btnUsuDeleteActionPerformed

    private void txtUsuIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuIdActionPerformed
    }//GEN-LAST:event_txtUsuIdActionPerformed

    private void btnUsuCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuCreateActionPerformed
    }//GEN-LAST:event_btnUsuCreateActionPerformed

    private void btnUsuUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuUpdateActionPerformed
    }//GEN-LAST:event_btnUsuUpdateActionPerformed

    private void btnUsuReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuReadActionPerformed
    }//GEN-LAST:event_btnUsuReadActionPerformed

    private void btnFunCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFunCreateActionPerformed
        // TODO add your handling code here:
        create();
    }//GEN-LAST:event_btnFunCreateActionPerformed

    private void btnFunReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFunReadActionPerformed
        // Chamando o método consultar:
        read();
    }//GEN-LAST:event_btnFunReadActionPerformed

    private void btnFunUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFunUpdateActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnFunUpdateActionPerformed

    private void btnFunDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFunDeleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnFunDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFunCreate;
    private javax.swing.JButton btnFunDelete;
    private javax.swing.JButton btnFunRead;
    private javax.swing.JButton btnFunUpdate;
    private javax.swing.JButton btnUsuCreate;
    private javax.swing.JButton btnUsuDelete;
    private javax.swing.JButton btnUsuRead;
    private javax.swing.JButton btnUsuUpdate;
    private javax.swing.JComboBox<String> cboFunCar;
    private javax.swing.JComboBox<String> cboUsuPerfil;
    private javax.swing.JInternalFrame jInternalFrame1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtFunCep;
    private javax.swing.JTextField txtFunCpf;
    private javax.swing.JTextField txtFunDen;
    private javax.swing.JTextField txtFunDsa;
    private javax.swing.JTextField txtFunEnd;
    private javax.swing.JTextField txtFunFon;
    private javax.swing.JTextField txtFunId;
    private javax.swing.JTextField txtFunNom;
    private javax.swing.JTextField txtUsuFone;
    private javax.swing.JTextField txtUsuId;
    private javax.swing.JTextField txtUsuLogin;
    private javax.swing.JTextField txtUsuNome;
    private javax.swing.JTextField txtUsuSenha;
    // End of variables declaration//GEN-END:variables
}
