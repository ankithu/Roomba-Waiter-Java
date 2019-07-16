package Commands;

import serialControl.RoombaJSSC;

public abstract class RoombaCommand {
	public enum CommandType{
		recieving, sending;
	}
	public CommandType commandType;
	public RoombaCommand() {
		setCommandType();
	}
	public abstract void setCommandType();
	public abstract void executeCommand(RoombaJSSC roomba);
	public abstract boolean isFinished();

	public CommandType getCommandType() {
		return commandType;
	}
	
}
