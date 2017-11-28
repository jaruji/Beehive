package kvety;

import java.util.Random;

public class Rastlina {
	
	Random srand = new Random();
	public static int pocitadlo = 0;
	protected int identifikator;
	protected int x;
	protected int y;
	protected double obsahNektaru;
	protected boolean opeleny;
	
	public int getIdentifikator() {
		return identifikator;
	}
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
	public double getObsahNektaru() {
		return obsahNektaru;
	}
	public void setObsahNektaru(double obsahNektaru) {
		this.obsahNektaru = obsahNektaru;
	}
	public boolean isOpeleny() {
		return opeleny;
	}
	public void setOpeleny(boolean opeleny) {
		this.opeleny = opeleny;
	}
	
	public void obnovNektar(int x) {
		
	}
	
}
