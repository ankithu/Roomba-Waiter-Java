package motionProfiling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Trajectory.FitMethod;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;

public class GenerationEngine {

	public static Trajectory[] calculate(Waypoint[] points, boolean isReversed, Config config) {
		double max_velocity, max_acceleration, max_jerk, wheelbase, delta_time;
	
		max_velocity = config.getMaxVel();
		max_acceleration = config.getMaxAccel();
		max_jerk = config.getMaxJerk();
		wheelbase = config.getWheelBase();
		delta_time = config.getDt();
		
		Trajectory.Config traj_config = new Trajectory.Config(FitMethod.HERMITE_QUINTIC, Trajectory.Config.SAMPLES_HIGH, delta_time, max_velocity, max_acceleration, max_jerk);
		Trajectory trajectory;
		try {
			trajectory = Pathfinder.generate(points, traj_config);
		} catch (Exception e) {
			e.printStackTrace();
	
			return null;
		}
		TankModifier modifier = new TankModifier(trajectory).modify(wheelbase);
		Trajectory[] ret = {modifier.getLeftTrajectory(), modifier.getRightTrajectory()};
		return ret;
	}

	
	

	
}
