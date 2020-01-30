package sodoku;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class ActiveNumber 
	extends Number{
	
	public boolean init =false;
	public boolean isActive = false;
	
	public ActiveNumber(int x, int y, int V) {
		super(x, y, V);
		// TODO Auto-generated constructor stub
		if (V < 0) init =false;
	}
	
	@Override
	public void Flush() {
		if(!isActive) {
			super.Flush();
		}else {
			for(int i = -2; i <= 6; i++) {
				for(int j = -3; j <= 5 ; j++) {
					WorldGenLoop.can.setColor(X+i, Y+j, Color.yellow);		
				}
			}
		}
	}
	
	public void EarlyHandling() {
		if(OldValue != Value) {
			draw();
			OldValue = Value;
		}
		/*MainSodoku.can.setColor(X - 2, Y - 3, Color.red);
		MainSodoku.can.setColor(X + 6, Y + 5, Color.red);*/
		if(WorldGenLoop.Events.mouseInput
		   && (X-2)*WorldGenLoop.dimention < WorldGenLoop.Events.MouseY 
		   && (Y-3)*WorldGenLoop.dimention < WorldGenLoop.Events.MouseX
		   && (X+6)*WorldGenLoop.dimention >  WorldGenLoop.Events.MouseY
		   && (Y+5)*WorldGenLoop.dimention >  WorldGenLoop.Events.MouseX) {
			isActive = true;
			draw();
		}else if(WorldGenLoop.Events.mouseInput) {
			Greatflush();
			isActive = false;
		}
		
	}
	
	public void setColor( Color c){
		C = c; 
		update();
	}
	
	private void Greatflush() {
		for(int i = -2; i <= 6; i++) {
			for(int j = -3; j <= 5 ; j++) {
				WorldGenLoop.can.setColor(X+i, Y+j, WorldGenLoop.can.Origin[X+i][Y+j]);		
			}
		}
	}
	
	@Override
	public void draw() {
		Flush();
		if(init) {
			switch(Value){
				case 0:
					DZero();
					break;
				case 1:
					DOne();
					break;
				case 2:
					DTwo();
					break;
				case 3:
					DThree();
					break;
				case 4:
					DFour();
					break;
				case 5:
					DFive();
					break;
				case 6:
					DSix();
					break;
				case 7:
					DSeven();
					break;
				case 8:
					DEight();
					break;
				case 9:
					DNine();
					break;
			
			}
		}
	}

	@Override
	public void MidHandling() {
		if(isActive) {
			if(WorldGenLoop.Events.KeyDown.contains(KeyEvent.VK_1)) {
				Value = 1;
				isActive = false;
				init = true;
				Greatflush();
			}
			if(WorldGenLoop.Events.KeyDown.contains(KeyEvent.VK_2)) {
				Value = 2;
				isActive = false;
				init = true;
				Greatflush();
			}
			if(WorldGenLoop.Events.KeyDown.contains(KeyEvent.VK_3)) {
				Value = 3;
				isActive = false;
				init = true;
				Greatflush();
			}
			if(WorldGenLoop.Events.KeyDown.contains(KeyEvent.VK_4)) {
				Value = 4;
				isActive = false;
				init = true;
				Greatflush();
			}
			if(WorldGenLoop.Events.KeyDown.contains(KeyEvent.VK_5)) {
				Value = 5;
				isActive = false;
				init = true;
				Greatflush();
			}
			if(WorldGenLoop.Events.KeyDown.contains(KeyEvent.VK_6)) {
				Value = 6;
				isActive = false;
				init = true;
				Greatflush();
			}
			if(WorldGenLoop.Events.KeyDown.contains(KeyEvent.VK_7)) {
				Value = 7;
				isActive = false;
				init = true;
				Greatflush();
			}
			if(WorldGenLoop.Events.KeyDown.contains(KeyEvent.VK_8)) {
				Value = 8;
				isActive = false;
				init = true;
				Greatflush();
			}
			if(WorldGenLoop.Events.KeyDown.contains(KeyEvent.VK_9)) {
				Value = 9;
				isActive = false;
				init = true;
				Greatflush();
			}
		
		}
		
	}

	@Override
	public void LateHandling() {
		// TODO Auto-generated method stub
		
	}
}
