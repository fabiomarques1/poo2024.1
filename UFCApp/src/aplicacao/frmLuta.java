package aplicacao;

import dao.DAOFactory;
import dao.LutaDAO;
import dao.LutadorDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Luta;
import modelo.Lutador;

public class frmLuta extends javax.swing.JFrame {

    Lutador lutador;
    Luta luta;
    LutadorDAO lutadorDAO = DAOFactory.criarLutadorDAO();
    LutaDAO lutaDAO = DAOFactory.criarLutaDAO();
    
    public frmLuta(Luta luta) {
        initComponents();
        carregarCombo();
        if (luta != null) {
            this.luta = luta;
            btnOK.setText("Editar");
            spnDataHora.setValue(luta.getDataHora());
            System.out.println("desafiado: " + luta.getDesafiado());
            System.out.println("desafiante: " + luta.getDesafiante());
            cbDesafiado.setSelectedItem(luta.getDesafiado());
            cbDesafiante.setSelectedItem(luta.getDesafiante());
            spnPartidas.setValue(luta.getPartidas());
        } else {
            btnOK.setText("Inserir");
        }
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

        lblDesafiado = new javax.swing.JLabel();
        lblDataHora = new javax.swing.JLabel();
        lblDesafiante = new javax.swing.JLabel();
        lblPartidas = new javax.swing.JLabel();
        spnDataHora = new javax.swing.JSpinner();
        cbDesafiado = new javax.swing.JComboBox<>();
        cbDesafiante = new javax.swing.JComboBox<>();
        spnPartidas = new javax.swing.JSpinner();
        btnOK = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCategoriaDesafiado = new javax.swing.JLabel();
        lblCategoriaDesafiante = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblDesafiado.setText("Desafiado");

        lblDataHora.setText("Data/Hora");

        lblDesafiante.setText("Desafiante");

        lblPartidas.setText("Partidas");

        spnDataHora.setModel(new javax.swing.SpinnerDateModel());
        spnDataHora.setEditor(new javax.swing.JSpinner.DateEditor(spnDataHora, "dd/MM/yyyy HH:mm:ss"));

        cbDesafiado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDesafiado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDesafiadoItemStateChanged(evt);
            }
        });

        cbDesafiante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDesafiante.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDesafianteItemStateChanged(evt);
            }
        });

        spnPartidas.setModel(new javax.swing.SpinnerNumberModel(2, 1, 4, 1));
        spnPartidas.setEditor(new javax.swing.JSpinner.NumberEditor(spnPartidas, "0"));

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblCategoriaDesafiado.setText("Categoria: ");

        lblCategoriaDesafiante.setText("Categoria:");

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
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(lblDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(spnDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(lblDesafiante)
                                .addGap(9, 9, 9)
                                .addComponent(cbDesafiante, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCategoriaDesafiante))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(spnPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDesafiado, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(cbDesafiado, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCategoriaDesafiado)))
                        .addGap(0, 76, Short.MAX_VALUE)))
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
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private Date validarDataLuta() {
        Date dataLuta = null;
        boolean erro = true;
        dataLuta = (Date) spnDataHora.getValue();
        Calendar data = Calendar.getInstance();
        data.setTime(dataLuta);
        Calendar hoje = Calendar.getInstance();
        hoje.getTime();
        if (hoje.before(data)) {
            erro = false;
        }

        if (erro) {
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            JOptionPane.showMessageDialog(this, "Data/Hora da Luta " + formatoData.format(dataLuta) + " precisa ser posterior a Data/Hora Atual");
            dataLuta = null;
            spnDataHora.requestFocus();
        }
        return dataLuta;
    }
            
    private void inserir() {
        //verificar data e hora futura
        Date dataLuta = validarDataLuta();
        if (dataLuta == null) {
            return;
        }
        //verificar se são lutadores da mesma categoria
        if (!lblCategoriaDesafiado.getText().equals(lblCategoriaDesafiante.getText())) {
            JOptionPane.showMessageDialog(this, "Os lutadores DEVEM ser da MESMA categoria!");
            cbDesafiado.requestFocus();
            return;
        }
        //verificar se são lutadores diferentes
        if (cbDesafiado.getSelectedItem().equals(cbDesafiante.getSelectedItem())) {
            JOptionPane.showMessageDialog(this, "Os lutadores NÃO podem ser iguais!");
            cbDesafiado.requestFocus();
            return;
        }
        
        Luta lutaInserida = new Luta();
        lutaInserida.setDataHora(dataLuta);
        lutaInserida.setDesafiado((Lutador) cbDesafiado.getSelectedItem());
        lutaInserida.setDesafiante((Lutador) cbDesafiante.getSelectedItem());
        lutaInserida.setPartidas((int) spnPartidas.getValue());
                
        int linha = lutaDAO.inserir(lutaInserida);
        if (linha > 0) {
            JOptionPane.showMessageDialog(this, "Luta inserida com sucesso!");
            cbDesafiado.setSelectedIndex(0);
            cbDesafiado.setSelectedIndex(0);
            spnDataHora.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao inserir Luta.");
        }
    }
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        if (this.luta != null) {
            //editar();
            this.dispose();
        } else {
            inserir();
            spnDataHora.requestFocus();
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void cancelar() {
        Object[] opcao = {"Não", "Sim"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(this, "Deseja realmente sair?", "Aviso",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcao, opcao[0]);
        if (opcaoSelecionada == 1) {
            this.dispose();
        }
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<String> cbDesafiado;
    private javax.swing.JComboBox<String> cbDesafiante;
    private javax.swing.JLabel lblCategoriaDesafiado;
    private javax.swing.JLabel lblCategoriaDesafiante;
    private javax.swing.JLabel lblDataHora;
    private javax.swing.JLabel lblDesafiado;
    private javax.swing.JLabel lblDesafiante;
    private javax.swing.JLabel lblPartidas;
    private javax.swing.JSpinner spnDataHora;
    private javax.swing.JSpinner spnPartidas;
    // End of variables declaration//GEN-END:variables
}
