package motionProfiling;

import Geometry.Pose;

public class Localizer {
	private static Pose locale;
	private static double dx, dy;
	private static double lastAngle;
	static {
		lastAngle = 90;
		locale = new Pose(0.0,0.0,90.0);
	}
	
	public static void loop(double dDistance, double dAngle) {
		locale.setTheta(lastAngle + dAngle);
		double avgAngle = (locale.getTheta() + lastAngle) / 2.0;
		
		dx = Math.cos(avgAngle) * dDistance; 
		dy = Math.sin(avgAngle) * dDistance;
		locale.continuousIntegrateX(dx);
		locale.continuousIntegrateY(dy);
		
	}
}
