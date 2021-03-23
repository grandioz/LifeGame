package fr.grandoz.lifegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

public class Main {
	public List<Block> blocks = new ArrayList<Block>();
	State stat = State.PASSIVE;
			public State getStat() {
		return stat;
	}





	public void setStat(State stat) {
		this.stat = stat;
	}
			static JFrame frame = new JFrame();
			public int range =600;
			
			
			
	public int getRange() {
				return range;
			}





			public void setRange(int range) {
				this.range = range;
			}	





	public List<Block> getBlocks() {
				return blocks;
			}





			public void setBlocks(List<Block> blocks) {
				this.blocks = blocks;
			}





			public static JFrame getFrame() {
				return frame;
			}





			public static void setFrame(JFrame frame) {
				Main.frame = frame;
			}





	public static void main(String[] args) {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(20*30, 20*30);
		frame.setTitle("Game Life V0.0.5");
		frame.setLocationRelativeTo(null);
		frame.setContentPane(new GPanel(new Main()));
		
	}

	
	
	
	
	public void DrawNotFillnX(int x , int y) {
		
	}
public Block getBlockByXY(int x , int y) {
	for(int i = 0 ; i<blocks.size() ; i++) {
		if(blocks.get(i).getX() == x && blocks.get(i).getY() == y) {
			return blocks.get(i);
		}
	}
	return null;
}
public Block getBlockDown(Block b) {
	
	Block p = new Block(true, b.getX(),b.getY()+10);
	Block after = getBlockByXY(p.getX(), p.getY());
	if(after == null) {
		getBlockUp(b);
	}
	return after;
	
}
public Block getBlockUp(Block b) {
	
	Block p = new Block(true, b.getX(),b.getY()-10);
	Block after = getBlockByXY(p.getX(), p.getY());
	if(after == null) {
		return getBlockDown(b);
	}
	return after;
	
}
public Block getRandomFill() {
	List<Block > filled = new ArrayList<Block>();
	Random r = new Random();
	for(int i = 0 ; i<blocks.size() ; i++) {
	
		
		Block b = blocks.get(i);
		if(b.IsFill) {
			filled.add(b);
		}
	}
	Block be= filled.get(r.nextInt(filled.size()));
	return be;
}
public Block getBlockRight(Block b) {
	
	Block p = new Block(true, b.getX()+10,b.getY());
	Block after = getBlockByXY(p.getX(), p.getY());
	if(after == null) {
		return getBlockLeft(b);
	}
	return after;
	
}
public Block getBlockLeft(Block b) {
	
	Block p = new Block(true, b.getX()-10,b.getY());
	Block after = getBlockByXY(p.getX(), p.getY());
	if(after == null) {
		return getBlockRight(b);	
	}
	return after;
	
}
public List<Block> getBlockAround(Block b){
	List<Block> around = new ArrayList<Block>();
	Block up = getBlockUp(b);	
	Block down = getBlockDown(b);
	Block left = getBlockLeft(b);
	Block right = getBlockRight(b);
	Block up_right = getBlockByXY(b.getX()+10, b.getY()+10);
	Block up_left = getBlockByXY(b.getX()-10, b.getY()+10);
	Block down_right = getBlockByXY(b.getX()+10, b.getY()-10);
	Block down_left = getBlockByXY(b.getX()-10, b.getY()-10);
	if(up != null) {
		around.add(up );
	}
	if(up_right != null) {
		around.add(up_right );
	}

if(up_left != null) {
	around.add(up_left );
}
	if(left != null) {
		around.add(left);
	}
	if(right!= null) {
		around.add(right);
	}
	if(down_left != null) {
		around.add(down_left);
	}
	if(down!= null) {
		around.add(down);
	}
	if(down_right!= null) {
		around.add(down_right);
	}
	
	return around;
}
public boolean IsAllAroundFIlled(Block b ) {
	for(int i  = 0 ;i< getBlockAround(b).size(); i++) {
		if(!getBlockAround(b).get(i).isIsFill()) {
			return false;
		}
	}
	return true;
}
public boolean IsOnLimite(Block b) {
	for(int i =0 ; i<getBlockAround(b).size() ; i++) {
		if(getBlockAround(b).get(i) == null) {
		
			return true;
		}
	}
	return false;
}
public List<Block> getFilledAround(Block b){
	List<Block> filled = new ArrayList<Block>();
	for(int i = 0 ; i<getBlockAround(b).size() ; i++) {
		if(getBlockAround(b).get(i).isIsFill()) {
			filled.add(getBlockAround(b).get(i));
		}
	}
	return filled;
}
public static int getLastNumber(int nbr) {
	  String nombre = Integer.toString(nbr);
	  char nb = nombre.charAt(nombre.length()-1);
	  int my = Character.getNumericValue(nb);
	  return my;
			  }
public List<Block> getFillAround(Block b){
	List<Block > fill = new ArrayList<Block>();
	for(int i = 0 ; i <getBlockAround(b).size() ; i++) {
		if(getBlockAround(b).get(i).isIsFill()){
			fill.add(getBlockAround(b).get(i));
		}
	}
	return fill;
}
}
