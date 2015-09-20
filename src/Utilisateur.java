import java.io.Serializable;

public class Utilisateur extends Personne implements Serializable
{
    // Attributs supplémentaires
    protected String login, password, loginSuperieur;
    
    // Constructeur et méthodes
    public Utilisateur(String nom, String prenom, Integer role, String login, String password, String loginSuperieur) {
        super(nom,prenom,role);
        this.login = login;
        this.password = password;
        this.loginSuperieur = loginSuperieur;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean checkPassword(String password) {
        return password.equals(this.password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginSuperieur() {
        return loginSuperieur;
    }

    public void setLoginSuperieur(String loginSuperieur) {
        this.loginSuperieur = loginSuperieur;
    }
}
