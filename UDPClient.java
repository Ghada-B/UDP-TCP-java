
    import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            // Création d'une socket UDP
            DatagramSocket clientSocket = new DatagramSocket();
            
            // Adresse IP et port du serveur
            InetAddress IPAddress = InetAddress.getByName("localhost");
            int port = 9876;
            
            // Message à envoyer
            String message = "Bonjour, serveur UDP!";
            byte[] sendData = message.getBytes();
            
            // Création du paquet à envoyer
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            
            // Envoi du paquet
            clientSocket.send(sendPacket);
            
            System.out.println("Message envoyé : " + message);
            
            // Fermeture de la socket
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


