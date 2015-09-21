import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

public class PanelListeUtilisateur extends JPanel {
	private TableModel t;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelListeUtilisateur(TableModel tableModel) {
		t = tableModel;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 450, 300);
		add(scrollPane);
		
		table = new JTable(t);
		table.setShowGrid(false);
		table.setShowVerticalLines(false);
		scrollPane.setViewportView(table);

	}
}
