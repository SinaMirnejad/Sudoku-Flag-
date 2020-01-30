package sodoku;

import java.awt.Color;

public class Number
extends visible{
	
	private Number next = null;
	int Value = -1;
	int OldValue = -1;
	public Number(int x, int y, int V) {
		super(x,y,WorldGenLoop.Size*2,WorldGenLoop.Size,Color.BLACK); 
		C = Color.BLACK;
		speed = 1;
		Value = V % 10;
		if(V/10 >= 1) {
			next = new Number(x-4, y , V/10);
		}
	}
	
	@Override
	public void draw() {
		Flush();
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

	
	protected void DZero() {
		int row =0;
		WorldGenLoop.can.setColor(X+row, Y ,C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =1;
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =2; 
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);

		row =3; 
		WorldGenLoop.can.setColor(X+row, Y , C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =4; 
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);	
	}
	protected void DOne() {
		int row =0;
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		
		row =1;
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y +1, C);
		
		row =2; 
		WorldGenLoop.can.setColor(X+row, Y + 1, C);


		row =3; 

		WorldGenLoop.can.setColor(X+row, Y + 1, C);

		
		row =4; 
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);	
	}
	protected void DTwo() {
		int row =0;
		WorldGenLoop.can.setColor(X+row, Y ,C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =1;
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =2; 
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);

		row =3; 
		WorldGenLoop.can.setColor(X+row, Y , C);
		row =4; 
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);		
	}
	
	protected void DThree() {
		int row =0;
		WorldGenLoop.can.setColor(X+row, Y ,C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		
		
		row =1;
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =2; 
		
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);

		row =3; 
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =4; 
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
			
	}
	protected void DFour() {
		int row =0;
		WorldGenLoop.can.setColor(X+row, Y ,C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =1;
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =2; 
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);

		row =3; 
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =4; 
		WorldGenLoop.can.setColor(X+row, Y + 2, C);	
	}
	protected void DFive() {
		int row =0;
		WorldGenLoop.can.setColor(X+row, Y ,C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =1;
		WorldGenLoop.can.setColor(X+row, Y, C);
		
		row =2; 
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);

		row =3; 
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =4; 
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);	
		
	}
	protected void DSix() {
		int row =0;
		WorldGenLoop.can.setColor(X+row, Y ,C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =1;
		WorldGenLoop.can.setColor(X+row, Y, C);
		
		row =2; 
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);

		row =3; 
		WorldGenLoop.can.setColor(X+row, Y , C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =4; 
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);	
	}
	protected void DSeven() {
		int row =0;
		WorldGenLoop.can.setColor(X+row, Y ,C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =1;
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =2; 
		WorldGenLoop.can.setColor(X+row, Y + 1, C);

		row =3; 
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		
		row =4; 
		WorldGenLoop.can.setColor(X+row, Y + 1, C);	
	}
	protected void DEight() {
		int row =0;
		WorldGenLoop.can.setColor(X+row, Y ,C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =1;
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =2; 
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);

		row =3; 
		WorldGenLoop.can.setColor(X+row, Y , C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =4; 
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);	
	}
	protected void DNine() {
		int row =0;
		WorldGenLoop.can.setColor(X+row, Y ,C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =1;
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =2; 
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);

		row =3; 
		WorldGenLoop.can.setColor(X+row, Y + 2, C);
		
		row =4; 
		WorldGenLoop.can.setColor(X+row, Y, C);
		WorldGenLoop.can.setColor(X+row, Y + 1, C);
		WorldGenLoop.can.setColor(X+row, Y + 2, C);	
		
	}
	
	public void Flush() {
		int row =0;
		WorldGenLoop.can.setColor(X+row, Y , WorldGenLoop.can.Origin[X+row][Y]);
		WorldGenLoop.can.setColor(X+row, Y + 1, WorldGenLoop.can.Origin[X+row][Y+1]);
		WorldGenLoop.can.setColor(X+row, Y + 2, WorldGenLoop.can.Origin[X+row][Y+2]);
		
		row =1;
		WorldGenLoop.can.setColor(X+row, Y, WorldGenLoop.can.Origin[X+row][Y ]);
		WorldGenLoop.can.setColor(X+row, Y +1, WorldGenLoop.can.Origin[X+row][Y+ 1]);
		WorldGenLoop.can.setColor(X+row, Y + 2, WorldGenLoop.can.Origin[X+row][Y+ 2]);
		
		row =2; 
		WorldGenLoop.can.setColor(X+row, Y, WorldGenLoop.can.Origin[X+row][Y]);
		WorldGenLoop.can.setColor(X+row, Y + 1, WorldGenLoop.can.Origin[X+row][Y+ 1]);
		WorldGenLoop.can.setColor(X+row, Y + 2, WorldGenLoop.can.Origin[X+row][Y+ 2]);

		row =3; 
		WorldGenLoop.can.setColor(X+row, Y , WorldGenLoop.can.Origin[X+row][Y ]);
		WorldGenLoop.can.setColor(X+row, Y + 1, WorldGenLoop.can.Origin[X+row][Y+ 1]);
		WorldGenLoop.can.setColor(X+row, Y + 2, WorldGenLoop.can.Origin[X+row][Y+ 2]);
		
		row =4; 
		WorldGenLoop.can.setColor(X+row, Y, WorldGenLoop.can.Origin[X][Y]);
		WorldGenLoop.can.setColor(X+row, Y + 1, WorldGenLoop.can.Origin[X+row][Y+ 1]);
		WorldGenLoop.can.setColor(X+row, Y + 2, WorldGenLoop.can.Origin[X+row][Y+ 2]);
	}
	
	
	public void FlushAll() {
		Flush();
		if(next != null)
			next.FlushAll();
	}
	
	public void Changevalue(int x) {
		if(x/10 >= 1) {
			if (next != null)
				next.Changevalue(x/10);
			else
				next = new Number(Y-4,X,x/10); 
		}else if(next != null) {
			next.FlushAll();
			next = null;
		}
		Value = x % 10;
	}
	
	
	@Override
	public void update() {
		super.update();
		if(next != null)
			next.update();
	}
	
	@Override
	public void EarlyHandling() {
		if(OldValue != Value) {
			draw();
			OldValue = Value;
		}
		
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
