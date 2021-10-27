/**
 * 
 */
package chapter3.textcolor;

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
public class MainWindow extends JFrame {
	public MainWindow() {
		setTitle("Fonts and Color");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		createWindow();
		setVisible(true);
	}

	private void createWindow() {
		add(createLabel("North", Color.blue, Color.white, new Font("Liberation Serif", Font.PLAIN, 24), 0, 30), BorderLayout.NORTH);
		add(createLabel("South", Color.green, Color.black, new Font("Liberation Serif", Font.BOLD, 36), 0, 50), BorderLayout.SOUTH);
		add(createLabel("West", Color.magenta, Color.black, new Font("Liberation Serif", Font.ITALIC, 18), 60, 0), BorderLayout.WEST);
		add(createLabel("East", Color.red, Color.white, new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 24), 60, 0), BorderLayout.EAST);
		add(createLabel("Center", new Color(240,240,240), Color.pink, new Font("Liberation Serif", Font.BOLD, 96), 0, 0), BorderLayout.CENTER);
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
		new MainWindow();
	}
}
