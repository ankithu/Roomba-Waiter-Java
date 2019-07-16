package Geometry;

public class Pose {
	private double x, y, theta;
	public Pose(double x, double y, double theta) {
		this.x = x;
		this.y = y;
		this.theta = theta;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getTheta() {
		return theta;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setTheta(double theta) {
		this.theta = theta;
	}
	public void continuousIntegrateX(double dx) {
		x += dx;
	}
	public void continuousIntegrateY(double dy) {
		 y += dy;
	}
}
