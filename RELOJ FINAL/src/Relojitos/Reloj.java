package Relojitos;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Reloj extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel horaLabel;
    private JButton iniciarButton;
    private JButton detenerButton;
    private JButton acelerarButton;
    private JButton desacelerarButton;
    private Timer timer;
    private int velocidad = 1000; // milisegundos

    public Reloj() {
        super("Reloj");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 120);
        setLayout(new FlowLayout());
        getContentPane().setBackground(new Color(240, 240, 240)); // Color de fondo

        horaLabel = new JLabel();
        horaLabel.setForeground(new Color(50, 50, 255)); // Color del texto
        add(horaLabel);

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(200, 200, 200)); // Color de fondo del panel de botones
        iniciarButton = new JButton("Iniciar");
        iniciarButton.setBackground(new Color(100, 200, 100)); // Color de fondo del botón de iniciar
        
        iniciarButton.addActionListener(this);
        panelBotones.add(iniciarButton);

        detenerButton = new JButton("Detener");
        detenerButton.setBackground(new Color(200, 100, 100)); // Color de fondo del botón de detener
        detenerButton.addActionListener(this);
        panelBotones.add(detenerButton);

        acelerarButton = new JButton("Acelerar");
        acelerarButton.setBackground(new Color(255, 200, 100)); // Color de fondo del botón de acelerar
        acelerarButton.addActionListener(this);
        panelBotones.add(acelerarButton);

        desacelerarButton = new JButton("Desacelerar");
        desacelerarButton.setBackground(new Color(255, 150, 150)); // Color de fondo del botón de desacelerar
        desacelerarButton.addActionListener(this);
        panelBotones.add(desacelerarButton);

        add(panelBotones);

        timer = new Timer(velocidad, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            horaLabel.setText(sdf.format(new Date()));
        } else if (e.getSource() == iniciarButton) {
            timer.start();
        } else if (e.getSource() == detenerButton) {
            timer.stop();
        } else if (e.getSource() == acelerarButton) {
            velocidad /= 5;
            timer.setDelay(velocidad);
        } else if (e.getSource() == desacelerarButton) {
            velocidad *= 5;
            timer.setDelay(velocidad);
        }
    }

    public static void main(String[] args) {
        Reloj reloj = new Reloj();
        reloj.setVisible(true);
    }
}