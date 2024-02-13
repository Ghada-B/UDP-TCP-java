import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try {
            // Création d'une socket UDP sur le port 9876
            DatagramSocket serverSocket = new DatagramSocket(9876);
            
            byte[] receiveData = new byte[1024];
            
            while (true) {
                // Réception du paquet
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                
                // Affichage du message reçu
                String message = new String(receivePacket.getData());
                System.out.println("Message reçu : " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
