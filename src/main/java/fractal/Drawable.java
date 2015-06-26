package fractal;

import com.jogamp.opengl.GL2;

public interface Drawable {
	
	public void drawGL(GL2 gl);
	
	public void drawWireframe(GL2 gl);

}
