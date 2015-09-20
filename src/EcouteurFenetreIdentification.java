import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurFenetreIdentification implements ActionListener {

    private JTextField pseudo;
    private JPasswordField password;
    private ListeUtilisateursImpl users;
    private FenetreIdentification login;

    public ListeUtilisateursImpl getUsers() {
        return users;
    }

    public String getPseudo() {
        return pseudo.getText();
    }

    public String getPassword() {
        return new String(password.getPassword());
    }

    public EcouteurFenetreIdentification(FenetreIdentification f, ListeUtilisateursImpl users) {
        this.users = users;
        this.pseudo = f.getTxtPseudo();
        this.password = f.getPasswordField();
        this.login = f;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        System.out.print(users.obtenirUtilisateur(0));
        System.out.println(getPseudo() + " " + getPassword());
        if (users.verifierIdentite(getPseudo(), getPassword())) {
            System.out.println("OK");
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        FenetrePrincipale frame = new FenetrePrincipale(getPseudo(), users);
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            this.login.setVisible(false);
        } else {
            System.out.println("NOK");
            JOptionPane.showMessageDialog(login, "Invalid credentials, try again please.");
        }
    }
}
