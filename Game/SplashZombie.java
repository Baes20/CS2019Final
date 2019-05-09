package CS2019Final;

public class SplashZombie extends Zombie {
	
	public SplashZombie() {
		super(100, 5);
	}
	
	public String toString() {
		return "SZ("+super.getHealth()+", "+super.getPower()+")";
	}
	@Override
	public Lambda getRule() {
		Lambda splashZombie = (Battlefield b, int i, int j) -> {
			int height = b.height;
			BNode[][] battlefield = b.getB();
			double playerhealth = b.getPlayerHealth();
			if(battlefield[i][j] instanceof SplashZombie && j-1 >= 0) { // if it's a zombie and hasn't reached to 0
				if(battlefield[i][j-1] instanceof NullNode) { // if the next is empty
					battlefield[i][j-1] = battlefield[i][j];
					battlefield[i][j] = new NullNode(); // move
				}else{
					for(int adj = i-1; adj <= i+1; adj++) {
						if( adj >= 0 && adj < battlefield.length && battlefield[adj][j-1] instanceof Plant) { // if the next is plant
							((Plant)battlefield[adj][j-1]).setHealth(battlefield[adj][j-1].getHealth() - battlefield[i][j].getPower()); //deal some damage
						}
					}
				}
			}else if(battlefield[i][j] instanceof Zombie && j == 0) { // if it reached the end
				b.setPlayerHealth(b.getPlayerHealth() - battlefield[i][j].getHealth()); // deal some damage equivalent of its health to the playerhealth
				battlefield[i][j] = new NullNode(); // and die
			}
		};
		return splashZombie;
	}

}
