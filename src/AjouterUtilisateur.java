import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AjouterUtilisateur extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public AjouterUtilisateur(ListeUtilisateursImpl li) {


		setBorder(new TitledBorder(null, "Ajout d'un utilisateur", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton btnCrer = new JButton("Créer");
		btnCrer.addActionListener(new EcouteurFenetrePrincipale(this, li));
		btnCrer.setBounds(268, 187, 117, 29);
		add(btnCrer);
		
		JLabel lblPrnom = new JLabel("Prénom:");
		lblPrnom.setBounds(46, 63, 61, 16);
		add(lblPrnom);


		JLabel lblNom = new JLabel("Nom:");
		lblNom.setBounds(46, 102, 61, 16);
		add(lblNom);
		
		JLabel lblRle = new JLabel("Rôle");
		lblRle.setBounds(46, 142, 61, 16);
		add(lblRle);
		
		textField = new JTextField();
		textField.setBounds(107, 57, 278, 38);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 96, 278, 38);
		add(textField_1);
		textField_1.setColumns(10);
		
		this.comboBox = new JComboBox();
		comboBox.addItem("administrateur");
		comboBox.addItem("statisticien");
		comboBox.addItem("infirmier");
		comboBox.addItem("patient");
		comboBox.setBounds(107, 138, 278, 37);
		add(comboBox);

	}

	public String getPrenom()
	{
		return textField.getText();
	}

	public String getNom()
	{
		return textField_1.getText();
	}
	public String getRole()
	{
		return comboBox.getSelectedItem().toString();
	}

	public void vider()
	{
		textField.setText("");
		textField_1.setText("");
		comboBox.setSelectedItem("administrateur");
	}


}
