import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateurDeTarif {
    public static void main(String[] args) {
        // Créer la fenêtre principale
        JFrame frame = new JFrame("Calculateur de Tarif");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Créer les composants de l'interface
        JLabel pagesLabel = new JLabel("Nombre de pages du site :");
        pagesLabel.setBounds(20, 20, 200, 25);
        frame.add(pagesLabel);

        JTextField pagesField = new JTextField();
        pagesField.setBounds(220, 20, 150, 25);
        frame.add(pagesField);

        JLabel heuresLabel = new JLabel("Heures passées par page :");
        heuresLabel.setBounds(20, 60, 200, 25);
        frame.add(heuresLabel);

        JTextField heuresField = new JTextField();
        heuresField.setBounds(220, 60, 150, 25);
        frame.add(heuresField);

        JLabel tauxLabel = new JLabel("Taux horaire (€) :");
        tauxLabel.setBounds(20, 100, 200, 25);
        frame.add(tauxLabel);

        JTextField tauxField = new JTextField();
        tauxField.setBounds(220, 100, 150, 25);
        frame.add(tauxField);

        JButton calculerButton = new JButton("Calculer");
        calculerButton.setBounds(150, 140, 100, 30);
        frame.add(calculerButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(20, 180, 350, 70);
        resultArea.setEditable(false);
        frame.add(resultArea);

        // Ajouter un ActionListener au bouton
        calculerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Lire les entrées utilisateur
                    int nombreDePages = Integer.parseInt(pagesField.getText());
                    double nombreDheures = Double.parseDouble(heuresField.getText());
                    double tauxHoraire = Double.parseDouble(tauxField.getText());

                    if (nombreDePages <= 0 || nombreDheures < 0 || tauxHoraire < 0) {
                        resultArea.setText("Les valeurs doivent être positives.");
                        return;
                    }

                    // Calculer le nombre total d'heures
                    double nombreTotalDheures = nombreDePages * nombreDheures;

                    // Calculer le prix total
                    double prixTotal = nombreTotalDheures * tauxHoraire;

                    // Afficher les résultats
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

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}