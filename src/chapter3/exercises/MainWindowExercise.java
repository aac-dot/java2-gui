/**
 * 
 */
package chapter3.exercises;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author pc1
 *
 */
public class MainWindowExercise extends JFrame {
	public MainWindowExercise() {
		setTitle("Fonts and Color");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		createWindow();
		setVisible(true);
	}

	private void createWindow() {
		add(createLabel("North", Color.blue, Color.white, new Font("Liberation Sans", Font.BOLD, 16), 0, 30), BorderLayout.NORTH);
		add(createLabel("South", Color.black, Color.green, new Font("Liberation Serif", Font.BOLD, 36), 0, 50), BorderLayout.SOUTH);
		add(createLabel("West", Color.magenta, Color.black, new Font("Liberation Serif", Font.ITALIC, 48), 100, 0), BorderLayout.WEST);
		add(createLabel("East", Color.red, Color.yellow, new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 24), 60, 0), BorderLayout.EAST);
		add(createLabel("Center", Color.DARK_GRAY, Color.gray, new Font("Liberation Serif", Font.BOLD, 96), 0, 0), BorderLayout.CENTER);
	}

	private JLabel createLabel(String text, Color bg, Color fg, Font font, int width, int height) {
		JLabel label = new JLabel(text);
		label.setOpaque(true);
		label.setBackground(bg);
		label.setForeground(fg);
		label.setFont(font);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setPreferredSize(new Dimension(width, height));
		
		return label;
	}
	
	public static void main(String args[] ) {
		new MainWindowExercise();
	}
}
