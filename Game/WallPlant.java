package CS2019Final;

public class WallPlant extends Plant {
	
	public WallPlant() {
		super(200, 0);
	}
	
	public String toString() {
		return "W("+super.getHealth()+", "+super.getPower()+")";
	}

	@Override
	public Lambda getRule() {
		Lambda wallRule = (Battlefield b, int i, int j) -> {
			// literally does nothing but acting like a wall
		};
		return wallRule;
	}

}
