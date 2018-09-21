package model;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException{
		
		//Create client into the machine in the port #1234
		Socket client = new Socket("localhost", 1234);
		
		
		//Create input and output streams
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
		
		Scanner s = new Scanner(System.in);
		//Send a message to the server
		while(true) {
			System.out.println("Write a message");
			String m = s.nextLine();
			pw.println(m);
			
			//Receive message from the server
			String answer = br.readLine();
			System.out.println("Answer: " + answer);
		}
		
		
	}

}
