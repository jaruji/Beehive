package hlavna;

import druhy_vciel.*;
import java.util.Timer;
import java.util.TimerTask;
import prostredie.*;
import procesy.*;

public class Cyklus {

	static int cas = 0;
	int n;
	int m;
	Timer timer = new Timer();
	Ul ul;
	Robotnicka[] robotnicka;
	Bod[][] luka;
	Kralovna kralovna;
	Trud[] trud;

	Cyklus(Ul ul, Robotnicka[] robotnicka, Bod[][] luka, Kralovna kralovna, Trud[] trud, int n, int m) {
		this.n = n;
		this.m = m;
		this.ul = ul;
		this.robotnicka = robotnicka;
		this.luka = luka;
		this.kralovna = kralovna;
		this.trud = trud;
	}

	// zaciatok simulacie
	TimerTask task = new TimerTask() {
		public void run() {
			// kazdodenny zivot vcely
			int x = 0;
			x++;
			cas += x;
			System.out.println("Od spustenia simulacie ubehlo uz: " + cas + " minut");
			for (int i = 0; i < Trud.getPocet(); i++) {
				trud[i].setVek(1);
				if (trud[i].getVek() > trud[i].getDlzkaZivota()) {
					trud[i].smrt();
				}
			}
			int pom = ul.getPocetVciel();
			for (int i = 0; i < pom; i++) {
				robotnicka[i].setVek(x);
				if (cas % 5 == 0) {
					robotnicka[i].zvysUnava(1);
				}
				if (robotnicka[i].getVek() >= robotnicka[i].getDlzkaZivota()) {
					robotnicka[i].smrt();
					ul.setPocetVciel(-1);
				}

				if (robotnicka[i].getLieta() == true) {
					System.out.println("Vcela cislo " + (i + 1) + " zije uz " + robotnicka[i].getVek()
							+ " minut, suradnice su:[" + robotnicka[i].getX() + "," + robotnicka[i].getY()
							+ "], unava: " + robotnicka[i].getUnava());
				}
				// generujem novu cielovu rastlinu
				if (robotnicka[i].getIdentifikator() == -1) {
					robotnicka[i].najdiKvet();
					robotnicka[i].setDoletela(false);
				}

				// pohybovanie a vyhladavanie kvetov
				for (int k = 0; k < n; k++) {
					for (int j = 0; j < m; j++) {
						if (luka[k][j].getA() != null) {
							if (robotnicka[i].getLieta() == true && robotnicka[i].getZije() == true
									&& luka[k][j].getA().getIdentifikator() == robotnicka[i].getIdentifikator()
									&& luka[k][j].getA().getObsahNektaru() > 0
									&& robotnicka[i].vzdialenost(luka[k][j].getA()) <= robotnicka[i].getDolet()) {
								if (robotnicka[i].getDoletela() == false) {
									robotnicka[i].let(luka[k][j].getA(), x);
									System.out.println("Robotnicka " + (i + 1) + " leti pre kvet "
											+ luka[k][j].getA().getIdentifikator() + " v zaludku ma  : "
											+ robotnicka[i].getObjemNektaru() + " mg nektaru");
								}
							} else if (robotnicka[i].getLieta() == true && robotnicka[i].getZije() == true
									&& luka[k][j].getA().getIdentifikator() == robotnicka[i].getIdentifikator()
									&& robotnicka[i].vzdialenost(luka[k][j].getA()) <= robotnicka[i].getDolet()) {
								robotnicka[i].najdiKvet();
							} else if (robotnicka[i].getLieta() == true && robotnicka[i].getZije() == true
									&& luka[k][j].getA().getIdentifikator() == robotnicka[i].getIdentifikator()
									&& luka[k][j].getA().getObsahNektaru() > 0)
								robotnicka[i].najdiKvet();
						}
					}
				}

				// ak je unavena tak sa musi vratit
				if (robotnicka[i].getUnava() >= robotnicka[i].getVydrz()) {
					robotnicka[i].setDoletela(true);
				}

				if (robotnicka[i].getDoletela() == true) {
					if ((robotnicka[i].getObjemNektaru() < 70) && (robotnicka[i].getUnava() < robotnicka[i].getVydrz()))
						robotnicka[i].setIdentifikator(-1);
					else {
						robotnicka[i].let(ul, x);
						System.out.println(
								"Robotnicka leti domov s objemom nektaru : " + robotnicka[i].getObjemNektaru());
						if (ul.jeVcela(robotnicka[i]) && cas > 1) {
							robotnicka[i].odovzdajNektar(ul);
							robotnicka[i].setUnava(0);
						}
					}
				}
			}

			// kralovna kladie vajicka = nove vcely

			kralovna.kladVajicka(cas);
			/*
			 * Vajicka[] vajicka = new Vajicka[kralovna.getVajicka()]; for(int i = 0; i <
			 * kralovna.getVajicka(); i++){ if(vajicka[i] == null) vajicka[i] = new
			 * Vajicka(); vajicka[i].setVek(1); if(vajicka[i].getVek() >=
			 * Vajicka.dobaVyvinu) { kralovna.setVajicka(-1);
			 * //robotnicka[luka[n/2][m/2].getPovodnyUl().getPocetVciel() + 1] = new
			 * Robotnicka(); } }
			 */

			System.out.println("Ubehlo uz " + cas + " minut, v uli je " + ul.getMnozstvoNektaru() + "mg nektaru");
			System.out.println("Vcely opelili uz " + Robotnicka.opelenych + " kvetov");
			System.out.println("Kralovna sa nachadza na suradniciach [" + kralovna.getX() + "," + kralovna.getY()
					+ "], uz nakladla " + kralovna.getVajicka() + " vajicok");
			// System.out.println("Pocet robotnicok v uli je:
			// "+luka[n/2][m/2].getPovodnyUl().getPocetVciel()+" pocet trudov je "+
			// Trud.getPocet());
			Tvorba_medu.urobMed(ul, cas);
			System.out.println("V uli bude " + Tvorba_medu.getMnozstvoMedu() + "mg medu");
			System.out.println(" ");

		}
	};

	public void start() {
		timer.scheduleAtFixedRate(task, 5000, 500);
	}
}