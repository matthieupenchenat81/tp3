import sun.java2d.Surface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by malibu on 9/17/15.
 */
public class EcouteurFenetrePrincipale implements ActionListener {

    private FenetrePrincipale f;
    private JPanel p;
    private ListeUtilisateursImpl liste;

    public EcouteurFenetrePrincipale(FenetrePrincipale f) {

        this.f = f;
        this.liste = f.getUsers();
    }
    public EcouteurFenetrePrincipale(JPanel f, ListeUtilisateursImpl l) {

        this.p = f;
        this.liste = l;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        switch (actionEvent.getActionCommand()) {
            case "Quitter":
                f.setVisible(false);
                f.dispose();
                System.exit(0);
                break;

            case "Sauvegarder":
                File file = new File("save");
                liste.sauverListe(file);
                break;

            case "Ajouter utilisateur":
                System.out.println("utilisateurs : "+ this.liste.toString());
                f.getP1().add(new AjouterUtilisateur(this.liste));
                f.validate();
                fermer(f.getP2());
                break;

            case "Supprimer utilisateur":
                f.getP2().add(new SupprimerUtilisateur(this.liste));
                f.validate();
                fermer(f.getP1());

                break;

            case "Créer":

                String prenom = ((AjouterUtilisateur)p).getPrenom();
                String nom = ((AjouterUtilisateur)p).getNom();
                String role = ((AjouterUtilisateur)p).getRole();

                if(prenom.equals("") || nom.equals(""))
                    JOptionPane.showMessageDialog(p, "Error : Empty Field");
                else {
                    Utilisateur newUser = new Utilisateur(nom, prenom, getRole(role), nom + "." + prenom, "tototo", "");
                    liste.ajouterUtilisateur(newUser);

                    System.out.println("Nouvelle liste: " + liste.toString());
                    JOptionPane.showMessageDialog(p, "Success: user created !");
                    ((AjouterUtilisateur)p).vider();
                }
                break;

            case "Supprimer":
                if(liste.liste.size() > 0) {
                    String pseudo = ((SupprimerUtilisateur)p).getLoginSelected();
                    liste.supprimerUtilisateur(liste.obtenirNumeroLigneUtilisateur(pseudo));
                    ((SupprimerUtilisateur)p).rafraichir();
                    JOptionPane.showMessageDialog(p, "Success: user deleted !");
                    if(liste.liste.size() == 0)
                        ((SupprimerUtilisateur)p).setListEmpty();
                } else {
                    ((SupprimerUtilisateur)p).setListEmpty();
                }


                break;

            default:
                System.out.println("Default");
                break;
        }
    }

    private int getRole(String s)
    {
        switch (s)
        {
            case "administrateur":
                return 0;
            case "statisticien":
                return 1;
            case "infirmier":
                return 2;
            case "patient":
                return 3;
            default:
                break;
        }
        return -1;
    }

    private void fermer(JPanel p)
    {
        p.removeAll();
        p.revalidate();
        p.repaint();
        p.validate();
    }

}
