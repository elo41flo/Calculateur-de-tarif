import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateurDeTarif {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculateur de Tarif");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel pagesLabel = new JLabel("Nombre de pages du site :");
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(pagesLabel, gbc);

        JTextField pagesField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(pagesField, gbc);

        JLabel heuresLabel = new JLabel("Heures passées par page :");
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(heuresLabel, gbc);

        JTextField heuresField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(heuresField, gbc);

        JLabel tauxLabel = new JLabel("Taux horaire (€) :");
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(tauxLabel, gbc);

        JTextField tauxField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(tauxField, gbc);

        JButton calculerButton = new JButton("Calculer");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        frame.add(calculerButton, gbc);

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH
        frame.add(new JScrollPane(resultArea), gbc);

        calculerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nombreDePages = Integer.parseInt(pagesField.getText());
                    double nombreDheures = Double.parseDouble(heuresField.getText());
                    double tauxHoraire = Double.parseDouble(tauxField.getText());

                    if (nombreDePages <= 0 || nombreDheures < 0 || tauxHoraire < 0) {
                        resultArea.setText("Les valeurs doivent être positives.");
                        return;
                    }

                    double nombreTotalDheures = nombreDePages * nombreDheures;
                    double prixTotal = nombreTotalDheures * tauxHoraire;

                    resultArea.setText(String.format(
                        "Votre nombre total d'heures pour %d pages est de : %.2f heures%n" +
                        "Le tarif de votre site est de : %.2f €",
                        nombreDePages, nombreTotalDheures, prixTotal
                    ));
                } catch (NumberFormatException ex) {
                    resultArea.setText("Veuillez entrer des valeurs numériques valides.");
                }
            }
        });

        frame.setVisible(true);
    }
}
