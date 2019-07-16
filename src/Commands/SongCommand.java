package Commands;

import RobotControl.Communicator;
import roombaSong.RoombaNote;
import roombaSong.RoombaNoteDuration;
import roombaSong.RoombaSongNote;
import serialControl.RoombaJSSC;

public class SongCommand  extends RoombaCommand{
	

	@Override
	public void setCommandType() {
		// TODO Auto-generated method stub
		commandType = CommandType.sending;
		
	}

	@Override
	public void executeCommand(RoombaJSSC roomba) {
		// TODO Auto-generated method stub
//		RoombaSongNote[] notes = {
//			    new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.EightNote),
//			    new RoombaSongNote(RoombaNote.D2Sharp, RoombaNoteDuration.EightNote),
//			    new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.EightNote),
//			    new RoombaSongNote(RoombaNote.D2Sharp, RoombaNoteDuration.EightNote),
//
//			    new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.EightNote),
//			    new RoombaSongNote(RoombaNote.B1, RoombaNoteDuration.EightNote),
//			    new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.EightNote),
//			    new RoombaSongNote(RoombaNote.C2, RoombaNoteDuration.EightNote),
//
//			    new RoombaSongNote(RoombaNote.A1, RoombaNoteDuration.QuarterNote),
//			    new RoombaSongNote(RoombaNote.Pause, RoombaNoteDuration.EightNote),
//			    new RoombaSongNote(RoombaNote.C1, RoombaNoteDuration.EightNote),
//			    new RoombaSongNote(RoombaNote.E1, RoombaNoteDuration.EightNote),
//			    new RoombaSongNote(RoombaNote.A1, RoombaNoteDuration.EightNote),
//			    new RoombaSongNote(RoombaNote.B1, RoombaNoteDuration.QuarterNote),
//			    new RoombaSongNote(RoombaNote.Pause, RoombaNoteDuration.EightNote),
//			    new RoombaSongNote(RoombaNote.E1, RoombaNoteDuration.EightNote)
//			};
//			// Save to song number 0, tempo (in BPM) 125
//			System.out.println(notes);
//			System.out.println();
			Communicator.testSong();
//			roomba.song(0, notes, 125);
//			// Play song 0
//			roomba.play(0);
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
		
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	} 
}