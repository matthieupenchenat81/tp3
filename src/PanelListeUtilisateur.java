import javax.swing.JPanel;
import javax.swing.JTable;

public class PanelListeUtilisateur extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelListeUtilisateur() {
		setLayout(null);
		
		table = new JTable();
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setShowGrid(false);
		table.setBounds(6, 6, 438, 288);
		add(table);

	}
}
