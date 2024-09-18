package aplicacao;

import dao.DAOFactory;
import dao.LutadorDAO;
import modelo.Lutador;

public class frmLutador extends javax.swing.JFrame {

    Lutador lutador;
    LutadorDAO lutadorDAO = DAOFactory.criarLutadorDAO();
    
    public frmLutador(Lutador lutador) {
        initComponents();
        if (lutador != null) {
            this.lutador = lutador;
            btnOK.setText("Editar");
            txtNome.setText(this.lutador.getNome());
            txtNacionalidade.setText(this.lutador.getNacionalidade());
            spnIdade.setValue(this.lutador.getIdade());
            spnAltura.setValue(this.lutador.getAltura());
            spnPeso.setValue(this.lutador.getPeso());
        } else {
            btnOK.setText("Inserir");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblNacionalidade = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        lblAltura = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        spnIdade = new javax.swing.JSpinner();
        txtNome = new javax.swing.JTextField();
        txtNacionalidade = new javax.swing.JTextField();
        spnAltura = new javax.swing.JSpinner();
        spnPeso = new javax.swing.JSpinner();
        btnCancelar = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNome.setText("Nome");
        jPanel1.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 22, 37, -1));

        lblNacionalidade.setText("Nacionalidade");
        jPanel1.add(lblNacionalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 52, -1, -1));

        lblIdade.setText("Idade");
        jPanel1.add(lblIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 82, 37, -1));

        lblAltura.setText("Altura");
        jPanel1.add(lblAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 112, 37, -1));

        lblPeso.setText("Peso");
        jPanel1.add(lblPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 142, 37, -1));

        spnIdade.setModel(new javax.swing.SpinnerNumberModel(18, 18, 50, 1));
        spnIdade.setEditor(new javax.swing.JSpinner.NumberEditor(spnIdade, "0"));
        jPanel1.add(spnIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 262, -1));
        jPanel1.add(txtNacionalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 160, -1));

        spnAltura.setModel(new javax.swing.SpinnerNumberModel(1.6f, 1.6f, null, 0.1f));
        spnAltura.setEditor(new javax.swing.JSpinner.NumberEditor(spnAltura, "0.00"));
        jPanel1.add(spnAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 64, -1));

        spnPeso.setModel(new javax.swing.SpinnerNumberModel(60.0f, 60.0f, null, 1.0f));
        spnPeso.setEditor(new javax.swing.JSpinner.NumberEditor(spnPeso, "0.0"));
        jPanel1.add(spnPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 64, -1));

        btnCancelar.setText("Cancelar");
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        btnOK.setText("OK");
        jPanel1.add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOK;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAltura;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNacionalidade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JSpinner spnAltura;
    private javax.swing.JSpinner spnIdade;
    private javax.swing.JSpinner spnPeso;
    private javax.swing.JTextField txtNacionalidade;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
