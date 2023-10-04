/**
 * this class is used to generate and then solve passwords based on there
 * complexity
 * 
 * @author samuel vossen
 *
 */
public class Assignment8 {
	/**
	 * this method turns a string into its hexadecimal
	 * 
	 * @param str
	 * @return string into its hexadecimal
	 */
	static String hexconverter(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			String hex = Integer.toHexString(str.charAt(i));
			result += hex;
		}
		return result;
	}

	/**
	 * this method creates a four character password, and then attempts to guess the
	 * password until solved
	 * 
	 * @param charSet the set of characters that the passwords can be made of
	 * @return the amount of time it takes to guess the password in nanoseconds
	 */
	public static double password(String charSet) {
		String rndPassword = "";
		for (int i = 0; i < 4; i++) {
			rndPassword += charSet.charAt((int) (Math.random() * charSet.length()));
		}
		System.out.println("Generated password is: " + rndPassword);
		System.out.println("Generated password in hex is: " + hexconverter(rndPassword));
		int guesses = 0;
		long start = System.currentTimeMillis();
		boolean match = false;
		for (int j = 0; j < charSet.length() && !match; j++) {
			for (int e = 0; e < charSet.length() && !match; e++) {
				for (int x = 0; x < charSet.length() && !match; x++) {
					for (int p = 0; p < charSet.length() && !match; p++) {
						String pass = "" + charSet.charAt(j) + charSet.charAt(e) + charSet.charAt(x)
								+ charSet.charAt(p);
						if (rndPassword.equals(pass)) {
							match = true;
						}
						guesses++;
					}
				}
			}
		}
		long stop = System.currentTimeMillis();
		double seconds = (stop - start) / 1000.0;
		System.out.println("match the password after " + guesses + " guesses.");
		System.out.printf("It took %.6f seconds to find the password.\n", seconds);
		return seconds;
	}

	public static void main(String[] args) {
		System.out.println("Assignment #7 for ICS 462 by Samuel Vossen");
		System.out.println("");
		double x = password("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		System.out.println("");
		double y = password("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789:;><=?@{}\\^_`");
		System.out.println("");
		System.out
				.println("It took " + y / x + " times as long with the expanded character set to guess the password.");
	}
}