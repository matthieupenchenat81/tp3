import java.io.Serializable;

public class Personne implements Serializable
{
    // Les attributs
    protected String nom, prenom;
    protected Integer role;
    
    // Les constantes
    public static final Integer ADMINISTRATEUR=0, STATISTICIEN=1, INFIRMIER=2, PATIENT=3; // Ce sont les valeurs que peut prendre l'attribut role
    
    // Les constructeurs et méthodes
    public Personne(String nom, String prenom, Integer role) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String toString()
    {
        return nom+" "+prenom+" avec rôle "+role;
    }
}
