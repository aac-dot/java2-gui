/**
 * 
 */
package chapter4.enterview;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chapter4.enterview.ShowView.CloseListener;

/**
 * @author pc1
 *
 */
@SuppressWarnings("serial")
public class MainView extends JFrame implements CloseListener {

	private DefaultListModel<Name> model = new DefaultListModel<Name>();
	private JButton cmdShow;
	
	public MainView() {
		setTitle("Dialogs");
		setSize(300, 160);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createWindow();
		setVisible(true);
	}
	private void createWindow() {
		JPanel panel = new JPanel(new GridLayout(2, 1, 0, 20));
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		panel.add(createButton("Entre com um nome", this::openEnter));
		panel.add(cmdShow = createButton("Abrir lista", this::openShow));
		
		add(panel);
	}
	
	private JButton createButton(String text, ActionListener listener) {
		JButton cmd = new JButton(text);
		cmd.addActionListener(listener);
		
		return cmd;
	}
	
	private void openEnter(ActionEvent e) {
		new EnterView(model);
	}
	
	private void openShow(ActionEvent e) {
		cmdShow.setEnabled(false);
		new ShowView(model, this);
	}

	@Override
	public void dialogClosed() {
		cmdShow.setEnabled(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MainView();

	}
	
}
