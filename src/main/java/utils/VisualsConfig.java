/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Gustavo Martini
 */
public class VisualsConfig {
    
    private static final String FONT_PATH = "/Roboto-Regular.ttf";
    private static final float FONT_SIZE = 16f;

    /**
     *
     * Este método altera as propriedades de um JFrame.
     *
     * @param jFrame
     * @param title
     * @param locationRelativeTo
     */
    public static void setPropsToWindow(JFrame jFrame, String title, Component locationRelativeTo) {
        jFrame.setTitle(title);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(locationRelativeTo);
        jFrame.setResizable(false);
    }

    /**
     *
     * Este método altera as propriedades de um JInternalFrame.
     *
     * @param jInternalFrame
     * @param title
     */
    public static void setPropsToWindow(JInternalFrame jInternalFrame, String title) {
        jInternalFrame.setTitle(title);
        jInternalFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jInternalFrame.setResizable(false);
        jInternalFrame.setClosable(true);
    }

    /**
     *
     * Este método altera as propriedades de um JDialog.
     *
     * @param jDialog
     * @param title
     * @param locationRelativeTo
     */
    public static void setPropsToWindow(JDialog jDialog, String title, Component locationRelativeTo) {
        jDialog.setTitle("Selecionar Usuário");
        jDialog.setLocationRelativeTo(locationRelativeTo);
        jDialog.setResizable(false);
    }

    /**
     *
     * Este método muda o LookAndFeel da aplicação
     *
     */
    public static void createLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
    }

    /**
     *
     * Este método altera a fonte da aplicação
     *
     */
    public static void setAppFont() {
        VisualsConfig.setFontOnSwingComponents(new FontUIResource(createFont()));
    }

    /**
     * 
     * Cria uma fonte de acordo com os campos FONT_PATH e FONT_SIZE.
     * 
     * @return Fonte criada
     */
    private static Font createFont() {
        Font font = null;

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, VisualsConfig.class.getResource(FONT_PATH).openStream());

            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            font = font.deriveFont(FONT_SIZE);
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
            ex.printStackTrace();
        } catch (FontFormatException ex) {
            System.out.println("FontFormatException: " + ex.getMessage());
            ex.printStackTrace();
        }
        
        return font;
    }

    /**
     *
     * Altera a fonte em todos os components do Swing.
     *
     * @param myFont
     */
    private static void setFontOnSwingComponents(FontUIResource myFont) {
        UIManager.put("CheckBoxMenuItem.acceleratorFont", myFont);
        UIManager.put("Button.font", myFont);
        UIManager.put("ToggleButton.font", myFont);
        UIManager.put("RadioButton.font", myFont);
        UIManager.put("CheckBox.font", myFont);
        UIManager.put("ColorChooser.font", myFont);
        UIManager.put("ComboBox.font", myFont);
        UIManager.put("Label.font", myFont);
        UIManager.put("List.font", myFont);
        UIManager.put("MenuBar.font", myFont);
        UIManager.put("Menu.acceleratorFont", myFont);
        UIManager.put("RadioButtonMenuItem.acceleratorFont", myFont);
        UIManager.put("MenuItem.acceleratorFont", myFont);
        UIManager.put("MenuItem.font", myFont);
        UIManager.put("RadioButtonMenuItem.font", myFont);
        UIManager.put("CheckBoxMenuItem.font", myFont);
        UIManager.put("OptionPane.buttonFont", myFont);
        UIManager.put("OptionPane.messageFont", myFont);
        UIManager.put("Menu.font", myFont);
        UIManager.put("PopupMenu.font", myFont);
        UIManager.put("OptionPane.font", myFont);
        UIManager.put("Panel.font", myFont);
        UIManager.put("ProgressBar.font", myFont);
        UIManager.put("ScrollPane.font", myFont);
        UIManager.put("Viewport.font", myFont);
        UIManager.put("TabbedPane.font", myFont);
        UIManager.put("Slider.font", myFont);
        UIManager.put("Table.font", myFont);
        UIManager.put("TableHeader.font", myFont);
        UIManager.put("TextField.font", myFont);
        UIManager.put("Spinner.font", myFont);
        UIManager.put("PasswordField.font", myFont);
        UIManager.put("TextArea.font", myFont);
        UIManager.put("TextPane.font", myFont);
        UIManager.put("EditorPane.font", myFont);
        UIManager.put("TabbedPane.smallFont", myFont);
        UIManager.put("TitledBorder.font", myFont);
        UIManager.put("ToolBar.font", myFont);
        UIManager.put("ToolTip.font", myFont);
        UIManager.put("Tree.font", myFont);
        UIManager.put("FormattedTextField.font", myFont);
        UIManager.put("IconButton.font", myFont);
        UIManager.put("InternalFrame.optionDialogTitleFont", myFont);
        UIManager.put("InternalFrame.paletteTitleFont", myFont);
        UIManager.put("InternalFrame.titleFont", myFont);
    }

}
