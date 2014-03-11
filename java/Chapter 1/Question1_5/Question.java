package Question1_5;

public class Question {

	public static int setChar(char[] array, char c, int index, int count) {
		array[index] = c;
		index++;
		char[] cnt = String.valueOf(count).toCharArray();
		for (char x : cnt) {
			array[index] = x;
			index++;
		}
		return index;
	}
	
	// return length of compressed string
	// ex) abbccccccde (length: 11) -> a1b2c6d1e1 (length: 10)
	public static int countCompression(String str) {
		if (str == null || str.isEmpty()) return 0;
		
		char last = str.charAt(0); // keep track of processed character
		int size = 0;
		int count = 1;
		
		// start for loop from 1 since count is set to 1
		for (int i = 1; i < str.length(); i++) {
			// if current character matches last character, increment count by 1
			// This condition counts number of repeated characters
			if (str.charAt(i) == last) {
				count++;
			}
			// if no match, current character becomes last character
			else {
				System.out.println("last: " + last);
				
				last = str.charAt(i);
				// add 1 for a character and add length of count
				// ex) count: 2 -> length: 1, count: 10 -> length: 2
				size += 1 + String.valueOf(count).length();
				
				System.out.println("count: " + count);
				
				// reset count
				count = 1;
			} 
		}
		size += 1 + String.valueOf(count).length();

		System.out.println("size: " + size);
		
		return size;
	}
	
	public static String compressBad(String str) {
//		int size = countCompression(str);
//		if (size >= str.length()) {
//			return str;
//		}
		
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				mystr += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}
		return mystr + last + count;
	}
	
	public static String compressBetter(String str) {
//		int size = countCompression(str);
//		if (size >= str.length()) {
//			return str;
//		}
		
		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		
		// start for loop from 1 since count is set to 1
		for (int i = 1; i < str.length(); i++) {
			// if current character matches last character, increment count by 1
			// This condition counts number of repeated characters			
			if (str.charAt(i) == last) {
				count++;
			}
			// if no match, current character becomes last character
			else {
				mystr.append(last);
				mystr.append(count);
				
				// set last to be current character being read
				last = str.charAt(i);
				// reset count
				count = 1;
			}
		}
		mystr.append(last);
		mystr.append(count);
		
		return mystr.toString();
	}	
	
	public static String compressAlternate(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		
		char[] array = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				index = setChar(array, last, index, count);
				last = str.charAt(i);
				count = 1;
			}
		}
		index = setChar(array, last, index, count);
		return String.valueOf(array);
	}
	
	public static void main(String[] args) {
//		String str = "abbccccccde";
		String str = "abc";
		int c = countCompression(str);
		
		System.out.println("str: " + str);
		System.out.println("c: " + c);
		
		
		if (c >= str.length()) {
			String str2 = compressBad(str);
	//		String str2 = compressAlternate(str);
	//		String str2 = compressBetter(str);
			
//			System.out.println("Compression: " + t);
			System.out.println("Old String (len = " + str.length() + "): " + str);
			System.out.println("New String (len = " + str2.length() + "): " + str2);
			System.out.println("Potential Compression: " + c);			
		}
	}
}
