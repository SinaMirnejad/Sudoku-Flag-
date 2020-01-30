package sodoku;

import java.awt.Color;
import java.util.HashSet;

public class SodokuBoard 
	extends visible{
	private static final String ActiveNumber = null;
	public int[][] Enteries = new int[9][9]; 
	public int[][] Answer ;
	public Number[][] show = new Number[9][9];
	
	SodokuBoard(int x, int y, int mx, int my, Color c) {
		super(x, y, mx, my, c);
		Game g = new Game();
		Answer = g.generateSolution(new int[9][9], 0);
		
		for(int i = 0 ; i < 9; i++) {
			for(int j = 0 ; j < 9; j++) {
				if(WorldGenLoop.rand.nextInt(8) < 5) {
					show[i][j] = new ActiveNumber(9*i+3,9*j+2,0);
					((ActiveNumber)show[i][j]).setColor(Color.DARK_GRAY);
				}
				else {
					show[i][j] = new Number(9*i+3,9*j+2,Answer[i][j]);
				}
			}
		}
	}
	
	@Override
	public void draw() {
		for(int i = 0 ; i < 9; i++) {
			for(int j = 0 ; j < 9; j++) {
				show[i][j].draw();
			}
		}
	}
	
	@Override
	public void EarlyHandling() {
		for(int i = 0 ; i < 9; i++) {
			for(int j = 0 ; j < 9; j++) {
				show[i][j].EarlyHandling();
			}
		}
	}

	@Override
	public void MidHandling() {
		for(int i = 0 ; i < 9; i++) {
			for(int j = 0 ; j < 9; j++) {
				show[i][j].MidHandling();;
			}
		}
		
	}

	@Override
	public void LateHandling() {
		HashSet<Integer> test;
		for(int i = 0 ; i < 9; i++) {
			for(int j = 0 ; j < 9; j++) {
				 test = checkup(i,j);
				 
				  if (test.contains(show[i][j].Value) && show[i][j].getClass().equals(ActiveNumber.class) ) {
					  
					//System.out.println(i + " : "+ j + test);
					((ActiveNumber)show[i][j]).setColor(Color.RED);
				 }
				 else if(show[i][j].getClass().equals(ActiveNumber.class) ) {
					
					((ActiveNumber)show[i][j]).setColor(Color.GRAY);
				 }
			}
		}
		
		
	}
	
	private HashSet<Integer> checkup(int i, int j) {
		HashSet<Integer> result = new HashSet<Integer>();
		for(int m = 0 ; m < 9; m++) {			
			
			if((show[i][m].getClass().equals(Number.class) || ((ActiveNumber) show[i][m]).init) && m!=j ) 
				result.add(new Integer(show[i][m].Value));
			if((show[m][j].getClass().equals(Number.class) || ((ActiveNumber) show[m][j]).init) && m!=i )	
				result.add(new Integer(show[m][j].Value));
			
		}
		for(int m = 0 ; m < 3; m++) {
			for(int n = 0 ; n < 3; n++) {
				if((show[3*((int)(i/3)) + m][3*((int)(j/3)) + n].getClass().equals(Number.class) || ((ActiveNumber) show[3*((int)(i/3)) + m][3*((int)(j/3)) + n]).init) && (3*((int)(i/3))+m != i || 3*((int)(j/3))+n !=j))
					result.add( new Integer( show [3*((int)(i/3)) + m][3*((int)(j/3)) + n].Value ) );
			}
		}
		return result;
	}
}
