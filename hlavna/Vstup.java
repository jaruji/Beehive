package hlavna;

import java.util.Scanner;

import druhy_vciel.*;
import prostredie.Bod;
import prostredie.Ul;
import kvety.*;

public class Vstup {
	static int m, n;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Zadajte rozmery luky:");
		m = s.nextInt();
		n = s.nextInt();
		s.close();
		// vytvorenie luky na zaklade vstupu
		Bod[][] luka = new Bod[n][m];
		System.out.println("Rozmery luky budu:" + m + "x" + n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				luka[i][j] = new Bod();
				if (luka[i][j].getA() != null) {
					luka[i][j].getA().setY(i);
					luka[i][j].getA().setX(j);
				}
			}
		}

		// vytvorim ul
		luka[n / 2][m / 2].setA(null);
		luka[n / 2][m / 2].setPovodnyUl(new Ul());
		Ul ul = luka[n / 2][m / 2].getPovodnyUl();
		ul.setY(n / 2);
		ul.setX(m / 2);

		System.out.println("Na mape sa nachadza " + Strom.pocetStromov + " stromov");
		System.out.println("Na mape sa nachadza " + Kvet.pocetKvetov + " kvetov");
		// generujem zakladne vcely
		Robotnicka[] robotnicka = new Robotnicka[400];
		for (int i = 0; i < 400; i++) {
			robotnicka[i] = new Robotnicka();
			ul.setPocetVciel(1);
			ul.nastavSuradnice(robotnicka[i]);
			if ((i + 1) % 2 == 0) {
				robotnicka[i].setLieta(true);
			}
		}

		Trud[] trud = new Trud[5];
		for (int i = 0; i < 5; i++) {
			trud[i] = new Trud();
		}

		Kralovna kralovna = new Kralovna();
		kralovna.setX(ul.getX());
		kralovna.setY(ul.getY());
		Cyklus hlavna = new Cyklus(ul, robotnicka, luka, kralovna, trud, n, m);
		hlavna.start();
	}

}
