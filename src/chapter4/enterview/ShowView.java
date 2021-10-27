package chapter4.enterview;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ShowView extends JDialog {
	
	private DefaultListModel<Name> model;
	private CloseListener listener;
	
	public ShowView(DefaultListModel<Name> model, CloseListener listener) {
		super(null, "Names", Dialog.ModalityType.MODELESS);
		this.model = model;
		this.listener = listener;
		
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new ClosingHandler());
		createView();
		setVisible(true);
	}

	private void createView() {
		setLayout(new BorderLayout());
		JPanel panel = new JPanel(new BorderLayout(0, 20));
		
		panel.setBorder(new EmptyBorder(20, 20, 20 ,20));
		panel.add(new JScrollPane(new JList<Name>(model)));
		panel.add(createBottom(), BorderLayout.SOUTH);
		
		add(panel);
	}

	private JPanel createBottom() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		panel.add(createButton("Close", 90, 25, this::close));
		
		return panel;
	}

	private JButton createButton(String text, int width, int height, ActionListener actionListener) {
		JButton button = new JButton(text);
		button.setPreferredSize(new Dimension(width, height));
		button.addActionListener(actionListener);
		
		return button;
	}
	
	private void close(ActionEvent e) {
		listener.dialogClosed();
		dispose();
	}
	
	class ClosingHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			listener.dialogClosed();
		}
	}
	
	public interface CloseListener {
		public void dialogClosed();
	}
}
