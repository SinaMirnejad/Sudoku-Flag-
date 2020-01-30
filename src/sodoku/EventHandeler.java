package sodoku;

import java.awt.event.*;
import java.util.ArrayList;

public class EventHandeler
implements KeyListener,
		   MouseMotionListener,
		   MouseListener {
	
	
	public ArrayList<Integer> KeyDown;
	
	boolean Mousemoved = false;
	public boolean mouseInput;
	public int MouseX;
	public int MouseY;
	
	
	public EventHandeler() {
		KeyDown = new ArrayList<Integer>();
	}

	//Keyboard input
	
	@Override
	public void keyPressed(KeyEvent e) {
		if( !KeyDown.contains( e.getKeyCode() )    )
			 KeyDown.add(new Integer(e.getKeyCode()));
	}

	@Override
	public void keyReleased(KeyEvent e) {

		KeyDown.remove(new Integer(e.getKeyCode()));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	//mouse input
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Mousemoved = true;
		MouseX = e.getX();
		MouseY = e.getY();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Mousemoved = true;
		MouseX = e.getX();
		MouseY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("Mouse Clicked" + e);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//System.out.println("Mouse Entered" + e);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//System.out.println("Mouse Exited" + e);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseInput = true;
		MouseX = e.getX() -9;
		MouseY = e.getY() -31;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseInput = false;

		
	}
	
}
