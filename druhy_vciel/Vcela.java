package druhy_vciel;

import java.util.Random;

public class Vcela {
	protected Random srand = new Random();
	protected int vek;
	protected boolean zije;
	protected int dlzkaZivota;
	protected int x;
	protected int y;

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

	public int getDlzkaZivota() {
		return dlzkaZivota;
	}

	public void setVek(int a) {
		this.vek += a;
	}

	public int getVek() {
		return this.vek;
	}

	public void setZije(boolean a) {
		this.zije = a;
	}

	public boolean getZije() {
		return this.zije;
	}

	public void smrt() {
		this.zije = false;
	}
}