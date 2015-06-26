package fractal;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

public class PolygonVector implements Drawable {
    private DrawVector dv;
    private Vector3f poly;
    private Color col;

    public PolygonVector(Vector3f p, Color c) {
	this.setPoly(p);
	this.col = new Color(c);
    }

    public Color getCol() {
	return col;
    }

    public void setCol(Color col) {
	this.col = col;
    }

    public void drawGL(GL2 gl) {
	gl.glBegin(GL.GL_LINE_STRIP);
	gl.glColor3f(col.getR(), col.getG(), col.getB());
	/*
	for (Polygon p : this) {
	    gl.glVertex3f(p.getPoly().getX(), p.getPoly().getY(), p.getPoly().getZ());
	}
	*/
	gl.glEnd();
    }

    public void drawWireframe(GL2 gl) {
	// TODO Auto-generated method stub

    }

    public Vector3f getPoly() {
	return poly;
    }

    public void setPoly(Vector3f poly) {
	this.poly = poly;
    }

}
