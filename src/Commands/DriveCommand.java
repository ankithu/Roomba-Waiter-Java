package Commands;

import Commands.RoombaCommand.CommandType;
import serialControl.RoombaJSSC;

public class DriveCommand extends RoombaCommand{
	public int right, left;
	long startTime;
	double timeOut;
	public DriveCommand(int right, int left, double timeOut) {
		super();
		this.right = right;
		this.left = left;
		this.timeOut = timeOut;
	}

	@Override
	public void setCommandType() {
		// TODO Auto-generated method stub
		commandType = CommandType.sending;
		
	}

	@Override
	public void executeCommand(RoombaJSSC roomba) {
		// TODO Auto-generated method stub
		roomba.driveDirect(right, left);
		startTime = System.currentTimeMillis();
		
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return (startTime + timeOut) > System.currentTimeMillis();
		
	}
}
