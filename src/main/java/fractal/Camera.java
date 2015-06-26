package fractal;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.event.MouseInputAdapter;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;

public class Camera extends MouseInputAdapter implements KeyListener,
		MouseWheelListener {
	private float x = 0.0f;
	private float y = 0.0f;
	private float vx = 0.0f;
	private float vy = 0.0f;
	private float ddist = 0.0f;
	private float dangl = 0.0f;
	private GL2 gl = null;
	private GLU glu = null;
	private boolean mouseDragged = false;
	private Point mouseLastDrag = null;

	public void setGLGLU(GL2 gl, GLU glu) {
		this.gl = gl;
		this.glu = glu;
	}

	public void setCamera(float width, float height, float distance) {
		// Change to projection matrix.
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();

		// Perspective.
		float widthHeightRatio = (float) width / (float) height;
		glu.gluPerspective(25, widthHeightRatio, 1, 1000);
		glu.gluLookAt((float) vx, (float) vy - 4.5f, distance + ddist, (float) x, (float) y, 0.0f, .0f, 1,
				0);
		gl.glRotated(dangl, 0f, 0f, 1.0f);
		dangl -= 0.1f;
		// Change back to model view matrix.
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			x -= 0.1f;
			break;
		case KeyEvent.VK_RIGHT:
			x += 0.1f;
			break;
		case KeyEvent.VK_DOWN:
			y -= 0.1f;
			break;
		case KeyEvent.VK_UP:
			y += 0.1f;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() < 0) {
			ddist -= 0.1f;
		} else
			ddist += 0.1f;
	}

	public void mouseDragged(MouseEvent e) {
		if (mouseLastDrag != null) {
			vx -= (mouseLastDrag.getX() > e.getX() ? 0.2f : -0.2f);
			vy += (mouseLastDrag.getY() > e.getY() ? 0.1f : -0.1f);
		}
		mouseLastDrag = e.getPoint();
		mouseDragged = true;
	}

	public void mouseMoved(MouseEvent e) {
		if (mouseDragged) {
			mouseDragged = false;
			mouseLastDrag = null;
		}
	}

}
