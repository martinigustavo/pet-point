/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.FuncionarioDao;
import entities.Funcionario;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import utils.Criptografar;
import utils.HibernateUtil;

@Log4j2
public class DlgFuncionario extends javax.swing.JDialog {

    private int id = 0;
    private Funcionario funcionario = new Funcionario();
    private final SessionFactory sessionFactory;

    public DlgFuncionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.sessionFactory = HibernateUtil.getSessionFactory();
         btnDeletar.setVisible(false);
    }

    public DlgFuncionario(java.awt.Frame parent, boolean modal, Funcionario funcionario) {
        super(parent, modal);
        initComponents();
        this.sessionFactory = HibernateUtil.getSessionFactory();
        this.funcionario = funcionario;
        txfNome.setText(funcionario.getNome());
        txfUsuario.setText(funcionario.getUsuario());
        ftfCpf.setText(funcionario.getCpf());
        ftfTelefone.setText(funcionario.getTelefone());
        txfAtividade.setText(funcionario.getAtividade());
        ftfData.setDate(convertToDateViaInstant(funcionario.getData_nascimento()));
        txfEstado.setText(funcionario.getEstado());
        txfCidade.setText(funcionario.getCidade());
        txfEmail.setText(funcionario.getEmail());
        String[] endereco = funcionario.getEndereco().split(Pattern.quote(","));
        txfRua.setText(endereco[0]);
        ftfNumero.setText(endereco[1]);
        txfBairro.setText(endereco[2]);
        btnDeletar.setVisible(true);

        if (funcionario.getSexo().equals("Feminino")) {
            cbxSexo.setSelectedIndex(1);
        } else {
            cbxSexo.setSelectedIndex(2);
        }

        if (funcionario.getStatus().equals("Ativo")) {
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

        lblFechar = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JButton();
        btncadastrar = new javax.swing.JButton();
        txfBairro = new javax.swing.JTextField();
        pwfSenha = new javax.swing.JPasswordField();
        cbxStatus = new javax.swing.JComboBox<>();
        txfAtividade = new javax.swing.JTextField();
        txfEmail = new javax.swing.JTextField();
        ftfTelefone = new javax.swing.JFormattedTextField();
        cbxSexo = new javax.swing.JComboBox<>();
        txfUsuario = new javax.swing.JTextField();
        ftfCpf = new javax.swing.JFormattedTextField();
        txfEstado = new javax.swing.JTextField();
        ftfNumero = new javax.swing.JTextField();
        txfNome = new javax.swing.JTextField();
        ftfData = new com.toedter.calendar.JDateChooser();
        txfRua = new javax.swing.JTextField();
        txfCidade = new javax.swing.JTextField();
        background = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFechar.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblFechar.setForeground(new java.awt.Color(0, 204, 204));
        lblFechar.setText("X");
        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharMouseClicked(evt);
            }
        });
        getContentPane().add(lblFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, -1, -1));

        btnDeletar.setBackground(new java.awt.Color(198, 0, 1));
        btnDeletar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnDeletar.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletar.setText("Deletar");
        btnDeletar.setToolTipText("");
        btnDeletar.setBorder(null);
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 640, 170, 40));

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
        getContentPane().add(btncadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 640, 170, 40));

        txfBairro.setBackground(new java.awt.Color(218, 218, 218));
        txfBairro.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfBairro.setToolTipText("");
        txfBairro.setBorder(null);
        getContentPane().add(txfBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 530, 270, 30));

        pwfSenha.setBackground(new java.awt.Color(218, 218, 218));
        pwfSenha.setToolTipText("");
        pwfSenha.setBorder(null);
        getContentPane().add(pwfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 300, 270, 30));

        cbxStatus.setBackground(new java.awt.Color(218, 218, 218));
        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Ativo", "Inativo" }));
        getContentPane().add(cbxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 310, 40));

        txfAtividade.setBackground(new java.awt.Color(218, 218, 218));
        txfAtividade.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfAtividade.setToolTipText("");
        txfAtividade.setBorder(null);
        getContentPane().add(txfAtividade, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 135, 250, 30));

        txfEmail.setBackground(new java.awt.Color(218, 218, 218));
        txfEmail.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfEmail.setToolTipText("");
        txfEmail.setBorder(null);
        getContentPane().add(txfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 610, 30));

        ftfTelefone.setBackground(new java.awt.Color(218, 218, 218));
        ftfTelefone.setBorder(null);
        try {
            ftfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(ftfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 362, 240, 30));

        cbxSexo.setBackground(new java.awt.Color(218, 218, 218));
        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Feminino", "Masculino" }));
        getContentPane().add(cbxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 290, 40));

        txfUsuario.setBackground(new java.awt.Color(218, 218, 218));
        txfUsuario.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfUsuario.setToolTipText("");
        txfUsuario.setBorder(null);
        getContentPane().add(txfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, 270, 30));

        ftfCpf.setBackground(new java.awt.Color(218, 218, 218));
        ftfCpf.setBorder(null);
        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(ftfCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 225, 280, 30));

        txfEstado.setBackground(new java.awt.Color(218, 218, 218));
        txfEstado.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfEstado.setToolTipText("");
        txfEstado.setBorder(null);
        getContentPane().add(txfEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 270, 30));

        ftfNumero.setBackground(new java.awt.Color(218, 218, 218));
        ftfNumero.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        ftfNumero.setToolTipText("");
        ftfNumero.setBorder(null);
        getContentPane().add(ftfNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 530, 260, 30));

        txfNome.setBackground(new java.awt.Color(218, 218, 218));
        txfNome.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfNome.setToolTipText("");
        txfNome.setBorder(null);
        getContentPane().add(txfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 270, 30));

        ftfData.setBackground(new java.awt.Color(218, 218, 218));
        ftfData.setToolTipText("");
        getContentPane().add(ftfData, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 310, 30));

        txfRua.setBackground(new java.awt.Color(218, 218, 218));
        txfRua.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfRua.setToolTipText("");
        txfRua.setBorder(null);
        getContentPane().add(txfRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 610, 270, 30));

        txfCidade.setBackground(new java.awt.Color(218, 218, 218));
        txfCidade.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfCidade.setToolTipText("");
        txfCidade.setBorder(null);
        getContentPane().add(txfCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 620, 270, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telafuncionario.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 690));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblFecharMouseClicked

    private void btncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarActionPerformed
        try {
            FuncionarioDao fd = new FuncionarioDao(sessionFactory);
            String nome = txfNome.getText().trim();
            String email = txfEmail.getText().trim();
            String atividade = txfAtividade.getText().trim();
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
            String usuario = txfUsuario.getText().trim();
            char[] getSenha = pwfSenha.getPassword();
            String senha = String.valueOf(getSenha);

            if (nome.isBlank() || email.isBlank() || atividade.isBlank()
                    || cidade.isBlank() || estado.isBlank()
                    || sexo.equals("Selecione") || status.equals("Selecione")
                    || telefone.equals("(  )      -    ") || cpf.equals("   .   .   -  ")
                    || usuario.isBlank() || senha.isBlank()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                return;
            }

            id = funcionario.getId();
            funcionario.setNome(nome);
            funcionario.setEmail(email);
            funcionario.setAtividade(atividade);
            funcionario.setCidade(cidade);
            funcionario.setEstado(estado);
            funcionario.setEndereco(endereco);
            funcionario.setData_cadastro(LocalDate.now());
            funcionario.setData_nascimento(dataNasc);
            funcionario.setSexo(sexo);
            funcionario.setStatus(status);
            funcionario.setTelefone(telefone);
            funcionario.setCpf(cpf);
            funcionario.setUsuario(usuario);
            funcionario.setSenha(Criptografar.encriptografar(senha));
            funcionario.setTipo("funcionario");

            Optional<Funcionario> funcionario0 = Optional.empty();

            if (id == 0) {
                funcionario0 = fd.salvar(funcionario);
            } else {
                funcionario0 = fd.atualizar(funcionario);
            }

            if (funcionario0.isPresent()) {
                if (id == 0) {
                    JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
                    this.dispose();
                }
            }
        } catch (Exception e) {
            log.error("Erro ao cadastrar funcionário: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário.");
            this.dispose();
        }
    }//GEN-LAST:event_btncadastrarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
         try {
            FuncionarioDao fd = new FuncionarioDao(sessionFactory);
            fd.excluir(funcionario);    
            JOptionPane.showMessageDialog(null, "Funcionário deletado do sistema.");
            this.dispose();
         } catch (Exception e) {
            log.error("Erro ao excluir funcionário: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário.");
            this.dispose();
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

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
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btncadastrar;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JFormattedTextField ftfCpf;
    private com.toedter.calendar.JDateChooser ftfData;
    private javax.swing.JTextField ftfNumero;
    private javax.swing.JFormattedTextField ftfTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFechar;
    private javax.swing.JPasswordField pwfSenha;
    private javax.swing.JTextField txfAtividade;
    private javax.swing.JTextField txfBairro;
    private javax.swing.JTextField txfCidade;
    private javax.swing.JTextField txfEmail;
    private javax.swing.JTextField txfEstado;
    private javax.swing.JTextField txfNome;
    private javax.swing.JTextField txfRua;
    private javax.swing.JTextField txfUsuario;
    // End of variables declaration//GEN-END:variables
}
