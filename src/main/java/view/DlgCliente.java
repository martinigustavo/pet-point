/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ClienteDao;
import entities.Cliente;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

/**
 *
 * @author evely
 */
public class DlgCliente extends javax.swing.JDialog {

    int id = 0;
    private Cliente cli = new Cliente();
    private final SessionFactory sessionFactory;

    public DlgCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public DlgCliente(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        this.sessionFactory = HibernateUtil.getSessionFactory();
        this.cli = cliente;
        txfNome.setText(cliente.getNome());
        ftfCpf.setText(cliente.getCpf());
        ftfTelefone.setText(cliente.getTelefone());
        ftfData.setDate(convertToDateViaInstant(cliente.getData_nascimento()));
        txfEstado.setText(cliente.getEstado());
        txfCidade.setText(cliente.getCidade());
        txfEmail.setText(cliente.getEmail());
        //endereço
        String[] endereco = cliente.getEndereco().split(Pattern.quote(","));
        txfRua.setText(endereco[0]);
        ftfNumero.setText(endereco[1]);
        txfBairro.setText(endereco[2]);

        if (cliente.getSexo().equals("Feminino")) {
            cbxSexo.setSelectedIndex(1);
        } else {
            cbxSexo.setSelectedIndex(2);
        }

        if (cliente.getStatus().equals("Ativo")) {
            cbxStatus.setSelectedIndex(1);
        } else {
            cbxStatus.setSelectedIndex(2);
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

        pnlcliente = new javax.swing.JPanel();
        lblFechar = new javax.swing.JLabel();
        btncadastrar = new javax.swing.JButton();
        txfBairro = new javax.swing.JTextField();
        cbxStatus = new javax.swing.JComboBox<>();
        txfEmail = new javax.swing.JTextField();
        ftfTelefone = new javax.swing.JFormattedTextField();
        cbxSexo = new javax.swing.JComboBox<>();
        ftfCpf = new javax.swing.JFormattedTextField();
        txfEstado = new javax.swing.JTextField();
        ftfNumero = new javax.swing.JTextField();
        txfNome = new javax.swing.JTextField();
        ftfData = new com.toedter.calendar.JDateChooser();
        txfRua = new javax.swing.JTextField();
        txfCidade = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        pnlcliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFechar.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblFechar.setForeground(new java.awt.Color(0, 204, 204));
        lblFechar.setText("X");
        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharMouseClicked(evt);
            }
        });
        pnlcliente.add(lblFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, -1, -1));

        btncadastrar.setBackground(new java.awt.Color(58, 203, 199));
        btncadastrar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btncadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btncadastrar.setText("Cadastrar");
        btncadastrar.setBorder(null);
        btncadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastrarActionPerformed(evt);
            }
        });
        pnlcliente.add(btncadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 640, 170, 40));

        txfBairro.setBackground(new java.awt.Color(218, 218, 218));
        txfBairro.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfBairro.setToolTipText("");
        txfBairro.setBorder(null);
        pnlcliente.add(txfBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, 270, 30));

        cbxStatus.setBackground(new java.awt.Color(218, 218, 218));
        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Ativo", "Inativo" }));
        pnlcliente.add(cbxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 310, 40));

        txfEmail.setBackground(new java.awt.Color(218, 218, 218));
        txfEmail.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfEmail.setToolTipText("");
        txfEmail.setBorder(null);
        pnlcliente.add(txfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 610, 30));

        ftfTelefone.setBackground(new java.awt.Color(218, 218, 218));
        ftfTelefone.setBorder(null);
        try {
            ftfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pnlcliente.add(ftfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 240, 20));

        cbxSexo.setBackground(new java.awt.Color(218, 218, 218));
        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Feminino", "Masculino" }));
        pnlcliente.add(cbxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 140, 290, 40));

        ftfCpf.setBackground(new java.awt.Color(218, 218, 218));
        ftfCpf.setBorder(null);
        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pnlcliente.add(ftfCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 280, 30));

        txfEstado.setBackground(new java.awt.Color(218, 218, 218));
        txfEstado.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfEstado.setToolTipText("");
        txfEstado.setBorder(null);
        pnlcliente.add(txfEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 270, 30));

        ftfNumero.setBackground(new java.awt.Color(218, 218, 218));
        ftfNumero.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        ftfNumero.setToolTipText("");
        ftfNumero.setBorder(null);
        pnlcliente.add(ftfNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 520, 260, 30));

        txfNome.setBackground(new java.awt.Color(218, 218, 218));
        txfNome.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfNome.setToolTipText("");
        txfNome.setBorder(null);
        pnlcliente.add(txfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 270, 30));

        ftfData.setBackground(new java.awt.Color(218, 218, 218));
        ftfData.setToolTipText("");
        pnlcliente.add(ftfData, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 310, 30));

        txfRua.setBackground(new java.awt.Color(218, 218, 218));
        txfRua.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfRua.setToolTipText("");
        txfRua.setBorder(null);
        pnlcliente.add(txfRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 600, 270, 30));

        txfCidade.setBackground(new java.awt.Color(218, 218, 218));
        txfCidade.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfCidade.setToolTipText("");
        txfCidade.setBorder(null);
        pnlcliente.add(txfCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 600, 270, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cadastrocliente.png"))); // NOI18N
        pnlcliente.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblFecharMouseClicked

    private void btncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarActionPerformed
        ClienteDao cd = new ClienteDao(sessionFactory);
        String nome = txfNome.getText().trim();
        String email = txfEmail.getText().trim();
        String cidade = txfCidade.getText().trim();
        String estado = txfEstado.getText().trim();
        String rua = txfRua.getText().trim();
        String numero = ftfNumero.getText().trim();
        String bairro = txfBairro.getText().trim();
        String endereco = rua.isBlank()
                ? ""
                : rua + ", " + numero + ", " + bairro;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate dataNasc = convertToLocalDate(ftfData.getDate());
        String sexo = cbxSexo.getSelectedItem().toString();
        String status = cbxStatus.getSelectedItem().toString();
        String telefone = ftfTelefone.getText();
        String cpf = ftfCpf.getText();

        if (nome.isBlank() || email.isBlank()
                || cidade.isBlank() || estado.isBlank()
                || sexo.equals("Selecione") || status.equals("Selecione")
                || telefone.equals("(  )      -    ") || cpf.equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return;
        }

        id = cli.getId();
        cli.setNome(nome);
        cli.setEmail(email);
        cli.setCidade(cidade);
        cli.setEstado(estado);
        cli.setEndereco(endereco);
        cli.setData_cadastro(LocalDate.now());
        cli.setData_nascimento(dataNasc);
        cli.setSexo(sexo);
        cli.setStatus(status);
        cli.setTelefone(telefone);
        cli.setCpf(cpf);

        Optional<Cliente> cliente0 = Optional.empty();

        if (id == 0) {
            cliente0 = cd.salvar(cli);
        } else {
            cli.setId(id);
            cliente0 = cd.atualizar(cli);
        }

        if (cliente0.isPresent()) {
            if (id == 0) {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Problema ao cadastrar cliente.");
            this.dispose();
        }
    }//GEN-LAST:event_btncadastrarActionPerformed

    public LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btncadastrar;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JFormattedTextField ftfCpf;
    private com.toedter.calendar.JDateChooser ftfData;
    private javax.swing.JTextField ftfNumero;
    private javax.swing.JFormattedTextField ftfTelefone;
    private javax.swing.JLabel lblFechar;
    private javax.swing.JPanel pnlcliente;
    private javax.swing.JTextField txfBairro;
    private javax.swing.JTextField txfCidade;
    private javax.swing.JTextField txfEmail;
    private javax.swing.JTextField txfEstado;
    private javax.swing.JTextField txfNome;
    private javax.swing.JTextField txfRua;
    // End of variables declaration//GEN-END:variables
}
