/*
 * Created by JFormDesigner on Sat Sep 28 14:22:44 BOT 2024
 */

package tech.icei.form;

import tech.icei.model.Usuario;

import java.awt.*;
import java.awt.event.*;
import javax.smartcardio.Card;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author jsanabria
 */
public class FormCrud extends JFrame {
    private Usuario usuarioCRUD;
    public FormCrud(Usuario usuario) {
        this.usuarioCRUD = usuario;
        initComponents();
        labelUser.setText(usuarioCRUD.getUsername());
    }

    private void mostrarPanelListar(ActionEvent e) {
        ((CardLayout) containerPanel.getLayout()).show(containerPanel, "listar");
    }

    private void mostrarPanelAdicionar(ActionEvent e) {
        ((CardLayout) containerPanel.getLayout()).show(containerPanel, "adicionar");
    }

    private void mostrarPanelEditar(ActionEvent e) {
        ((CardLayout) containerPanel.getLayout()).show(containerPanel, "editar");
    }

    private void mostrarPanelEliminar(ActionEvent e) {
        ((CardLayout) containerPanel.getLayout()).show(containerPanel, "eliminar");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jose
        menuLibreria = new JMenuBar();
        menuArchivo = new JMenu();
        menuItemImprimir = new JMenuItem();
        menuItemSalir = new JMenuItem();
        menuCrud = new JMenu();
        menuItemListar = new JMenuItem();
        menuItemAdicionar = new JMenuItem();
        menuItemEditar = new JMenuItem();
        menuItemEliminar = new JMenuItem();
        menuAyuda = new JMenu();
        menuItemAcerca = new JMenuItem();
        toolBarLibreria = new JToolBar();
        buttonListar = new JButton();
        buttonAdicionar = new JButton();
        buttonEditar = new JButton();
        buttonEliminar = new JButton();
        containerPanel = new JPanel();
        panelPrincipal = new JPanel();
        labelBienvenida = new JLabel();
        labelUser = new JLabel();
        panelListar = new JPanel();
        panelAdicionar = new JPanel();
        panelEditar = new JPanel();
        panelEliminar = new JPanel();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/assets/libreria_icon.png")).getImage());
        setVisible(true);
        setTitle("Form CRUD");
        var contentPane = getContentPane();

        //======== menuLibreria ========
        {

            //======== menuArchivo ========
            {
                menuArchivo.setText("Archivo");
                menuArchivo.setMnemonic('A');

                //---- menuItemImprimir ----
                menuItemImprimir.setText("Imprimir");
                menuArchivo.add(menuItemImprimir);
                menuArchivo.addSeparator();

                //---- menuItemSalir ----
                menuItemSalir.setText("Salir");
                menuArchivo.add(menuItemSalir);
            }
            menuLibreria.add(menuArchivo);

            //======== menuCrud ========
            {
                menuCrud.setText("Crud");
                menuCrud.setMnemonic('C');

                //---- menuItemListar ----
                menuItemListar.setText("Listar");
                menuItemListar.setIcon(new ImageIcon(getClass().getResource("/assets/search_icon_16.png")));
                menuItemListar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));
                menuItemListar.addActionListener(e -> mostrarPanelListar(e));
                menuCrud.add(menuItemListar);
                menuCrud.addSeparator();

                //---- menuItemAdicionar ----
                menuItemAdicionar.setText("Adicionar");
                menuItemAdicionar.setIcon(new ImageIcon(getClass().getResource("/assets/new_icon_16.png")));
                menuItemAdicionar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
                menuItemAdicionar.addActionListener(e -> mostrarPanelAdicionar(e));
                menuCrud.add(menuItemAdicionar);

                //---- menuItemEditar ----
                menuItemEditar.setText("Editar");
                menuItemEditar.setIcon(new ImageIcon(getClass().getResource("/assets/edit_icon_16.png")));
                menuItemEditar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
                menuItemEditar.addActionListener(e -> mostrarPanelEditar(e));
                menuCrud.add(menuItemEditar);

                //---- menuItemEliminar ----
                menuItemEliminar.setText("Eliminar");
                menuItemEliminar.setIcon(new ImageIcon(getClass().getResource("/assets/delete_icon_16.png")));
                menuItemEliminar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
                menuItemEliminar.addActionListener(e -> mostrarPanelEliminar(e));
                menuCrud.add(menuItemEliminar);
            }
            menuLibreria.add(menuCrud);

            //======== menuAyuda ========
            {
                menuAyuda.setText("Ayuda");
                menuAyuda.setMnemonic('U');

                //---- menuItemAcerca ----
                menuItemAcerca.setText("Acerca de ...");
                menuAyuda.add(menuItemAcerca);
            }
            menuLibreria.add(menuAyuda);
        }
        setJMenuBar(menuLibreria);

        //======== toolBarLibreria ========
        {

            //---- buttonListar ----
            buttonListar.setIcon(new ImageIcon(getClass().getResource("/assets/search_icon_32.png")));
            buttonListar.setMaximumSize(new Dimension(38, 38));
            buttonListar.setMinimumSize(new Dimension(38, 38));
            buttonListar.setPreferredSize(new Dimension(38, 38));
            buttonListar.addActionListener(e -> mostrarPanelListar(e));
            toolBarLibreria.add(buttonListar);
            toolBarLibreria.addSeparator();

            //---- buttonAdicionar ----
            buttonAdicionar.setIcon(new ImageIcon(getClass().getResource("/assets/new_icon_32.png")));
            buttonAdicionar.setMaximumSize(new Dimension(38, 38));
            buttonAdicionar.setMinimumSize(new Dimension(38, 38));
            buttonAdicionar.setPreferredSize(new Dimension(38, 38));
            buttonAdicionar.addActionListener(e -> mostrarPanelAdicionar(e));
            toolBarLibreria.add(buttonAdicionar);
            toolBarLibreria.addSeparator();

            //---- buttonEditar ----
            buttonEditar.setIcon(new ImageIcon(getClass().getResource("/assets/edit_icon_32.png")));
            buttonEditar.setMaximumSize(new Dimension(38, 38));
            buttonEditar.setMinimumSize(new Dimension(38, 38));
            buttonEditar.setPreferredSize(new Dimension(38, 38));
            buttonEditar.addActionListener(e -> mostrarPanelEditar(e));
            toolBarLibreria.add(buttonEditar);
            toolBarLibreria.addSeparator();

            //---- buttonEliminar ----
            buttonEliminar.setIcon(new ImageIcon(getClass().getResource("/assets/delete_icon_32.png")));
            buttonEliminar.setMaximumSize(new Dimension(38, 38));
            buttonEliminar.setMinimumSize(new Dimension(38, 38));
            buttonEliminar.setPreferredSize(new Dimension(38, 38));
            buttonEliminar.addActionListener(e -> mostrarPanelEliminar(e));
            toolBarLibreria.add(buttonEliminar);
        }

        //======== containerPanel ========
        {
            containerPanel.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder ( 0
            , 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM
            , new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,
            containerPanel. getBorder () ) ); containerPanel. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
            containerPanel.setLayout(new CardLayout());

            //======== panelPrincipal ========
            {

                //---- labelBienvenida ----
                labelBienvenida.setText("Bienvenido(a)");
                labelBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
                labelBienvenida.setFont(new Font("Roboto Thin", Font.BOLD, 36));

                //---- labelUser ----
                labelUser.setHorizontalAlignment(SwingConstants.CENTER);
                labelUser.setFont(new Font("Roboto", Font.PLAIN, 22));

                GroupLayout panelPrincipalLayout = new GroupLayout(panelPrincipal);
                panelPrincipal.setLayout(panelPrincipalLayout);
                panelPrincipalLayout.setHorizontalGroup(
                    panelPrincipalLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                            .addContainerGap(105, Short.MAX_VALUE)
                            .addGroup(panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelBienvenida, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                                .addGroup(panelPrincipalLayout.createSequentialGroup()
                                    .addGap(106, 106, 106)
                                    .addComponent(labelUser, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)))
                            .addGap(189, 189, 189))
                );
                panelPrincipalLayout.setVerticalGroup(
                    panelPrincipalLayout.createParallelGroup()
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addGap(81, 81, 81)
                            .addComponent(labelBienvenida)
                            .addGap(64, 64, 64)
                            .addComponent(labelUser, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(252, Short.MAX_VALUE))
                );
            }
            containerPanel.add(panelPrincipal, "principal");

            //======== panelListar ========
            {
                panelListar.setBackground(new Color(0x999999));

                GroupLayout panelListarLayout = new GroupLayout(panelListar);
                panelListar.setLayout(panelListarLayout);
                panelListarLayout.setHorizontalGroup(
                    panelListarLayout.createParallelGroup()
                        .addGap(0, 696, Short.MAX_VALUE)
                );
                panelListarLayout.setVerticalGroup(
                    panelListarLayout.createParallelGroup()
                        .addGap(0, 493, Short.MAX_VALUE)
                );
            }
            containerPanel.add(panelListar, "listar");

            //======== panelAdicionar ========
            {
                panelAdicionar.setBackground(new Color(0x009933));

                GroupLayout panelAdicionarLayout = new GroupLayout(panelAdicionar);
                panelAdicionar.setLayout(panelAdicionarLayout);
                panelAdicionarLayout.setHorizontalGroup(
                    panelAdicionarLayout.createParallelGroup()
                        .addGap(0, 696, Short.MAX_VALUE)
                );
                panelAdicionarLayout.setVerticalGroup(
                    panelAdicionarLayout.createParallelGroup()
                        .addGap(0, 493, Short.MAX_VALUE)
                );
            }
            containerPanel.add(panelAdicionar, "adicionar");

            //======== panelEditar ========
            {
                panelEditar.setBackground(new Color(0x0066cc));

                GroupLayout panelEditarLayout = new GroupLayout(panelEditar);
                panelEditar.setLayout(panelEditarLayout);
                panelEditarLayout.setHorizontalGroup(
                    panelEditarLayout.createParallelGroup()
                        .addGap(0, 696, Short.MAX_VALUE)
                );
                panelEditarLayout.setVerticalGroup(
                    panelEditarLayout.createParallelGroup()
                        .addGap(0, 493, Short.MAX_VALUE)
                );
            }
            containerPanel.add(panelEditar, "editar");

            //======== panelEliminar ========
            {
                panelEliminar.setBackground(new Color(0xff3333));

                GroupLayout panelEliminarLayout = new GroupLayout(panelEliminar);
                panelEliminar.setLayout(panelEliminarLayout);
                panelEliminarLayout.setHorizontalGroup(
                    panelEliminarLayout.createParallelGroup()
                        .addGap(0, 696, Short.MAX_VALUE)
                );
                panelEliminarLayout.setVerticalGroup(
                    panelEliminarLayout.createParallelGroup()
                        .addGap(0, 493, Short.MAX_VALUE)
                );
            }
            containerPanel.add(panelEliminar, "eliminar");
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(toolBarLibreria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(containerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(toolBarLibreria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(containerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jose
    private JMenuBar menuLibreria;
    private JMenu menuArchivo;
    private JMenuItem menuItemImprimir;
    private JMenuItem menuItemSalir;
    private JMenu menuCrud;
    private JMenuItem menuItemListar;
    private JMenuItem menuItemAdicionar;
    private JMenuItem menuItemEditar;
    private JMenuItem menuItemEliminar;
    private JMenu menuAyuda;
    private JMenuItem menuItemAcerca;
    private JToolBar toolBarLibreria;
    private JButton buttonListar;
    private JButton buttonAdicionar;
    private JButton buttonEditar;
    private JButton buttonEliminar;
    private JPanel containerPanel;
    private JPanel panelPrincipal;
    private JLabel labelBienvenida;
    private JLabel labelUser;
    private JPanel panelListar;
    private JPanel panelAdicionar;
    private JPanel panelEditar;
    private JPanel panelEliminar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
