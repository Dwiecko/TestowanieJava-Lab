package FirstTask;

public class NWD {
	
	public int nwd(int a, int b) {
		int nwd = 0;

		do {
			nwd = a % b;
			a = b;
			b = nwd;
		} while (nwd != 0);

		return a;
}
}
