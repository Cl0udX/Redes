import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class user  {

   
	public static void main(String[] args) throws UnknownHostException, IOException {
		int puert=1234;
		Socket clienteServer=new Socket("localhost", puert);
		escritorThread fff=new escritorThread(clienteServer);
		fff.start();
		
	
		PrintWriter dd=new PrintWriter(clienteServer.getOutputStream(),true);
		Scanner g=new Scanner(System.in);
		while(true) {			
			String d=g.nextLine();
			dd.println(d);
			
		}
		
		 
		
	}
}
