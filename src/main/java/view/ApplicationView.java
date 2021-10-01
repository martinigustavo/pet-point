/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ClienteDao;
import dao.FuncionarioDao;
import dao.VeterinarioDao;
import entities.Cliente;
import entities.Funcionario;
import entities.Veterinario;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;
import utils.VisualsConfig;

@Log4j2
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

        pnlcadastros.setVisible(false);

        VisualsConfig.setPropsToWindow(this, "Pet Point", rootPane);
        this.funcLogado = funcLogado;
        this.sessionFactory = HibernateUtil.getSessionFactory();
        this.fd = new FuncionarioDao(sessionFactory);
        this.busca = "";
        this.id = 0;
        configurarTblCadastros();

        lblLogado.setText(funcLogado.getNome());

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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
        jButton1 = new javax.swing.JButton();
        barralateral = new javax.swing.JLabel();
        pnlhome = new javax.swing.JPanel();
        pnlcadastros = new javax.swing.JPanel();
        tfdbusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblgeral = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        cmbescolher = new javax.swing.JComboBox<>();
        fundobusca = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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

        jButton1.setBackground(new java.awt.Color(58, 203, 199));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconcadastro.png"))); // NOI18N
        jButton1.setToolTipText("Cadastrar produto");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlmenulateral.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 130, 40));

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

        tblgeral.setBackground(new java.awt.Color(218, 218, 218));
        tblgeral.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tblgeral.setModel(new javax.swing.table.DefaultTableModel(
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
        tblgeral.setRowHeight(35);
        tblgeral.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblgeral.setShowVerticalLines(false);
        tblgeral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblgeralMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblgeral);
        if (tblgeral.getColumnModel().getColumnCount() > 0) {
            tblgeral.getColumnModel().getColumn(0).setMinWidth(70);
            tblgeral.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblgeral.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        pnlcadastros.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 1450, 800));

        btnAdicionar.setBackground(new java.awt.Color(225, 225, 225));
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAdicionar.setToolTipText("");
        btnAdicionar.setBorder(null);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        pnlcadastros.add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 980, 50, 50));

        cmbescolher.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        cmbescolher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionário", "Cliente", "Veterinário", " " }));
        pnlcadastros.add(cmbescolher, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 990, 250, 40));

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


    private void btnhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhomeActionPerformed
        desativarTelas();
        pnlmenulateral.setVisible(true);
    }//GEN-LAST:event_btnhomeActionPerformed

    private void btncadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastroActionPerformed
        desativarTelas();
        pnlcadastros.setVisible(true);
    }//GEN-LAST:event_btncadastroActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        switch (cmbescolher.getSelectedIndex()) {
            case 0:
                DlgFuncionario tela = new DlgFuncionario(null, true);
                tela.setVisible(true);
                break;
            case 1:
                DlgCliente tela2 = new DlgCliente(null, true);
                tela2.setVisible(true);
                break;
            case 2:
                DlgVeterinario tela3 = new DlgVeterinario(null, true);
                tela3.setVisible(true);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void tblgeralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblgeralMouseClicked
        try {
            String idString = String.valueOf(tblgeral.getValueAt(tblgeral.getSelectedRow(), 0));
            id = Integer.parseInt(idString);

            if (id < 0) {
                System.out.println("Id menor que 0");
                //lblmensagem.setVisible(true);
            } else {
                System.out.println(cmbescolher.getSelectedIndex());
                switch (cmbescolher.getSelectedIndex()) {
                    case 0: {
                        Optional<Funcionario> func = new FuncionarioDao(sessionFactory).buscar(id);
                        Funcionario funcionario = func.get();
                        DlgFuncionario funcionarioTela = new DlgFuncionario(null, true, funcionario);
                        funcionarioTela.setVisible(true);
                        break;
                    }
                    case 1: {
                        Optional<Cliente> cli = new ClienteDao(sessionFactory).buscar(id);
                        Cliente cliente = cli.get();
                        DlgCliente clienteTela = new DlgCliente(null, true, cliente);
                        clienteTela.setVisible(true);
                        break;
                    }
                    case 2: {
                        Optional<Veterinario> vet = new VeterinarioDao(sessionFactory).buscar(id);
                        Veterinario veterinario = vet.get();
                        DlgVeterinario veterinarioTela = new DlgVeterinario(null, true, veterinario);
                        veterinarioTela.setVisible(true);
                        break;
                    }
                    default:
                        break;
                }
            }

            /*
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
             */
        } catch (Exception e) {
            log.error("Erro ao selecionar na tabela de cadastros "
                    + "(combobox selected_index: "
                    + cmbescolher.getSelectedIndex()
                    + "): " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao selecionar.");
        }
    }//GEN-LAST:event_tblgeralMouseClicked

    private void tfdbuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdbuscaKeyReleased
        try {
            busca = tfdbusca.getText();

            Object[] cabecalho = {"id", "Nome"};
            Object[][] dadosTabela = new Object[0][2];

            switch (cmbescolher.getSelectedIndex()) {
                case 0: {
                    List<Funcionario> funcionarios = new FuncionarioDao(sessionFactory).buscarPorNome(busca);

                    dadosTabela = new Object[funcionarios.size()][2];
                    if (funcionarios.size() > 0) {
                        for (int i = 0; i < funcionarios.size(); i++) {
                            dadosTabela[i][0] = funcionarios.get(i).getId();
                            dadosTabela[i][1] = funcionarios.get(i).getNome();
                        }
                    }
                    break;
                }

                case 1: {
                    List<Cliente> clientes = new ClienteDao(sessionFactory).buscarPorNome(busca);

                    dadosTabela = new Object[clientes.size()][2];
                    if (clientes.size() > 0) {
                        for (int i = 0; i < clientes.size(); i++) {
                            dadosTabela[i][0] = clientes.get(i).getId();
                            dadosTabela[i][1] = clientes.get(i).getNome();
                        }
                    }
                    break;
                }

                case 2: {
                    List<Veterinario> veterinarios = new VeterinarioDao(sessionFactory).buscarPorNome(busca);

                    dadosTabela = new Object[veterinarios.size()][2];
                    if (veterinarios.size() > 0) {
                        for (int i = 0; i < veterinarios.size(); i++) {
                            dadosTabela[i][0] = veterinarios.get(i).getId();
                            dadosTabela[i][1] = veterinarios.get(i).getNome();
                        }
                    }
                    break;
                }

                default:
                    break;
            }

            tblgeral.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            });

            tblgeral.setSelectionMode(0);

            // redimensiona as colunas de uma tabela
            TableColumn column = null;
            for (int i = 0; i < tblgeral.getColumnCount(); i++) {
                column = tblgeral.getColumnModel().getColumn(i);
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                column.setCellRenderer(centerRenderer);
            }

            column = tblgeral.getColumnModel().getColumn(0);
            column.setPreferredWidth(70);
            column.setMaxWidth(70);
            column.setMinWidth(70);
        } catch (Exception e) {
            log.error("Erro ao buscar na tabela de cadastros "
                    + "(combobox selected_item: "
                    + cmbescolher.getSelectedItem().toString()
                    + "): " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar.");
        }
    }//GEN-LAST:event_tfdbuscaKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int i = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja sair?");
        if (i == 0) {
            funcLogado.setLogado(false);
            new FuncionarioDao(sessionFactory).atualizar(funcLogado);

            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DlgProduto tela = new DlgProduto(null, true);
        tela.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void desativarTelas() {
        pnlhome.setVisible(false);
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
    
    public void configurarTblCadastros() {
        tblgeral.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 15));
        tblgeral.getTableHeader().setForeground(Color.WHITE);
        tblgeral.getTableHeader().setOpaque(false);
        tblgeral.getTableHeader().setBackground(new Color(2, 166, 166));
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel barralateral;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btncadastro;
    private javax.swing.JButton btnhome;
    private javax.swing.JComboBox<String> cmbescolher;
    private javax.swing.JLabel fundobusca;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogado;
    private javax.swing.JPanel pnlcadastros;
    private javax.swing.JPanel pnlhome;
    private javax.swing.JPanel pnlmenulateral;
    private javax.swing.JTable tblgeral;
    private javax.swing.JTextField tfdbusca;
    // End of variables declaration//GEN-END:variables
}
