package prostredie;

import kvety.*;
import java.util.Random;

public class Bod {
	private Rastlina a;
	private Random srand = new Random();
	private int pom;
	private Ul povodnyUl = null;

	public Bod() {
		pom = srand.nextInt(51);

		if (pom <= 0 && pom >= 3)
			a = null;

		else if (pom >= 4 && pom <= 27) {
			a = new Pupava();
		}

		else if (pom >= 28 && pom <= 48) {
			a = new Harmancek();
		}

		else if (pom == 49)
			a = new Agat();

		else if (pom == 50)
			a = new Lipa();
	}

	public void setA(Rastlina a) {
		this.a = a;
	}

	public Rastlina getA() {
		return a;
	}

	public Ul getPovodnyUl() {
		return povodnyUl;
	}

	public void setPovodnyUl(Ul povodnyUl) {
		this.povodnyUl = povodnyUl;
	}
}
