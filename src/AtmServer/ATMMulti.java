package AtmServer;

import java.io.IOException;
import java.net.ServerSocket;


public class ATMMulti {

public static void main(String[] args) throws IOException {

ServerSocket serverSocket = null;
boolean listening = true;

try {
serverSocket = new ServerSocket(1212);
} catch (IOException e) {
System.err.println("Could not listen on port: 1212.");
System.exit(-1);
}

while (listening)
new MultiServerThread(serverSocket.accept()).start();

serverSocket.close();
}

}
