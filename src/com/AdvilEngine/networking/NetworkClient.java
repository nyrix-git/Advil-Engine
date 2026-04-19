package com.AdvilEngine.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkClient {

	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;

	public void connect(String ip, int port) {
		try {
			socket = new Socket(ip, port);

			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			System.out.println("Connected to server!");

			new Thread(() -> listen()).start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void listen() {
		try {
			String msg;
			while ((msg = in.readLine()) != null) {
				System.out.println("Server message: " + msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send(String msg) {
		out.println(msg);
	}
}