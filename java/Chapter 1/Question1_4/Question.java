package Question1_4;

import CtCILibrary.AssortedMethods;

public class Question {
	// Assume string has sufficient free space at the end
	public static void replaceSpaces(char[] str, int length) {
		int spaceCount = 0, index, i = 0;
		
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
//		index = length + spaceCount * 2;
		index = str.length - 1; // max index of str array
		
		System.out.println("length: " + length); // length of string
		System.out.println("spaceCount: " + spaceCount);
		System.out.println("index: " + index); // length of array
		
//		str[index] = '\0'; // decimal ASCII for NUL
		
		System.out.println("str[" + index + "]: " + str[index]);
		System.out.println("(int) str[" + index + "]: " + (int) str[index]);
		
		System.out.println("str: \"" + String.valueOf(str) + "\"");
		System.out.println();
		System.out.println("beginning of for loop");
		System.out.println();
		
		// index is an indicator to an element of array, index is 0 based.
		// i is an indicator to a character of string
		// this loop end once every character of string is processed.
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				// copy %20 characters into str array
				str[index - 0] = '0';
				str[index - 1] = '2';
				str[index - 2] = '%';
				
				System.out.println("index: " + index);
				// move index pointer three times to front
				index = index - 3;
				
				System.out.println("str: \"" + String.valueOf(str) + "\"");
				System.out.println();
			} 
			else {
				System.out.println("index: " + index);
				
				// copy a character into str array and move index pointer once to front
//				str[index - 1] = str[i];
				str[index] = str[i];
				index--;
				
//				System.out.println("index: " + index);
				System.out.println("str[" + i + "]: " + str[i]);
				System.out.println("str: \"" + String.valueOf(str) + "\"");
				System.out.println();
			}
		}
		System.out.println("end of for loop");
		System.out.println();
	}
	
	public static void main(String[] args) {
		String str = "abc d e f";
//		char[] arr = new char[str.length() + 3 * 2 + 1];
		// add extra space to array in addition to length of str
		int extraSpace = 6;
		char[] arr = new char[str.length() + extraSpace];
		
		System.out.println("str: " + str);
		System.out.println("str.length: " + str.length());
		System.out.println("arr.length: " + arr.length);
		
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		
		System.out.println("arr: \"" + String.valueOf(arr) + "\"");
		
		replaceSpaces(arr, str.length());	
//		System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\""); // "abc%20d%20e%20f"
		System.out.println("\"" + String.valueOf(arr) + "\""); // "abc%20d%20e%20f"
	}
}
