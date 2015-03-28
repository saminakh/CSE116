package lab10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class ElusiveBall extends JPanel{
	
	private Ball ball = new Ball();
	
	public ElusiveBall(){
				
		ball.setBackground(Color.GRAY);
		ball.setBorder(new LineBorder(Color.cyan));
		setLayout(new BorderLayout());
		add(ball, BorderLayout.CENTER);
		
		ball.addMouseMotionListener(new EventHandler(ball));
		ball.addMouseListener(new EventHandler(ball));
	}
	
	

}
