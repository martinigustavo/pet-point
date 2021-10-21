package program;

import entities.Funcionario;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;
import utils.VisualsConfig;
import view.ApplicationView;
import view.DlgBuscaFuncionario;
import view.DlgLogs;
import view.LoginView;

@Log4j2
public class AppRunner {

//    private static final Logger LOG = LogManager.getLogger(AppRunner.class);
    public static void appRunner() {

        VisualsConfig.createLookAndFeel();

        SessionFactory sf = HibernateUtil.getSessionFactory();
        
        // Set swing frame visible after this comment
        // código que inicializa a aplicaçao (janela do login/cadastro)   
        
        new LoginView(sf).setVisible(true);
//        new ApplicationView(new Funcionario()).setVisible(true);
//        DlgBuscaFuncionario buscaFuncionario = new DlgBuscaFuncionario(null, true);
//        buscaFuncionario.setVisible(true);
    }
}
