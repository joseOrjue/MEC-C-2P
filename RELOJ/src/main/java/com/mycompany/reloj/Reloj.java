

package com.mycompany.reloj;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.Timer;

public class Reloj extends JFrame implements ActionListener {
    private JLabel hourLabel, minuteLabel, secondLabel;
    private JButton startButton, stopButton;
    private JSlider speedSlider;
    private Timer timer;
    private int speed = 1000;

    public Reloj() {
        super("Reloj");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear etiquetas para las horas, minutos y segundos
        hourLabel = new JLabel("00");
        minuteLabel = new JLabel("00");
        secondLabel = new JLabel("00");

        // Crear botones para iniciar y detener la actualización de la hora
        startButton = new JButton("Iniciar");
        stopButton = new JButton("Detener");

        // Conectar los botones a sus respectivas funciones
        startButton.addActionListener(this);
        stopButton.addActionListener(this);

        // Crear un slider para ajustar la velocidad del temporizador
        speedSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
        speedSlider.setMajorTickSpacing(1);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.addChangeListener(e -> {
            speed = 1000 / speedSlider.getValue();
            timer.setDelay(speed);
        });

        // Crear un temporizador para actualizar la hora cada segundo
        timer = new Timer(speed, this);

        // Agregar los componentes a la ventana
        add(hourLabel);
        add(new JLabel(":"));
        add(minuteLabel);
        add(new JLabel(":"));
        add(secondLabel);
        add(startButton);
        add(stopButton);
        add(speedSlider);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            // Iniciar el temporizador
            timer.start();
        } else if (e.getSource() == stopButton) {
            // Detener el temporizador
            timer.stop();
        } else {
            // Actualizar la hora
            Calendar now = Calendar.getInstance();
            hourLabel.setText(String.format("%02d", now.get(Calendar.HOUR_OF_DAY)));
            minuteLabel.setText(String.format("%02d", now.get(Calendar.MINUTE)));
            secondLabel.setText(String.format("%02d", now.get(Calendar.SECOND)));
        }
    }

    public static void main(String[] args) {
        Reloj reloj = new Reloj ();
    }
}