package sodoku;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Cursor;

/**
 * WARNING:  READING THIS CODE MAY CONFUSE YOU PRETTY BADLY!!!
 * 
 * I've decided to include this source code in the project in case you
 * are curious to see an example of more advanced Java programming.
 * 
 * You should not modify this file in any way.
 * 
 * You should not even READ this file unless you are very curious and
 * not easily scared!
 * 
 */

@SuppressWarnings("serial")
public class MyGrid extends JPanel  {
	protected ArrayList<JLayeredPane> Levels = new ArrayList<JLayeredPane>(); 
	protected static long serialVersionUID = 0L;
	protected static int MARGIN_SIZE = 5;
	protected int scaleH;
	protected int scaleW;
	protected Color[][] colors;
	protected Color[][] Origin;
	private static int SQUARE_SIZE = 15;  // pixel size of each square
	protected JFrame frame;
	private Boolean Drawlines = false;
	public static Color BackGround = Color.LIGHT_GRAY;
	public Graphics Graph;
	public ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	protected MyGrid() {
	}
	
	public MyGrid(int scale, boolean dl,Color[][] Base) {
		Origin = Base;
		this.scaleH = scale;
		this.scaleW = 2*scale;
		int overallSizeH = scaleH + 2 * MARGIN_SIZE;
		int overallSizeW = scaleW + 2 * MARGIN_SIZE;
		this.Drawlines = dl;
		colors = Base;
		Origin = new Color[overallSizeH][overallSizeW];
		for (int i = 0 ; i < overallSizeH; i++)
			for(int j = 0 ; j < overallSizeW ; j++)
				Origin[i][j] = colors[i][j];
		
		
		javax.swing.SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
						createAndShowFrame();
					}
				}
		);	
	}
	
	public MyGrid(int scale, int SS,  int MS, boolean dl,Color[][] Base) {
		Origin = Base;
		MyGrid.MARGIN_SIZE = MS;
		MyGrid.SQUARE_SIZE = SS;
		this.scaleH = scale;
		this.scaleW = 2*scale;
		int overallSizeH = scaleH + 2 * MARGIN_SIZE;
		int overallSizeW = scaleW + 2 * MARGIN_SIZE;
		this.Drawlines = dl;
		colors = Base;
		Origin = new Color[overallSizeH][overallSizeW];
		for (int i = 0 ; i < overallSizeH; i++)
			for(int j = 0 ; j < overallSizeW ; j++)
				Origin[i][j] = colors[i][j];
		
		javax.swing.SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
						createAndShowFrame();
					}
				}
		);	
	}
	
	
	public MyGrid(int scale, int SS,  int MS, EventHandeler ks,boolean dl,Color[][] Base) {
		Origin = Base;
		MyGrid.MARGIN_SIZE = MS;
		MyGrid.SQUARE_SIZE = SS;
		this.scaleH = scale;
		this.scaleW = scale;
		int overallSizeH = scaleH + 2 * MARGIN_SIZE;
		int overallSizeW = scaleW + 2 * MARGIN_SIZE;
		this.Drawlines = dl;
		colors = Base;
		
		Origin = new Color[overallSizeH][overallSizeW];
		for (int i = 0 ; i < overallSizeH; i++)
			for(int j = 0 ; j < overallSizeW ; j++)
				Origin[i][j] = colors[i][j];
		
		javax.swing.SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
						createAndShowFrame(ks);
					}
				}
		);
	}
	
	
	public int getScale(){
		return scaleH;
	}
	
	public int getHt() {
		return scaleH;
	}
	
	public int getWd(){
		return scaleW;
	}
	
	
	private void createAndShowFrame() {
		frame = new JFrame("Drawing Grid");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize((scaleW + 2 * MARGIN_SIZE) * SQUARE_SIZE, 
				((scaleH) + 2 * MARGIN_SIZE) * SQUARE_SIZE);
		frame.setContentPane(this);
		frame.pack();
		frame.setVisible(true);
		frame.toFront();
		frame.setAlwaysOnTop(true);
	}

	private void createAndShowFrame(EventHandeler ks) {
		frame = new JFrame("Drawing Grid");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize((scaleW + 2 * MARGIN_SIZE) * SQUARE_SIZE, 
				((scaleH) + 2 * MARGIN_SIZE) * SQUARE_SIZE);
		frame.setContentPane(this);
		frame.pack();
		frame.setVisible(true);
		frame.toFront();
		frame.setAlwaysOnTop(true);
		frame.addKeyListener(ks);
		frame.addMouseListener(ks);
		frame.addMouseMotionListener(ks);
		
		Toolkit tools = Toolkit.getDefaultToolkit();
		Image img = tools.getImage("http://www.clipartbest.com/cliparts/biy/pLK/biypLK46T.png");
		Point p = new Point(0,0);
		Cursor cursor = tools.createCustomCursor(img, p, "Invis");
		setCursor(cursor);
		//frame.setCursor( Cursor.   );
	}
	
	
	public void setColor(int row, int col, Color color) {
		colors[row + MARGIN_SIZE][col + MARGIN_SIZE] = color;
	}
	
	public void kill() {
		if (frame != null)
			frame.dispose();
	}
	
	public Dimension getPreferredSize() {
		return new Dimension((scaleW + 2 * MARGIN_SIZE) * SQUARE_SIZE + 1, 
				((scaleH) + 2 * MARGIN_SIZE) * SQUARE_SIZE + 1);
	}
	int  i = 0 ;
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int offset = MARGIN_SIZE * SQUARE_SIZE;
		Graph = g;		
		

		for (int i = 0; i < scaleH + 2 * MARGIN_SIZE; i ++)
			for (int j = 0; j < scaleW + 2 * MARGIN_SIZE; j++) {
				g.setColor(colors[i][j]);
				g.fillRect(j * SQUARE_SIZE + 1, i * SQUARE_SIZE + 1, 
						SQUARE_SIZE, SQUARE_SIZE);
			}
		if(Drawlines) {
		g.setColor(Color.BLACK);
		for (int i = 0; i < scaleW + 1; i += 9) 
			g.drawLine(offset + i * SQUARE_SIZE, offset, 
					offset + i * SQUARE_SIZE, offset + scaleH * SQUARE_SIZE);
		for (int j = 0; j < scaleH + 1; j += 9) 
			g.drawLine(offset, offset + j * SQUARE_SIZE, 
					offset + scaleW * SQUARE_SIZE, offset + j * SQUARE_SIZE);
			
		}
		for(Sprite i : sprites) {
			i.draw();
		}
	}
	
	
}
