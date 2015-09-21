import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;


public class FenetrePrincipale extends JFrame {

    private JPanel contentPane;
    private ListeUtilisateursImpl users;
    private Utilisateur loggedUser;
    private JPanel panel_1, panel_2;

    public JPanel getP1() {
        return panel_1;
    }

    public JPanel getP2() {
        return panel_2;
    }

    /**
     * Create the frame.
     */
    public FenetrePrincipale(String login, ListeUtilisateursImpl users) {
        super();

        this.users = users;
        this.loggedUser = users.obtenirUtilisateur(users.obtenirNumeroLigneUtilisateur(login));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(20,50, 1300, 600);
        setResizable(false);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFichier = new JMenu("Fichier");
        menuBar.add(mnFichier);

        JMenuItem mntmNomPrenom = new JMenuItem(loggedUser.getNom() + " " + loggedUser.getPrenom());
        mntmNomPrenom.setEnabled(false);
        mnFichier.add(mntmNomPrenom);

        JMenuItem mntmSauvegarder = new JMenuItem("Sauvegarder");
        mntmSauvegarder.addActionListener(new EcouteurFenetrePrincipale(this));
        mnFichier.add(mntmSauvegarder);

        JMenuItem mntmQuitter = new JMenuItem("Quitter");
        mntmQuitter.addActionListener(new EcouteurFenetrePrincipale(this));
        
        JMenuItem mntmListeUtilisateurs = new JMenuItem("Liste Utilisateurs");
        mnFichier.add(mntmListeUtilisateurs);
        mnFichier.add(mntmQuitter);

        JMenu mnGestion = new JMenu("Gestion");
        menuBar.add(mnGestion);

        JMenuItem mntmAjouter = new JMenuItem("Ajouter utilisateur");
        mntmAjouter.addActionListener(new EcouteurFenetrePrincipale(this));
        mnGestion.add(mntmAjouter);

        JMenuItem mntmSupprimer = new JMenuItem("Supprimer utilisateur");
        mntmSupprimer.addActionListener(new EcouteurFenetrePrincipale(this));
        mnGestion.add(mntmSupprimer);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(2, 3, 0, 0));

        this.panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "P1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        this.panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(null, "P2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.add(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new TitledBorder(null, "P3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.add(panel_3);
        panel_3.setLayout(new BorderLayout(0, 0));

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new TitledBorder(null, "P3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.add(panel_4);
        panel_4.setLayout(new BorderLayout(0, 0));

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(null, "P5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.add(panel_5);
        panel_5.setLayout(new BorderLayout(0, 0));

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new TitledBorder(null, "P6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.add(panel_6);
        panel_6.setLayout(new BorderLayout(0, 0));
    }

    public ListeUtilisateursImpl getUsers()
    {
        return this.users;
    }

}
