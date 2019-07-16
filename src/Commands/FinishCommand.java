package Commands;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Commands.RoombaCommand.CommandType;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import motionProfiling.Config;
import motionProfiling.GenerationEngine;
import motionProfiling.TrajectoryFollowerFeedForward;
import serialControl.RoombaJSSC;
@Deprecated
public class FinishCommand extends RoombaCommand{
	@Override
	public void setCommandType() {
		// TODO Auto-generated method stub
		this.commandType = CommandType.sending;
	}
	
	
	@Override
	public void executeCommand(RoombaJSSC roomba) {
		// TODO Auto-generated method stub
		
		roomba.disconnect();
		
	}


	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
