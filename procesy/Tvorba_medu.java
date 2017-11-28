package procesy;

import prostredie.*;

public class Tvorba_medu {
	private static double mnozstvoMedu;

	public static void urobMed(Ul ul, int x) {
		if (x % (1) == 0)
			mnozstvoMedu = ul.getMnozstvoNektaru() / 2.5;
	}

	public static double getMnozstvoMedu() {
		return mnozstvoMedu;
	}

	public static void setMnozstvoMedu(double mnozstvoMedu) {
		Tvorba_medu.mnozstvoMedu = mnozstvoMedu;
	}
}
