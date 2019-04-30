package CS2019Final;

public abstract class Plant extends BNode{
	double health;
	double power;
	
	public Plant(double h, double p) { //defaultplant has health of 100 and power of 10
		health = h;
		power = p;
	}

	@Override
	public double getHealth() {
		// TODO Auto-generated method stub
		return health;
	}

	@Override
	public double getPower() {
		// TODO Auto-generated method stub
		return power;
	}
	
	public void setHealth(double h) {
		health = h;
	}
	
	public void setPower(double p) {
		power = p;
	}
	
	public abstract Lambda getRule();
}
