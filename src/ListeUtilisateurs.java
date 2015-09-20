import java.io.File;

interface ListeUtilisateurs 
// Liste d'Utilisateur. Les éléments seront indicés à partir de 0
{
	void ajouterUtilisateur(Utilisateur u); // Ajoute un utilisateur à la liste
	Utilisateur obtenirUtilisateur(int numeroLigne); // Retourne l'utilisateur d'indice numeroLigne
	void supprimerUtilisateur(int numeroLigne);      // Supprime l'utilisateur d'indice numeroLigne
	int obtenirNumeroLigneUtilisateur(String login); // Recherche le numéro de ligne d'un utilisateur à partir du login
	void modifierUtilisateur(int numeroLigne, Utilisateur u); // Remplace l'utilisateur en ligne numeroLigne par u
	boolean verifierIdentite(String login, String password);  // Vérifie que l'utilisateur login existe et que c'est bien son login
	int nbUtilisateurs();                           // Retourne le nombre d'utilisateurs
        
        void sauverListe(File f);      // Sérialise la liste dans le fichier pointé par f (les exceptions seront traitée et non propagées)
        void chargerListe(File f);     // Désérialise la liste dans le fichier pointé par f (les exceptions seront traitée et non propagées)
}
