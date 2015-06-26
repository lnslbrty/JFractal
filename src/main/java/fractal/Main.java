package fractal;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

public class Main {

	public static void main(String[] args) {
		GLProfile glp = GLProfile.getDefault();
		GLCapabilities caps = new GLCapabilities(glp);
		GLCanvas canvas = new GLCanvas(caps);
		MainScene ms;
		Camera cam = new Camera();

		Frame frame = new Frame("CoGra FRACTAL");
		frame.setSize(300, 300);
		frame.add(canvas);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		ms = new MainScene(cam);
		canvas.addGLEventListener(ms);
		canvas.addKeyListener(cam);
		canvas.addMouseWheelListener(cam);
		canvas.addMouseListener(cam);
		canvas.addMouseMotionListener(cam);

		FPSAnimator animator = new FPSAnimator(canvas, 60);
		animator.start();
	}

}
