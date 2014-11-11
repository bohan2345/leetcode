package tc;

public enum Planet {
	EARTH(100, 2),
	MARS(80, 1);

	private int mass;
	private int radius;

	Planet(int mass, int radius) {
		this.mass = mass;
		this.radius = radius;
	}

	@Override
	public String toString() {
		return this.mass + " : " + this.radius;
	}

	public static Planet getPlanet(int mass) {
		if (mass == Planet.EARTH.mass)
			return Planet.EARTH;
		else
			return Planet.MARS;
	}
}
