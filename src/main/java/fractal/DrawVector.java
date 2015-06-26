package fractal;

import java.util.Vector;

import com.jogamp.opengl.GL2;

public class DrawVector extends Vector<Drawable> implements Drawable {
	private static final long serialVersionUID = 865136054358700998L;

	public DrawVector() {
		super();
	}

	public void drawGL(GL2 gl) {
		for (Drawable t : this) {
			t.drawGL(gl);
		}
	}

	public void drawWireframe(GL2 gl) {
		for (Drawable t : this) {
			t.drawWireframe(gl);
		}
	}
}
