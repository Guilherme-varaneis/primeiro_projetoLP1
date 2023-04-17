/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.projeto_1.view;

import java.awt.Dimension;
import br.com.projeto_1.ctr.ReservaCTR;
import br.com.projeto_1.dto.ReservaDTO;
import br.com_projeto_1.dao.ConexaoDAO;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guiva
 */
public class ReservaView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReservaView
     */
    ReservaDTO reservaDTO = new ReservaDTO();
    ReservaCTR reservaCTR = new ReservaCTR();
    int gravar_alterar;

    ResultSet rs;
    DefaultTableModel modelo_consultarRes;

    public ReservaView() {

        initComponents();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
        modelo_consultarRes = (DefaultTableModel) consultarRes.getModel();
    }

    private void liberaCampos(boolean a) {
        nome_res.setEnabled(a);
        fone_res.setEnabled(a);
        email_res.setEnabled(a);
        pessoas_res.setEnabled(a);
        cpf_res.setEnabled(a);
        nacional_res.setEnabled(a);
        nome_res.setEnabled(a);
    }

    private void limpaCampos() {
        nome_res.setText("");
        fone_res.setText("");
        email_res.setText("");
        pessoas_res.setText("");
        cpf_res.setText("");
        nacional_res.setText("");
        nome_res.setText("");
    }

    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e) {
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);
    }

    private void gravar() {
        try {
            reservaDTO.setNome_res(nome_res.getText());
            reservaDTO.setFone_res(fone_res.getText());
            reservaDTO.setCpf_res(cpf_res.getText());
            reservaDTO.setEmail_res(email_res.getText());
            reservaDTO.setHabitacao_res(habitacao_res.getSelectedItem().toString());
            reservaDTO.setNacional_res(nacional_res.getText());
            reservaDTO.setPessoas_res(Integer.parseInt(pessoas_res.getText()));
            
            JOptionPane.showMessageDialog(null, reservaCTR.inserirReserva(reservaDTO));
        } catch (Exception e) {
            System.out.println("Erro ao Gravar!!" + e.getMessage());
        }
    }

    private void alterar() {
        try {
            reservaDTO.setNome_res(nome_res.getText());
            reservaDTO.setFone_res(fone_res.getText());
            reservaDTO.setCpf_res(cpf_res.getText());
            reservaDTO.setEmail_res(email_res.getText());
            reservaDTO.setHabitacao_res(habitacao_res.getSelectedItem().toString());
            reservaDTO.setNacional_res(nacional_res.getText());
            reservaDTO.setPessoas_res(Integer.parseInt(pessoas_res.getText()));
            
            JOptionPane.showMessageDialog(null, reservaCTR.alterarReserva(reservaDTO));

        } catch (Exception e) {
            System.out.println("ERRO AO ALTERAR");
        }
    }

    private void excluir() {
        if (JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir a reserva?", "Aviso",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,
                    reservaCTR.excluirCliente(reservaDTO)
            );
        }
    }

    private void cancelar() {
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar a reserva?", "aviso",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            limpaCampos();
            liberaCampos(false);
            modelo_consultarRes.setNumRows(0);
            liberaBotoes(true, false, false, false, true);
            gravar_alterar = 0;
        }
    }
        private void preencherTabela(String Nome_res){
        try{
             modelo_consultarRes.setNumRows(0);
            
            reservaDTO.setNome_res(Nome_res);
            rs = reservaCTR.consultarCliente(reservaDTO, 1);
            while(rs.next()){
                 modelo_consultarRes.addRow(new Object[]{
                rs.getString("id_res"),
                rs.getString("Nome_res"),
                });
            }
        }
        catch(Exception erTab){
            System.out.println("Erro SQL!!" + erTab);
        }
        finally{
            reservaCTR.CloseDB();
        }
    }
            private void preencheCampos(int id_res){
        try{
            reservaDTO.setId_res(id_res);
            rs = reservaCTR.consultarCliente(reservaDTO, 2);
            if(rs.next()){
                limpaCampos();
                nome_res.setText(rs.getString("nome_res"));
                fone_res.setText(rs.getString("fone_res"));
                pessoas_res.setText(rs.getString("pessoas_res"));
                email_res.setText(rs.getString("email_res"));
                cpf_res.setText(rs.getString("cpf_res"));
                habitacao_res.setSelectedItem(rs.getString("habitacao_res"));
                nacional_res.setText(rs.getString("nacional_res"));
                gravar_alterar = 2;
                liberaCampos(true);
            }   
        }  catch(Exception erTab){
            System.out.println("Erro SQL!!" + erTab);
        }
        finally{
            reservaCTR.CloseDB();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nome_res = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fone_res = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        email_res = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pessoas_res = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        habitacao_res = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        nacional_res = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cpf_res = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        consultarRes = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pesquisa_nome_res = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("ÁREA DE CADASTRO - RESERVA DE HOTEL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 510, -1));

        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));
        getContentPane().add(nome_res, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 253, -1));

        jLabel3.setText("Telefone:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));
        getContentPane().add(fone_res, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 150, -1));

        jLabel4.setText("E-mail:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));
        getContentPane().add(email_res, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 163, -1));

        jLabel5.setText("Nº de pessoas:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));
        getContentPane().add(pessoas_res, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 49, -1));

        jLabel6.setText("Preferencias de Habitação:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        habitacao_res.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------------", "Individual c/ vista pro Mar", "Duplo c/ vista pro mar", "Individual Simples", "Duplo Simples", "cobertura", "compartilhado" }));
        getContentPane().add(habitacao_res, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 160, -1));

        jLabel7.setText("Nacionalidade:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));
        getContentPane().add(nacional_res, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 130, -1));

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_1/imagens/Novo.jpeg"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 110, 40));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_1/imagens/Salvar.jpeg"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 120, 40));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_1/imagens/Excluir.jpeg"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, 40));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_1/imagens/Excluir.jpeg"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 120, 40));

        jLabel10.setText("CPF:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));
        getContentPane().add(cpf_res, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 200, 30));

        consultarRes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "NOME"
            }
        ));
        consultarRes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultarResMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(consultarRes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 400, 130));

        jLabel11.setText("nome:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("CONSULTA");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, -1, -1));
        getContentPane().add(pesquisa_nome_res, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 270, -1));

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_1/imagens/pesquisar.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 160, 60, 30));

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto_1/imagens/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 110, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (gravar_alterar == 1) {
            gravar();
            gravar_alterar = 0;
        } else if (gravar_alterar == 2) {
            alterar();
            gravar_alterar = 0;
        } else {
            JOptionPane.showMessageDialog(null, "Erro no sistema");
        }
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
        limpaCampos();
        liberaBotoes(true, false, false, false, true);
        modelo_consultarRes.setNumRows(0);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true, false, true);
        gravar_alterar = 1;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
       preencherTabela(pesquisa_nome_res.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void consultarResMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultarResMouseClicked
      preencheCampos(Integer.parseInt(String.valueOf(
                 consultarRes.getValueAt(
                 consultarRes.getSelectedRow(), 0))));
        liberaBotoes(false,true,true,true,true);
    }//GEN-LAST:event_consultarResMouseClicked
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTable consultarRes;
    private javax.swing.JTextField cpf_res;
    private javax.swing.JTextField email_res;
    private javax.swing.JTextField fone_res;
    private javax.swing.JComboBox<String> habitacao_res;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nacional_res;
    private javax.swing.JTextField nome_res;
    private javax.swing.JTextField pesquisa_nome_res;
    private javax.swing.JTextField pessoas_res;
    // End of variables declaration//GEN-END:variables
}
