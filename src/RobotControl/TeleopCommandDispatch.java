package RobotControl;

public class TeleopCommandDispatch {
	private static volatile double f = 0.0, b=0.0, l=0.0, r=0.0;
	private static volatile boolean vOn = false;
	private static volatile String speakString = "";
	private static int MAX_VEL = 300;
	public static synchronized void setForward(double f) {
		TeleopCommandDispatch.f = f;
	}
	public static synchronized void setBackward(double b) {
		TeleopCommandDispatch.b = b;
	}
	public static synchronized void setLeft(double l) {
		TeleopCommandDispatch.l = l;
	}
	public static synchronized void setRight(double r) {
		TeleopCommandDispatch.r = r;
	}
	public static synchronized void setStop() {
		TeleopCommandDispatch.f = 0.0;
		TeleopCommandDispatch.b = 0.0;
		TeleopCommandDispatch.l = 0.0;
		TeleopCommandDispatch.r = 0.0;
	}
	public static synchronized void setVacuum(boolean on) {
		TeleopCommandDispatch.vOn = on;
	}
	public static synchronized void setSpeakString(String in) {
		TeleopCommandDispatch.speakString = in;
	}
	public static synchronized String getSpeakString() {
		return speakString;
	}
	public static int[] getRoombaOut() {
		double power = f - b;
		double turn = r - l;
		double left = power + turn;
		double right = power - turn;
		int[] ret = {(int)(left * MAX_VEL ), (int) (right*MAX_VEL)};
		return ret;
	}
	public static synchronized boolean getVacuumOn() {
		return vOn;
	}
}

