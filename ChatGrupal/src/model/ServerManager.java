package model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ServerManager {

	private ServerSocket server;
	
	private HashMap<String, ClientManager> hash;
	
	public ServerManager() {
		// TODO Auto-generated constructor stub
		hash = new HashMap<>();
	}
	
	public void iniciar() {
		try {
			int port = 1234;

			// Create a server in the port #1234
			server = new ServerSocket(port);

			while (true) {
				//Open a new connection with a client
				Socket client = server.accept();
				
				System.out.println(client.getInetAddress().getHostAddress());
				ClientManager cm = new ClientManager(client, this);
				hash.put(client.getInetAddress().getHostAddress(), cm);				
				cm.start();

			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	
	public void sendMessage(String message, String address) {
		System.out.println(hash.get(address));
		hash.get(address).recibirMensaje(message);
	}
	
	public void sendMessage2(String message,String address) {
		Iterator<ClientManager> hilos =  hash.values().iterator();
		
		while(hilos.hasNext()) {
			ClientManager aux=hilos.next();
			if(!address.equals(aux.getSocket().getInetAddress().getHostName())) {
				aux.recibirMensaje(message);				
			}
		}
	}
	
}
