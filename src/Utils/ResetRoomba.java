package Utils;

import RobotControl.Communicator;

public class ResetRoomba {
	public static void run() {
		Communicator.kill();
	}
}
