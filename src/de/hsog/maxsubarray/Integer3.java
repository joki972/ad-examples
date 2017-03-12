package de.hsog.maxsubarray;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Integer3 dient der Abspeicherung 
 * zweier Arrayindices und einer Summe
 * @author Trahasch
 *
 */
public class Integer3 {
	int lower, upper;
	long sum;

	Integer3() {
		set(0, -1, 0);
	}

	Integer3(int l, int u, long s) {
		set(l, u, s);
	}

	public void set(int l, int u, long s) {
		lower = l;
		upper = u;
		sum = s;
	}

	public void set(Integer3 o) {
		set(o.lower, o.upper, o.sum);
	}

	public String toString() {
		String pattern = "###,###.###";
		Locale loc = new Locale("de", "DE");
		NumberFormat nf = NumberFormat.getNumberInstance(loc);
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern(pattern);
		String output = df.format(sum);
		
		return "lower: " + lower + " upper: " + upper + " sum: " + output;
	}
}
