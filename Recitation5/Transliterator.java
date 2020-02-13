package Recitation5;

/**
 * Transliterator.java
 * Recitation 5 code demonstrates a character transliteration
 * function
 */

/**
 * This class demonstrates a character substitution function 
 * based on transliterating characters from one alphabet to
 * characters in another alphabet for a source string, and
 * using this function to implement substitution ciphers.
 * 
 * @author phil
 * @since 2020-02-06
 */
public class Transliterator {

	/**
	 * Copy fromText to toText, transliterating characters in
	 * fromChars to positionally corresponding characters in
	 * toChars. Characters not in fromChars or with no toChars
	 * character are copied directly to toText.
	 *
	 * @param fromText the source string
	 * @param toChars the characters to replace with
	 * @param fromChars the characters to replace
	 * @return the transliterated string
	 */
	public static String translit ( 
			String fromText, String toChars, String fromChars) {
		int len = fromText.length();
		char[] toText = new char[len];
		
		for (int i = 0; i < len; i++) {
			// get next character as fromChar
			char fromChar = fromText.charAt(i);
			
			// find position of fromChar in fromChars
			int index = fromChars.indexOf(fromChar);
			
			if ((index >= 0) && (index < toChars.length())) {
				// if available, append corresponding char from toChars to toText
				char toChar = toChars.charAt(index);
				toText[i] = toChar;
			} else {
				// if not available, append original fromChar to toText
				toText[i] = fromChar;
			}
		}
		
		return new String(toText);
	}

	/**
	 * Main program tests translit function by illustrating
	 * its use it to implement various substitution ciphers.
	 * 
	 * @see : https://en.wikipedia.org/wiki/Substitution_cipher
	 */
	static public void main(String[] args) {

		String translitText;
		String plainText;

		String plainChars = "abcdefghijklmnopqrstuvwxyz";
		String message = "runforyourlifewearediscovered";

		// transliterate from lower to upper case
		String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.printf("\nTransliterate lower to upper case characters\n");
		System.out.printf("original: %s\n", message);
		translitText = Transliterator.translit(message, upperChars, plainChars);
		System.out.printf("translit: %s\n", translitText);
		
		plainText = translit(translitText, plainChars, upperChars);
		System.out.printf("plain: %s\n", plainText);

		
		// transliterate from lower to greek characters (only 24)
		String greekChars = "αβγδεζηθικλμνξοπρστυφχψω";
		System.out.printf("\nTransliterate lower to greek characters\n");
		System.out.printf("original: %s\n", message);
		translitText = Transliterator.translit(message, greekChars, plainChars);
		System.out.printf("translit: %s\n", translitText);
		
		plainText = translit(translitText, plainChars, greekChars);
		System.out.printf("plain: %s\n", plainText);

		
		// empty transliteration arrays perform no transliteration
		String noChars = "";
		System.out.printf("\nTransliterate no characters\n");
		System.out.printf("original: %s\n", message);
		translitText = Transliterator.translit(message, noChars, noChars);
		System.out.printf("translit: %s\n", translitText);
		
		plainText = translit(translitText, noChars, noChars);
		System.out.printf("plain: %s\n", plainText);
		

		// same transliteration arrays perform no transliteration
		System.out.printf("\nTransliterate all characters to themselves\n");
		System.out.printf("original: %s\n", message);
		translitText = Transliterator.translit(message, plainChars, plainChars);
		System.out.printf("translit: %s\n", translitText);
		
		plainText = translit(translitText, plainChars, plainChars);
		System.out.printf("plain: %s\n", plainText);

		
		// mixed substitution cipher uses a code word with non-repeating
		// characters followed by the unused letters of the alphabet;
		// code word is 'monarchy'.
		String mixedChars = "monarchybdefgijklpqstuvwxz";
		System.out.printf("\nMixed or Deranged code word alphabet substitution cipher\n");
		System.out.printf("original: %s\n", message);
		translitText = Transliterator.translit(message, mixedChars, plainChars);
		System.out.printf("translit: %s\n", translitText);
		
		plainText = translit(translitText, plainChars, mixedChars);
		System.out.printf("plain: %s\n", plainText);

		
		// Caesar substitution cipher was used by Julius Caesar
		// circularly shifts the alphabet by a count. The ROT13 algorithm uses
		// a shift count of 13, transposed upper- and lower-halves of alphabet
		String caesarChars = "nopqrstuvwxyzabcdefghijklm";
		System.out.printf("\nCaesar transposed upper and lower alphabet substitution cipher\n");
		System.out.printf("original: %s\n", message);
		translitText = Transliterator.translit(message, caesarChars, plainChars);
		System.out.printf("translit: %s\n", translitText);
		
		plainText = translit(translitText, plainChars, caesarChars);
		System.out.printf("plain: %s\n", plainText);
		

		// Atbash substitution cipher transposes using reversed alphabet
		String atbashChars = "zyxwvutsrqponmlkjihgfedcba";
		System.out.printf("\nAtbash reversed alphabet substitution cipher\n");
		System.out.printf("original: %s\n", message);
		translitText = Transliterator.translit(message, atbashChars, plainChars);
		System.out.printf("translit: %s\n", translitText);
		
		plainText = translit(translitText, plainChars, atbashChars);
		System.out.printf("plain: %s\n", plainText);
		
		plainText.toCharArray();
	}
}
