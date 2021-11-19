/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import utils.ConexaoBD;
import utils.HibernateUtil;

/**
 *
 * @author Gustavo Martini
 */
public class ReportsGenerator {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void gerarRelatorioSimples(String path) {
        try {
            // Compila o relatorio
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
            JasperReport relatorio = JasperCompileManager.compileReport(inputStream);

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();

            // Executa relatoio
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    try {
                        // do your work using connection
                        JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, connection);

                        // Exibe resultado em video
                        JasperViewer.viewReport(impressao, false);
                    } catch (JRException ex) {
                        Logger.getLogger(ReportsGenerator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }

    public void gerarRelatorioRobusto(String path, Map params) {
        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream(path));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = params;

            // adiciona parametros
//            parametros.put("nomeParametro1","valorParametro1");
//            parametros.put("nomeParametro2","valorParametro2");
            // Executa relatoio
            session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    try {
                        // do your work using connection
                        JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, connection);

                        // Exibe resultado em video
                        JasperViewer.viewReport(impressao, false);
                    } catch (JRException ex) {
                        Logger.getLogger(ReportsGenerator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }
}
