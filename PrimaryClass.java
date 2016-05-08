package finalProjectPackage;

import java.awt.BasicStroke;
import java.awt.Canvas; 
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import java.io.*;

public class PrimaryClass extends Canvas{
	
	  private JFrame frame;
	  protected final int WINDOW_WIDTH = 1050;
	  protected final int WINDOW_HEIGHT = 700;
	  public Color userColor[];
	  public int colorID;
	  public int chosenColor;
	  
	  public int topIt;
	  public int botIt;
	  
	  public int chosenTopIt;
	  public int chosenBotIt;
	  
	  public double tA;
	  public double uTA;
	  
	  public double bA;
	  public double uBA;

//method for frame characteristics
//uses the numbers defined above	  
	  public PrimaryClass(int colorID, int topIt, int botIt, double uTA, double uBA) {	
	    
	    frame = new JFrame("Image");
  	    frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    frame.setResizable(true);
	    frame.add(this);
	    setBackground(Color.black);
	    frame.setVisible(true);    
	    frame.setBackground(Color.black);
	    frame.setVisible(true);
	    
	    chosenColor = colorID;
	    chosenTopIt = topIt;
	    chosenBotIt = botIt;
	    
	    tA = uTA;
	    bA = uBA;
	    
	    	   
	  }//end method

	  public void newMaine() {
		  //does nothing, program starts from the top
	  }//end method

	  @Override
	  public void paint(Graphics g) {
		  Color userColor[] = new Color[10];   
		    
		    userColor[0] = (Color.blue);
		    userColor[1] = (Color.pink);
		    userColor[2] = (Color.green);
		    userColor[3] = (Color.red);
		    userColor[4] = (Color.white);
		    userColor[5] = (Color.orange);
		    userColor[6] = (Color.gray);
		    userColor[7] = (Color.magenta);
		    userColor[8] = (Color.cyan);
		    userColor[9] = (Color.yellow);
		  
	    g.setColor(userColor[chosenColor]);		//defines color of the drawing lines //window height argument = -265
	    drawFractalTree(g, WINDOW_WIDTH / 2, WINDOW_HEIGHT/ 2, -90, chosenTopIt);	//horizontal placement(middle), vertical placement, orientation, # iterations
	    drawFractalRoots(g, WINDOW_WIDTH / 2, WINDOW_HEIGHT/ 2, -90, chosenBotIt);	//horizontal placement(middle), vertical placement, orientation, # iterations
	  }

//method executes drawing
//takes the numbers passed to it from 	  
	  public void drawFractalTree(Graphics g, int x1, int y1, double angle, int depth) {
			 
		  if (depth == 0) {
	    } else {
	      int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 5); // *horizontal stretchyness?
	      int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 5);	//vertical stretchyness

	      Graphics2D g2d = (Graphics2D) g;
	      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	      g2d.setStroke(new BasicStroke(0.1f * depth));
	      g2d.drawLine(x1, y1, x2, y2);	//starting line
	      
//	      try{Thread.sleep(1);}							
//			 catch(Exception e){};
//			 
	      drawFractalTree(g, x2, y2, angle + tA, depth - 1); //right side angle; default: +20
	      
//	      try{Thread.sleep(1);}							
//			 catch(Exception e){};
			 
	      drawFractalTree(g, x2, y2, angle - tA, depth - 1); //left side angle; default: -20
//	      
//	      try{Thread.sleep(1);}							
//			 catch(Exception e){};	      
	    }

	  }// end method
	  
	  public void drawFractalRoots(Graphics g, int x1, int y1, double angle, int depth) {
	 
		  if (depth == 0) {
		    } else {
		      int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 5); // *horizontal stretchyness?
		      int y2 = y1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 5);	//vertical stretchyness

		      Graphics2D g2d = (Graphics2D) g;
		      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);	//improves image quality

		      g2d.setStroke(new BasicStroke(0.1f * depth));
		      g2d.drawLine(x1, y1, x2, y2);

		      drawFractalTree(g, x2, y2, angle - bA, depth - 1); //left side angle; default: -30; old = -200
		      drawFractalTree(g, x2, y2, angle + bA, depth - 1); //left side angle; default: -30; old = 200
	  }
	  }//end method

}
