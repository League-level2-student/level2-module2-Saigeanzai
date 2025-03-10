package _08_LeagueSnake;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;

    /*
     * Game variables
     * 
     * Put all the game variables here.
     */
int snakeX =250;
int snakeY =450;
int Segment;
int foodX;
int foodY;
int snakeDirection = UP;
int foodEaten = 0;
boolean hasFood = false;
    
Random rand = new Random();
Random ran = new Random();
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        setSize(500,500);
       
    }

    @Override
    public void setup() {
        Segment newSegment;
        frameRate(20);
        dropFood();
        
      
		
    }

    void dropFood() {
        // Set the food in a new random location
    	
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
        background(0, 0, 0);
        drawFood();
        drawSnake();
        eat();
        
    }

    void drawFood() {
        // Draw the food
    	//dropFood();
    	fill(46, 184, 62);
    	rect(foodX, foodY, 10, 10);
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    	Segment snakeHead = new Segment(10,10);
    	fill(191, 61, 21);
    	rect(snakeX, snakeY, 10, 10);
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
    	if (key == CODED) {
    	    if (keyCode == KeyEvent.VK_UP) {
    	        snakeY -=4;
    	    }
    	    if (keyCode == KeyEvent.VK_DOWN) {
    	    	snakeY +=4;
    	    }
    	    if (keyCode == KeyEvent.VK_RIGHT) {
    	    	snakeX +=4;
    	    }
    	    if (keyCode == KeyEvent.VK_LEFT) {
    	    	snakeX -=4;
    	    }
    	    
    	}
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

        
        if (snakeDirection == UP) {
            snakeY --;
            
        } else if (snakeDirection == DOWN) {
            snakeY ++;
                
        } else if (snakeDirection == LEFT) {
        	snakeX --;
            
        } else if (snakeDirection == RIGHT) {
        	snakeX ++;
            
        }
        
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        if (snakeX==500) {
        	snakeX=1;
        }
        else if (snakeX==0) {
        	snakeX=499;
        }
       if (snakeY==500) {
    	   snakeY=1;
       }
       else if (snakeY==0) {
    	   snakeY=499;
       }
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
        if (snakeY>=foodY-1 && snakeY<=foodY+1 && snakeX>=foodX-1 && snakeX<=foodX+1) {
        	System.out.println(snakeY);
        	System.out.println(snakeX);
        	System.out.println(foodY);
        	System.out.println(foodY);
        	//dropFood();
        	foodX = rand.nextInt(500);
        	foodY = ran.nextInt(500);
        	   foodEaten ++;
        }
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
