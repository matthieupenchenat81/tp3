import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

public class FenetreIdentification extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtPseudo;
    private JPasswordField passwordField;
    private ListeUtilisateursImpl users;

    public ListeUtilisateursImpl getUsers() {
        return users;
    }

    public JTextField getTxtPseudo() {
        return txtPseudo;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public FenetreIdentification(ListeUtilisateursImpl users) {
        super();

        this.users = users;
        this.setResizable(false);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JLabel lblLogin = new JLabel("Login:");
            lblLogin.setBounds(26, 81, 80, 28);
            contentPanel.add(lblLogin);
        }
        {
            passwordField = new JPasswordField();
            passwordField.setBounds(128, 121, 268, 28);
            contentPanel.add(passwordField);
        }
        {
            JLabel lblPassword = new JLabel("Password:");
            lblPassword.setBounds(26, 121, 80, 28);
            contentPanel.add(lblPassword);
        }
        {
            txtPseudo = new JTextField();
            txtPseudo.setBounds(128, 81, 268, 28);
            contentPanel.add(txtPseudo);
            txtPseudo.setColumns(10);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("Se Connecter");
                okButton.addActionListener(new EcouteurFenetreIdentification(this, users));
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
        }
    }

}
