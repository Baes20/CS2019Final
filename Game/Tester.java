package CS2019Final;

import java.util.Arrays;

public class Tester {
	
	public static void main(String[] args) {
		Battlefield B = new Battlefield(10, 10);
		B.putPieces(new DefaultPlant(), 3, 3);
		B.putPieces(new DefaultZombie(), 3, 4);
		B.putPieces(new DefaultZombie(), 2, 6);
		B.putPieces(new DefaultZombie(), 2, 7);
		B.putPieces(new DefaultZombie(), 2, 8);
		B.putPieces(new DefaultZombie(), 2, 9);
		System.out.println(B.toString());
		B.calcNextState();
		System.out.println(B.toString());
		B.calcNextState();
		System.out.println(B.toString());
		B.calcNextState();
		System.out.println(B.toString());
		B.calcNextState();
		System.out.println(B.toString());
		B.calcNextState();
		System.out.println(B.toString());
		B.calcNextState();
		System.out.println(B.toString());
		B.calcNextState();
		System.out.println(B.toString());
		B.calcNextState();
		System.out.println(B.toString());
		B.calcNextState();
		System.out.println(B.toString());
		B.calcNextState();
		System.out.println(B.toString());
		B.calcNextState();
		System.out.println(B.toString());
		B.calcNextState();
		System.out.println(B.toString());
		B.calcNextState();
		System.out.println(B.toString());
		B.calcNextState();
		System.out.println(B.toString());
		System.out.println(B.getPlayerHealth());
//		while(!B.isGameOver()) {
//			B.calcNextState();
//		}
		
	}
	
	
}
