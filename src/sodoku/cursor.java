package sodoku;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class cursor 
extends visible 
implements EventHandelling{
	
	EventHandeler Events;
	
	static Color myColor = Color.BLACK;
	
	cursor(int mx, int my, EventHandeler events) {
		super(mx/2, my/2, my, mx , myColor);
		Events = events;
		
	}
	

	@Override
	public void EarlyHandling() {
		if(Events.KeyDown.contains(KeyEvent.VK_UP))
			Move(X,Y-1);
		if(Events.KeyDown.contains(KeyEvent.VK_DOWN))
			Move (X,Y+1);
		if(Events.KeyDown.contains(KeyEvent.VK_RIGHT))
			Move (X+1, Y);
		if(Events.KeyDown.contains(KeyEvent.VK_LEFT) && Y > 0)
			Move (X-1,Y);
		if(Events.Mousemoved) {
			Move(((Events.MouseX - 10)/WorldGenLoop.dimention), ((Events.MouseY-30)/WorldGenLoop.dimention));

			Events.Mousemoved =false;
		}
		//System.out.println(X + "    " +Y);
		
	}

	@Override
	public void MidHandling() {
		// TODO Auto-generated method stub
	}

	@Override
	public void LateHandling() {
		// TODO Auto-generated method stub
		
	}
}
