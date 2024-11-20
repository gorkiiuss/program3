package com.github.gorkiiuss.program3.parcial2024.vista;

import com.github.gorkiiuss.program3.parcial2024.io.GestorCSVDeOrganismos;
import com.github.gorkiiuss.program3.parcial2024.modelo.Carnivoro;
import com.github.gorkiiuss.program3.parcial2024.modelo.Herviboro;
import com.github.gorkiiuss.program3.parcial2024.modelo.Organismo;
import com.github.gorkiiuss.program3.parcial2024.modelo.Planta;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.util.List;
import java.util.Vector;

public class ComponentesRutaVista extends JPanel {
    private final JPanel pnlArriba;
    private final JLabel lblArchivo;
    private final JTextField tfRuta;
    private final JButton btnBuscar;
    private final JPanel pnlOrganismos;
    private final OrganismosTable tblOrganismos;
    private final JPanel pnlBotonesOrganismos;
    private final JButton btnNuevo;
    private final JButton btnEditar;
    private final JButton btnEliminar;
    private final JButton btnGuardarYCerrar;

    public ComponentesRutaVista() {
        // Set the layout to BoxLayout for vertical stacking
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Initialize components
        this.pnlArriba = new JPanel(new BorderLayout(10, 10));
        this.lblArchivo = new JLabel("Archivo:");

        this.tfRuta = new JTextField("Ruta");
        this.tfRuta.setHorizontalAlignment(JTextField.CENTER);
        this.tfRuta.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tfRuta.selectAll();
            }
        });

        this.btnBuscar = new JButton("...");

        this.pnlOrganismos = new JPanel(new BorderLayout(5, 5));

        OrganismosTableModel organismosTableModel = new OrganismosTableModel();
        this.tblOrganismos = new OrganismosTable(organismosTableModel);

        this.pnlBotonesOrganismos = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        this.btnNuevo = new JButton("Nuevo");
        this.btnEditar = new JButton("Editar");
        this.btnEliminar = new JButton("Eliminar");
        this.btnGuardarYCerrar = new JButton("Guardar y cerrar");

        // Add listeners and actions
        organismosTableModel.addTableModelListener(e -> {
            if (organismosTableModel.getData().isEmpty()) {
                remove(pnlOrganismos);
            } else {
                if (getComponentZOrder(pnlOrganismos) == -1) {
                    add(pnlOrganismos);
                }
            }
            revalidate();
            repaint();
        });

        this.tfRuta.addActionListener(e -> organismosTableModel.setData(GestorCSVDeOrganismos.get().readAllFromFile(
                new File(tfRuta.getText())
        )));

        this.btnBuscar.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();

            jFileChooser.setFileFilter(new FileNameExtensionFilter("Archivo CSV", "csv"));
            jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = jFileChooser.showOpenDialog(btnBuscar);

            if (result == JFileChooser.APPROVE_OPTION) {
                File csvFile = jFileChooser.getSelectedFile();
                organismosTableModel.setData(GestorCSVDeOrganismos.get().readAllFromFile(csvFile));
                tfRuta.setText(csvFile.getAbsolutePath());
            }
        });

        this.btnNuevo.addActionListener(e -> {
            JPanel pnlOrganismo = new JPanel(new GridLayout(2, 2, 5, 5));
            JLabel lblTipo = new JLabel("Tipo");
            JComboBox<String> cbTipo = new JComboBox<>(new Vector<>(List.of(Planta.class.getSimpleName(), Herviboro.class.getSimpleName(), Carnivoro.class.getSimpleName())));
            JLabel lblNombre = new JLabel("Nombre");
            JTextField tfNombre = new JTextField();

            pnlOrganismo.add(lblTipo);
            pnlOrganismo.add(cbTipo);
            pnlOrganismo.add(lblNombre);
            pnlOrganismo.add(tfNombre);

            int result = JOptionPane.showConfirmDialog(
                    btnNuevo, pnlOrganismo, "Nuevo organismo", JOptionPane.OK_CANCEL_OPTION);

            if (result != JOptionPane.OK_OPTION || tfNombre.getText().isBlank() || cbTipo.getSelectedItem() == null)
                return;

            organismosTableModel.addOrganismo((String) cbTipo.getSelectedItem(), tfNombre.getText());
        });

        this.btnEditar.addActionListener(e -> {
            if (tblOrganismos.getSelectedRow() == -1) return;

            Organismo organismo = organismosTableModel.getData().get(tblOrganismos.getSelectedRow());

            JPanel pnlOrganismo = new JPanel(new GridLayout(1, 2, 5, 5));
            JLabel lblNombre = new JLabel("Nombre");
            JTextField tfNombre = new JTextField(organismo.getNombre());

            pnlOrganismo.add(lblNombre);
            pnlOrganismo.add(tfNombre);

            int result = JOptionPane.showConfirmDialog(
                    btnEditar, pnlOrganismo, "Editar organismo - " + organismo.getClass().getSimpleName(), JOptionPane.OK_CANCEL_OPTION);

            if (result != JOptionPane.OK_OPTION || tfNombre.getText().isBlank())
                return;

            organismo.setNombre(tfNombre.getText());
            organismosTableModel.updateOrganismo(tblOrganismos.getSelectedRow());
        });

        this.btnEliminar.addActionListener(e -> {
            if (tblOrganismos.getSelectedRow() == -1)
                return;

            int result = JOptionPane.showConfirmDialog(
                    btnEliminar,
                    "¿Estás seguro de que quieres eliminar el organismo seleccionado?",
                    "Eliminar organismo",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
            if (result == JOptionPane.OK_OPTION)
                organismosTableModel.deleteOrganismo(tblOrganismos.getSelectedRow());
        });

        btnGuardarYCerrar.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("Guardar archivo");
            jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = jFileChooser.showSaveDialog(btnGuardarYCerrar);
            if (result == JFileChooser.APPROVE_OPTION) {
                File archivo = jFileChooser.getSelectedFile();
                GestorCSVDeOrganismos.get().save(organismosTableModel.getData(), archivo);
                organismosTableModel.clear();
            }
        });

        // Assemble components
        pnlArriba.add(lblArchivo, BorderLayout.WEST);
        pnlArriba.add(tfRuta, BorderLayout.CENTER);
        pnlArriba.add(btnBuscar, BorderLayout.EAST);
        add(pnlArriba);

        // Wrap the table in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(tblOrganismos);
        pnlOrganismos.add(scrollPane, BorderLayout.CENTER);
        pnlBotonesOrganismos.add(btnNuevo);
        pnlBotonesOrganismos.add(btnEditar);
        pnlBotonesOrganismos.add(btnEliminar);
        pnlBotonesOrganismos.add(btnGuardarYCerrar);
        pnlOrganismos.add(pnlBotonesOrganismos, BorderLayout.SOUTH);

        // Only add pnlOrganismos if data is not empty
        if (!organismosTableModel.getData().isEmpty()) {
            add(pnlOrganismos);
        }
    }

    public Organismo[] getOrganismos() {
        return ((OrganismosTableModel)tblOrganismos.getModel()).getData().toArray();
    }
}
