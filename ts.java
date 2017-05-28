
import javax.swing.*;
import java. awt.*;

class Mypanel extends JPanel implements Runnable
{ 
	{ 
		setOpaque(false);   
		setPreferredSize(new Dimension( 400, 330));
	}//constructor ends
	
	int xpos=0; int ypos=0; 
	int xinc=2; int yinc=2;
	int xtop=0; int ytop=0; 
	int xbot=370; int ybot=270; 
	Color color =Color.red;	
	//genertates random colors			
	public Color genColor() 
	{
		return new Color((float)Math.random(),(float)Math.random(),(float)Math.random()); 
	}//method ends

	public void paintComponent(Graphics g)
	{ 
		Graphics2D g2d = (Graphics2D)g;
		this.setBackground(Color.cyan);																										//setting background
		super.paintComponent(g);
		g2d.setColor(color);				
		g2d.fillOval(xpos,ypos,25,25);		//draws ovals						
	}//paint ends 

	public void update1 ()
	{
		if(ypos<=ytop) { color=genColor(); yinc=( int ) ( Math.random()*6 ) ; }				//if touches the top then change color and speed
		else if (ypos>=ybot) { color=genColor(); yinc=-( int ) ( Math.random()*6  ) ;  }	//if touches the bottom then change color and speed	
		if(xpos<=xtop) { color=genColor(); xinc=( int ) ( Math.random()*6  ) ; }			//if touches the sides then change color and speed 
		else if (xpos>=xbot){   color=genColor(); xinc= -( int ) ( Math.random()*6  ) ; }
		xpos+=xinc; ypos+=yinc;																//increment , movement
	}//methods ends
	
public void run()			//run method that execute when thread starts
	{
		for (;;)
        {
        	
            try 
            { 
            	Thread.sleep(10);
            } //try ends
            catch (InterruptedException e) {}
           
            update1();			//updating the position of each ball
            repaint();			//calling paint component
        }//for ends
		
	}

}
//class ends
public class ts extends JFrame 
{
	
	public static void main (String args [])
	{
		ts mb = new ts();
		
		 Mypanel mp1 = new Mypanel ();				//making objects of panels
		 Mypanel mp2 = new Mypanel ();
		 Mypanel mp3 = new Mypanel ();
		 Mypanel mp4 = new Mypanel ();
		 Mypanel mp5 = new Mypanel ();
		 Mypanel mp6 = new Mypanel ();
		 Mypanel mp7 = new Mypanel ();
		 Mypanel mp8 = new Mypanel ();
		 Mypanel mp9 = new Mypanel ();
		 Mypanel mp10 = new Mypanel ();
		 mp1.add(mp2);					//adding panels
		 mp2.add(mp3);
		 mp3.add(mp4);
		 mp4.add(mp5);
		 mp5.add(mp6);
		 mp6.add(mp7);
		 mp7.add(mp8);
		 mp8.add(mp9);
		 mp9.add(mp10);
		 mb.add(mp1);
		 								
		 Thread x1 = new Thread(mp1);			//making threads and passing each a different object of the Mypanel class
		Thread x2 = new Thread(mp2);
		Thread x3 = new Thread(mp3);
		Thread x4 = new Thread(mp4);
		Thread x5 = new Thread(mp5);
		Thread x6 = new Thread(mp6);
		Thread x7 = new Thread(mp7);
		Thread x8 = new Thread(mp8);
		Thread x9 = new Thread(mp9);
		Thread x10 = new Thread(mp10);
		x1.start();					//starting all the threads
		x2.start();
		x3.start();
		x4.start();
		x5.start();
		x6.start();
		x7.start();
		x8.start();
		x9.start();
		x10.start();
		
		mb.setTitle("Bouncing Balls");
		mb.setBounds(100,100,410,360);
		mb.setVisible(true);
		mb.setResizable(false);
	}//main ends

}//public class ends
