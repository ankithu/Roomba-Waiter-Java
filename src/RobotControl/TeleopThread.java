package RobotControl;

import Speech.TextToSpeech;

public class TeleopThread implements Runnable{
	int left, right;
	int prevLeft = 0, prevRight = 0;
	int i = 0;
	boolean vacuumOn = false, prevVac = false;
	String speakString = "";
	TextToSpeech t  = new TextToSpeech();
	@Override
	public void run() {
		
		i++;
		// TODO Auto-generated method stub
	//	System.out.println("running");
		int[] command = {0,0};
		try {
			command = TeleopCommandDispatch.getRoombaOut();
			vacuumOn = TeleopCommandDispatch.getVacuumOn();
			speakString = TeleopCommandDispatch.getSpeakString();
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			
		}
	
		//System.out.println(command.length);
		left = command[0];
		right = command[1];
		left = Math.min(left, 500);
		right = Math.min(right, 500);
//		left = Math.max(left, -500);
//		right = Math.max(left, -500);
		System.out.println(TeleopCommandDispatch.getSpeakString());
		if (!speakString.equals("")) {
			System.out.println(speakString);
			t.speak(speakString, (float) 1.0, false, false);
			TeleopCommandDispatch.setSpeakString("");
		}
		if (vacuumOn != prevVac) {
			
			Communicator.startVacuum(vacuumOn);
		}
		else if (left != prevLeft || right != prevRight) {
			Communicator.testDrive(left, right);

		}
		if (left == right && i % 10 == 0) {
			System.out.println(Communicator.getAngleTurned());
		}
		else if (left!=right) {
			i = 0;
		}
		
		prevVac = vacuumOn;
		prevLeft = left;
		prevRight = right;
				
	}

}
