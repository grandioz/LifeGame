package fr.grandoz.lifegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.javafx.collections.SetListenerHelper;


public class GPanel extends JPanel {
	int x = 0;
	Main main;
	
	int y = 0;
	int range;
	public GPanel(Main main) {
		this.main = main;
		range = main.getRange();	
		this.setSize(50*12, 50*12);
	setBackground(Color.BLACK);
	Thread t = new Thread(new Runnable() {	
		@Override
		public void run() {
			while(true) {
repaint();				
try {	
	Thread.sleep(1000/40l);
} catch (InterruptedException e) {
	e.printStackTrace();
}
		}
		}
	});
	t.start();
	
	
	
	
   addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		int x = e.getX();
		if(main.getLastNumber(x)!= 0) {
			x = x-main.getLastNumber(x);
		}
		int y= e.getY();
		if(main.getLastNumber(y) != 0) {
			y = y-main.getLastNumber(y);
		}
		
		Block clicked = main.getBlockByXY(x, y);
		if(clicked != null) {
			clicked.setIsFill(true);
		}else {
			main.setStat(State.ACTIVE);
			JLabel label = new JLabel();
			label.setBounds(0, 0,301, 200);
			label.setText("ACTIVE");
			label.setBackground(Color.red);
			add(label);
		}
		
		repaint();
		
		
		
		
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
});
	
	
	
	
	
	
	
	
	
	
	
	
	

	}
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			Block b = new Block(true, 0,0);
			for(int i  =0 ; i< main.getBlocks().size() ; i++) {
				
				if(main.getBlocks().get(i).IsFill) {
					g.fillRect(main.getBlocks().get(i).getX(), main.getBlocks().get(i).getY(), 10,10);
				}else {
					g.drawRect(main.getBlocks().get(i).getX(), main.getBlocks().get(i).getY(), 10,10);
				}
			}
			
			
			setBackground(Color.white);
			
			while(x !=  range && y!= range) {
			if(x != range && y != range) {
				g.setColor(Color.black);
				Random r =new Random();
				Block b1 ;
		
					b1 = new Block(false , x, y);
				
			
				main.getBlocks().add(b1);
			x = x+10;
			if(x ==range) {
				y=y+10;
				x=0;
			}
				
			}
				
				
				
			}
			if(main.getStat()==State.ACTIVE) {
			
			Regle regle = new Regle(main);
			regle.news();
			}
		}	
			
		
}
