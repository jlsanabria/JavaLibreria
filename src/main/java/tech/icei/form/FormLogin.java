/*
 * Created by JFormDesigner on Sat Sep 21 16:42:10 BOT 2024
 */

package tech.icei.form;

import java.awt.event.*;
import org.hibernate.SessionFactory;
import tech.icei.config.HibernateConfig;
import tech.icei.dao.UsuarioDAO;
import tech.icei.dao.UsuarioDAOImpl;
import tech.icei.model.Usuario;
import tech.icei.service.UsuarioService;
import tech.icei.service.UsuarioServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * @author jsanabria
 */
public class FormLogin extends JFrame {
    // Inicio de la fábrica de sesiones de Hibernate
    SessionFactory sessionFactory = HibernateConfig.createSessionFactory();
    UsuarioService usuarioService = new UsuarioServiceImpl(sessionFactory);
    FormCrud formCrud;

    public FormLogin() {
        setLookAndFeel("Nimbus");
        initComponents();
    }

    private void setLookAndFeel(String lookAndFeel) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if (lookAndFeel.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
    }

    private void login(ActionEvent e) {
        // TODO add your code here
        Usuario usuarioAutenticado = usuarioService.login(tfUsuario.getText(), pfPassword.getText());
        if(Objects.nonNull(usuarioAutenticado)) {
            lError.setText("");
            System.out.println("Bienvenido(a) " + usuarioAutenticado.getUsername());
            this.setVisible(false);
            formCrud = new FormCrud(sessionFactory, usuarioAutenticado);
        } else {
            lError.setText("Credenciales no válidas :(");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jose
        labelLogo = new JLabel();
        label1 = new JLabel();
        lUsuario = new JLabel();
        lPassword = new JLabel();
        tfUsuario = new JTextField();
        pfPassword = new JPasswordField();
        button1 = new JButton();
        lError = new JLabel();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/assets/libreria_icon.png")).getImage());
        setVisible(true);
        setTitle(":: Mi Libreria");
        var contentPane = getContentPane();

        //---- labelLogo ----
        labelLogo.setIcon(new ImageIcon(getClass().getResource("/assets/libreria_icon.png")));
        labelLogo.setMaximumSize(new Dimension(54, 512));

        //---- label1 ----
        label1.setText("Mi libreria");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Roboto", Font.BOLD, 22));

        //---- lUsuario ----
        lUsuario.setText("Usuario:");
        lUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));

        //---- lPassword ----
        lPassword.setText("Contrase\u00f1a:");
        lPassword.setFont(new Font("Roboto", Font.PLAIN, 16));

        //---- tfUsuario ----
        tfUsuario.setFont(new Font("Inter", Font.PLAIN, 16));

        //---- pfPassword ----
        pfPassword.setFont(new Font("Inter", Font.PLAIN, 16));

        //---- button1 ----
        button1.setText("INGRESAR");
        button1.addActionListener(e -> login(e));

        //---- lError ----
        lError.setForeground(new Color(0xff3333));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(152, 152, 152)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelLogo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(168, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(146, 146, 146)
                            .addComponent(lError, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(lUsuario, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lPassword, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(tfUsuario, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(pfPassword)
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))))
                    .addGap(85, 85, 85))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labelLogo, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label1)
                    .addGap(40, 40, 40)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lUsuario)
                        .addComponent(tfUsuario, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lPassword)
                        .addComponent(pfPassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lError)
                    .addContainerGap(73, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jose
    private JLabel labelLogo;
    private JLabel label1;
    private JLabel lUsuario;
    private JLabel lPassword;
    private JTextField tfUsuario;
    private JPasswordField pfPassword;
    private JButton button1;
    private JLabel lError;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
