package com.github.gorkiiuss.program3.parcial2024.vista;

import com.github.gorkiiuss.program3.utils.PositiveIntegerField;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ParametrosVista extends JPanel {
    private static final String TXT_ECOSISTEMAS = "Número de ecosistemas para crear: ";
    private static final String TXT_ORGANISMOS = "Número de organismos para crear: ";

    private final JLabel lblImagenEcosistema;
    private final JPanel pnlCentro;
    private final JLabel lblEcosistemas;
    private final JLabel lblOrganismos;
    private final JPanel pnlEste;
    private final PositiveIntegerField pifEcosistemas;
    private final PositiveIntegerField pifOrganismos;

    private int ecosistemas;
    private int organismos;

    public ParametrosVista() {
        super(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblImagenEcosistema = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("/parcial2024/ecosistemas.jpeg"))));

        // Configurar pnlCentro con GridBagLayout
        pnlCentro = new JPanel(new GridBagLayout());
        GridBagConstraints gbcCentro = new GridBagConstraints();
        gbcCentro.insets = new Insets(5, 5, 5, 5);
        gbcCentro.fill = GridBagConstraints.HORIZONTAL;

        lblEcosistemas = new JLabel();
        lblOrganismos = new JLabel();

        gbcCentro.gridx = 0;
        gbcCentro.gridy = 0;
        gbcCentro.weightx = 1.0;
        pnlCentro.add(lblEcosistemas, gbcCentro);

        gbcCentro.gridy = 1;
        pnlCentro.add(new JSeparator(), gbcCentro);

        gbcCentro.gridy = 2;
        pnlCentro.add(lblOrganismos, gbcCentro);

        // Configurar pnlEste con GridBagLayout
        pnlEste = new JPanel(new GridBagLayout());
        GridBagConstraints gbcEste = new GridBagConstraints();
        gbcEste.insets = new Insets(5, 5, 5, 5);
        gbcEste.fill = GridBagConstraints.HORIZONTAL;

        pifEcosistemas = new PositiveIntegerField(10); // 10 columnas
        pifEcosistemas.addActionListener(e -> setEcosistemas(pifEcosistemas.getInteger()));

        pifOrganismos = new PositiveIntegerField(10); // 10 columnas
        pifOrganismos.addActionListener(e -> setOrganismos(pifOrganismos.getInteger()));

        gbcEste.gridx = 0;
        gbcEste.gridy = 0;
        gbcEste.weightx = 1.0;
        pnlEste.add(pifEcosistemas, gbcEste);

        gbcEste.gridy = 1;
        pnlEste.add(new JSeparator(), gbcEste);

        gbcEste.gridy = 2;
        pnlEste.add(pifOrganismos, gbcEste);

        // Agregar componentes al panel principal
        add(lblImagenEcosistema, BorderLayout.WEST);
        add(pnlCentro, BorderLayout.CENTER);
        add(pnlEste, BorderLayout.EAST);

        setEcosistemas(0);
        setOrganismos(0);
    }

    public int getEcosistemas() {
        return ecosistemas;
    }

    public void setEcosistemas(int ecosistemas) {
        this.ecosistemas = ecosistemas;
        this.lblEcosistemas.setText(TXT_ECOSISTEMAS + ecosistemas);
    }

    public int getOrganismos() {
        return organismos;
    }

    public void setOrganismos(int organismos) {
        this.organismos = organismos;
        this.lblOrganismos.setText(TXT_ORGANISMOS + organismos);
    }
}
