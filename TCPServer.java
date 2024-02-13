import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5000); // Port 5000
            System.out.println("Serveur démarré, en attente de connexion...");

            Socket clientSocket = serverSocket.accept(); // Attendre qu'un client se connecte
            System.out.println("Connexion établie avec " + clientSocket.getInetAddress());

            // Flux de lecture et d'écriture avec le client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String messageClient;
            while ((messageClient = in.readLine()) != null) {
                System.out.println("Message reçu du client : " + messageClient);
                out.println("Message bien reçu : " + messageClient); // Envoyer un accusé de réception
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null)
                    serverSocket.close(); // Fermer le serveur
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
