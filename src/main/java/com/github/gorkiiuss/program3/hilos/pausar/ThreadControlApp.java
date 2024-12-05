package com.github.gorkiiuss.program3.hilos.pausar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase principal que crea la interfaz gráfica y controla los hilos.
 */
public class ThreadControlApp extends JFrame {

    private JToggleButton toggleButtonWorkerThread;
    private WorkerThread workerThread;

    private JToggleButton toggleButtonNonVolatileWorkerThread;
    private NonVolatileWorkerThread nonVolatileWorkerThread;

    private JToggleButton toggleButtonNotUsingSyncWhenLockingWorkerThread;
    private NotUsingSyncWhenLockingWorkerThread notUsingSyncWhenLockingWorkerThread;

    private JToggleButton toggleButtonUsingSleepWorkingThread;
    private UsingSleepWorkingThread usingSleepWorkingThread;

    public ThreadControlApp() {
        initUI();
    }

    private void initUI() {
        // Panel para las etiquetas
        JPanel labelsPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        labelsPanel.add(createCenteredLabel("Implementación correcta"));
        labelsPanel.add(createCenteredLabel("Sin utilizar 'volatile'"));
        labelsPanel.add(createCenteredLabel("Sin sincronizar el acceso al 'lock'"));
        labelsPanel.add(createCenteredLabel("Usar 'sleep' en vez de un 'lock'"));

        // Panel para los botones
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 4, 10, 10));

        toggleButtonWorkerThread = new JToggleButton("Ejecutar");
        toggleButtonWorkerThread.addActionListener(new ButtonActionListener());

        toggleButtonNonVolatileWorkerThread = new JToggleButton("Ejecutar");
        toggleButtonNonVolatileWorkerThread.addActionListener(new ButtonActionListener());

        toggleButtonNotUsingSyncWhenLockingWorkerThread = new JToggleButton("Ejecutar");
        toggleButtonNotUsingSyncWhenLockingWorkerThread.addActionListener(new ButtonActionListener());

        toggleButtonUsingSleepWorkingThread = new JToggleButton("Ejecutar");
        toggleButtonUsingSleepWorkingThread.addActionListener(new ButtonActionListener());

        buttonsPanel.add(toggleButtonWorkerThread);
        buttonsPanel.add(toggleButtonNonVolatileWorkerThread);
        buttonsPanel.add(toggleButtonNotUsingSyncWhenLockingWorkerThread);
        buttonsPanel.add(toggleButtonUsingSleepWorkingThread);

        // Panel principal que contiene etiquetas y botones
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.add(labelsPanel, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Configuración del JFrame
        add(mainPanel);
        setTitle("Control de Hilos");
        setSize(800, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Método auxiliar para crear etiquetas centradas
    private JLabel createCenteredLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        return label;
    }

    // ActionListener para los botones
    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!(e.getSource() instanceof JToggleButton tglBtn))
                return;

            if (tglBtn.getText().equals("Ejecutar")) {
                if (tglBtn == toggleButtonWorkerThread) {
                    workerThread = new WorkerThread();
                    workerThread.start();
                } else if (tglBtn == toggleButtonNonVolatileWorkerThread) {
                    nonVolatileWorkerThread = new NonVolatileWorkerThread();
                    nonVolatileWorkerThread.start();
                } else if (tglBtn == toggleButtonNotUsingSyncWhenLockingWorkerThread) {
                    notUsingSyncWhenLockingWorkerThread = new NotUsingSyncWhenLockingWorkerThread();
                    notUsingSyncWhenLockingWorkerThread.start();
                } else if (tglBtn == toggleButtonUsingSleepWorkingThread) {
                    usingSleepWorkingThread = new UsingSleepWorkingThread();
                    usingSleepWorkingThread.start();
                }
                tglBtn.setText("Pausar");
            } else if (tglBtn.getText().equals("Pausar")) {
                if (tglBtn == toggleButtonWorkerThread) workerThread.pauseThread();
                else if (tglBtn == toggleButtonNonVolatileWorkerThread) nonVolatileWorkerThread.pauseThread();
                else if (tglBtn == toggleButtonNotUsingSyncWhenLockingWorkerThread)
                    notUsingSyncWhenLockingWorkerThread.pauseThread();
                else if (tglBtn == toggleButtonUsingSleepWorkingThread) usingSleepWorkingThread.pauseThread();
                tglBtn.setText("Continuar");
            } else if (tglBtn.getText().equals("Continuar")) {
                if (tglBtn == toggleButtonWorkerThread) workerThread.resumeThread();
                else if (tglBtn == toggleButtonNonVolatileWorkerThread) nonVolatileWorkerThread.resumeThread();
                else if (tglBtn == toggleButtonNotUsingSyncWhenLockingWorkerThread)
                    notUsingSyncWhenLockingWorkerThread.resumeThread();
                else if (tglBtn == toggleButtonUsingSleepWorkingThread) usingSleepWorkingThread.resumeThread();
                tglBtn.setText("Pausar");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ThreadControlApp app = new ThreadControlApp();
            app.setVisible(true);
        });
    }
}
