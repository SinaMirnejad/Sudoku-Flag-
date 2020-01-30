package sodoku;

import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.Color;

public class WorldGenLoop {
	
	public static int elemspeed = 40; 
	public static int Speed = 5;
	public static int Frequency = 1;
	public static int score = 81; 
	public static int Size = 82;
	public static int margin = 0;
	public static int dimention = 7;
	public static MyGrid can;
	public static int timer = 0 ; 
	public static Random rand = new Random();
	public static ArrayList<visible> elements;
	public static ArrayList<visible> elementsCopy;
	public static EventHandeler Events;
	static int overallSizeH = Size+2*margin;
	static int overallSizeW = Size+2*margin;
	
	public static void main(String[] args) throws InterruptedException {
		
		//variable declaration
		elements = new ArrayList<visible>();
		ArrayList<Integer> history = new ArrayList<Integer>();
		Events = new EventHandeler();
		can = new MyGrid(Size,dimention,margin,Events,true,Hud());
		
		//adding the curser
		cursor CR = new cursor(Size, Size, Events);
		elements.add(CR);
		//sound
		//SoundAnalizer S = new SoundAnalizer();
		SodokuBoard board = new SodokuBoard (0,0,Size,Size,Color.black);
		elements.add(board);
		
		//main loop
		for(;;timer = (timer+1)%1000) {
			can.repaint();
			
			//Spawning
			elementsCopy = new ArrayList(elements);
			
			for (visible Curr : elements) {
				Curr.EarlyHandling();
			}
			for (visible Curr : elements) {
				Curr.MidHandling();
			}
			for (visible Curr : elements) {
				Curr.LateHandling();
			}
			for (visible Curr : elements) {
				Curr.update();
			}
			
			//Speed
			Thread.sleep(Speed, 0);
			elements = elementsCopy;
		}
		
		
	}
	
	
	private static Color[][] Hud(){
		Color[][] result = new Color[Size][Size];
		for (int  i = 0 ; i<Size; i++) {
			for (int  j = 0 ; j<Size ; j++) {
				result[i][j] = Color.LIGHT_GRAY;
			}
		}
		//horizontal lines
		for (int  i = 0 ; i<Size; i += 27) {
			for (int  j = 0 ; j<Size ; j++) 
				result[i][j] = Color.DARK_GRAY;
		}
		//Vertical lines		
		for (int  i = 0 ; i<Size; i += 27) {
			for (int  j = 0 ; j<Size ; j++) 
				result[j][i] = Color.DARK_GRAY;
		}
		return result;
				
	}
}