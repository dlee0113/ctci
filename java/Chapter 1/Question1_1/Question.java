package Question1_1;

// reference
// http://stackoverflow.com/questions/19484406/detecting-if-a-string-has-unique-characters-comparing-my-solution-to-cracking


public class Question {

	public static boolean isUniqueChars(String str) {
		if (str.length() > 256) { // size of extended ASCII table (http://www.ascii-code.com/)
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	public static boolean isUniqueChars2(String str) {
		if (str.length() > 256) { // size of extended ASCII table (http://www.ascii-code.com/)
			return false;
		}
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
//		String[] words = {"€"}; // error on extended ASCII character
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word) + " " + isUniqueChars2(word));
		}
	}

}
