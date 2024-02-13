import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 5000); // Se connecter au serveur sur le port 5000
            System.out.println("Connecté au serveur.");

            // Flux de lecture et d'écriture avec le serveur
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Envoyer un message au serveur
            out.println("Bonjour, serveur!");

            // Lire la réponse du serveur
            String messageServeur = in.readLine();
            System.out.println("Réponse du serveur : " + messageServeur);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null)
                    socket.close(); // Fermer la connexion
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
