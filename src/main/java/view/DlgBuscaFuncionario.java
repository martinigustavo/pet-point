/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.FuncionarioDao;
import entities.Funcionario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;
import utils.ReportsGenerator;
import utils.VisualsConfig;

@Log4j2
public class DlgBuscaFuncionario extends javax.swing.JDialog {

    private final SessionFactory sessionFactory;
    private FuncionarioDao funcDAO;
    private List<Funcionario> funcionarios;
    int id = 0;
    boolean relatorio = false;
    /**
     * Creates new form DlgBuscaAutor
     */
    public DlgBuscaFuncionario(java.awt.Frame parent, boolean modal, SessionFactory sf) {
        super(parent, modal);
        initComponents();
        btnSelecionar.setText("Selecionar");
        VisualsConfig.setPropsToWindow(this, "Selecionar Funcionário", parent);
        this.sessionFactory = HibernateUtil.getSessionFactory();
        funcDAO = new FuncionarioDao(sessionFactory);
    }
    
    public DlgBuscaFuncionario(java.awt.Frame parent, boolean modal, SessionFactory sf, boolean relatorio) {
        super(parent, modal);
        initComponents();
        this.relatorio = relatorio;
        btnSelecionar.setText("Gerar");
        VisualsConfig.setPropsToWindow(this, "Selecionar Funcionário", parent);
        this.sessionFactory = HibernateUtil.getSessionFactory();
        funcDAO = new FuncionarioDao(sessionFactory);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txfBusca = new javax.swing.JTextField();
        btnSelecionar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionario = new javax.swing.JTable();
        cbxPermissao = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        jLabel2.setText("Procure o funcionário que deseja, clique na linha correspondente da tabela e aperte o botão \"Selecionar\".");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.", "Nome", "Permissão"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblFuncionario.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblFuncionario);
        if (tblFuncionario.getColumnModel().getColumnCount() > 0) {
            tblFuncionario.getColumnModel().getColumn(0).setMinWidth(70);
            tblFuncionario.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblFuncionario.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        cbxPermissao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Admin", "Veterinária", "Petshop" }));

        jLabel1.setText("Permissão");

        jLabel4.setText("Campo de busca");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelecionar)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxPermissao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txfBusca)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(60, 60, 60))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(cbxPermissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSelecionar)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarDadosTabela() {
        try {
            String busca = txfBusca.getText();

            Object[] cabecalho = {"Cód.", "Nome", "Permissão"};
            Object[][] dadosTabela = new Object[0][3];

            switch (cbxPermissao.getSelectedIndex()) {
                case 0: {
                    funcionarios = funcDAO.buscarPorNomeEPermissao(busca, "todas");

                    dadosTabela = new Object[funcionarios.size()][3];
                    if (funcionarios.size() > 0) {
                        for (int i = 0; i < funcionarios.size(); i++) {
                            dadosTabela[i][0] = funcionarios.get(i).getId();
                            dadosTabela[i][1] = funcionarios.get(i).getNome();
                            dadosTabela[i][2] = funcionarios.get(i).getPermissao().getDescricao();
                        }
                    }
                    break;
                }

                case 1: {
                    funcionarios = funcDAO.buscarPorNomeEPermissao(busca, "admin");

                    dadosTabela = new Object[funcionarios.size()][3];
                    if (funcionarios.size() > 0) {
                        for (int i = 0; i < funcionarios.size(); i++) {
                            dadosTabela[i][0] = funcionarios.get(i).getId();
                            dadosTabela[i][1] = funcionarios.get(i).getNome();
                            dadosTabela[i][2] = funcionarios.get(i).getPermissao().getDescricao();
                        }
                    }
                    break;
                }

                case 2: {
                    funcionarios = funcDAO.buscarPorNomeEPermissao(busca, "vet");

                    dadosTabela = new Object[funcionarios.size()][3];
                    if (funcionarios.size() > 0) {
                        for (int i = 0; i < funcionarios.size(); i++) {
                            dadosTabela[i][0] = funcionarios.get(i).getId();
                            dadosTabela[i][1] = funcionarios.get(i).getNome();
                            dadosTabela[i][2] = funcionarios.get(i).getPermissao().getDescricao();
                        }
                    }
                    break;
                }

                case 3: {
                    funcionarios = funcDAO.buscarPorNomeEPermissao(busca, "pet");

                    dadosTabela = new Object[funcionarios.size()][3];
                    if (funcionarios.size() > 0) {
                        for (int i = 0; i < funcionarios.size(); i++) {
                            dadosTabela[i][0] = funcionarios.get(i).getId();
                            dadosTabela[i][1] = funcionarios.get(i).getNome();
                            dadosTabela[i][2] = funcionarios.get(i).getPermissao().getDescricao();
                        }
                    }
                    break;
                }

                default:
                    break;
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
        } catch (Exception e) {
            log.error("Erro ao buscar funcionarios "
                    + "(combobox selected_item: "
                    + cbxPermissao.getSelectedItem().toString()
                    + "): " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar funcionário(s).");
        }
    }

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        if (relatorio) {
            String idString = String.valueOf(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 0));
            id = Integer.parseInt(idString);
            
            Map params = new HashMap();
            params.put("funcionario_id", id);
            new ReportsGenerator().gerarRelatorioRobusto("/reports/relatorio_atendimento_funcionario.jrxml", params);
            this.dispose();
        }
        try {
            String idString = String.valueOf(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 0));

            id = Integer.parseInt(idString);

            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nenhum funcionário selecionado.");
            System.out.println("Erro: " + e.toString());
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        carregarDadosTabela();
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(DlgBuscaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgBuscaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgBuscaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgBuscaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgBuscaFuncionario dialog = new DlgBuscaFuncionario(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox<String> cbxPermissao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFuncionario;
    private javax.swing.JTextField txfBusca;
    // End of variables declaration//GEN-END:variables
}
