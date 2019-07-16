package motionProfiling;

public class Config {
	private double mv, ma, mj, wb, dt;
	public Config(double max_vel, double max_accel, double max_jerk, double wheel_base, double dt) {
		this.mv = max_vel;
		this.ma = max_accel;
		this.mj = max_jerk;
		this.wb = wheel_base;
		this.dt = dt;
	}
	public double getMaxVel() {
		return mv;
	}
	public double getMaxAccel() {
		return ma;
	}
	public double getMaxJerk() {
		return mj;
	}
	public double getWheelBase() {
		return wb;
	}
	public double getDt() {
		return dt;
	}
}
