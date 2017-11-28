package vajicka;
//import druhy_vciel.*;

public class Vajicka {
	
	private int vek;
	//private boolean oplodnene;
	public static final int dobaVyvinu = 21 * 24;
	
	public Vajicka(){
		this.vek = 0;
		//this.oplodnene = true;
	}
	
	public int getVek() {
		return vek;
	}

	public void setVek(int vek) {
		this.vek += vek;
	}	
}

