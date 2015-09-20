import javax.rmi.CORBA.Util;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.util.List;

public class SupprimerUtilisateur extends JPanel {

	/**
	 * Create the panel.
	 */
	private ListeUtilisateursImpl li;
	private JButton btnSupprimer;

	private JComboBox comboBox;

	public SupprimerUtilisateur(ListeUtilisateursImpl li) {
		setLayout(null);

		this.li = li;
		
		comboBox = new JComboBox();
		for(Utilisateur u : li.liste)
		{
			comboBox.addItem(u.getLogin());
		}
		comboBox.setBounds(160, 59, 206, 27);
		add(comboBox);
		
		JLabel lblUtilisateur = new JLabel("Utilisateur:");

		lblUtilisateur.setBounds(67, 63, 81, 16);
		add(lblUtilisateur);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new EcouteurFenetrePrincipale(this, li));
		btnSupprimer.setBounds(249, 98, 117, 29);
		add(btnSupprimer);

		if(li.liste.size() == 0) {
			btnSupprimer.setEnabled(false);
			comboBox.setEnabled(false);
		}

	}

	public String getLoginSelected()
	{
		return comboBox.getSelectedItem().toString();
	}

	public void rafraichir()
	{
		comboBox.removeAllItems();
		for(Utilisateur u : li.liste)
		{
			comboBox.addItem(u.getLogin());
		}
	}

	public void setListEmpty()
	{
		btnSupprimer.setEnabled(false);
		comboBox.setEnabled(false);
	}
}
