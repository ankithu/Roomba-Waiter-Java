package RobotControl;

import java.util.Arrays;

import motionProfiling.Localizer;
import roombaSong.RoombaNote;
import roombaSong.RoombaNoteDuration;
import roombaSong.RoombaSongNote;
import serialControl.RoombaJSSC;
import serialControl.RoombaJSSCSerial;


public class Communicator {
	static RoombaJSSC roomba = new RoombaJSSCSerial();
	static String[] ports = roomba.portList();
	private static enum DataState{
		sending, recieving, clear;
	}
	private DataState state = DataState.clear;
	public static void init() {
		System.out.println(Arrays.toString(ports));
		if (ports.length > 0 ) {}
			//roomba.connect(ports[0]); 
		//roomba.startup();
	}
	public static void kill() {
		roomba.stop();
		roomba.disconnect();
	}
	
	public static void testSong() {
		// Fur Elise - Beethoven
		RoombaSongNote[] notes = {
		    new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.EightNote),
		    new RoombaSongNote(RoombaNote.D2Sharp, RoombaNoteDuration.EightNote),
		    new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.EightNote),
		    new RoombaSongNote(RoombaNote.D2Sharp, RoombaNoteDuration.EightNote),

		    new RoombaSongNote(RoombaNote.E2, RoombaNoteDuration.EightNote),
		    new RoombaSongNote(RoombaNote.B1, RoombaNoteDuration.EightNote),
		    new RoombaSongNote(RoombaNote.D2, RoombaNoteDuration.EightNote),
		    new RoombaSongNote(RoombaNote.C2, RoombaNoteDuration.EightNote),

		    new RoombaSongNote(RoombaNote.A1, RoombaNoteDuration.QuarterNote),
		    new RoombaSongNote(RoombaNote.Pause, RoombaNoteDuration.EightNote),
		    new RoombaSongNote(RoombaNote.C1, RoombaNoteDuration.EightNote),
		    new RoombaSongNote(RoombaNote.E1, RoombaNoteDuration.EightNote),
		    new RoombaSongNote(RoombaNote.A1, RoombaNoteDuration.EightNote),
		    new RoombaSongNote(RoombaNote.B1, RoombaNoteDuration.QuarterNote),
		    new RoombaSongNote(RoombaNote.Pause, RoombaNoteDuration.EightNote),
		    new RoombaSongNote(RoombaNote.E1, RoombaNoteDuration.EightNote)
		};
		// Save to song number 0, tempo (in BPM) 125
		roomba.song(0, notes, 125);
		// Play song 0
		roomba.play(0);
	}
	public static void testDrive(int leftVel, int rightVel) {
		System.out.println("right: " + rightVel + "left: " + leftVel);
		roomba.driveDirect(rightVel, leftVel);
		
		
	}
	public static void startVacuum(boolean on) {
		if (on) {
			roomba.motorsPWM(50, 50, 50);
		}
		else {
			roomba.motorsPWM(0, 0, 0);
		}
		
	}
	public static double getAngleTurned() {
		return roomba.angleTurned();
	}
	public static void updatePoseData() throws InterruptedException {
		int dDistance = roomba.distanceTraveled();
		Thread.sleep(20);
		int dAngle = roomba.angleTurned();
		Localizer.loop(dDistance, dAngle);
		Thread.sleep(20);
	}
}
	
