package chapter4.enterview;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class EnterView extends JDialog {
	
	private DefaultListModel<Name> model;	// Utilizada para manter os objetos Names para exibir na próxima caixa de diálogo.
	private JTextField txtFirstName = new JTextField();	
	private JTextField txtLastName = new JTextField();
	
	public EnterView(DefaultListModel<Name> model) {
		super(null, "Entre com um nome", Dialog.ModalityType.APPLICATION_MODAL);
		this.model = model;
		
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createView();
		setVisible(true);
	}

	private void createView() {
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel(new BorderLayout(0, 20));
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		panel.add(createTop(), BorderLayout.NORTH);
		panel.add(createBottom());
		
		add(panel);
	}
	
	private JPanel createTop() {
		JPanel panel = new JPanel(new GridLayout(2,1,0,10));
		
		panel.add(createLine("Nome", txtFirstName));
		panel.add(createLine("Sobrenome", txtLastName));
		
		return panel;
	}

	private JPanel createLine(String text, JTextField field) {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel(text);
		
		label.setPreferredSize(new Dimension(90, 22));
		
		panel.add(label, BorderLayout.WEST);
		panel.add(field);
		
		return panel;
	}

	private JPanel createBottom() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		panel.add(createButton("OK", 90, 25, this::ok));
		panel.add(createSpace());
		panel.add(createButton("Close", 90, 25, this::close));
		
		return panel;
	}
	
	private JButton createButton(String text, int width, int height, ActionListener listener) {
		JButton cmd = new JButton(text);
		
		cmd.setPreferredSize(new Dimension(width, height));
		cmd.addActionListener(listener);
		
		return cmd;
	}
	
	private JLabel createSpace() {
		JLabel label = new JLabel();
		
		label.setPreferredSize(new Dimension(10, 20));
		
		return label;
	}
	
	private void clear() {
		txtFirstName.setText("");
		txtLastName.setText("");
		txtFirstName.requestFocus();
	}
	
	private void ok(ActionEvent e) {
		String firstName = txtFirstName.getText().trim();
		String lastName = txtLastName.getText().trim();
		
		if (firstName.length() > 0 && lastName.length() > 0) {
			model.addElement(new Name(firstName, lastName));
			clear();
		} else {
			JOptionPane.showMessageDialog(this,
			"You must enter both first name and last name",
			"Error", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void close(ActionEvent e) {
		dispose();
	}
}
