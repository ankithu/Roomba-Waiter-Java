package RobotControl;

import java.util.ArrayList;

import Commands.FinishCommand;
import Commands.RoombaCommand;
import Commands.SpeakCommand;
import serialControl.RoombaJSSC;

public class Scheduler {
	private  static ArrayList<RoombaCommand> commandList = new ArrayList<RoombaCommand>();
	private static  RoombaJSSC roomba; 
	private static RoombaCommand endCommand = new FinishCommand();
	public static SpeakCommand speakCommand = new SpeakCommand();
	public  static void run() {
		for (RoombaCommand command: commandList) {
			command.executeCommand(roomba);
			while (!command.isFinished()) {}
		}
		endCommand.executeCommand(roomba);
	}
	public static  void addCommand(RoombaCommand comm) {
		commandList.add(comm);
	}
}
