/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.io.File;

/**
 *
 * @author Jean-Christophe
 */
public class ProgrammePrincipal1 {

    public static void main(String[] args)
    {
        new ProgrammePrincipal1();
    }
    
    public ProgrammePrincipal1()
    {
        // Initialisation de la liste utilisateur
        ListeUtilisateursImpl users = new ListeUtilisateursImpl();

        File f = new File("save");
        if(f.exists() && !f.isDirectory()) {
            users.chargerListe(f);
        }else {
            Utilisateur u1 = new Utilisateur("Durant", "Paul", Personne.ADMINISTRATEUR, "paul.durant", "tototo", "");
            Utilisateur u2 = new Utilisateur("Dupont", "Jean", Personne.STATISTICIEN, "jean.dupont", "tototo", "paul.durant");
            users.ajouterUtilisateur(u1);
            for(int i = 0; i < 200; i++)
            	users.ajouterUtilisateur(u1);
            users.ajouterUtilisateur(u2);
        }

        // Chargement identification
        try {
            FenetreIdentification dialog = new FenetreIdentification(users);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
