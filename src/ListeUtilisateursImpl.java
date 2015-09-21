/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.rmi.CORBA.Util;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jean-Christophe
 */
public class ListeUtilisateursImpl extends AbstractTableModel implements ListeUtilisateurs
{
    // Attributs
    List<Utilisateur> liste;

    // Le constructeur et les méthodes
    public ListeUtilisateursImpl() {
        liste = new ArrayList<Utilisateur>();
    }

    @Override
    public void ajouterUtilisateur(Utilisateur u) {
        liste.add(u);
    }

    @Override
    public Utilisateur obtenirUtilisateur(int numeroLigne) {
        return liste.get(numeroLigne);
    }

    @Override
    public void supprimerUtilisateur(int numeroLigne) {
        liste.remove(numeroLigne);
    }

    @Override
    public int obtenirNumeroLigneUtilisateur(String login) {
        for (int i=0; i<liste.size(); i++)
            if (liste.get(i).getLogin().equals(login))
                return i;
        
        return -1; // Bredouille
    }

    @Override
    public void modifierUtilisateur(int numeroLigne, Utilisateur u) {
        liste.set(numeroLigne, u);
    }

    @Override
    public boolean verifierIdentite(String login, String password) {
        int ligne = obtenirNumeroLigneUtilisateur(login);
        
        if (ligne>=0)
            return liste.get(ligne).checkPassword(password);
        else return false;
    }

    @Override
    public int nbUtilisateurs() {
        return liste.size();
    }

    @Override
    public void sauverListe(File f) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f, false); //  false impose de réécrire tout le fichier
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(liste);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListeUtilisateursImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListeUtilisateursImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(ListeUtilisateursImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void chargerListe(File f) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            liste = (List<Utilisateur>)(ois.readObject());
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListeUtilisateursImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListeUtilisateursImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListeUtilisateursImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ListeUtilisateursImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer();
        for(Utilisateur u: liste)
        {
            str.append(u.toString());
            str.append("\n");
        }
        return str.toString();
    }

    public int getColumnCount() {
        return 3;
    }

    public int getRowCount() {
        return liste.size();
    }

    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Login";
            case 1:
                return "Nom";
            case 2:
                return "Rôle";
        }
        return "False";
    }

    public Object getValueAt(int row, int col) {

        Utilisateur u = liste.get(row);
        switch (col) {
            case 0:
                return u.getLogin();
            case 1:
                return u.getNom();
            case 2:
                return u.getRole();
        }

        return "FALSE_GET_VALUE";
    }
}
