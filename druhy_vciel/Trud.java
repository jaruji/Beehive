package druhy_vciel;

public class Trud extends Vcela {

	private boolean oplodnil;
	private static int pocet = 0;

	public Trud() {
		this.vek = 0;
		this.zije = true;
		this.oplodnil = false;
		pocet++;
		this.dlzkaZivota = 90 * 24 * 60;
	}

	public static int getPocet() {
		return pocet;
	}

	public static void setPocet(int pocet) {
		Trud.pocet += pocet;
	}

	public boolean getOplodnil() {
		return oplodnil;
	}

	public void setOplodnil(boolean oplodnil) {
		this.oplodnil = oplodnil;
	}

	public void smrt() {
		this.zije = false;
		pocet--;
	}
}
