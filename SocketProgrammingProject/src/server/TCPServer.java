import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {  // Create server socket on port 5000
            System.out.println("Server is listening on port 5000...");
            
            Socket clientSocket = serverSocket.accept();  // Accept client connection
            System.out.println("Client connected!");

            // I/O streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message = in.readLine();  // Read message from client
            System.out.println("Client: " + message);

            out.println("Hello Client!");  // Send response to client

            clientSocket.close();  // Close connection
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
