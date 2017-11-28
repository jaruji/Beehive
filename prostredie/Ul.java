package prostredie;

import druhy_vciel.*;

public class Ul {

	private int x;
	private int y;
	private boolean obsadeny;
	private int pocetVciel;
	private int pocetVajicok;
	private double mnozstvoNektaru;

	public Ul() {
		this.pocetVciel = 0;
		this.obsadeny = true;
		this.pocetVajicok = 0;
		this.mnozstvoNektaru = 0;
	}

	public int getPocetVajicok() {
		return pocetVajicok;
	}

	public void setPocetVajicok(int pocetVajicok) {
		this.pocetVajicok = pocetVajicok;
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

	public boolean isObsadeny() {
		return obsadeny;
	}

	public void setObsadeny(boolean obsadeny) {
		this.obsadeny = obsadeny;
	}

	public int getPocetVciel() {
		return pocetVciel;
	}

	public void setPocetVciel(int pocetVciel) {
		this.pocetVciel += pocetVciel;
	}

	public void nastavSuradnice(Vcela a) {
		a.setX(this.x);
		a.setY(this.y);
	}

	public double getMnozstvoNektaru() {
		return mnozstvoNektaru;
	}

	public void setMnozstvoNektaru(double mnozstvoNektaru) {
		this.mnozstvoNektaru += mnozstvoNektaru;
	}

	public boolean jeVcela(Vcela a) {
		if (a.getX() == this.x && a.getY() == this.y)
			return true;
		else
			return false;
	}
}
