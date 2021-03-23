package fr.grandoz.lifegame;

import java.util.Random;

public class Regle {
private Main main;
	public Regle(Main main) {
	this.main = main;
			}
	
	
	
	
	
	
	
	
	
	public void reglealea() {

		Random r = new Random();
	Block randomb = main.getRandomFill();
int tom = r.nextInt(7);
		if(tom == 0) {
			Block b1 = main.getBlockDown(randomb);
			if(b1 != null) {
				b1.setIsFill(true);
				randomb.setIsFill(false);
			}
		}
		if(tom == 1) {
			Block b1 = main.getBlockUp(randomb);
			if(b1 != null) {
				b1.setIsFill(true);
				randomb.setIsFill(false);
			}
		}
		if(tom == 2	) {
			Block b1 = main.getBlockByXY(randomb.getX()+10,randomb.getY()-10);
			if(b1 != null) {
				b1.setIsFill(true);
				randomb.setIsFill(false);
			}
		}
		if(tom == 3) {
			Block b1 = main.getBlockByXY(randomb.getX()-20 ,randomb.getY()+10);
			if(b1 != null) {
				b1.setIsFill(true);
				randomb.setIsFill(false);
			}
		}	if(tom == 4	) {
			Block b1 = main.getBlockByXY(randomb.getX()+10 ,randomb.getY()-10);
			if(b1 != null) {
				b1.setIsFill(true);
				randomb.setIsFill(false);
			}
		}
		if(tom == 5	) {
			Block b1 = main.getBlockByXY(randomb.getX()+10 ,randomb.getY()+10);
			if(b1 != null) {
				b1.setIsFill(true);
				randomb.setIsFill(false);
			}
		}
		if(tom == 6	) {
			Block b1 = main.getBlockByXY(randomb.getX()-20 ,randomb.getY()+20);
			if(b1 != null) {
				b1.setIsFill(true);
				randomb.setIsFill(false);
			}
		}
		if(tom == 7	) {
			Block b1 = main.getBlockByXY(randomb.getX()-25 ,randomb.getY()+30);
			if(b1 != null) {
				b1.setIsFill(true);
				randomb.setIsFill(false);
			}
		}
	}
	
	
	
	public void news(Block b) {
		
		
		Block up = main.getBlockUp(b);
		Block down = main.getBlockDown(b);
		Block left = main.getBlockLeft(b);
		Block right = main.getBlockRight(b);
		Block up_left = main.getBlockByXY(left.getX(), up.getY());
		Block up_right = main.getBlockByXY(right.getX(), up.getY());
		Block down_left = main.getBlockByXY(left.getX(), down.getY());
		Block down_right = main.getBlockByXY(right.getX(), down.getY());
		
		
				
		
		
		
		
		
		
		
		
		
		
		
		
	}
	public void goid() {
		
		
		for(int i =0 ; i<main.getBlocks().size() ; i++) {
			Block filled = main.getBlocks().get(i);
			if(filled.isIsFill()) {
				
				System.out.println(main.getBlockAround(filled).size());
				if(main.IsAllAroundFIlled(filled)) {
					filled.setIsFill(false);
				}
				
				if(!main.IsAllAroundFIlled(filled)) {
				}
				
				
				
				
				
				
				
			}
		}
		
		
		
		
		
		
	}
	
	
	

	
}
