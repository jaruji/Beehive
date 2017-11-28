package kvety;

public class Agat extends Strom {
	
	public Agat() {
		this.identifikator = pocitadlo;
		pocitadlo++;
		pocetStromov++;
		this.kvety = srand.nextInt(2001)+8000;
		this.obsahNektaru = 1*this.kvety;
	}
}
