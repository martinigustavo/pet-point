/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.FuncionarioDao;
import entities.Funcionario;
import java.awt.event.KeyEvent;
import java.util.Optional;
import javax.swing.JOptionPane;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import utils.Criptografar;
import utils.HibernateUtil;
import utils.VisualsConfig;

@Log4j2
public class LoginView extends javax.swing.JFrame {

    /**
     * Creates new form LoginGUI
     */
    public LoginView() {
        initComponents();
        VisualsConfig.setPropsToWindow(this, "Login", rootPane);
        lblerror.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        txfUsuario = new javax.swing.JTextField();
        txfSenha = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JLabel();
        lblerror = new javax.swing.JLabel();
        lblFechar = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txfUsuario.setBackground(new java.awt.Color(225, 225, 225));
        txfUsuario.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfUsuario.setToolTipText("Nome de usuário");
        txfUsuario.setBorder(null);
        txfUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txfUsuarioMouseClicked(evt);
            }
        });
        txfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfUsuarioKeyReleased(evt);
            }
        });
        panelLogin.add(txfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, 320, 30));

        txfSenha.setBackground(new java.awt.Color(225, 225, 225));
        txfSenha.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txfSenha.setToolTipText("Senha");
        txfSenha.setBorder(null);
        txfSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txfSenhaMouseClicked(evt);
            }
        });
        txfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfSenhaKeyReleased(evt);
            }
        });
        panelLogin.add(txfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 390, 320, 30));

        btnLogin.setToolTipText("");
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        panelLogin.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, 200, 50));

        lblerror.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblerror.setForeground(new java.awt.Color(255, 0, 0));
        lblerror.setText("Usuário ou senha incorretos.");
        panelLogin.add(lblerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 700, 160, 20));

        lblFechar.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblFechar.setForeground(new java.awt.Color(0, 204, 204));
        lblFechar.setText("X");
        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharMouseClicked(evt);
            }
        });
        panelLogin.add(lblFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 10, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telalogin.png"))); // NOI18N
        panelLogin.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void login() {
        try {
            String usuario = txfUsuario.getText();

            char[] getSenha = txfSenha.getPassword();
            String senha = String.valueOf(getSenha);
            String senhaCriptografada = Criptografar
                    .encriptografar(senha);

            if (usuario.isBlank() || senha.isBlank()) {
                JOptionPane.showMessageDialog(null, "Você deve preencher o usuário e senha para prosseguir.");
                return;
            }

            SessionFactory sf = HibernateUtil.getSessionFactory();

            Optional<Funcionario> funcionario = new FuncionarioDao(sf).buscarPorUsuario(usuario);

            if (funcionario.isPresent()) {
                if (funcionario.get().getSenha().equals(senhaCriptografada)) {
                    log.info("Usuário " + funcionario.get().getUsuario()
                            + " logado com sucesso.");

                    this.dispose();
                    new ApplicationView(funcionario.get()).setVisible(true);
                } else {
                    log.warn("Senha incorreta informada para o usuário "
                            + funcionario.get().getUsuario(), ".");
                    lblerror.setVisible(true);
                }
            } else {
                log.warn("Usuário informado não está cadastrado: "
                        + usuario);
                JOptionPane.showMessageDialog(null, "Este funcionário não está cadastrado.");
            }
        } catch (Exception e) {
            log.error("Erro ao acessar aplicação: " + e.getMessage());

            JOptionPane.showMessageDialog(null, "Erro ao acessar aplicação."
                    + "\n"
                    + "Mensagem de erro: "
                    + e.getMessage());

        }
    }

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        this.login();
    }//GEN-LAST:event_btnLoginMouseClicked

    private void txfUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfUsuarioMouseClicked
        lblerror.setVisible(false);
    }//GEN-LAST:event_txfUsuarioMouseClicked

    private void txfSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfSenhaMouseClicked
        lblerror.setVisible(false);
    }//GEN-LAST:event_txfSenhaMouseClicked

    private void txfSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfSenhaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.login();
        }
    }//GEN-LAST:event_txfSenhaKeyReleased

    private void txfUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUsuarioKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txfSenha.requestFocus();
        }
    }//GEN-LAST:event_txfUsuarioKeyReleased

    private void lblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblFecharMouseClicked

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel btnLogin;
    private javax.swing.JLabel lblFechar;
    private javax.swing.JLabel lblerror;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField txfSenha;
    private javax.swing.JTextField txfUsuario;
    // End of variables declaration//GEN-END:variables
}
