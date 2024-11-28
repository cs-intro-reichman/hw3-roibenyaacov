public class Anagram {
    public static void main(String[] args) {
       
        System.out.println(isAnagram("silent", "listen")); // true
        System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
        System.out.println(isAnagram("hello", "world")); // false
        System.out.println(isAnagram("Silent", "Listen")); // true

   
        String original = "silent";
        String random = randomAnagram(original);
        System.out.println("Original: " + original + ", Random anagram: " + random);
        System.out.println("Are they anagrams? " + isAnagram(original, random)); // true
    }

    
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
        return true; 
    }

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