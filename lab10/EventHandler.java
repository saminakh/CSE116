package lab10;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class EventHandler implements MouseMotionListener, MouseListener{

	private Ball _ball;
	private JFrame _tempFrame;

	public EventHandler(Ball ball){

		_ball = ball;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		//get current ball location
		int xPos = _ball.getBallX();
		int yPos = _ball.getBallY();
		int radius = _ball.getRadius();
		
		//make winning frame
		JFrame tempFrame = new JFrame("Cool Game");
		tempFrame.setLayout(new GridLayout(0, 1));
		JLabel winLabel = new JLabel("You won! Would you like to continue playing?");
		JPanel buttonPanel = new JPanel();
		JButton yesButton = new JButton("Yes");
		JButton noButton = new JButton("No");
		
		//make button choices
		yesButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				_tempFrame.setVisible(false);
				_ball.resetBall();
			}
		});
		
		noButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		buttonPanel.add(yesButton);
		buttonPanel.add(noButton);
		
		tempFrame.add(winLabel);
		tempFrame.add(buttonPanel);
		tempFrame.pack();
		tempFrame.setLocationRelativeTo(null);
		_tempFrame = tempFrame;
	
		//have frame display if they successfully click in the circle
		if(xPos - radius < e.getX() && e.getX() < xPos + radius && yPos - radius < e.getY() && e.getY() < yPos + radius){
			tempFrame.setVisible(true);
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

		//create random (x,y) to jump to
		int randX = (int) (Math.random() * 450);
		int randY = (int) (Math.random() * 300);
		int radius = _ball.getRadius();

		//get current position of ball
		int xPos = _ball.getBallX();
		int yPos = _ball.getBallY();

		//when mouse approaches ball, have it move! set new position to random (x,y) and have the ball repainted in
		if(xPos - radius < arg0.getX() + 10 && arg0.getX() + 10 < xPos + radius && yPos - radius < arg0.getY() + 10 && arg0.getY() + 10 < yPos + radius){
			_ball.setBallX(randX + radius);
			_ball.setBallY(randY + radius);
			_ball.repaintBall();
			_ball.removeMouseMotionListener(this);
			_ball.addMouseMotionListener(this);
		}

	}


	//UNIMPORTANT MOUSE EVENTS
	@Override
	public void mouseEntered(MouseEvent e) {		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
	}



}
