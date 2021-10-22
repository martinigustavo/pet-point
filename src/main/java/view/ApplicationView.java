/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ClienteDao;
import dao.FuncionarioDao;
import entities.Cliente;
import entities.Funcionario;
import entities.Permissao;
import java.awt.Color;
import java.awt.Font;
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
    private SessionFactory sessionFactory;
    private FuncionarioDao fd;
    private String busca;
    private Permissao permissao;
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
        permissao = funcLogado.getPermissao();
        this.carregarHomeByPermissao();
        configurarPermissoes(permissao);
        configurarPermissoesCadastros(permissao);
        lblLogado.setText(funcLogado.getNome());
        lblPetshop.setVisible(false);
        lblVeterinaria.setVisible(false);

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        try {
            funcLogado.setLogado(true);
            fd.atualizar(funcLogado);
        } catch (Exception e) {
            log.error("Erro ao alterar status de login do funcionário: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao alterar status de login do funcionário.");
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

        background = new javax.swing.JPanel();
        pnlmenulateral = new javax.swing.JPanel();
        userimg = new javax.swing.JLabel();
        btnhome = new javax.swing.JButton();
        btncadastro = new javax.swing.JButton();
        lblLogado = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        barralateral = new javax.swing.JLabel();
        pnlHomeAdmin = new javax.swing.JPanel();
        lblVeterinaria = new javax.swing.JLabel();
        lblPetshop = new javax.swing.JLabel();
        btnVeterinaria = new javax.swing.JButton();
        btnPetshop = new javax.swing.JButton();
        backgroundadm = new javax.swing.JLabel();
        pnlHomePet = new javax.swing.JPanel();
        btncadastros = new javax.swing.JButton();
        fundoPet = new javax.swing.JLabel();
        pnlHomeVet = new javax.swing.JPanel();
        fundoVet = new javax.swing.JLabel();
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

        userimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        pnlmenulateral.add(userimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

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
        pnlmenulateral.add(btnhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 130, 50));

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
        pnlmenulateral.add(btncadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 130, 50));

        lblLogado.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblLogado.setForeground(new java.awt.Color(255, 255, 255));
        lblLogado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogado.setText("logado");
        pnlmenulateral.add(lblLogado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, 40));

        btnSair.setBackground(new java.awt.Color(58, 203, 199));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnlogout.png"))); // NOI18N
        btnSair.setBorder(null);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        pnlmenulateral.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1010, 130, 40));

        btnAdmin.setBackground(new java.awt.Color(58, 203, 199));
        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconlogs.png"))); // NOI18N
        btnAdmin.setToolTipText("");
        btnAdmin.setBorder(null);
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        pnlmenulateral.add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 130, 50));

        barralateral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/barralateral.png"))); // NOI18N
        pnlmenulateral.add(barralateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        background.add(pnlmenulateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 1080));

        pnlHomeAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVeterinaria.setFont(new java.awt.Font("Grand Aventure Text", 0, 100)); // NOI18N
        lblVeterinaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letreiro-veterinaria.png"))); // NOI18N
        pnlHomeAdmin.add(lblVeterinaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 930, -1, -1));

        lblPetshop.setFont(new java.awt.Font("Grand Aventure Text", 0, 100)); // NOI18N
        lblPetshop.setForeground(new java.awt.Color(255, 255, 255));
        lblPetshop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letreiro-petshop.png"))); // NOI18N
        pnlHomeAdmin.add(lblPetshop, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 940, -1, -1));

        btnVeterinaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnvet.png"))); // NOI18N
        btnVeterinaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVeterinariaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVeterinariaMouseExited(evt);
            }
        });
        btnVeterinaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVeterinariaActionPerformed(evt);
            }
        });
        pnlHomeAdmin.add(btnVeterinaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 560, 1080));

        btnPetshop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnpetshop.png"))); // NOI18N
        btnPetshop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPetshopMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPetshopMouseExited(evt);
            }
        });
        btnPetshop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetshopActionPerformed(evt);
            }
        });
        pnlHomeAdmin.add(btnPetshop, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 600, 1080));

        backgroundadm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telainicialadm.png"))); // NOI18N
        pnlHomeAdmin.add(backgroundadm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        background.add(pnlHomeAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 1760, 1080));

        pnlHomePet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncadastros.setBackground(new java.awt.Color(236, 236, 236));
        btncadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btncadastros.png"))); // NOI18N
        btncadastros.setBorder(null);
        btncadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastrosActionPerformed(evt);
            }
        });
        pnlHomePet.add(btncadastros, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 150, 50));

        fundoPet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telapetshop.png"))); // NOI18N
        pnlHomePet.add(fundoPet, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1760, 1080));

        background.add(pnlHomePet, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 1760, 1080));

        pnlHomeVet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fundoVet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telaveterinaria.png"))); // NOI18N
        fundoVet.setToolTipText("");
        pnlHomeVet.add(fundoVet, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1760, 1080));

        background.add(pnlHomeVet, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 1760, 1080));

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
        cmbescolher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionário", "Cliente", "Veterinário" }));
        cmbescolher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbescolherItemStateChanged(evt);
            }
        });
        cmbescolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbescolherActionPerformed(evt);
            }
        });
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
    private void configurarPermissoes(Permissao permissao) {

        if (permissao.getId() == 2) {
            btnAdmin.setVisible(false);
        } else if (permissao.getId() == 3) {
            btnAdmin.setVisible(false);
        }
    }

    private void configurarPermissoesCadastros(Permissao permissao) {
        switch (cmbescolher.getSelectedIndex()) {
            case 0:
                if (permissao.getId() == 2 || permissao.getId() == 3) {
                    btnAdicionar.setVisible(false);
                } else {
                    btnAdicionar.setVisible(true);
                }
                break;
            case 1:
                btnAdicionar.setVisible(true);
                break;
            case 2:
                if (permissao.getId() == 2 || permissao.getId() == 3) {
                    btnAdicionar.setVisible(false);
                } else {
                    btnAdicionar.setVisible(true);
                }
                break;
        }
    }

    private void btnhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhomeActionPerformed
        this.carregarHomeByPermissao();
    }//GEN-LAST:event_btnhomeActionPerformed

    private void carregarHomeByPermissao() {
        this.desativarTelas();
        pnlmenulateral.setVisible(true);

        if (permissao.getId() == 1) {
            pnlHomeAdmin.setVisible(true);
        } else if (permissao.getId() == 2) {
            pnlHomeVet.setVisible(true);
        } else if (permissao.getId() == 3) {
            pnlHomePet.setVisible(true);
        }
    }

    private void btncadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastroActionPerformed
        desativarTelas();
        pnlcadastros.setVisible(true);
        this.atualizarTabela();
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

        this.atualizarTabela();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void tblgeralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblgeralMouseClicked
        try {
            String idString = String.valueOf(tblgeral.getValueAt(tblgeral.getSelectedRow(), 0));
            id = Integer.parseInt(idString);

            if (id < 0) {
                System.out.println("Id menor que 0");
            } else {
                System.out.println(cmbescolher.getSelectedIndex());
                switch (cmbescolher.getSelectedIndex()) {
                    case 0: {
                        Optional<Funcionario> func = new FuncionarioDao(sessionFactory).buscar(id);
                        Funcionario funcionario = func.get();
                        DlgFuncionario funcionarioTela = new DlgFuncionario(null, true, funcionario, permissao);
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
                        Optional<Funcionario> vet = new FuncionarioDao(sessionFactory).buscar(id);
                        Funcionario veterinario = vet.get();
                        DlgVeterinario veterinarioTela = new DlgVeterinario(null, true, veterinario, permissao);
                        veterinarioTela.setVisible(true);
                        break;
                    }
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            log.error("Erro ao selecionar na tabela de cadastros "
                    + "(combobox selected_index: "
                    + cmbescolher.getSelectedIndex()
                    + "): " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao selecionar.");
        }
    }//GEN-LAST:event_tblgeralMouseClicked

    private void tfdbuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdbuscaKeyReleased
        this.atualizarTabela();
    }//GEN-LAST:event_tfdbuscaKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int i = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja sair?");
        if (i == 0) {
            funcLogado.setLogado(false);
            new FuncionarioDao(HibernateUtil.getSessionFactory()).atualizar(funcLogado);

            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    public void atualizarTabela() {
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
                    List<Funcionario> veterinarios = new FuncionarioDao(sessionFactory).buscarVetPorNome(busca);

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
    }

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int i = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja sair?");
        
        if (i == 0) {
            funcLogado.setLogado(false);
            new FuncionarioDao(HibernateUtil.getSessionFactory()).atualizar(funcLogado);

            System.exit(0);
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        DlgLogs dlgLogs = new DlgLogs(null, true);
        dlgLogs.setVisible(true);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void cmbescolherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbescolherActionPerformed
        configurarPermissoesCadastros(permissao);
    }//GEN-LAST:event_cmbescolherActionPerformed

    private void cmbescolherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbescolherItemStateChanged
        this.atualizarTabela();
    }//GEN-LAST:event_cmbescolherItemStateChanged

    private void btncadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrosActionPerformed
        DlgProduto dlgProduto = new DlgProduto(null, true);
        dlgProduto.setVisible(true);
    }//GEN-LAST:event_btncadastrosActionPerformed

    private void btnPetshopMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPetshopMouseEntered
        lblPetshop.setVisible(true);
    }//GEN-LAST:event_btnPetshopMouseEntered

    private void btnPetshopMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPetshopMouseExited
        lblPetshop.setVisible(false);
    }//GEN-LAST:event_btnPetshopMouseExited

    private void btnVeterinariaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVeterinariaMouseEntered
        lblVeterinaria.setVisible(true);
    }//GEN-LAST:event_btnVeterinariaMouseEntered

    private void btnVeterinariaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVeterinariaMouseExited
        lblVeterinaria.setVisible(false);
    }//GEN-LAST:event_btnVeterinariaMouseExited

    private void btnPetshopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetshopActionPerformed
        pnlHomeAdmin.setVisible(false);
        pnlHomeVet.setVisible(false);
        pnlHomePet.setVisible(true);
    }//GEN-LAST:event_btnPetshopActionPerformed

    private void btnVeterinariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVeterinariaActionPerformed
        pnlHomeAdmin.setVisible(false);
        pnlHomePet.setVisible(false);
        pnlHomeVet.setVisible(true);
    }//GEN-LAST:event_btnVeterinariaActionPerformed

    public void desativarTelas() {
        pnlHomeAdmin.setVisible(false);
        pnlHomePet.setVisible(false);
        pnlHomeVet.setVisible(false);
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
    private javax.swing.JLabel backgroundadm;
    private javax.swing.JLabel barralateral;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnPetshop;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVeterinaria;
    private javax.swing.JButton btncadastro;
    private javax.swing.JButton btncadastros;
    private javax.swing.JButton btnhome;
    private javax.swing.JComboBox<String> cmbescolher;
    private javax.swing.JLabel fundoPet;
    private javax.swing.JLabel fundoVet;
    private javax.swing.JLabel fundobusca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogado;
    private javax.swing.JLabel lblPetshop;
    private javax.swing.JLabel lblVeterinaria;
    private javax.swing.JPanel pnlHomeAdmin;
    private javax.swing.JPanel pnlHomePet;
    private javax.swing.JPanel pnlHomeVet;
    private javax.swing.JPanel pnlcadastros;
    private javax.swing.JPanel pnlmenulateral;
    private javax.swing.JTable tblgeral;
    private javax.swing.JTextField tfdbusca;
    private javax.swing.JLabel userimg;
    // End of variables declaration//GEN-END:variables
}
