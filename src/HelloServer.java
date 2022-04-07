import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;
import java.rmi.registry.*;

public class HelloServer implements Hello {

	public HelloServer() {}  // Construtor

	
	public static void main(String[] args) {
		
		
		try {
			HelloServer server = new HelloServer();
			//Exporta o server para o stub ("apendice ou toco") do RMI na porta 0
			Hello stub = (Hello) UnicastRemoteObject.exportObject(server, 0);
			
			Registry registry = LocateRegistry.getRegistry();
			// Registra a stub no RMI para que ela seja obtida pelos clientes
			registry.bind("Servidor", stub);
			
			System.out.println("Servidor inicializado com sucesso.");
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}



	@Override
	public float hello(float a, float b, float c) throws RemoteException {
		float delta;
		delta = (b * b) + (-4 * (a * c));  // Calculando valor de Delta
		return delta;
	}
	
}