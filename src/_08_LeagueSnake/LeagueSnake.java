package _08_LeagueSnake;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
	int snakeX = 250;
	int snakeY = 450;
	int Segment;
	int foodX;
	int foodY;
	int snakeDirection = UP;
	int foodEaten = 0;
	boolean hasFood = false;
	ArrayList<Segment> snakeTails = new ArrayList<>();

	Random rand = new Random();
	Random ran = new Random();
	
	/*
	 * Setup methods
	 * 
	 * These methods are called at the start of the game.
	 */
	@Override
	public void settings() {
		setSize(500, 500);

	}

	@Override
	public void setup() {
		Segment newSegment;
		frameRate(20);
		dropFood();
		Segment snakeHead = new Segment(10, 10);
		Segment snakeBody = new Segment(250, 450);
		snakeTails.add(snakeHead);
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
		move();
		drawSnake();
		eat();

	}

	void drawFood() {
		// Draw the food
		// dropFood();
		fill(46, 184, 62);
		rect(foodX, foodY, 10, 10);
	}

	void drawSnake() {
		// Draw the head of the snake followed by its tail

		fill(191, 61, 21);
		for (Segment s : snakeTails) {
			rect(s.x, s.y, 10, 10);
		}
		manageTail();
	}

	void drawTail() {
		// Draw each segment of the tail

		// if (foodEaten ) {
		// fill(191, 61, 21);
		// rect(250, 450, 10, 10);
		// }
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
		checkTailCollision();
		drawTail();
		Segment snakeBody = new Segment(snakeX, snakeY);
		snakeTails.add(snakeBody);
		if (snakeTails.size() > foodEaten) {
			snakeTails.remove(0);
		}
		
	}

	void checkTailCollision() {
		// If the snake crosses its own tail, shrink the tail back to one segment
		for (Segment s : snakeTails) {
			//System.out.println(snakeX);	
			//System.out.println(snakeY);
			//System.out.println(s.x);
			//System.out.println(s.y);
			//System.out.println(snakeTails.size());
			if (snakeX == s.x  && snakeX == s.x) {
				if (snakeY == s.y && snakeY == s.y) {
					foodEaten = 1;
					snakeTails = new ArrayList<>();
					
		}
			}
		}
			
		
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
				snakeDirection = UP;
			}
			if (keyCode == KeyEvent.VK_DOWN) {
				snakeDirection = DOWN;
			}
			if (keyCode == KeyEvent.VK_RIGHT) {
				snakeDirection = RIGHT;
			}
			if (keyCode == KeyEvent.VK_LEFT) {
				snakeDirection = LEFT;
			}

		}
	}

	void move() {
		// Change the location of the Snake head based on the direction it is moving.

		checkBoundaries();
		if (snakeDirection == UP) {
			snakeY -= 4;

		} else if (snakeDirection == DOWN) {
			snakeY += 4;

		} else if (snakeDirection == LEFT) {
			snakeX -= 4;

		} else if (snakeDirection == RIGHT) {
			snakeX += 4;

		}

	}

	void checkBoundaries() {
		// If the snake leaves the frame, make it reappear on the other side

		if (snakeX > 502) {
			snakeX = -8;
		} else if (snakeX < -10) {
			snakeX = 500;
		} else if (snakeY > 502) {
			snakeY = -8;
		} else if (snakeY < -10) {
			snakeY = 500;
		}
		// 250X
		// 450Y
	}

	void eat() {
		// When the snake eats the food, its tail should grow and more
		// food appear
		// System.out.println(snakeX);
		// System.out.println(snakeY);
		if (snakeX - 10 < foodX && snakeX + 10 > foodX) {
			if (snakeY - 10 < foodY && snakeY + 10 > foodY) {
				// dropFood();
				foodX = rand.nextInt(500);
				foodY = ran.nextInt(500);
				foodEaten += 1;
				System.out.println(foodEaten);
			}
		}

	}

	static public void main(String[] passedArgs) {
		PApplet.main(LeagueSnake.class.getName());
	}
}
