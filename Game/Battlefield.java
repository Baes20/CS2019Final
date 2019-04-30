package CS2019Final;

import java.util.Arrays;

public class Battlefield {
	
	public int height;
	public int width;
	private BNode[][] battlefield;
	private double playerhealth;
	
	// creates an empty battlefield 
	public Battlefield(int h, int w) {
		height = h;
		width = w;
		battlefield = new BNode[h][w];
		playerhealth = 1000;
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				battlefield[i][j] = new NullNode();
			}
		}
	}
	
	public BNode[][] getB(){
		return battlefield;
	}
	
	public void putPieces(BNode piece, int row, int col) {
		if (piece instanceof Plant && col > width/2) {
			throw new IllegalArgumentException("plants cannot be placed over the right half of the battlefield");
		}
		battlefield[row][col] = piece;
	}
	
	public void calcNextState() {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				calcPlantMove(i, j);
				calcZombieMove(i, j);
			}
		}
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				removeDead(i, j);
			}
		}
	}
	
	public void calcPlantMove(int i, int j) {
		if(battlefield[i][j] instanceof Plant) {
			Lambda rule = ((Plant)battlefield[i][j]).getRule();
			rule.rule(this, i, j);
		}
		
//		if(battlefield[i][j] instanceof Plant) {
//			for(int k = j+1; k < height; k++) {
//				if(battlefield[i][k] instanceof Zombie) {
//					double zHealth = battlefield[i][k].getHealth();
//					double pPower = battlefield[i][j].getPower();
//					((Zombie)battlefield[i][k]).setHealth(zHealth-pPower); // this basically deals damage to all zombies in a row
//				}
//			}
//		}
	}
	
	public void calcZombieMove(int i, int j) {
		if(battlefield[i][j] instanceof Zombie) {
			Lambda rule = ((Zombie)battlefield[i][j]).getRule();
			rule.rule(this, i, j);
		}
	}
	
	public void removeDead(int i, int j) {
		if(battlefield[i][j].getHealth() <= 0) {
			battlefield[i][j] = new NullNode();
		}
		
	}
	
	public double getPlayerHealth() {
		return playerhealth;
	}
	
	public void setPlayerHealth(double amt) {
		playerhealth = amt;
	}
	
	public boolean isGameOver() {
		if(playerhealth <= 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return Arrays.deepToString(battlefield);
	}
	
}
