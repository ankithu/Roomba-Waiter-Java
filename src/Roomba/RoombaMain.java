package Roomba;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Commands.TeleopCommand;
import GUI.Form;
import RobotControl.Communicator;
import RobotControl.Scheduler;
import Utils.ResetRoomba;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import motionProfiling.Config;
import motionProfiling.GenerationEngine;
import motionProfiling.TrajectoryFollowerFeedForward;

public class RoombaMain extends Scheduler{
	private static char curMove = 'n';
	
	public static void main(String[] args) throws InterruptedException {
		ResetRoomba.run();
		Communicator.init();
//		Form.start();
//		Config config = new Config(200,400,5000,240,0.1);
//		Waypoint[] points = {new Waypoint(0.0,0.0,0.0), new Waypoint(500.0, 0.0, 0.0)};
//		List<String> speech =  Arrays.asList("My name is Christopher.");
//		speakCommand.init(speech);
//		addCommand(speakCommand);
//		addCommand(new TeleopCommand());
//		run();

	}
}

