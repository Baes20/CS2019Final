package CS2019Final;

public class NullNode extends BNode {
	
	public NullNode() {
		//basically does nothing
	}
	@Override
	public double getHealth() {
		return 0;
	}

	@Override
	public double getPower() {
		return 0;
	}
	
	public void setHealth(double h) {
		// does nothing as well
	}
	
	public void setPower(double p) {
		// also does nothing
	}
	
	public String toString() {
		return "N";
	}
}
