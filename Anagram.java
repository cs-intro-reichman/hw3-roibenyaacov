/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1); 
        str2 = preProcess(str2); 

   
        String newString = ""; 
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) != ' ') { 
                newString += str2.charAt(i);
            }
        }
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (c == ' ') continue; 
            int index = newString.indexOf(c); 
            if (index == -1) {
                return false; 
            }
            newString = newString.substring(0, index) + newString.substring(index + 1); 
		}
		return false;
		}	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String beforeStr = ""; 
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') { 
                beforeStr += (char) (c + 32); 
            } else if (c >= 'a' && c <= 'z') { 
                beforeStr += c; 
            } else if (c == ' ') { 
                beforeStr += c;
            }
        }
        return beforeStr; 
    }

	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str = preProcess(str); 
        String newString = ""; 
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') { 
                newString += str.charAt(i);
            }
        }
        String beforeStr = ""; 
        while (newString.length() > 0) {
            int randomIndex = (int) (Math.random() * newString.length()); 
            char randomChar = newString.charAt(randomIndex); 
            beforeStr += randomChar; 
            newString = newString.substring(0, randomIndex) + newString.substring(randomIndex + 1); 
        }
        return beforeStr; 
    }
}
