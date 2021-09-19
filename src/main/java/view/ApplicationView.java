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
import java.util.List;
import java.util.Optional;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.SessionFactory;
import utils.Criptografar;
import utils.HibernateUtil;
import utils.VisualsConfig;

/**
 *
 * @author evely
 */
public class ApplicationView extends javax.swing.JFrame {

    private final Funcionario funcLogado;
    private final SessionFactory sessionFactory;
    private FuncionarioDao fd;
    private String busca;
    private int id;

    /**
     * Creates new form ApplicationView
     * 
     */
    public ApplicationView(Funcionario funcLogado) {
        initComponents();

        pnlcadastrarfunc.setVisible(false);
        pnlcadastros.setVisible(false);

        VisualsConfig.setPropsToWindow(this, "Cadastro de Funcionário", txfAtividade);

        this.funcLogado = funcLogado;
        this.sessionFactory = HibernateUtil.getSessionFactory();
        this.fd = new FuncionarioDao(sessionFactory);
        this.busca = "";
        this.id = 0;
        
        lblLogado.setText(funcLogado.getNome());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        pnlmenulateral = new javax.swing.JPanel();
        btnhome = new javax.swing.JButton();
        btncadastro = new javax.swing.JButton();
        lblLogado = new javax.swing.JLabel();
        barralateral = new javax.swing.JLabel();
        pnlhome = new javax.swing.JPanel();
        pnlcadastrarfunc = new javax.swing.JPanel();
        ftfData = new com.toedter.calendar.JDateChooser();
        btnSalvar = new javax.swing.JButton();
        pwfSenha = new javax.swing.JPasswordField();
        txfEmail = new javax.swing.JTextField();
        ftfNumero = new javax.swing.JTextField();
        txfRua = new javax.swing.JTextField();
        txfBairro = new javax.swing.JTextField();
        txfCidade = new javax.swing.JTextField();
        txfEstado = new javax.swing.JTextField();
        txfAtividade = new javax.swing.JTextField();
        txfNome = new javax.swing.JTextField();
        txfUsuario = new javax.swing.JTextField();
        cbxSexo = new javax.swing.JComboBox<>();
        cbxStatus = new javax.swing.JComboBox<>();
        ftfCpf = new javax.swing.JFormattedTextField();
        ftfTelefone = new javax.swing.JFormattedTextField();
        btnBackFunc = new javax.swing.JButton();
        cadastroform = new javax.swing.JLabel();
        pnlcadastrarcliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBackCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txfNomeCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ftfCpfCliente = new javax.swing.JFormattedTextField();
        pnlcadastros = new javax.swing.JPanel();
        tfdbusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionario = new javax.swing.JTable();
        btnAdicionarFunc = new javax.swing.JButton();
        btnAdicionarCliente = new javax.swing.JButton();
        fundobusca = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlmenulateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhome.setBackground(new java.awt.Color(58, 203, 199));
        btnhome.setForeground(new java.awt.Color(58, 203, 199));
        btnhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        btnhome.setToolTipText("Home");
        btnhome.setBorder(null);
        btnhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhomeActionPerformed(evt);
            }
        });
        pnlmenulateral.add(btnhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 180, 140, 50));

        btncadastro.setBackground(new java.awt.Color(58, 203, 199));
        btncadastro.setForeground(new java.awt.Color(58, 203, 199));
        btncadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconcadastro.png"))); // NOI18N
        btncadastro.setToolTipText("Cadastros");
        btncadastro.setBorder(null);
        btncadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastroActionPerformed(evt);
            }
        });
        pnlmenulateral.add(btncadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 250, 140, 50));

        lblLogado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogado.setText("logado");
        pnlmenulateral.add(lblLogado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1020, 130, 30));

        barralateral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/barralateral.png"))); // NOI18N
        pnlmenulateral.add(barralateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        background.add(pnlmenulateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 1080));

        javax.swing.GroupLayout pnlhomeLayout = new javax.swing.GroupLayout(pnlhome);
        pnlhome.setLayout(pnlhomeLayout);
        pnlhomeLayout.setHorizontalGroup(
            pnlhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1760, Short.MAX_VALUE)
        );
        pnlhomeLayout.setVerticalGroup(
            pnlhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );

        background.add(pnlhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 1760, 1080));

        pnlcadastrarfunc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ftfData.setBackground(new java.awt.Color(218, 218, 218));
        ftfData.setToolTipText("");
        pnlcadastrarfunc.add(ftfData, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 390, 40));

        btnSalvar.setBackground(new java.awt.Color(58, 203, 199));
        btnSalvar.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(null);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        pnlcadastrarfunc.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 1010, 190, 40));

        pwfSenha.setBackground(new java.awt.Color(218, 218, 218));
        pwfSenha.setToolTipText("");
        pwfSenha.setBorder(null);
        pnlcadastrarfunc.add(pwfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 460, 390, 40));

        txfEmail.setBackground(new java.awt.Color(218, 218, 218));
        txfEmail.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfEmail.setToolTipText("");
        txfEmail.setBorder(null);
        pnlcadastrarfunc.add(txfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 550, 860, 40));

        ftfNumero.setBackground(new java.awt.Color(218, 218, 218));
        ftfNumero.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        ftfNumero.setToolTipText("");
        ftfNumero.setBorder(null);
        pnlcadastrarfunc.add(ftfNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 790, 370, 30));

        txfRua.setBackground(new java.awt.Color(218, 218, 218));
        txfRua.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfRua.setToolTipText("");
        txfRua.setBorder(null);
        pnlcadastrarfunc.add(txfRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 900, 370, 30));

        txfBairro.setBackground(new java.awt.Color(218, 218, 218));
        txfBairro.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfBairro.setToolTipText("");
        txfBairro.setBorder(null);
        pnlcadastrarfunc.add(txfBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 780, 370, 40));

        txfCidade.setBackground(new java.awt.Color(218, 218, 218));
        txfCidade.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfCidade.setToolTipText("");
        txfCidade.setBorder(null);
        pnlcadastrarfunc.add(txfCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 900, 370, 40));

        txfEstado.setBackground(new java.awt.Color(218, 218, 218));
        txfEstado.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfEstado.setToolTipText("");
        txfEstado.setBorder(null);
        pnlcadastrarfunc.add(txfEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 780, 390, 40));

        txfAtividade.setBackground(new java.awt.Color(218, 218, 218));
        txfAtividade.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfAtividade.setToolTipText("");
        txfAtividade.setBorder(null);
        pnlcadastrarfunc.add(txfAtividade, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 230, 360, 40));

        txfNome.setBackground(new java.awt.Color(218, 218, 218));
        txfNome.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfNome.setToolTipText("");
        txfNome.setBorder(null);
        pnlcadastrarfunc.add(txfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 390, 30));

        txfUsuario.setBackground(new java.awt.Color(218, 218, 218));
        txfUsuario.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfUsuario.setToolTipText("");
        txfUsuario.setBorder(null);
        pnlcadastrarfunc.add(txfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 350, 380, 30));

        cbxSexo.setBackground(new java.awt.Color(218, 218, 218));
        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Feminino", "Masculino" }));
        pnlcadastrarfunc.add(cbxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 390, 40));

        cbxStatus.setBackground(new java.awt.Color(218, 218, 218));
        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Ativo", "Inativo" }));
        pnlcadastrarfunc.add(cbxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, 380, 40));

        ftfCpf.setBackground(new java.awt.Color(218, 218, 218));
        ftfCpf.setBorder(null);
        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pnlcadastrarfunc.add(ftfCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 390, 40));

        ftfTelefone.setBackground(new java.awt.Color(218, 218, 218));
        ftfTelefone.setBorder(null);
        try {
            ftfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pnlcadastrarfunc.add(ftfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, 370, 40));

        btnBackFunc.setBackground(new java.awt.Color(230, 230, 230));
        btnBackFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/left-chevron.png"))); // NOI18N
        btnBackFunc.setToolTipText("Voltar");
        btnBackFunc.setBorder(null);
        btnBackFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackFuncActionPerformed(evt);
            }
        });
        pnlcadastrarfunc.add(btnBackFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        cadastroform.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cadastrofuncionario.png"))); // NOI18N
        pnlcadastrarfunc.add(cadastroform, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1760, 1080));

        background.add(pnlcadastrarfunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 1760, 1080));

        pnlcadastrarcliente.setBackground(new java.awt.Color(230, 230, 230));

        jLabel1.setText("Nome:");

        btnBackCliente.setBackground(new java.awt.Color(230, 230, 230));
        btnBackCliente.setForeground(new java.awt.Color(230, 230, 230));
        btnBackCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/left-chevron.png"))); // NOI18N
        btnBackCliente.setBorder(null);
        btnBackCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackClienteActionPerformed(evt);
            }
        });

        jLabel2.setText("CADASTRAR CLIENTE");

        jLabel3.setText("CPF:");

        try {
            ftfCpfCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout pnlcadastrarclienteLayout = new javax.swing.GroupLayout(pnlcadastrarcliente);
        pnlcadastrarcliente.setLayout(pnlcadastrarclienteLayout);
        pnlcadastrarclienteLayout.setHorizontalGroup(
            pnlcadastrarclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlcadastrarclienteLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnBackCliente)
                .addGap(71, 71, 71)
                .addGroup(pnlcadastrarclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlcadastrarclienteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftfCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        pnlcadastrarclienteLayout.setVerticalGroup(
            pnlcadastrarclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlcadastrarclienteLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlcadastrarclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBackCliente)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(pnlcadastrarclienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(ftfCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(837, Short.MAX_VALUE))
        );

        background.add(pnlcadastrarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 930, 950));

        pnlcadastros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfdbusca.setBackground(new java.awt.Color(215, 214, 214));
        tfdbusca.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tfdbusca.setToolTipText("");
        tfdbusca.setBorder(null);
        tfdbusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfdbuscaKeyReleased(evt);
            }
        });
        pnlcadastros.add(tfdbusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 1150, 40));

        tblFuncionario.setBackground(new java.awt.Color(218, 218, 218));
        tblFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFuncionario);
        if (tblFuncionario.getColumnModel().getColumnCount() > 0) {
            tblFuncionario.getColumnModel().getColumn(0).setMinWidth(70);
            tblFuncionario.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblFuncionario.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        pnlcadastros.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 1450, 800));

        btnAdicionarFunc.setBackground(new java.awt.Color(225, 225, 225));
        btnAdicionarFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAdicionarFunc.setText("Novo funcionário");
        btnAdicionarFunc.setToolTipText("");
        btnAdicionarFunc.setBorder(null);
        btnAdicionarFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarFuncActionPerformed(evt);
            }
        });
        pnlcadastros.add(btnAdicionarFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 980, 170, 40));

        btnAdicionarCliente.setBackground(new java.awt.Color(225, 225, 225));
        btnAdicionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAdicionarCliente.setText("Novo cliente");
        btnAdicionarCliente.setToolTipText("");
        btnAdicionarCliente.setBorder(null);
        btnAdicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarClienteActionPerformed(evt);
            }
        });
        pnlcadastros.add(btnAdicionarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 980, 170, 40));

        fundobusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cadastrolista.png"))); // NOI18N
        pnlcadastros.add(fundobusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1770, -1));

        background.add(pnlcadastros, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 1760, 1080));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparCadastro() {
//        txfBusca.setText("");
        txfNome.setText("");
        txfEmail.setText("");
        txfAtividade.setText("");
        txfCidade.setText("");
        txfEstado.setText("");
//        txfRua.setText("");
//        txfBairro.setText("");
        txfUsuario.setText("");
        pwfSenha.setText("");

//        ftfNumero.setText("");
        ftfData.setDate(null);
        ftfCpf.setText("");
        ftfTelefone.setText("");

        cbxSexo.setSelectedIndex(0);
        cbxStatus.setSelectedIndex(0);

        busca = "";
        id = 0;
    }

    private void btnhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhomeActionPerformed
        desativarTelas();
        pnlmenulateral.setVisible(true);
    }//GEN-LAST:event_btnhomeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
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

        Funcionario func = new Funcionario();
        func.setNome(nome);
        func.setEmail(email);
        func.setAtividade(atividade);
        func.setCidade(cidade);
        func.setEstado(estado);
//        func.setEndereco(endereco);
        func.setData_cadastro(LocalDate.now());
        func.setData_nascimento(dataNasc);
        func.setSexo(sexo);
        func.setStatus(status);
        func.setTelefone(telefone);
        func.setCpf(cpf);
        func.setUsuario(usuario);
        func.setSenha(Criptografar.encriptografar(senha));

        Optional<Funcionario> funcionario0 = Optional.empty();

        if (id == 0) {
            funcionario0 = fd.salvar(func);
        } else {
            func.setId(id);
            funcionario0 = fd.atualizar(func);
        }

        if (funcionario0.isPresent()) {
            if (id == 0) {
                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
            }
            this.limparCadastro();
        } else {
            JOptionPane.showMessageDialog(null, "Problema ao cadastrar funcionário.");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btncadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastroActionPerformed
        desativarTelas();
        pnlcadastros.setVisible(true);
    }//GEN-LAST:event_btncadastroActionPerformed

    private void btnBackClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackClienteActionPerformed
        desativarTelas();
        pnlcadastros.setVisible(true);
    }//GEN-LAST:event_btnBackClienteActionPerformed

    private void btnBackFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackFuncActionPerformed
        desativarTelas();
        pnlcadastros.setVisible(true);
    }//GEN-LAST:event_btnBackFuncActionPerformed

    private void btnAdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarClienteActionPerformed
        desativarTelas();
        pnlcadastrarcliente.setVisible(true);

        this.limparCadastro();
    }//GEN-LAST:event_btnAdicionarClienteActionPerformed

    private void btnAdicionarFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarFuncActionPerformed
        desativarTelas();
        pnlcadastrarfunc.setVisible(true);

        this.limparCadastro();
    }//GEN-LAST:event_btnAdicionarFuncActionPerformed

    private void tblFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionarioMouseClicked
        try {
            String idString = String.valueOf(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 0));
            id = Integer.parseInt(idString);

            Optional<Funcionario> func = new FuncionarioDao(sessionFactory).buscar(id);

            if (func.isPresent()) {
                txfNome.setText(func.get().getNome());
                txfUsuario.setText(func.get().getUsuario());
                ftfCpf.setText(func.get().getCpf());
                ftfTelefone.setText(func.get().getTelefone());
                txfAtividade.setText(func.get().getAtividade());
                ftfData.setDate(convertToDateViaInstant(func.get().getData_nascimento()));
                txfEstado.setText(func.get().getEstado());
                txfCidade.setText(func.get().getCidade());
                txfEmail.setText(func.get().getEmail());

                if (func.get().getSexo().equals("Feminino")) {
                    cbxSexo.setSelectedIndex(1);
                } else {
                    cbxSexo.setSelectedIndex(2);
                }

                if (func.get().getStatus().equals("Ativo")) {
                    cbxStatus.setSelectedIndex(1);
                } else {
                    cbxStatus.setSelectedIndex(2);
                }

                desativarTelas();
                pnlcadastrarfunc.setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nenhum funcionário selecionado.");
        }
    }//GEN-LAST:event_tblFuncionarioMouseClicked

    private void tfdbuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdbuscaKeyReleased
        busca = tfdbusca.getText();
        List<Funcionario> funcionarios = new FuncionarioDao(sessionFactory).buscarPorNome(busca);

        Object[] cabecalho = {"id", "Nome"};
        Object[][] dadosTabela = new Object[funcionarios.size()][2];
        if (funcionarios.size() > 0) {
            for (int i = 0; i < funcionarios.size(); i++) {
                dadosTabela[i][0] = funcionarios.get(i).getId();
                dadosTabela[i][1] = funcionarios.get(i).getNome();
            }
        }

        tblFuncionario.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        });

        tblFuncionario.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tblFuncionario.getColumnCount(); i++) {
            column = tblFuncionario.getColumnModel().getColumn(i);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            column.setCellRenderer(centerRenderer);
        }

        column = tblFuncionario.getColumnModel().getColumn(0);
        column.setPreferredWidth(70);
        column.setMaxWidth(70);
        column.setMinWidth(70);
    }//GEN-LAST:event_tfdbuscaKeyReleased

    public void desativarTelas() {
        pnlhome.setVisible(false);
        pnlcadastrarfunc.setVisible(false);
        pnlcadastrarcliente.setVisible(false);
        pnlcadastros.setVisible(false);
    }
    
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
            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel barralateral;
    private javax.swing.JButton btnAdicionarCliente;
    private javax.swing.JButton btnAdicionarFunc;
    private javax.swing.JButton btnBackCliente;
    private javax.swing.JButton btnBackFunc;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btncadastro;
    private javax.swing.JButton btnhome;
    private javax.swing.JLabel cadastroform;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JFormattedTextField ftfCpf;
    private javax.swing.JFormattedTextField ftfCpfCliente;
    private com.toedter.calendar.JDateChooser ftfData;
    private javax.swing.JTextField ftfNumero;
    private javax.swing.JFormattedTextField ftfTelefone;
    private javax.swing.JLabel fundobusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogado;
    private javax.swing.JPanel pnlcadastrarcliente;
    private javax.swing.JPanel pnlcadastrarfunc;
    private javax.swing.JPanel pnlcadastros;
    private javax.swing.JPanel pnlhome;
    private javax.swing.JPanel pnlmenulateral;
    private javax.swing.JPasswordField pwfSenha;
    private javax.swing.JTable tblFuncionario;
    private javax.swing.JTextField tfdbusca;
    private javax.swing.JTextField txfAtividade;
    private javax.swing.JTextField txfBairro;
    private javax.swing.JTextField txfCidade;
    private javax.swing.JTextField txfEmail;
    private javax.swing.JTextField txfEstado;
    private javax.swing.JTextField txfNome;
    private javax.swing.JTextField txfNomeCliente;
    private javax.swing.JTextField txfRua;
    private javax.swing.JTextField txfUsuario;
    // End of variables declaration//GEN-END:variables
}
