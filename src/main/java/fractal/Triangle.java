package fractal;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

public class Triangle implements Drawable {

	private Vector3f p1;
	private Vector3f p2;
	private Vector3f p3;
	private Color wfColor;

	public Triangle(Vector3f p1, Vector3f p2, Vector3f p3, Color wireframeColor) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.wfColor = new Color(wireframeColor);
	}

	public Triangle clone() {
		return new Triangle(this.getP1(), this.getP2(), this.getP3(),
				this.getWireframeColor());
	}

	public static Triangle rightAngleTriangle(Vector3f p1, float width,
			float height, Color wireframeColor) {
		return new Triangle(p1, new Vector3f(p1.getX() + width, p1.getY()
				+ height, p1.getZ(), p1.getCol()), new Vector3f(p1.getX()
				+ width, p1.getY(), p1.getZ(), p1.getCol()), wireframeColor);
	}

	public Vector3f getP1() {
		return p1;
	}

	public Vector3f getP2() {
		return p2;
	}

	public Vector3f getP3() {
		return p3;
	}

	public Triangle setP1(Vector3f p1) {
		this.p1 = p1;
		return this;
	}

	public Triangle setP2(Vector3f p2) {
		this.p2 = p2;
		return this;
	}

	public Triangle setP3(Vector3f p3) {
		this.p3 = p3;
		return this;
	}

	public Color getWireframeColor() {
		return this.wfColor;
	}

	public void drawGL(GL2 gl) {
		gl.glBegin(GL.GL_TRIANGLES);
		gl.glColor3f(p1.getCol().getR(), p1.getCol().getG(), p1.getCol().getB());
		gl.glVertex3f(p1.getX(), p1.getY(), p1.getZ());
		gl.glColor3f(p2.getCol().getR(), p2.getCol().getG(), p2.getCol().getB());
		gl.glVertex3f(p2.getX(), p2.getY(), p2.getZ());
		gl.glColor3f(p3.getCol().getR(), p3.getCol().getG(), p3.getCol().getB());
		gl.glVertex3f(p3.getX(), p3.getY(), p3.getZ());
		gl.glEnd();
	}

	public void drawWireframe(GL2 gl) {
		gl.glBegin(GL.GL_LINES);
		gl.glColor3f(wfColor.getR(), wfColor.getG(), wfColor.getB());
		gl.glVertex3f(p1.getX(), p1.getY(), p1.getZ());
		gl.glVertex3f(p2.getX(), p2.getY(), p2.getZ());
		gl.glVertex3f(p2.getX(), p2.getY(), p2.getZ());
		gl.glVertex3f(p3.getX(), p3.getY(), p3.getZ());
		gl.glVertex3f(p3.getX(), p3.getY(), p3.getZ());
		gl.glVertex3f(p1.getX(), p1.getY(), p1.getZ());
		gl.glEnd();
	}

	public String toString() {
		return "TRIANGLE: " + p1 + " , " + p2 + " , " + p3;
	}

}
