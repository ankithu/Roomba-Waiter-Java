package Commands;

import java.util.Arrays;
import java.util.List;

import Speech.TextToSpeech;
import marytts.signalproc.effects.JetPilotEffect;
import marytts.signalproc.effects.LpcWhisperiserEffect;
import marytts.signalproc.effects.RobotiserEffect;
import marytts.signalproc.effects.StadiumEffect;
import marytts.signalproc.effects.VocalTractLinearScalerEffect;
import marytts.signalproc.effects.VolumeEffect;
import serialControl.RoombaJSSC;

public class SpeakCommand extends RoombaCommand{
	TextToSpeech engine = new TextToSpeech();
	List<String> speech;
	VocalTractLinearScalerEffect vocalTractLSE ;
	JetPilotEffect jetPilotEffect;
	RobotiserEffect robotiserEffect ;
	
	
	public SpeakCommand() {
		
		engine.getAudioEffects().stream().forEach(audioEffect -> {
			System.out.println("-----Name-----");
			System.out.println(audioEffect.getName());
			System.out.println("-----Examples-----");
			System.out.println(audioEffect.getExampleParameters());
			System.out.println("-----Help Text------");
			System.out.println(audioEffect.getHelpText() + "\n\n");
			
		});
		
		//=========================================================================
		//========================= Print available voices =========================
		//=========================================================================
		
		//Print all the available voices
		System.out.println(engine.getAvailableVoices().size());
		
		engine.getAvailableVoices().stream().forEach(voice -> System.out.println("Voice: " + voice));
		
		// Setting the Current Voice
		engine.setVoice("cmu-slt-hsmm");
		
		
		
		//VocalTractLinearScalerEffect
		vocalTractLSE = new VocalTractLinearScalerEffect(); //russian drunk effect
		vocalTractLSE.setParams("amount:25");
		
		//JetPilotEffect
		 jetPilotEffect = new JetPilotEffect(); //epic fun!!!
		jetPilotEffect.setParams("amount:0");
		
		//RobotiserEffect
		 robotiserEffect = new RobotiserEffect();
		robotiserEffect.setParams("amount:0");
		
	
//			
			
//
		
	}
	@Override
	public void setCommandType() {
		// TODO Auto-generated method stub
		this.commandType = CommandType.sending;
		
	}
	public void init(List<String> speech) {
		this.speech = speech;
	}

	@Override
	public void executeCommand(RoombaJSSC roomba) {
		// TODO Auto-generated method stub
		
		engine.setVoice("cmu-slt-hsmm");
		engine.getMarytts().setAudioEffects(robotiserEffect.getFullEffectAsString());// + "+" + stadiumEffect.getFullEffectAsString());
		
		speech.forEach(word -> engine.speak(word, 2.0f, false, true));
		
		
		
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
