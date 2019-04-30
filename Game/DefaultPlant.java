package CS2019Final;

public class DefaultPlant extends Plant{
	public DefaultPlant() {
		super(100, 10); //has 100 health & 10 power
	}
	
	public String toString() {
		return "P("+super.getHealth()+", "+super.getPower()+")";
	}

	@Override
	public Lambda getRule() {
	Lambda defaultPlant = (Battlefield b, int i, int j) -> {
		int height = b.height;
		BNode[][] battlefield = b.getB();
		if(battlefield[i][j] instanceof Plant) {
			for(int k = j+1; k < height; k++) {
				if(battlefield[i][k] instanceof Zombie) {
					double zHealth = battlefield[i][k].getHealth();
					double pPower = battlefield[i][j].getPower();
					((Zombie)battlefield[i][k]).setHealth(zHealth-pPower); // this basically deals damage to all zombies in a row
				}
			}
		}
	};
	return defaultPlant;
	}
}
