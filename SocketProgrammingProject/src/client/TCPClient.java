import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {  // Connect to server at localhost:5000
            // I/O streams for communication
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Hello Server!");  // Send message to server

            String response = in.readLine();  // Read response from server
            System.out.println("Server: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
