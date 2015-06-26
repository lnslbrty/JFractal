package fractal;

public class Vector3f {

	private float x, y, z;
	private Color col;

	public Vector3f(float x, float y, float z, Color vecColor) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
		this.setCol(vecColor);
	}

	public Vector3f clone() {
		return new Vector3f(this.getX(), this.getY(), this.getZ(),
				this.getCol());
	}

	public float getX() {
		return x;
	}

	public Vector3f setX(float x) {
		this.x = x;
		return this;
	}

	public float getY() {
		return y;
	}

	public Vector3f setY(float y) {
		this.y = y;
		return this;
	}

	public float getZ() {
		return z;
	}

	public Vector3f setZ(float z) {
		this.z = z;
		return this;
	}

	public Vector3f distance(Vector3f vec) {
		this.x = vec.x + this.x;
		this.y = vec.y + this.y;
		this.z = vec.z + this.z;
		return this;
	}

	public Vector3f half() {
		this.x = this.getX() / 2.0f;
		this.y = this.getY() / 2.0f;
		this.z = this.getZ() / 2.0f;
		return this;
	}
	
	public boolean equalXY(Vector3f vec) {
	    return (this.getX() == vec.getX() && this.getY() == vec.getY());
	}

	public String toString() {
		return String.format("[X: %.2f , Y: %.2f , Z: %.2f]", this.x, this.y, this.z);
	}

	public Color getCol() {
		return col;
	}

	public void setCol(Color col) {
		this.col = col;
	}

}
