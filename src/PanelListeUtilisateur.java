import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.*;

public class PanelListeUtilisateur extends JPanel {
	private TableModel t;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelListeUtilisateur(TableModel tableModel) {
		t = tableModel;
		setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 450, 300);
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(t);
		table.setCellSelectionEnabled(true);
		table.setShowGrid(false);
		table.setShowVerticalLines(false);
		
		scrollPane.setViewportView(table);

	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		return true;
	}
}
