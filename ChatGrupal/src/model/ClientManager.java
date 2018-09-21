package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class ClientManager extends Thread {

	private Socket client;
	
	private ServerManager server;
	
	private BufferedReader br;
	
	private PrintWriter pw;

	public ClientManager(Socket client, ServerManager server) {
		// TODO Auto-generated constructor stub
		this.client = client;
		this.server = server;
		try {
			
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			pw = new PrintWriter(client.getOutputStream(), true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
	

	}
	public Socket getSocket() {
		return client;
	}

	private static int fibonacci(int pos) {
		if (pos == 0)
			return 0;
		else if (pos == 1)
			return 1;
		return fibonacci(pos - 2) + fibonacci(pos - 1);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {

			// Create input and output streams
			while(true) {
				String[] message = br.readLine().split("//");
				if(message.length == 1) {
					server.sendMessage2(message[0],client.getInetAddress().getHostAddress());
				}else if(message.length == 2) {
					server.sendMessage(message[0], message[1]);
				}
				
			}
			// Take the message send by the client

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void recibirMensaje(String message) {
		pw.println(message);
	}
}
