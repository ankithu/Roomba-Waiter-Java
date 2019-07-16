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

public class PathCommand extends RoombaCommand{
	private TrajectoryFollowerFeedForward follower;
	private ScheduledExecutorService executor;
	private static boolean pathComplete;
	@Override
	public void setCommandType() {
		// TODO Auto-generated method stub
		this.commandType = CommandType.sending;
	}
	
	public PathCommand(Waypoint[] points, Config config) {
		super();
		Trajectory[] traj = GenerationEngine.calculate(points, false, config);
		for (int i = 0; i < traj[0].length(); i ++) {
			System.out.print(traj[0].get(i).x + ',');
			System.out.println(traj[0].get(i).y);
		}
		this.follower = new TrajectoryFollowerFeedForward();
		this.executor = Executors.newSingleThreadScheduledExecutor();
		//Thread thread = new Thread(follower);
		follower.setTraj(traj);
		
	}

	@Override
	public void executeCommand(RoombaJSSC roomba) {
		// TODO Auto-generated method stub
		
		follower.startTraj();
	//	thread.start();
		executor.scheduleAtFixedRate(follower, 0, 100, TimeUnit.MILLISECONDS);
		
	}
	
	public static void signalIsFinished(boolean fin) {
		pathComplete = true;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		if (pathComplete) {
			pathComplete = false;
			return true;
		}
		return false;
	}
	
	

}
