
public class StringPatternMatchBrute {
	public static int bruteForceStringMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        
        for (int i = 0; i <= n - m; i++) {
            int j;
            
            if(pattern.equals(pattern.substring(i, i+m)))
            	return i;
//            for (j = 0; j < m; j++) {
//                if (text.charAt(i + j) != pattern.charAt(j))
//                    break;
//            }
//            if (j == m) {
//                return i;
//            }
        }
        
        return -1;
    }
	
	public static void main(String[] args) {
		String text = "ababcababcabc";
        String pattern = "abc";
        int matchIndex = bruteForceStringMatch(text, pattern);
        
        if (matchIndex != -1) {
            System.out.println("Pattern found at index: " + matchIndex);
        } else {
            System.out.println("Pattern not found in the text.");
        }
	}
}
