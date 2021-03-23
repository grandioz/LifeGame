package fr.grandoz.lifegame;

import java.awt.Color;

public class Block {
public boolean IsFill;
public Color color;
int x ;
int y;

public int getX() {
	return x;
}


public void setX(int x) {
	this.x = x;
}


public int getY() {
	return y;
}


public void setY(int y) {
	this.y = y;
}


public Block(boolean IsFill , int x , int y) {
	this.IsFill = IsFill;
	this.x = x;
	this.y = y;
}


public boolean isIsFill() {
	return IsFill;
}


public void setIsFill(boolean isFill) {
	IsFill = isFill;
}


public Color getColor() {
	return color;
}


public void setColor(Color color) {
	this.color = color;
}

}
