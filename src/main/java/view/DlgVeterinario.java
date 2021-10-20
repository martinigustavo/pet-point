/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.VeterinarioDao;
import entities.Permissao;
import entities.Veterinario;
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
public class DlgVeterinario extends javax.swing.JDialog {

    private int id = 0;
    private Veterinario vet = new Veterinario();
    private final SessionFactory sessionFactory;

    public DlgVeterinario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btnDeletar.setVisible(false);
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public DlgVeterinario(java.awt.Frame parent, boolean modal, Veterinario medico, Permissao permissao) {
        super(parent, modal);
        initComponents();
        this.sessionFactory = HibernateUtil.getSessionFactory();
        this.vet = medico;
        checkPermissoes(permissao);
        btnDeletar.setVisible(true);
        txfNome.setText(medico.getNome());
        txfUsuario.setText(medico.getUsuario());
        ftfCpf.setText(medico.getCpf());
        ftfTelefone.setText(medico.getTelefone());
        txfCrmv.setText(medico.getCrmv());
        ftfData.setDate(convertToDateViaInstant(medico.getData_nascimento()));
        txfEstado.setText(medico.getEstado());
        txfCidade.setText(medico.getCidade());
        txfEmail.setText(medico.getEmail());
        //endereço
        String[] endereco = medico.getEndereco().split(Pattern.quote(","));
        txfRua.setText(endereco[0]);
        ftfNumero.setText(endereco[1]);
        txfBairro.setText(endereco[2]);
        if (medico.getSexo().equals("Feminino")) {
            cbxSexo.setSelectedIndex(1);
        } else {
            cbxSexo.setSelectedIndex(2);
        }

        if (medico.getStatus().equals("Ativo")) {
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

        pnlcadastromedico = new javax.swing.JPanel();
        lblFechar = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JButton();
        txfBairro = new javax.swing.JTextField();
        pwfSenha = new javax.swing.JPasswordField();
        cbxStatus = new javax.swing.JComboBox<>();
        txfCrmv = new javax.swing.JTextField();
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
        btnCadastrar = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        pnlcadastromedico.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFechar.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblFechar.setForeground(new java.awt.Color(0, 204, 204));
        lblFechar.setText("X");
        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharMouseClicked(evt);
            }
        });
        pnlcadastromedico.add(lblFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, -1, -1));

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
        pnlcadastromedico.add(btnDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 640, 170, 40));

        txfBairro.setBackground(new java.awt.Color(218, 218, 218));
        txfBairro.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfBairro.setToolTipText("");
        txfBairro.setBorder(null);
        pnlcadastromedico.add(txfBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, 270, 30));

        pwfSenha.setBackground(new java.awt.Color(218, 218, 218));
        pwfSenha.setToolTipText("");
        pwfSenha.setBorder(null);
        pnlcadastromedico.add(pwfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 300, 250, 30));

        cbxStatus.setBackground(new java.awt.Color(218, 218, 218));
        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Ativo", "Inativo" }));
        pnlcadastromedico.add(cbxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 310, 40));

        txfCrmv.setBackground(new java.awt.Color(218, 218, 218));
        txfCrmv.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfCrmv.setToolTipText("");
        txfCrmv.setBorder(null);
        pnlcadastromedico.add(txfCrmv, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 140, 250, 30));

        txfEmail.setBackground(new java.awt.Color(218, 218, 218));
        txfEmail.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfEmail.setToolTipText("");
        txfEmail.setBorder(null);
        pnlcadastromedico.add(txfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 610, 30));

        ftfTelefone.setBackground(new java.awt.Color(218, 218, 218));
        ftfTelefone.setBorder(null);
        try {
            ftfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pnlcadastromedico.add(ftfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 364, 240, 30));

        cbxSexo.setBackground(new java.awt.Color(218, 218, 218));
        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Feminino", "Masculino" }));
        pnlcadastromedico.add(cbxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 290, 40));

        txfUsuario.setBackground(new java.awt.Color(218, 218, 218));
        txfUsuario.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfUsuario.setToolTipText("");
        txfUsuario.setBorder(null);
        pnlcadastromedico.add(txfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 220, 250, 30));

        ftfCpf.setBackground(new java.awt.Color(218, 218, 218));
        ftfCpf.setBorder(null);
        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pnlcadastromedico.add(ftfCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 260, 30));

        txfEstado.setBackground(new java.awt.Color(218, 218, 218));
        txfEstado.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfEstado.setToolTipText("");
        txfEstado.setBorder(null);
        pnlcadastromedico.add(txfEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 250, 30));

        ftfNumero.setBackground(new java.awt.Color(218, 218, 218));
        ftfNumero.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        ftfNumero.setToolTipText("");
        ftfNumero.setBorder(null);
        pnlcadastromedico.add(ftfNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 520, 260, 30));

        txfNome.setBackground(new java.awt.Color(218, 218, 218));
        txfNome.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfNome.setToolTipText("");
        txfNome.setBorder(null);
        pnlcadastromedico.add(txfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 260, 30));

        ftfData.setBackground(new java.awt.Color(218, 218, 218));
        ftfData.setToolTipText("");
        pnlcadastromedico.add(ftfData, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 310, 30));

        txfRua.setBackground(new java.awt.Color(218, 218, 218));
        txfRua.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfRua.setToolTipText("");
        txfRua.setBorder(null);
        pnlcadastromedico.add(txfRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 600, 260, 30));

        txfCidade.setBackground(new java.awt.Color(218, 218, 218));
        txfCidade.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfCidade.setToolTipText("");
        txfCidade.setBorder(null);
        pnlcadastromedico.add(txfCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 260, 20));

        btnCadastrar.setBackground(new java.awt.Color(58, 203, 199));
        btnCadastrar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setBorder(null);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        pnlcadastromedico.add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 640, 170, 40));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cadastromedico.png"))); // NOI18N
        background.setToolTipText("");
        pnlcadastromedico.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlcadastromedico, javax.swing.GroupLayout.PREFERRED_SIZE, 1162, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlcadastromedico, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     private void checkPermissoes(Permissao permissao){
        if (permissao.getId() == 2 || permissao.getId() == 3){
            txfNome.setEditable(false);
            txfEmail.setEditable(false);
            txfCrmv.setEditable(false);
            txfCidade.setEditable(false);
            txfEstado.setEditable(false);
            txfRua.setEditable(false);
            ftfNumero.setEditable(false);
            txfBairro.setEditable(false);
            cbxSexo.setEnabled(false);
            cbxStatus.setEnabled(false);
            ftfData.setEnabled(false);
            ftfTelefone.setEditable(false);
            ftfCpf.setEditable(false);
            pwfSenha.setVisible(false);
            txfUsuario.setEditable(false);
            btnCadastrar.setEnabled(false);
            btnDeletar.setEnabled(false);
        }
     }
        
    private void lblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblFecharMouseClicked

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        try {
            VeterinarioDao vd = new VeterinarioDao(sessionFactory);
            String nome = txfNome.getText().trim();
            String email = txfEmail.getText().trim();
            String crmv = txfCrmv.getText().trim();
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

            if (nome.isBlank() || email.isBlank() || crmv.isBlank()
                    || cidade.isBlank() || estado.isBlank()
                    || sexo.equals("Selecione") || status.equals("Selecione")
                    || telefone.equals("(  )      -    ") || cpf.equals("   .   .   -  ")
                    || usuario.isBlank() || senha.isBlank()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                return;
            }

            id = vet.getId();
            vet.setNome(nome);
            vet.setEmail(email);
            vet.setCrmv(crmv);
            vet.setCidade(cidade);
            vet.setEstado(estado);
            vet.setEndereco(endereco);
            vet.setData_cadastro(LocalDate.now());
            vet.setData_nascimento(dataNasc);
            vet.setSexo(sexo);
            vet.setStatus(status);
            vet.setTelefone(telefone);
            vet.setCpf(cpf);
            vet.setUsuario(usuario);
            vet.setSenha(Criptografar.encriptografar(senha));
            vet.setTipo("veterinario");
            Permissao permissao = new Permissao();
            permissao.setId(2);
            permissao.setDescricao("veterinario");
            vet.setPermissao(permissao);        
            Optional<Veterinario> medico0 = Optional.empty();

            if (id == 0) {
                medico0 = vd.salvar(vet);
            } else {
                medico0 = vd.atualizar(vet);
            }

            if (medico0.isPresent()) {
                if (id == 0) {
                    JOptionPane.showMessageDialog(null, "Veterinário cadastrado com sucesso!");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Veterinário atualizado com sucesso!");
                    this.dispose();
                }
            }
        } catch (Exception e) {
            log.error("Erro ao cadastrar veterinário: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Problema ao cadastrar veterinário.");
            this.dispose();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        try {
            VeterinarioDao vd = new VeterinarioDao(sessionFactory);
            vd.excluir(vet);
            JOptionPane.showMessageDialog(null, "Veterinário deletado do sistema.");
            this.dispose();
        } catch (Exception e) {
            log.error("Erro ao excluir veterinário: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao deletar veterinário.");
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
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JFormattedTextField ftfCpf;
    private com.toedter.calendar.JDateChooser ftfData;
    private javax.swing.JTextField ftfNumero;
    private javax.swing.JFormattedTextField ftfTelefone;
    private javax.swing.JLabel lblFechar;
    private javax.swing.JPanel pnlcadastromedico;
    private javax.swing.JPasswordField pwfSenha;
    private javax.swing.JTextField txfBairro;
    private javax.swing.JTextField txfCidade;
    private javax.swing.JTextField txfCrmv;
    private javax.swing.JTextField txfEmail;
    private javax.swing.JTextField txfEstado;
    private javax.swing.JTextField txfNome;
    private javax.swing.JTextField txfRua;
    private javax.swing.JTextField txfUsuario;
    // End of variables declaration//GEN-END:variables
}
