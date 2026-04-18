package networkingAdvilEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import java.io.InputStreamReader;

public class ClientHandler implements Runnable {

	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;

	public ClientHandler(Socket socket) {
		this.socket = socket;
	}

	public void send(String msg) {
		if (out != null) {
			out.println(msg);
		}
	}

	@Override
	public void run() {
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String msg;
			while ((msg = in.readLine()) != null) {
				System.out.println("Client says: " + msg);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}