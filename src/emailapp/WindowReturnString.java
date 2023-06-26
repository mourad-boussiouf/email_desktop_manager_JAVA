package emailapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowReturnString extends JFrame {

    private String outputValue;
    private JTextField textField;

    public String FormWindow() {
        setTitle("Secteur de profession");

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        textField = new JTextField(10);
        panel.add(textField);

        JButton button = new JButton("Envoyer");
        panel.add(button);

        JLabel descriptionLabel1 = new JLabel("Entrez le secteur de profession de l'employé");
        JLabel descriptionLabel2 = new JLabel("\\ \n1 pour Sales");
        JLabel descriptionLabel3 = new JLabel("\\ \n2 pour Développement");
        JLabel descriptionLabel4 = new JLabel("\\ \n3 pour Comptabilité");

        panel.add(descriptionLabel1);
        panel.add(descriptionLabel2);
        panel.add(descriptionLabel3);
        panel.add(descriptionLabel4);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputValue = textField.getText();

                System.out.println("Input value: " + outputValue);
                dispose();
            }
        });

        getContentPane().add(panel);

        setVisible(true);

        while (isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return outputValue;
    }
}
