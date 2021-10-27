package exercises;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainWindowExercise extends JFrame {

	private JTextField txtName = new JTextField();
	private JButton cmdAdd = new JButton( "Adicionar" );
	private JButton cmdClr = new JButton( "Limpar" );
	private JButton cmdCount = new JButton("Contar");
	
	private JList lstNames;
	private DefaultListModel model = new DefaultListModel();
	
	public MainWindowExercise() {
		setTitle("Hello Swing");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addListeners();
		createWindow();
		setVisible(true);
	}
	
	private void createWindow() {
		/*add(createLabel(), BorderLayout.NORTH);
		add(createLabel(), BorderLayout.WEST);
		add(createLabel(), BorderLayout.EAST);
		add(createLabel(), BorderLayout.SOUTH);
		*/
		JPanel panel = new JPanel(new BorderLayout(0 ,10));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.add(createTop(), BorderLayout.NORTH);
		panel.add(createCenter());
		panel.add(createBottom(), BorderLayout.SOUTH);
		
		add(panel);
		
	}

	private void addListeners() {
		cmdAdd.addActionListener(new AddAction());
		cmdClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choose = JOptionPane.showConfirmDialog(MainWindowExercise.this, "Você realmente deseja excluir a lista?",
						"Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
				if (choose == JOptionPane.YES_OPTION) {
					model.clear();
				}
			}
		});
		cmdCount.addActionListener(new countAction());
	}

	private JPanel createBottom() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel.add(cmdClr);
		panel.add(cmdCount);
		return panel;
	}

	private JPanel createCenter() {
		lstNames = new JList(model);
		JPanel panel = new JPanel(new BorderLayout());
		/*
		panel.add(createLabel(), BorderLayout.NORTH);
		panel.add(createLabel(), BorderLayout.SOUTH);
		*/
		panel.add(new JScrollPane(lstNames));
		
		return panel;
	}

	private JPanel createTop() {
		JPanel panel = new JPanel(new BorderLayout(10, 10));
		JLabel label = new JLabel("Entre com um nome");
		
		panel.add(label, BorderLayout.WEST);
		panel.add(cmdAdd, BorderLayout.EAST);
		
		panel.add(txtName);
		
		return panel;
	}
	/*
	private JLabel createLabel() {
		JLabel label = new JLabel("");
		label.setPreferredSize(new Dimension(10, 10));
		return label;
	}
	*/
	class AddAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = txtName.getText().trim();
			
			if (name.length() > 0) {
				model.addElement(name);
				txtName.setText("");
				txtName.requestFocus();
			}
		}
	}
	
	class countAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(MainWindowExercise.this, "Você entrou com " + model.getSize() + " nomes", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}
	
	public static void main(String[] args) {
		new MainWindowExercise().setVisible(true);

	}
}