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

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create the text field
        textField = new JTextField(10);
        panel.add(textField);

        // Create the button
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

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputValue = textField.getText();

                // Perform any operations with the string value here
                System.out.println("Input value: " + outputValue);
                dispose();
            }
        });

        // Add the panel to the content pane
        getContentPane().add(panel);

        // Make the frame visible
        setVisible(true);

        // Wait until the frame is closed
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