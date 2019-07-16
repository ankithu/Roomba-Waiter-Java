package DeprecatedControlIdeas;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestListener {
    static Scanner inputMachine = new Scanner(System.in);
	public static void main(String[] args) throws InterruptedException, IOException {
		int in;
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader steam = new BufferedReader(input);
		String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
		Runtime.getRuntime().exec(cmd).waitFor();
		while (true) {
			
			
			
			try {
			
				in = input.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				in = -1;
				
			}
			System.out.println(in);
//			try {
//				in = System.console().readLine();
//			}
//			catch(NullPointerException e) {
//				in = "nohhhhhhhhhhhh input";
//			}
//			System.out.println(in);
		}
	}
}
