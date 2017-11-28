package kvety;

public class Lipa extends Strom {

	public Lipa() {
		this.identifikator = pocitadlo;
		pocitadlo++;
		pocetStromov++;
		this.kvety = srand.nextInt(2001) + 8000;
		this.obsahNektaru = 0.8 * this.kvety;
	}
}
