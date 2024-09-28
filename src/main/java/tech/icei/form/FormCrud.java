/*
 * Created by JFormDesigner on Sat Sep 28 14:22:44 BOT 2024
 */

package tech.icei.form;

import org.hibernate.SessionFactory;
import tech.icei.dao.LibroDAO;
import tech.icei.model.Autor;
import tech.icei.model.Editorial;
import tech.icei.model.Libro;
import tech.icei.model.Usuario;
import tech.icei.service.LibroService;
import tech.icei.service.LibroServiceImpl;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.smartcardio.Card;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

/**
 * @author jsanabria
 */
public class FormCrud extends JFrame {
    private SessionFactory factory;
    private Usuario usuarioCRUD;
    private LibroService libroService;

    private DefaultTableModel model;
    private String columnNames[] = {"Código", "Título", "Autor", "# páginas", "Editorial"};

    private List<Autor> autoresForm;
    private List<Editorial> editorialesForm;

    public FormCrud(SessionFactory factory, Usuario usuario) {
        this.factory = factory;
        this.usuarioCRUD = usuario;
        libroService = new LibroServiceImpl(factory);
        initComponents();
        labelUser.setText(usuarioCRUD.getUsername());
    }

    private void mostrarPanelListar(ActionEvent e) {
        ((CardLayout) containerPanel.getLayout()).show(containerPanel, "listar");
        listarLibros();
    }

    private void listarLibros() {
        model = new DefaultTableModel(null, columnNames);
        libroService.obtenerLibros()
                .forEach(libro -> {
                    Object[] filaLibro = new Object[columnNames.length];
                    filaLibro[0] = libro.getCodLibro();
                    filaLibro[1] = libro.getTitulo();
                    filaLibro[2] = libro.getAutor().getNombreAutor().concat(" ")
                            .concat(libro.getAutor().getApellidoAutor());
                    filaLibro[3] = libro.getNumeroPaginas();
                    filaLibro[4] = libro.getEditorial().getNombre();
                    model.addRow(filaLibro);
                });
        tableLibros.setModel(model);
    }

    private void mostrarPanelAdicionar(ActionEvent e) {
        ((CardLayout) containerPanel.getLayout()).show(containerPanel, "adicionar");
        adicionarLibro();
    }

    private void adicionarLibro() {
        tfCodigo.setText(nuevoCodigoLibro());
        llenarAutores();
        llenarEditoriales();
    }

    public String nuevoCodigoLibro() {
        String lastCode = libroService.obtenerLibros()
                .stream()
                .sorted(Comparator.comparing(Libro::getCodLibro).reversed())
                .map(Libro::getCodLibro).findFirst().get();
        String lastValue = lastCode.substring(lastCode.indexOf("-") + 1);
        String newCode = "L-" + String.format("%04d", (Integer.valueOf(lastValue) + 1));
        return newCode;
    }

    private void llenarAutores() {
        autoresForm = new ArrayList<>();
        autoresForm = libroService.obtenerAutores();

        autoresForm.forEach(autor -> {
            cbAutores.addItem(autor.getNombreAutor() + " " + autor.getApellidoAutor());
        });
    }

    private void llenarEditoriales() {
        editorialesForm = new ArrayList<>();
        editorialesForm = libroService.obtenerEditoriales();

        editorialesForm.forEach(editorial -> {
            cbEditoriales.addItem(editorial.getNombre());
        });
    }

    private void mostrarPanelEditar(ActionEvent e) {
        ((CardLayout) containerPanel.getLayout()).show(containerPanel, "editar");
    }

    private void mostrarPanelEliminar(ActionEvent e) {
        ((CardLayout) containerPanel.getLayout()).show(containerPanel, "eliminar");
    }

    private void guardarLibro(ActionEvent e) {
        // TODO add your code here
        Libro libro = new Libro();
        libro.setCodLibro(tfCodigo.getText());
        libro.setTitulo(tfTitulo.getText());

        String itemAutor = String.valueOf(cbAutores.getSelectedItem());
        Autor autor = autoresForm
                .stream()
                .filter(l -> (l.getNombreAutor() + " " + l.getApellidoAutor()).equalsIgnoreCase(itemAutor))
                .findFirst()
                .get();
        libro.setAutor(autor);

        String itemEditorial = String.valueOf(cbEditoriales.getSelectedItem());
        Editorial editorial = editorialesForm
                .stream()
                .filter(ed -> ed.getNombre().equals(itemEditorial))
                .findFirst().get();
        libro.setEditorial(editorial);

        libro.setNumeroPaginas(Integer.parseInt(tfNroPaginas.getText()));

//        System.out.println("Item Autor --> " + itemAutor);
//        System.out.println("Item Editorial --> " + itemEditorial);
//        System.out.println("Nuevo libro --> " + libro);

        Libro libroRegistrado = libroService.guardarLibro(libro);
        System.out.println("Libro registrado :) --> " + libroRegistrado);


    }

    private void limpiar(ActionEvent e) {
        tfCodigo.setText(nuevoCodigoLibro());
        tfTitulo.setText("");
        tfNroPaginas.setText("");
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
        labelBuscar = new JLabel();
        tfBuscar = new JTextField();
        scrollPaneTabla = new JScrollPane();
        tableLibros = new JTable();
        panelAdicionar = new JPanel();
        labelTituloRegistrar = new JLabel();
        lCodigo = new JLabel();
        tfCodigo = new JTextField();
        lTitulo = new JLabel();
        tfTitulo = new JTextField();
        lAutor = new JLabel();
        cbAutores = new JComboBox();
        lEditorial = new JLabel();
        cbEditoriales = new JComboBox();
        lNroPaginas = new JLabel();
        tfNroPaginas = new JTextField();
        bGuardar = new JButton();
        bLimpiar = new JButton();
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
            containerPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0
            ,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
            ,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt.Color.red),
            containerPanel. getBorder()));containerPanel. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException();}});
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
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addContainerGap(149, Short.MAX_VALUE)
                            .addComponent(labelBienvenida, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
                            .addGap(145, 145, 145))
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addGap(198, 198, 198)
                            .addComponent(labelUser, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(202, Short.MAX_VALUE))
                );
                panelPrincipalLayout.setVerticalGroup(
                    panelPrincipalLayout.createParallelGroup()
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addComponent(labelBienvenida)
                            .addGap(18, 18, 18)
                            .addComponent(labelUser, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(300, Short.MAX_VALUE))
                );
            }
            containerPanel.add(panelPrincipal, "principal");

            //======== panelListar ========
            {

                //---- labelBuscar ----
                labelBuscar.setText("Buscar:");

                //======== scrollPaneTabla ========
                {
                    scrollPaneTabla.setViewportView(tableLibros);
                }

                GroupLayout panelListarLayout = new GroupLayout(panelListar);
                panelListar.setLayout(panelListarLayout);
                panelListarLayout.setHorizontalGroup(
                    panelListarLayout.createParallelGroup()
                        .addGroup(panelListarLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(panelListarLayout.createParallelGroup()
                                .addComponent(scrollPaneTabla, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelListarLayout.createSequentialGroup()
                                    .addComponent(labelBuscar, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfBuscar, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(46, Short.MAX_VALUE))
                );
                panelListarLayout.setVerticalGroup(
                    panelListarLayout.createParallelGroup()
                        .addGroup(panelListarLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(panelListarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelBuscar)
                                .addComponent(tfBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(43, 43, 43)
                            .addComponent(scrollPaneTabla, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(30, Short.MAX_VALUE))
                );
            }
            containerPanel.add(panelListar, "listar");

            //======== panelAdicionar ========
            {

                //---- labelTituloRegistrar ----
                labelTituloRegistrar.setText("Registro de Libro");
                labelTituloRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
                labelTituloRegistrar.setFont(new Font("Roboto", Font.BOLD, 28));

                //---- lCodigo ----
                lCodigo.setText("C\u00f3digo:");
                lCodigo.setFont(new Font("Inter", Font.PLAIN, 14));

                //---- tfCodigo ----
                tfCodigo.setEditable(false);

                //---- lTitulo ----
                lTitulo.setText("T\u00edtulo:");
                lTitulo.setFont(new Font("Inter", Font.PLAIN, 14));

                //---- lAutor ----
                lAutor.setText("Autor:");
                lAutor.setFont(new Font("Inter", Font.PLAIN, 14));

                //---- lEditorial ----
                lEditorial.setText("Editorial:");
                lEditorial.setFont(new Font("Inter", Font.PLAIN, 14));

                //---- lNroPaginas ----
                lNroPaginas.setText("N\u00b0 p\u00e1ginas:");
                lNroPaginas.setFont(new Font("Inter", Font.PLAIN, 14));

                //---- bGuardar ----
                bGuardar.setText("Guardar");
                bGuardar.addActionListener(e -> guardarLibro(e));

                //---- bLimpiar ----
                bLimpiar.setText("Limpiar");
                bLimpiar.addActionListener(e -> limpiar(e));

                GroupLayout panelAdicionarLayout = new GroupLayout(panelAdicionar);
                panelAdicionar.setLayout(panelAdicionarLayout);
                panelAdicionarLayout.setHorizontalGroup(
                    panelAdicionarLayout.createParallelGroup()
                        .addGroup(panelAdicionarLayout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addGroup(panelAdicionarLayout.createParallelGroup()
                                .addComponent(labelTituloRegistrar)
                                .addGroup(panelAdicionarLayout.createSequentialGroup()
                                    .addGroup(panelAdicionarLayout.createParallelGroup()
                                        .addComponent(lCodigo)
                                        .addComponent(lTitulo)
                                        .addComponent(lAutor)
                                        .addComponent(lEditorial))
                                    .addGap(35, 35, 35)
                                    .addGroup(panelAdicionarLayout.createParallelGroup()
                                        .addComponent(cbEditoriales, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfTitulo, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbAutores, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panelAdicionarLayout.createSequentialGroup()
                                    .addGroup(panelAdicionarLayout.createParallelGroup()
                                        .addGroup(panelAdicionarLayout.createSequentialGroup()
                                            .addComponent(lNroPaginas)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(tfNroPaginas, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                            .addGap(58, 58, 58))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panelAdicionarLayout.createSequentialGroup()
                                            .addComponent(bGuardar, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)))
                                    .addComponent(bLimpiar, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(150, Short.MAX_VALUE))
                );
                panelAdicionarLayout.setVerticalGroup(
                    panelAdicionarLayout.createParallelGroup()
                        .addGroup(panelAdicionarLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(labelTituloRegistrar)
                            .addGap(15, 15, 15)
                            .addGroup(panelAdicionarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lCodigo)
                                .addComponent(tfCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28)
                            .addGroup(panelAdicionarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lTitulo)
                                .addComponent(tfTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addGroup(panelAdicionarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lAutor)
                                .addComponent(cbAutores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25)
                            .addGroup(panelAdicionarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lEditorial)
                                .addComponent(cbEditoriales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(panelAdicionarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lNroPaginas)
                                .addComponent(tfNroPaginas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(47, 47, 47)
                            .addGroup(panelAdicionarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(bGuardar)
                                .addComponent(bLimpiar))
                            .addContainerGap(56, Short.MAX_VALUE))
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
    private JLabel labelBuscar;
    private JTextField tfBuscar;
    private JScrollPane scrollPaneTabla;
    private JTable tableLibros;
    private JPanel panelAdicionar;
    private JLabel labelTituloRegistrar;
    private JLabel lCodigo;
    private JTextField tfCodigo;
    private JLabel lTitulo;
    private JTextField tfTitulo;
    private JLabel lAutor;
    private JComboBox cbAutores;
    private JLabel lEditorial;
    private JComboBox cbEditoriales;
    private JLabel lNroPaginas;
    private JTextField tfNroPaginas;
    private JButton bGuardar;
    private JButton bLimpiar;
    private JPanel panelEditar;
    private JPanel panelEliminar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
