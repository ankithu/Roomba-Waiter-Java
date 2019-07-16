package motionProfiling;


import Commands.PathCommand;
import RobotControl.Communicator;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Trajectory.Segment;

public class TrajectoryFollowerFeedForward implements Runnable {
	Trajectory leftTraj;
	Trajectory rightTraj;
	private boolean start = false;
	private int segmentIndex;

	private double dt;
	private boolean isFinished = false;
	private double startTime = 0;
	
	
	public void setTraj(Trajectory[] traj) {
		this.leftTraj = traj[0];
		this.rightTraj = traj[1];
		this.dt = leftTraj.get(0).dt;
		start = false;
		isFinished = false;
	}
	public void startTraj() {
		start = true;
		segmentIndex = 0;
		startTime = System.currentTimeMillis();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (start) {
		//	segmentIndex = (int)(((System.currentTimeMillis()-startTime)/1000.0)/dt);
			Segment leftSeg = leftTraj.get(segmentIndex);
			Segment rightSeg = rightTraj.get(segmentIndex);
			System.out.println(leftSeg.toString());
			System.out.println(segmentIndex);
			double leftVel = leftSeg.velocity;
			double rightVel = rightSeg.velocity;
			if (isFinished()) {
				leftVel = 0;
				rightVel =0;
				start = false;
			}
			Communicator.testDrive((int)leftVel, (int)rightVel);
			segmentIndex++;
			if (isFinished()) {
				PathCommand.signalIsFinished(true);
			}
			
		}
		
	}
	public synchronized boolean isFinished() {
		return segmentIndex >= leftTraj.length();
	}
	
}
