package fractal;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class MainScene implements GLEventListener {

    private Triangle myStart;
    private DrawVector myFractal;
    private Camera myCam = null;
    private GLU glu;

    public MainScene(Camera c) throws IllegalArgumentException {
	if (c == null) {
	    throw new IllegalArgumentException("Camera must not null.");
	}
	this.myCam = c;
    }

    private void update() {
    }

    private void render(GLAutoDrawable drawable) {
	GL2 gl = drawable.getGL().getGL2();

	gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
	gl.glLoadIdentity();
	gl.glBegin(GL.GL_LINES);
	gl.glColor3f(0.8f, 0.8f, 0.8f);
	gl.glVertex3f(-1.0f, -1.0f, 0.0f);
	gl.glVertex3f(-1.0f, 1.0f, 0.0f);
	gl.glVertex3f(-1.0f, 1.0f, 0.0f);
	gl.glVertex3f(1.0f, 1.0f, 0.0f);
	gl.glVertex3f(1.0f, 1.0f, 0.0f);
	gl.glVertex3f(1.0f, -1.0f, 0.0f);
	gl.glVertex3f(1.0f, -1.0f, 0.0f);
	gl.glVertex3f(-1.0f, -1.0f, 0.0f);
	gl.glEnd();
	gl.glStencilFunc(GL.GL_ALWAYS, 0x1, 0x1);
	myStart.drawGL(gl);
	myStart.drawWireframe(gl);
	myFractal.drawGL(gl);
	myFractal.drawWireframe(gl);
	gl.glStencilFunc(GL.GL_EQUAL, 0x0, 0x1);

	myCam.setCamera(.7f, .5f, 5.5f);
    }

    public void display(GLAutoDrawable arg0) {
	update();
	render(arg0);
    }

    public void dispose(GLAutoDrawable arg0) {
    }

    public void init(GLAutoDrawable arg0) {
	GL2 gl = arg0.getGL().getGL2();

	this.glu = new GLU();
	this.myCam.setGLGLU(gl, glu);
	gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
	gl.glClearDepth(1.0f);
	gl.glEnable(GL.GL_DEPTH_TEST);
	gl.glDepthFunc(GL.GL_LEQUAL);
	this.myStart = Triangle.rightAngleTriangle(new Vector3f(-0.8f, -0.9f, 0.0f, new Color(1.0f, 0.0f, 0.0f)), 1.5f,
		1.75f, new Color(1.0f, 1.0f, 1.0f));
	this.myFractal = TriangleFractal.generateFractalRecursive(myStart, 0.5f, 4);
    }

    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
    }

}