package fractal;

public class Color {
	
	private float r, g, b;
	
	public Color(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public Color(Color c) {
		this(c.r, c.g, c.b);
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

	public float getR() {
		return r;
	}

	public void setR(float r) {
		this.r = r;
	}

	public float getG() {
		return g;
	}

	public void setG(float g) {
		this.g = g;
	}
	
	public String toString() {
		return String.format("[R: %.2f , G: %.2f, B: %.2f]", r, g, b);
	}

}
