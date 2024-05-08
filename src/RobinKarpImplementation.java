
public class RobinKarpImplementation {
	
	public static void main(String[] args) {
		String text = "12312354653213";
        String pattern = "231";
        int d = 10;
        int q = 101;
        int i = GFG_rk.search(pattern, text, q);
        int matchIndex = robinKarpMather(text, pattern, d, q);

        if (i != -1) {
            System.out.println("Pattern found at index: " + i);
        } else {
            System.out.println("Pattern not found in the text.");
        }
	}
	
	static int robinKarpMather(String text, String pattern, int d, int q) {
		int n = text.length(),
			m = pattern.length(),
			h = 1,
			p = 0,
			t = 0,
			i, j;
		
		for(i = 0; i < m -1 ; i++) {
			h = (h * d) % q;
		}
		
		for(i = 0; i < m; i++) {
			p = (d * p + pattern.charAt(i)) % q;
			t = (d * t + text.charAt(i)) % q;
		}
		
		for (i = 0; i <= n - m; i++) {
			if(p == t) {
				j = 0;
				while(j < m) {
					if(text.charAt(i + j) != pattern.charAt(j))
						break;
					j++;
				}
			 
				if(j == m) return i;
			}
		 }
		 
		 if(i < n - m) {
			 t  = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
			 
			 if (t < 0)
                 t = (t + q);
		 }
		 
		 return -1;
	}
}
