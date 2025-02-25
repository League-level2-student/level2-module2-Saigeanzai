package _08_LeagueSnake;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    JPanel gamePanel = new JPanel();
	JFrame frame = new JFrame();
    
    /*
     * Game variables
     * 
     * Put all the game variables here.
     */
    
int Segment;
int foodX;
int foodY;
    
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        frame.setSize(500,500);
    }

    @Override
    public void setup() {
        Segment newSegment;
        frameRate(20);
        dropFood();
        
        gamePanel.setLayout( new GridLayout(500,500));
        frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gamePanel);
		
    }

    void dropFood() {
        // Set the food in a new random location
    	Random rand = new Random();
    	Random ran = new Random();
   foodX = rand.nextInt(500);
   foodY = ran.nextInt(500);
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
       // frame.setBackground(Color.black);
        drawFood();
        drawSnake();
    }

    void drawFood() {
        // Draw the food
    	for (int i=0; i<2500; i++) {
    		JLabel temp = new JLabel();
    		temp.setText(String.valueOf(i));
    		if (i==foodX && i==foodY) {
    			temp.setBackground(Color.green);
    		}
    		else {
    			temp.setBackground(Color.black);
    		}
    	}
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    }

    void drawTail() {
        // Draw each segment of the tail
        
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
        // After drawing the tail, add a new segment at the "start" of the tail and
        // remove the one at the "end"
        // This produces the illusion of the snake tail moving.

    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
        
    }

    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    public void keyPressed() {
        // Set the direction of the snake according to the arrow keys pressed
        
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

        /*
        if (direction == UP) {
            // Move head up
            
        } else if (direction == DOWN) {
            // Move head down
                
        } else if (direction == LEFT) {
            
        } else if (direction == RIGHT) {
            
        }
        */
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
        
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
