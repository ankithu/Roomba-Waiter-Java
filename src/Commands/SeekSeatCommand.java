package Commands;

import BarCodeReading.QRCode;
import serialControl.RoombaJSSC;

public class SeekSeatCommand extends RoombaCommand{
	private String seat;
	private boolean seatFound = false;
	public SeekSeatCommand(String seat) {
		super();
		this.seat = seat;
		
	}
	@Override
	public void setCommandType() {
		// TODO Auto-generated method stub
		this.commandType = CommandType.sending;
	}

	@Override
	public void executeCommand(RoombaJSSC roomba) {
		// TODO Auto-generated method stub
		while(!seatFound) {
			roomba.driveDirect(400, 400);
			if (QRCode.hasSpecificQRCode(seat)) {
				seatFound = true;
				roomba.driveDirect(0, 0);
			}
		}
		
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return seatFound;
	}

}
