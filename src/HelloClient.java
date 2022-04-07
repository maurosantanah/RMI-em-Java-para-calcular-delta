import java.rmi.registry.*;
import java.util.Scanner;

public class HelloClient {
	
	
	
	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		float a, b, c;
		
		try {
			// Procura o registro do RMI no Servidor
			// Se o servidor estiver em outro host basta substituir pelo seu IP
			Registry registry = LocateRegistry.getRegistry("localhost");

			// Procura a stub do servidor
			Hello stub= (Hello) registry.lookup("Servidor");

			System.out.println("Executando metodo neste host, vamos calcular a formula de Bháskara...");
			
			System.out.println("Digite o valor de A: "); // Solicitando valor de A
	        a = Float.parseFloat(read.next());
			
	        System.out.println("Digite o valor de B: ");  // Solicitando valor de B
	        b = Float.parseFloat(read.next());
	        
	        System.out.println("Digite o valor de C: ");  // Solicitando valor de C
	        c = Float.parseFloat(read.next());
			
			// Chama o método do servidor e imprime a mensagem
			System.out.println("Invocando metodo do servidor");
			float delta = stub.hello(a, b, c);
			System.out.println("O valor de delta é: " +delta); 
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
}