package DeprecatedControlIdeas;

import java.util.ArrayList;

import Commands.RoombaCommand;
import Commands.RoombaCommand.CommandType;
import serialControl.RoombaJSSC;
@Deprecated
public class BufferManager implements Runnable {
	private static  ArrayList<RoombaCommand> commandBuffer = new ArrayList<RoombaCommand>();
	private final int BUFFER_LIMIT = 100;
	private RoombaJSSC roomba;
	public enum DataState {
		sending, recieving, clear;
	}
	private DataState state = DataState.clear;
	public synchronized void push(RoombaCommand command) {
		commandBuffer.add(command);
	}
	public synchronized void clear() {
		commandBuffer.clear();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (commandBuffer.size() != 0) {
			if (commandBuffer.get(0).commandType == CommandType.recieving) {
				state = DataState.recieving;
			}
			else {
				state = DataState.sending;
			}
			commandBuffer.get(0).executeCommand(roomba);
		}
		else {
			state = DataState.clear;
		}
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
