package lab10;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;

import javax.swing.JPanel;

public class Ball extends JPanel {
	
	private int x = 300; 
	private int y = 250;
	private int radius = 50;
	private Timer _timer;
	
	protected void paintComponent(Graphics g){
		
		//make the oval
		super.paintComponent(g);		
		g.setColor(Color.cyan);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
	
	//return X and Y coordinates
	public int getBallX(){
		return x;
	}
	
	public int getBallY(){
		return y;
	}
	
	//return radius of oval
	public int getRadius(){
		return radius;
	}
	
	//set X and Y coordinates
	public void setBallX(int val){
		x = val;
	}
	
	public void setBallY(int val){
		y = val;
	}
	
	//repaint the ball
	public void repaintBall(){
		repaint();
	}
	
	//place in a new spot upon winning
	public void resetBall(){
		this.setBallX(300);
		this.setBallY(250);
		repaint();
	}

}
