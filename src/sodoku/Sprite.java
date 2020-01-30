package sodoku;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Sprite
	   extends visible{
	int Score;
	Sprite(int x, int y, int mx, int my, String c) {
		super(x, y, mx, my, c);
		Score = WorldGenLoop.score;
		speed = 1;
		WorldGenLoop.can.sprites.add(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void EarlyHandling() {
			if(Score < WorldGenLoop.score -10) {
				//System.out.println("sad");
				myImage = IImage.IMG.get("sad.png");
				Score = WorldGenLoop.score; 
			}
			if( Score > WorldGenLoop.score + 10 ) {
				//System.out.println("happy");
				myImage = IImage.IMG.get("happy.png");
				Score = WorldGenLoop.score;
			}
	}

	@Override
	public void MidHandling() {
		
	}

	@Override
	public void LateHandling() {
		// TODO Auto-generated method stub
		
	}

}
