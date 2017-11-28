package druhy_vciel;

import kvety.*;
import prostredie.*;

public class Robotnicka extends Vcela {
	private int dolet;
	private int vydrz;
	private double objemNektaru;
	static final int maxNektaru = 70;
	public static int opelenych = 0;
	private int unava;
	private int rychlostLetu;
	private boolean lieta = false;
	private boolean doletela;
	private int identifikator = -1;

	public int getIdentifikator() {
		return identifikator;
	}

	public void setIdentifikator(int identifikator) {
		this.identifikator = identifikator;
	}

	public boolean getLieta() {
		return lieta;
	}

	public void setLieta(boolean lieta) {
		this.lieta = lieta;
	}

	public Robotnicka() {
		this.dolet = 60;
		this.vydrz = srand.nextInt(5) + 6;
		this.objemNektaru = 0;
		this.vek = 0;
		this.unava = 0;
		this.zije = true;
		this.dlzkaZivota = srand.nextInt(7 * 24) + 6 * 7 * 24;
		this.rychlostLetu = 3;
		this.doletela = false;
	}

	public int getRychlostLetu() {
		return rychlostLetu;
	}

	public void setRychlostLetu(int rychlostLetu) {
		this.rychlostLetu = rychlostLetu;
	}

	public int getDolet() {
		return dolet;
	}

	public void setDolet(int dolet) {
		this.dolet = dolet;
	}

	public int getVydrz() {
		return vydrz;
	}

	public void setVydrz(int vydrz) {
		this.vydrz = vydrz;
	}

	public double getObjemNektaru() {
		return objemNektaru;
	}

	public void setObjemNektaru(int objemNektaru) {
		this.objemNektaru = objemNektaru;
	}

	public int getUnava() {
		return unava;
	}

	public void setUnava(int unava) {
		this.unava = unava;
	}

	public void zvysUnava(int unava) {
		this.unava += unava;
	}

	public boolean getDoletela() {
		return doletela;
	}

	public void najdiKvet() {
		this.identifikator = srand.nextInt(Rastlina.pocitadlo);
	}

	public int vzdialenost(Rastlina a) {
		int vzdialenost = (int) Math.sqrt(Math.pow(this.x - a.getX(), 2) + Math.pow((this.y - a.getY()), 2));
		return vzdialenost;
	}

	public void vysajNektar(Rastlina a) {
		if (a.getObsahNektaru() > maxNektaru) {
			this.objemNektaru += (maxNektaru - this.objemNektaru);
			a.setObsahNektaru(-(maxNektaru - this.objemNektaru));
		} else if (this.objemNektaru + a.getObsahNektaru() > maxNektaru) {
			this.objemNektaru += (maxNektaru - this.objemNektaru);
			a.setObsahNektaru(-(maxNektaru - this.objemNektaru));
		} else {
			this.objemNektaru += a.getObsahNektaru();
			a.setObsahNektaru(0);
		}
	}

	public void let(Ul ul, int b) {
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < this.rychlostLetu; j++) {
				if (this.x != ul.getX()) {
					if (this.x < ul.getX())
						this.x += 1;
					if (this.x > ul.getX())
						this.x -= 1;
				}
				if (this.y != ul.getY()) {
					if (this.y < ul.getY())
						this.y += 1;
					if (this.y > ul.getY())
						this.y -= 1;
				}
			}
		}
	}

	public void let(Rastlina a, int b) {
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < this.rychlostLetu; j++) {
				if (this.x != a.getX()) {
					if (this.x < a.getX())
						this.x += 1;
					else if (this.x > a.getX())
						this.x -= 1;
				}
				if (this.y != a.getY()) {
					if (this.y < a.getY())
						this.y += 1;
					else if (this.y > a.getY())
						this.y -= 1;
				}
			}
		}

		if (this.x == a.getX() && this.y == a.getY()) {
			a.setOpeleny(true);
			opelenych++;
			vysajNektar(a);
			this.doletela = true;
		}

	}

	public void odovzdajNektar(Ul ul) {
		ul.setMnozstvoNektaru(this.objemNektaru);
		this.objemNektaru = 0;
		this.identifikator = -1;
		this.doletela = false;
	}

	public void setDoletela(boolean doletela) {
		this.doletela = doletela;
	}
}
