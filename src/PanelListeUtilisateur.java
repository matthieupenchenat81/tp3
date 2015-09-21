import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.TableModel;

public class PanelListeUtilisateur extends JPanel {
	private JTable table;
	private TableModel t;

	/**
	 * Create the panel.
	 */
	public PanelListeUtilisateur(TableModel tableModel) {
		setLayout(null);
		t = tableModel;
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(429, 6, 15, 288);
		add(scrollBar);
		
		table = new JTable();
		table.setModel(t);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setShowGrid(false);
		table.setBounds(6, 6, 438, 288);
		add(table);

	}
}
