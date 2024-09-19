package aplicacao;

import dao.DAOFactory;
import dao.LutaDAO;
import dao.LutadorDAO;
import java.util.Vector;
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
            DefaultComboBoxModel comboModel = new DefaultComboBoxModel(lutadores);
            cbDesafiado.setModel(comboModel);
            cbDesafiante.setModel(comboModel);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDesafiado.setText("Desafiado");
        getContentPane().add(lblDesafiado, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 68, 76, -1));

        lblDataHora.setText("Data/Hora");
        getContentPane().add(lblDataHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 65, -1));

        lblDesafiante.setText("Desafiante");
        getContentPane().add(lblDesafiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 96, -1, -1));

        lblPartidas.setText("Partidas");
        getContentPane().add(lblPartidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 122, 57, -1));

        spnDataHora.setModel(new javax.swing.SpinnerDateModel());
        spnDataHora.setEditor(new javax.swing.JSpinner.DateEditor(spnDataHora, "dd/MM/yyyy HH:mm:ss"));
        getContentPane().add(spnDataHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 38, -1, -1));

        cbDesafiado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbDesafiado, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 65, 246, -1));

        cbDesafiante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cbDesafiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 93, 246, -1));

        spnPartidas.setModel(new javax.swing.SpinnerNumberModel(2, 1, 4, 1));
        spnPartidas.setEditor(new javax.swing.JSpinner.NumberEditor(spnPartidas, "0"));
        getContentPane().add(spnPartidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 121, -1, -1));

        btnOK.setText("OK");
        getContentPane().add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        btnCancelar.setText("Cancelar");
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<String> cbDesafiado;
    private javax.swing.JComboBox<String> cbDesafiante;
    private javax.swing.JLabel lblDataHora;
    private javax.swing.JLabel lblDesafiado;
    private javax.swing.JLabel lblDesafiante;
    private javax.swing.JLabel lblPartidas;
    private javax.swing.JSpinner spnDataHora;
    private javax.swing.JSpinner spnPartidas;
    // End of variables declaration//GEN-END:variables
}
