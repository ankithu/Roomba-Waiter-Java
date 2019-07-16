package Commands;

import motionProfiling.Localizer;
import serialControl.RoombaJSSC;

public class SenseCommand extends RoombaCommand{
	

	@Override
	public void setCommandType() {
		// TODO Auto-generated method stub
		commandType = CommandType.recieving;
		
	}

	@Override
	public void executeCommand(RoombaJSSC roomba) {
		// TODO Auto-generated method stub
		int dDistance = roomba.distanceTraveled();
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int dAngle = roomba.angleTurned();
		Localizer.loop(dDistance, dAngle);
		
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
