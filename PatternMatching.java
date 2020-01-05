public class PatternMatching {
	
	public static int[] BruteForce(String text, String pattern) { //BruteForce
		int returnValues[] = new int[2];
		int n = text.length();
		int m = pattern.length();
		int count = 0;
		for (int i = 0; i <= n - m; i++) {
			int j = 0;
			while (j < m) {
				count++;
				if (text.charAt(i + j) != pattern.charAt(j)) {
					break;
				} else {
					j++;
				}
				if (j == m) {
					returnValues[0] = i;
					returnValues[1] = count;
					return returnValues;
				}
			}
		}
		return new int[] {-1,count};
	}
	
	
	public static int[] ShiftTable(String pattern) { //Shift table for BMHarspool
		int m = pattern.length();
		int table[] = new int[128];
		for (int i = 0; i < 128; i++) {
			table[i] = m;
		}
		for (int j = 0; j < m - 1; j++) {
			table[pattern.charAt(j)] = m - 1 - j;
		}
		return table;
	}
	
	public static int[] HarspoolMatching(String text, String pattern) { //BMHarspool matching method
		int[] place_and_comparisions = new int[2];
		int count = 0;
		int[] table = ShiftTable(pattern);
		int m = pattern.length();
		int n = text.length();
		int i = m - 1;
		while (i < n) {
			int k = 0;
			while (k < m) {
				count++;
				if (pattern.charAt(m - 1 - k) == text.charAt(i - k)) {
					k++;
				} else {
					break;
				}
			}
			if (k == m) {
				place_and_comparisions[0] = i - m + 1;
				place_and_comparisions[1] = count;
				return place_and_comparisions;
			} else {
				i = i + table[text.charAt(i)];
			}
		}
		return new int[] { -1, count };
	}
	
	public static int[] FailureFunction(String pattern) { //Failure function for KMP
		int m = pattern.length();
		int i = 1;
		int j = 0;
		int[] function = new int[m];
		function[0] = 0;
		while (i < m) {
			if (pattern.charAt(j) == pattern.charAt(i)) {
				function[i] = j + 1;
				i++;
				j++;
			} else if (j > 0) {
				j = function[j - 1];
			} else {
				function[i] = 0;
				i++;
			}
		}
		return function;
	}

	public static int[] KMPMatch(String text, String pattern) { //KMP matching method
		int[] function = FailureFunction(pattern);
		int[] place_and_comparisions = new int[2];
		int i = 0;
		int j = 0;
		int n = text.length();
		int m = pattern.length();
		int count = 0;
		while (i < n) {
			count++;
			if (pattern.charAt(j) == text.charAt(i)) {
				if (j == m - 1) {
					place_and_comparisions[0] = i - m + 1;
					place_and_comparisions[1] = count;
					return place_and_comparisions;
				}
				i++;
				j++;
			} else if (j > 0) {
				j = function[j - 1];
			} else {
				i++;
			}
		}
		return new int[] { -1, count };
	}

	public static void main(String[] args) {
		
		String text = args[0];
		String pattern = args[1];
		
		int[] BruteForce = BruteForce(text,pattern);
		int[] BMHarspool = HarspoolMatching(text, pattern);
		int[] KMP = KMPMatch(text, pattern);
		
		String text_pattern = "Text :"+text+", Pattern :"+pattern;
		
		
		System.out.print(text_pattern+"  |  ");
		System.out.print("place: "+BruteForce[0]+", "+"comp: "+BruteForce[1]+"  |  ");
		System.out.print("place: "+BMHarspool[0]+", "+"comp: "+BMHarspool[1]+"  |  ");
		System.out.print("place: "+KMP[0]+", "+"comp: "+KMP[1]);
        System.out.println();
		
	}

}
