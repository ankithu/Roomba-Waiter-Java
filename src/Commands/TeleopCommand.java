package Commands;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;

import RobotControl.TeleopCommandDispatch;
import RobotControl.TeleopThread;
import serialControl.RoombaJSSC;


public class TeleopCommand extends RoombaCommand{
	
	public TeleopCommand(){
		super();
	}

	@Override
	public void setCommandType() {
		// TODO Auto-generated method stub
		commandType = CommandType.sending;
		
	}

	@Override
	public void executeCommand(RoombaJSSC roomba) {
		// TODO Auto-generated method stub
		TeleopThread teleop = new TeleopThread();
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(teleop, 0,200, TimeUnit.MILLISECONDS);
		
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
		
	}
}
