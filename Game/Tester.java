package CS2019Final;

import java.util.Arrays;

public class Tester {
	
	public static void main(String[] args) {
		Battlefield B = new Battlefield(10, 10);
		B.putPieces(new DefaultPlant(), 3, 3);
		B.putPieces(new DefaultZombie(), 3, 5);
		
		
	}
	
	
}
