import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class escritorThread extends Thread{

	private BufferedReader lector;
	public escritorThread(Socket clienteServer) {
		// TODO Auto-generated constructor stub
	try {
		lector=new BufferedReader(new InputStreamReader(clienteServer.getInputStream()));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public BufferedReader getLector() {
		return lector;
	}
	public void run() {
		String mensajeAntiguo="";
		while(true) {
			try {
				String mensaje=lector.readLine();
				if(mensaje!=null&&!mensaje.equals(" ")&&!mensaje.equals("")&&!mensaje.equals(mensajeAntiguo)) {
					System.out.println(mensaje);
					mensajeAntiguo=mensaje;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
