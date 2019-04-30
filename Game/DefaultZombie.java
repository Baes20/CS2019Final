package CS2019Final;

public class DefaultZombie extends Zombie{
	public DefaultZombie() {
		super(100, 10); //has 100 health & 10 power
	}
	
	public String toString() {
		return "Z("+super.getHealth()+", "+super.getPower()+")";
	}

	@Override
	public Lambda getRule() {
		Lambda defaultZombie = (Battlefield b, int i, int j) -> {
			int height = b.height;
			BNode[][] battlefield = b.getB();
			double playerhealth = b.getPlayerHealth();
			if(battlefield[i][j] instanceof Zombie && j-1 >= 0) { // if it's a zombie and hasn't reached to 0
				if(battlefield[i][j-1] instanceof NullNode) { // if the next is empty
					battlefield[i][j-1] = battlefield[i][j];
					battlefield[i][j] = new NullNode(); // move
				}else if(battlefield[i][j-1] instanceof Plant) { // if the next is plant
					((Plant)battlefield[i][j-1]).setHealth(battlefield[i][j-1].getHealth() - battlefield[i][j-1].getPower()); //deal some damage
				}
			}else if(battlefield[i][j] instanceof Zombie && j == 0) { // if it reached the end
				b.setPlayerHealth(b.getPlayerHealth() - battlefield[i][j].getHealth()); // deal some damage equivalent of its health to the playerhealth
				battlefield[i][j] = new NullNode(); // and die
			}
		};
		return defaultZombie;
	}
}
