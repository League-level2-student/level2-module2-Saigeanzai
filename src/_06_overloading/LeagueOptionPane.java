package _06_overloading;

import java.awt.Color;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Overloading is when we have multiple methods with the SAME name, but DIFFERENT parameters.
 * This can mean a different number of parameters, or the parameter types can differ, or both!
 * An overloaded method can also have a different return type, in addition to changing the parameters.
 * 
 * GOAL: Create your own custom pop-up messages
 */
public class LeagueOptionPane {
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JLabel label = new JLabel();
	
	public static void showMessageDialog(String message) {
		// 1. Open example.png and make a GUI that looks like that
		//    The message parameter is what we want to show on our pop-up
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(label);
		
		//message = JOptionPane.showInputDialog("type any message");
		label.setText(message);
		
		
		// 2. Uncomment the line of code below. It sets the location of our frame to the center of the screen
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
	
	// 3. Call this method in the Runner class
	

	// 4. Create another showMessageDialog() method that lets us also choose the Message and Title 
	//    2 String parameters (one for the message and one for the title)
	public static void showMessageDialog(String Message, String Title) {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(label);
		Message = JOptionPane.showInputDialog("type any message");
		Title = JOptionPane.showInputDialog("name the title");
		label.setText(Message);
		frame.setTitle(Title);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
	// 5. Call this method in the Runner class
	
	
	// 6. Create another showMessageDialog() method that lets us choose the Message, Title, and Image
	//    3 String parameters (one for the message, one for the title, and one for the fileName)
	public static JPanel showMessageDialog(String Message, String Title, String Image) {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(label);
		Message = JOptionPane.showInputDialog("type any message");
		Title = JOptionPane.showInputDialog("name the title");
		Image = JOptionPane.showInputDialog("which image do you want? java, league, or leagueDark?");
		if (Image.equals("java")) {
			label.setIcon(loadImage("java.png"));
		}
		if (Image.equals("league")) {
			label.setIcon(loadImage("league.png"));
		}
		if (Image.equals("leagueDark")) {
			label.setIcon(loadImage("leagueDark.png"));
		}
		label.setText(Message);
		frame.setTitle(Title);
		frame.setLocationRelativeTo(null);
		frame.pack();
		return panel;
	}
	// 7. Call this method in the Runner class
	
	// CHALLENGE: 
		//	1. Create another showMessageDialog() method that lets us choose the Message, Title, Image, and Background Color
		//     3 String parameters (one for the message, one for the title, and one for the fileName)
		//	   1 Color parameter for the backgroundColor
	public static void showMessageDialog(String Message, String Title, String Image, Color backgroundColor) {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(label);
		showMessageDialog("","","").equals(panel);
		Message = JOptionPane.showInputDialog("type any message");
		Title = JOptionPane.showInputDialog("name the title");
		Image = JOptionPane.showInputDialog("which image do you want? java, league, or leagueDark?");
		String color = JOptionPane.showInputDialog("what color do you want the background color to be?");
		if (Image.equals("java")) {
			label.setIcon(loadImage("java.png"));
		}
		if (Image.equals("league")) {
			label.setIcon(loadImage("league.png"));
		}
		if (Image.equals("leagueDark")) {
			label.setIcon(loadImage("leagueDark.png"));
		}
		label.setText(Message);
		panel.setBackground(backgroundColor);
		frame.setTitle(Title);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
		//	2. Change the return type of the 3rd showMessageDialog() method(the one right above) to JPanel
		//	   Make sure to return your panel at the end of that method
			
		//	3. Call the showMessageDialog() method you just modified in this method
		//	   Set the method equal to a JPanel
			
		//	4. Set the background of your panel to the backgroundColor parameter
		
		//	5. Call this method in the Runner class
		
		// WHY DID WE DO THIS? - because we were able to overload this method by calling one of the other methods inside of it
	
	
	public static ImageIcon loadImage(String fileName) {
		try {
			return new ImageIcon(ImageIO.read(new LeagueOptionPane().getClass().getResourceAsStream(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
