package aplicacao;

import dao.DAOFactory;
import dao.LutaDAO;
import dao.LutadorDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Luta;
import modelo.Lutador;

public class frmAprovarLuta extends javax.swing.JFrame {

    Lutador lutador;
    Luta luta;
    LutadorDAO lutadorDAO = DAOFactory.criarLutadorDAO();
    LutaDAO lutaDAO = DAOFactory.criarLutaDAO();
    
    public frmAprovarLuta(Luta luta) {
        initComponents();
        carregarCombo();
        if (luta != null) {
            this.luta = luta;
            spnDataHora.setValue(luta.getDataHora());
            System.out.println("desafiado: " + luta.getDesafiado());
            System.out.println("desafiante: " + luta.getDesafiante());
            cbDesafiado.setSelectedItem(luta.getDesafiado());
            cbDesafiante.setSelectedItem(luta.getDesafiante());
            spnPartidas.setValue(luta.getPartidas());
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os dados da Luta");
        }
        rbLutaReprovada.setSelected(true);
    }
    
    private void carregarCombo() {
        try {
            Vector<Lutador> lutadores = new Vector<>(lutadorDAO.listar());
            DefaultComboBoxModel comboModelDesafiado = new DefaultComboBoxModel(lutadores);
            DefaultComboBoxModel comboModelDesafiante = new DefaultComboBoxModel(lutadores);
            cbDesafiado.setModel(comboModelDesafiado);
            cbDesafiante.setModel(comboModelDesafiante);
            Lutador desafiado = (Lutador) cbDesafiado.getSelectedItem();
            lblCategoriaDesafiado.setText("Categoria: " + desafiado.getCategoria());
            Lutador desafiante = (Lutador) cbDesafiante.getSelectedItem();
            lblCategoriaDesafiante.setText("Categoria: " + desafiante.getCategoria());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar a lista de Lutadores");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAprovarLuta = new javax.swing.ButtonGroup();
        lblDesafiado = new javax.swing.JLabel();
        lblDataHora = new javax.swing.JLabel();
        lblDesafiante = new javax.swing.JLabel();
        lblPartidas = new javax.swing.JLabel();
        spnDataHora = new javax.swing.JSpinner();
        cbDesafiado = new javax.swing.JComboBox<>();
        cbDesafiante = new javax.swing.JComboBox<>();
        spnPartidas = new javax.swing.JSpinner();
        btnOK = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        lblCategoriaDesafiado = new javax.swing.JLabel();
        lblCategoriaDesafiante = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbLutaReprovada = new javax.swing.JRadioButton();
        rbLutaAprovada = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblDesafiado.setText("Desafiado");

        lblDataHora.setText("Data/Hora");

        lblDesafiante.setText("Desafiante");

        lblPartidas.setText("Partidas");

        spnDataHora.setModel(new javax.swing.SpinnerDateModel());
        spnDataHora.setEditor(new javax.swing.JSpinner.DateEditor(spnDataHora, "dd/MM/yyyy HH:mm:ss"));
        spnDataHora.setEnabled(false);

        cbDesafiado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDesafiado.setEnabled(false);
        cbDesafiado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDesafiadoItemStateChanged(evt);
            }
        });

        cbDesafiante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDesafiante.setEnabled(false);
        cbDesafiante.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDesafianteItemStateChanged(evt);
            }
        });

        spnPartidas.setModel(new javax.swing.SpinnerNumberModel(2, 1, 4, 1));
        spnPartidas.setEditor(new javax.swing.JSpinner.NumberEditor(spnPartidas, "0"));
        spnPartidas.setEnabled(false);

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        lblCategoriaDesafiado.setText("Categoria: ");

        lblCategoriaDesafiante.setText("Categoria:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Aprovar Luta?"));

        buttonGroupAprovarLuta.add(rbLutaReprovada);
        rbLutaReprovada.setText("Não");

        buttonGroupAprovarLuta.add(rbLutaAprovada);
        rbLutaAprovada.setText("Sim");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbLutaAprovada, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbLutaReprovada, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbLutaReprovada)
                    .addComponent(rbLutaAprovada))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(lblDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(spnDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDesafiado, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(cbDesafiado, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCategoriaDesafiado))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(spnPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDesafiante)
                                        .addGap(9, 9, 9)
                                        .addComponent(cbDesafiante, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCategoriaDesafiante)))
                        .addGap(0, 92, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblDataHora))
                    .addComponent(spnDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbDesafiado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCategoriaDesafiado))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblDesafiado)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblDesafiante))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbDesafiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCategoriaDesafiante)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spnPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblPartidas)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnVoltar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbDesafiadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDesafiadoItemStateChanged
        Lutador desafiado = (Lutador) cbDesafiado.getSelectedItem();
        lblCategoriaDesafiado.setText("Categoria: " + desafiado.getCategoria());
    }//GEN-LAST:event_cbDesafiadoItemStateChanged

    private void cbDesafianteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDesafianteItemStateChanged
        Lutador desafiante = (Lutador) cbDesafiante.getSelectedItem();
        lblCategoriaDesafiante.setText("Categoria: " + desafiante.getCategoria());
    }//GEN-LAST:event_cbDesafianteItemStateChanged


    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        if (rbLutaAprovada.isSelected()) {
            Random random = new Random();
            int resultado = random.nextInt(3);
            lutaDAO.aprovarLuta(luta.getCodigo());
            switch (resultado) {
                case 0 -> {
                    JOptionPane.showMessageDialog(this, "Empate!");
                    lutadorDAO.empatarLuta(luta.getDesafiante().getCodigo());
                    lutadorDAO.empatarLuta(luta.getDesafiado().getCodigo());
                }
                case 1 -> {
                    JOptionPane.showMessageDialog(this, "Desafiante venceu!");
                    lutadorDAO.ganharLuta(luta.getDesafiante().getCodigo());
                    lutadorDAO.perderLuta(luta.getDesafiado().getCodigo());
                }
                case 2 -> {
                    JOptionPane.showMessageDialog(this, "Desafiado venceu!");
                    lutadorDAO.perderLuta(luta.getDesafiante().getCodigo());
                    lutadorDAO.ganharLuta(luta.getDesafiado().getCodigo());
                }
            }
        } 
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnVoltar;
    private javax.swing.ButtonGroup buttonGroupAprovarLuta;
    private javax.swing.JComboBox<String> cbDesafiado;
    private javax.swing.JComboBox<String> cbDesafiante;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCategoriaDesafiado;
    private javax.swing.JLabel lblCategoriaDesafiante;
    private javax.swing.JLabel lblDataHora;
    private javax.swing.JLabel lblDesafiado;
    private javax.swing.JLabel lblDesafiante;
    private javax.swing.JLabel lblPartidas;
    private javax.swing.JRadioButton rbLutaAprovada;
    private javax.swing.JRadioButton rbLutaReprovada;
    private javax.swing.JSpinner spnDataHora;
    private javax.swing.JSpinner spnPartidas;
    // End of variables declaration//GEN-END:variables
}
