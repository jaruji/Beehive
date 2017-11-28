package druhy_vciel;

public class Kralovna extends Vcela {
	protected int vajicka;
	protected boolean rojenie;

	public Kralovna() {
		this.vek = 0;
		this.vajicka = 0;
		this.rojenie = false;
		this.zije = true;
		this.dlzkaZivota = srand.nextInt(24 * 365) + (24 * 365 * 2);
	}

	public void kladVajicka(int x) {
		int pom;
		if (Trud.getPocet() > 0 && (x % 60) == 0) {
			pom = srand.nextInt(3);
			if (pom == 0 || pom == 1)
				this.vajicka += 1;
		}
	}

	public int getVajicka() {
		return vajicka;
	}

	public void setVajicka(int vajicka) {
		this.vajicka += vajicka;
	}
}
