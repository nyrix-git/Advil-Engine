package networkingAdvilEngine;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class NetworkManager {

	private ServerSocket serverSocket;
	private final List<ClientHandler> clients = new ArrayList<>();

	public void startServer(int port) {
		new Thread(() -> {
			try {
				serverSocket = new ServerSocket(port);
				System.out.println("Server started on port " + port);

				while (true) {
					Socket clientSocket = serverSocket.accept();
					System.out.println("Connected!");

					ClientHandler handler = new ClientHandler(clientSocket);
					clients.add(handler);
					new Thread(handler).start();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

	public void broadcast(String message) {
		for (ClientHandler c : clients) {
			c.send(message);
		}
	}
}