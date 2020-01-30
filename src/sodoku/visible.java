package sodoku;

import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.Graphics2D;


public abstract class visible 
	   implements EventHandelling{
	
	int Y;
	int X;
	int LastX;
	int LastY;
	int MaxX;
	int MaxY;
	int speed = 10;
	float rotation = 30;
	Color C;
	IImage images = new IImage();
	Image myImage;
	JLayeredPane Level =new JLayeredPane();
    
	visible (int x, int y,int mx, int my, Color c){
		Y = x;
		X = y;
		LastX = x;
		LastY = y;
		MaxX = mx;
		MaxY = my;
		C = c;
		myImage = null;
	}

	visible (int x, int y,int mx, int my, String name){
		myImage = images.IMG.get(name);
		Y = x;
		X = y;
		LastX = x;
		LastY = y;
		MaxX = mx;
		MaxY = my;
		WorldGenLoop.can.Levels.add(Level);
		C = null;
	}

	protected void Move(int x , int y) {
		if(x < MaxX && x >= 0 ) {
			X = x;
		}
		if( y < MaxY && y >= 0) {
			Y = y;
		}
	}
	
	
	public void update(){
		if(WorldGenLoop.timer % speed == 0) {
			if(myImage == null)
			draw();
		}
	}
	
	public void draw() {
			
		if(C != null) {
			if( LastX != Y  || LastY != X) {
				WorldGenLoop.can.setColor(LastX, LastY, WorldGenLoop.can.Origin[LastX][LastY]);
				WorldGenLoop.can.setColor(Y, X, C);
				LastX = Y;
				LastY = X;
			}
		}
		else if (myImage != null){
			// TODO Auto-generated method stub
			AffineTransform at = AffineTransform.getTranslateInstance(600, 10);
			at.rotate(Math.toRadians(this.rotation), myImage.getHeight(null)/2, myImage.getWidth(null)/2);
			at.scale(1.5, 1.5);
			//System.out.println("Before");
			Graphics2D g2d = (Graphics2D) WorldGenLoop.can.Graph;
			//System.out.println("After");
			g2d.drawImage(myImage,at,null);
			if(WorldGenLoop.timer % 35 == 0)
				this.rotation *= -1;
		}
	}
	
	public void kill() {
		C= WorldGenLoop.can.Origin[Y][X];
		WorldGenLoop.can.setColor(Y, X, C);
		try{
			WorldGenLoop.elementsCopy.remove(this);
		}catch(Exception  e){
			
		}
		
	}
}
