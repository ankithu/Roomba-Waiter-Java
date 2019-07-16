package RobotControl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
 
import javax.swing.JFrame;
import javax.swing.JTextField;
 
public class KeyboardSpy {
	public static KeyListener initAndGetListener() {
		  KeyListener listener = new KeyListener() {
				 
		@Override   
		public void keyPressed(KeyEvent event) {
		switch (KeyEvent.getKeyText(event.getKeyCode())) {
		    case "W":
		    	TeleopCommandDispatch.setForward(1.0);
		    	break;
		    case "A":
		    	TeleopCommandDispatch.setLeft(1.0);
		    	break;
		    case "S":
		    	TeleopCommandDispatch.setBackward(1.0);
		    	break;
		    case "D":
		    	TeleopCommandDispatch.setRight(1.0);
		    	break;
		    case "J":
		    	TeleopCommandDispatch.setVacuum(true);
		    	break;
		    case "K":
		    	TeleopCommandDispatch.setVacuum(false);
		    	break;
		    case "L":
		    	TeleopCommandDispatch.setSpeakString("What would you like to order?");
		    	System.out.println("L");
		    	break;
		    case "P":
		    	TeleopCommandDispatch.setSpeakString("Your food is ready");
		    	break;
		    }
		    	
		 
		}
		 
		@Override
		 
		public void keyReleased(KeyEvent event) {
			 switch (KeyEvent.getKeyText(event.getKeyCode())) {
			    case "W":
			    	TeleopCommandDispatch.setForward(0.0);
			    	break;
			    case "A":
			    	TeleopCommandDispatch.setLeft(0.0);
			    	break;
			    case "S":
			    	TeleopCommandDispatch.setBackward(0.0);
			    	break;
			    case "D":
			    	TeleopCommandDispatch.setRight(0.0);
			    	break;
			    }
		    //printEventInfo("Key Released", event);
		 
		}
		 
		@Override
		 
		public void keyTyped(KeyEvent event) {
		 
		   // printEventInfo("Key Typed", event);
		 
		}
		 
		private void printEventInfo(String str, KeyEvent e) {
		 
		    System.out.println(str);
		 
		    int code = e.getKeyCode();
		 
		    System.out.println("   Code: " + KeyEvent.getKeyText(code));
		 
		    System.out.println("   Char: " + e.getKeyChar());
		 
		    int mods = e.getModifiersEx();
		 
		    System.out.println("    Mods: "
		 
		+ KeyEvent.getModifiersExText(mods));
		 
		    System.out.println("    Location: "
		 
		+ keyboardLocation(e.getKeyLocation()));
		 
		    System.out.println("    Action? " + e.isActionKey());
		 
		}
		 
		private String keyboardLocation(int keybrd) {
		 
		    switch (keybrd) {
		 
		  case KeyEvent.KEY_LOCATION_RIGHT:
		 
		return "Right";
		 
		  case KeyEvent.KEY_LOCATION_LEFT:
		 
		return "Left";
		 
		  case KeyEvent.KEY_LOCATION_NUMPAD:
		 
		return "NumPad";
		 
		  case KeyEvent.KEY_LOCATION_STANDARD:
		 
		return "Standard";
		 
		  case KeyEvent.KEY_LOCATION_UNKNOWN:
		 
		  default:
		 
		return "Unknown";
		 
		    }
		 
		}
		 
		  };
		  return listener;
		
	}
    public static void start() {
 
		  JFrame frame = new JFrame("Key Spy");
		 
		  Container contentPane = frame.getContentPane();
		 

		 
		  JTextField textField = new JTextField();
		 
		 
		  textField.addKeyListener(initAndGetListener());
		 
		  contentPane.add(textField, BorderLayout.NORTH);
		 
		  frame.pack();
		  frame.requestFocus();
		 
		  frame.setVisible(true);
		    }
}