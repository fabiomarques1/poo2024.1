/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplicacao;

import dao.DAOFactory;
import dao.LutaDAO;
import dao.LutadorDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Luta;
import modelo.Lutador;

/**
 *
 * @author fmacz
 */
public class frmPrincipal extends javax.swing.JFrame {
    
    LutaDAO lutaDAO = DAOFactory.criarLutaDAO();
    LutadorDAO lutadorDAO = DAOFactory.criarLutadorDAO();
    DefaultTableModel modeloLuta, modeloLutador = null;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
        modeloLutador = (DefaultTableModel) tblLutador.getModel();
        modeloLuta = (DefaultTableModel) tblLuta.getModel();
    }
    
    private void preencherTabelaLutador() {
        modeloLutador.getDataVector().clear();
        try {
            for (Lutador lutador : lutadorDAO.listar()) {
                modeloLutador.addRow(new Object[]{
                                            lutador.getCodigo(), 
                                            lutador.getNome(), 
                                            lutador.getNacionalidade(),
                                            lutador.getIdade(),
                                            lutador.getAltura(),
                                            lutador.getPeso(),
                                            lutador.getVitorias(),
                                            lutador.getDerrotas(),
                                            lutador.getEmpates()
                                    });
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void preencherTabelaLuta() {
        modeloLuta.getDataVector().clear();
        try {
            for (Luta luta : lutaDAO.listar()) {
                modeloLuta.addRow(new Object[]{
                                            luta.getCodigo(), 
                                            df.format(luta.getDataHora()),
                                            luta.getDesafiado().getNome(),
                                            luta.getDesafiante().getNome(),
                                            luta.getPartidas(),
                                            luta.isAprovada()
                                    });
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void apagarLutador() {
        try {
            Integer codigo = (Integer) modeloLutador.getValueAt(tblLutador.getSelectedRow(), 0);

            int linha = lutadorDAO.apagar(codigo);
            if (linha > 0) {
                modeloLutador.removeRow(tblLutador.getSelectedRow());
                JOptionPane.showMessageDialog(this, "O Lutador foi excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir Lutador.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Por favor, selecionar um ludator da tabela");
        }
    }
    
       private void apagarLuta() {
        try {
            Integer codigo = (Integer) modeloLuta.getValueAt(tblLuta.getSelectedRow(), 0);

            int linha = lutaDAO.apagar(codigo);
            if (linha > 0) {
                modeloLuta.removeRow(tblLuta.getSelectedRow());
                JOptionPane.showMessageDialog(this, "A Luta foi excluída com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir Luta.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Por favor, selecionar uma luda da tabela");
        }
    }
       
    private void editarLutador() {
        try {
            Integer codigo = (Integer) modeloLutador.getValueAt(tblLutador.getSelectedRow(), 0);
            String nome = (String) modeloLutador.getValueAt(tblLutador.getSelectedRow(), 1);
            String nacionalidade = (String) modeloLutador.getValueAt(tblLutador.getSelectedRow(), 2);
            int idade = (Integer) modeloLutador.getValueAt(tblLutador.getSelectedRow(), 3);
            float altura = (Float) modeloLutador.getValueAt(tblLutador.getSelectedRow(), 4);
            float peso = (Float) modeloLutador.getValueAt(tblLutador.getSelectedRow(), 5);

            Lutador lutador = new Lutador();
            lutador.setCodigo(codigo);
            lutador.setNome(nome);
            lutador.setNacionalidade(nacionalidade);
            lutador.setIdade(idade);
            lutador.setAltura(altura);
            lutador.setPeso(peso);

            new frmLutador(lutador).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Por favor, selecionar um lutador da tabela");
        }
    }

    private void editarLuta() {
        try {
            Integer codigo = (Integer) modeloLuta.getValueAt(tblLuta.getSelectedRow(), 0);
            String dataHoraTexto = (String) modeloLuta.getValueAt(tblLuta.getSelectedRow(), 1);
            Date dataHora = df.parse(dataHoraTexto);
            //Lutador desafiado = (Lutador) modeloLuta.getValueAt(tblLuta.getSelectedRow(), 2);
            //Lutador desafiante = (Lutador) modeloLuta.getValueAt(tblLuta.getSelectedRow(), 3);
            int partidas = (int) modeloLuta.getValueAt(tblLuta.getSelectedRow(), 4);


            Luta luta = new Luta();
            luta.setCodigo(codigo);
            luta.setDataHora(dataHora);
            //luta.setDesafiado(desafiado);
            //luta.setDesafiante(desafiante);
            luta.setPartidas(partidas);

            new frmLuta(luta).setVisible(true);

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Por favor, selecionar um luta da tabela");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao converter Data e Hora");
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelLutadores = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLutador = new javax.swing.JTable();
        btnInserirLutador = new javax.swing.JButton();
        btnEditarLutador = new javax.swing.JButton();
        btnApagarLutador = new javax.swing.JButton();
        painelLutas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLuta = new javax.swing.JTable();
        btnInserirLuta = new javax.swing.JButton();
        btnEditarLuta = new javax.swing.JButton();
        btnApagarLuta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        tblLutador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Nacionalidade", "Idade", "Altura", "Peso", "Vitórias", "Derrotas", "Empates"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLutador.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblLutador.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblLutador.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tblLutador);
        if (tblLutador.getColumnModel().getColumnCount() > 0) {
            tblLutador.getColumnModel().getColumn(0).setMaxWidth(50);
            tblLutador.getColumnModel().getColumn(3).setMaxWidth(50);
            tblLutador.getColumnModel().getColumn(4).setMaxWidth(50);
            tblLutador.getColumnModel().getColumn(5).setMaxWidth(50);
            tblLutador.getColumnModel().getColumn(6).setMaxWidth(50);
            tblLutador.getColumnModel().getColumn(7).setMaxWidth(60);
            tblLutador.getColumnModel().getColumn(8).setMaxWidth(60);
        }

        btnInserirLutador.setText("Inserir");
        btnInserirLutador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirLutadorActionPerformed(evt);
            }
        });

        btnEditarLutador.setText("Editar");
        btnEditarLutador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarLutadorActionPerformed(evt);
            }
        });

        btnApagarLutador.setText("Apagar");
        btnApagarLutador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarLutadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLutadoresLayout = new javax.swing.GroupLayout(painelLutadores);
        painelLutadores.setLayout(painelLutadoresLayout);
        painelLutadoresLayout.setHorizontalGroup(
            painelLutadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLutadoresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInserirLutador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarLutador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnApagarLutador)
                .addContainerGap())
        );
        painelLutadoresLayout.setVerticalGroup(
            painelLutadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLutadoresLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLutadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserirLutador)
                    .addComponent(btnEditarLutador)
                    .addComponent(btnApagarLutador))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lutadores", painelLutadores);

        tblLuta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Data/Hora", "Desafiado", "Desafiante", "Partidas", "Aprovada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLuta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblLuta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblLuta);
        if (tblLuta.getColumnModel().getColumnCount() > 0) {
            tblLuta.getColumnModel().getColumn(0).setMaxWidth(50);
            tblLuta.getColumnModel().getColumn(4).setMaxWidth(50);
            tblLuta.getColumnModel().getColumn(5).setMaxWidth(60);
        }

        btnInserirLuta.setText("Inserir");
        btnInserirLuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirLutaActionPerformed(evt);
            }
        });

        btnEditarLuta.setText("Editar");
        btnEditarLuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarLutaActionPerformed(evt);
            }
        });

        btnApagarLuta.setText("Apagar");
        btnApagarLuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarLutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLutasLayout = new javax.swing.GroupLayout(painelLutas);
        painelLutas.setLayout(painelLutasLayout);
        painelLutasLayout.setHorizontalGroup(
            painelLutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLutasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInserirLuta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarLuta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnApagarLuta)
                .addContainerGap())
        );
        painelLutasLayout.setVerticalGroup(
            painelLutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLutasLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserirLuta)
                    .addComponent(btnEditarLuta)
                    .addComponent(btnApagarLuta))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lutas", painelLutas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        preencherTabelaLutador();
        preencherTabelaLuta();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnApagarLutadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarLutadorActionPerformed
        apagarLutador();
    }//GEN-LAST:event_btnApagarLutadorActionPerformed

    private void btnApagarLutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarLutaActionPerformed
        apagarLuta();
    }//GEN-LAST:event_btnApagarLutaActionPerformed

    private void btnInserirLutadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirLutadorActionPerformed
        new frmLutador(null).setVisible(true);
    }//GEN-LAST:event_btnInserirLutadorActionPerformed

    private void btnEditarLutadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarLutadorActionPerformed
        editarLutador();
    }//GEN-LAST:event_btnEditarLutadorActionPerformed

    private void btnInserirLutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirLutaActionPerformed
        new frmLuta(null).setVisible(true);
    }//GEN-LAST:event_btnInserirLutaActionPerformed

    private void btnEditarLutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarLutaActionPerformed
        editarLuta();
    }//GEN-LAST:event_btnEditarLutaActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagarLuta;
    private javax.swing.JButton btnApagarLutador;
    private javax.swing.JButton btnEditarLuta;
    private javax.swing.JButton btnEditarLutador;
    private javax.swing.JButton btnInserirLuta;
    private javax.swing.JButton btnInserirLutador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel painelLutadores;
    private javax.swing.JPanel painelLutas;
    private javax.swing.JTable tblLuta;
    private javax.swing.JTable tblLutador;
    // End of variables declaration//GEN-END:variables
}
