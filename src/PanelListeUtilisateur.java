import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class PanelListeUtilisateur extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelListeUtilisateur() {
		setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(429, 6, 15, 288);
		add(scrollBar);
		
		table = new JTable();
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setShowGrid(false);
		table.setBounds(6, 6, 438, 288);
		add(table);

	}
}
