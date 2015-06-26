package fractal;

import java.util.Random;

public class TriangleFractal {

    private static Random rnd;

    private static Triangle generateFractalR(DrawVector dv, Triangle start, float maxHeight, int maxRecursions) {
	int startIdx;
	float newHeight = maxHeight;
	Triangle t1, t2, t3, t4;
	Triangle r1, r2, r3, r4;
	Vector3f d1_2, d1_3, d2_3;
	if (maxRecursions == 0)
	    return null;

	if (dv.indexOf(start) > -1) {
	    dv.remove(start);
	}

	d1_2 = start.getP1().clone().distance(start.getP2()).half();
	d1_3 = start.getP1().clone().distance(start.getP3()).half();
	d2_3 = start.getP2().clone().distance(start.getP3()).half();
	Color col1_2 = new Color(start.getP1().getCol());
	Color col1_3 = new Color(start.getP2().getCol());
	Color col2_3 = new Color(start.getP3().getCol());
	d1_2.setCol(col1_2);
	d1_3.setCol(col1_3);
	d2_3.setCol(col2_3);
	col1_2.setR(col1_2.getR() + (1 - col1_2.getR()) / maxRecursions);
	col1_3.setG(col1_3.getG() + (1 - col1_3.getG()) / maxRecursions);
	col2_3.setB(col2_3.getB() + (1 - col2_3.getB()) / maxRecursions);

	t1 = new Triangle(start.getP1(), d1_2, d1_3, start.getWireframeColor());
	t2 = new Triangle(start.getP2(), d2_3, d1_2, start.getWireframeColor());
	t3 = new Triangle(start.getP3(), d1_3, d2_3, start.getWireframeColor());
	t4 = new Triangle(d1_3, d1_2, d2_3, start.getWireframeColor());

	newHeight = maxHeight * (rnd.nextFloat() + 0.5f);
	t4.getP1().setZ(newHeight);
	newHeight = maxHeight * (rnd.nextFloat() + 0.5f);
	t4.getP2().setZ(newHeight);
	newHeight = maxHeight * (rnd.nextFloat() + 0.5f);
	t4.getP3().setZ(newHeight);

	startIdx = dv.size();
	dv.add(t1);
	dv.add(t2);
	dv.add(t3);
	dv.add(t4);

	r1 = generateFractalR(dv, t1, maxHeight / 2.0f, maxRecursions - 1);
	r2 = generateFractalR(dv, t2, maxHeight / 2.0f, maxRecursions - 1);
	r3 = generateFractalR(dv, t3, maxHeight / 2.0f, maxRecursions - 1);
	r4 = generateFractalR(dv, t4, maxHeight / 2.0f, maxRecursions - 1);
	if (r1 != null && r2 != null && r3 != null && r4 != null) {
	    r4.getP2().setZ(r1.getP3().getZ());
	    r4.getP3().setZ(r2.getP3().getZ());
	    r4.getP1().setZ(r3.getP3().getZ());
	    if (maxRecursions > 2) {
		for (int i = startIdx; i < dv.size(); i++) {
		    Vector3f[] veca = new Vector3f[3];
		    veca[0] = ((Triangle) dv.get(i)).getP1();
		    veca[1] = ((Triangle) dv.get(i)).getP2();
		    veca[2] = ((Triangle) dv.get(i)).getP3();
		    for (int j = i + 1; j < dv.size(); j++) {
			Vector3f[] vecb = new Vector3f[3];
			vecb[0] = ((Triangle) dv.get(j)).getP1();
			vecb[1] = ((Triangle) dv.get(j)).getP2();
			vecb[2] = ((Triangle) dv.get(j)).getP3();
			for (int h = 0; h < 3; h++) {
			    if (veca[h] == vecb[h])
				continue;
			    if (veca[h].equalXY(vecb[h]) && veca[h].getZ() != vecb[h].getZ()) {
				float newZ = (veca[h].getZ() + vecb[h].getZ()) / 2.0f;
				veca[h].setZ(newZ);
				vecb[h].setZ(newZ);
			    }
			}
		    }
		}
	    }
	}
	return t4;
    }

    public static DrawVector generateFractalRecursive(Triangle start, float maxHeight, int maxRecursions) {
	rnd = new Random();
	DrawVector dv = new DrawVector();
	generateFractalR(dv, start.clone(), maxHeight, maxRecursions);
	return dv;
    }

    public static PolygonVector generateTerrainBorder(Triangle ground, DrawVector dv) {
	// PolygonVector borders;
	Triangle t;
	System.out.println(ground.getP1());
	for (int j = 0; j < dv.size(); j++) {
	    t = (Triangle) dv.get(j);
	    if (t.getP1().getX() > ground.getP1().getX() && t.getP1().getY() == ground.getP1().getY()) {
		// borders[0].add(new Polygon(t.getP1(), new Color(0.9f, 0.9f,
		// 0.9f)));
	    }
	}
	return null;
    }
}
