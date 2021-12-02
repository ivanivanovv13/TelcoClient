package cln;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.plaf.DesktopPaneUI;

public class Client {

	public static void main(String[] args) throws IOException, URISyntaxException {
		Socket server = new Socket("localhost", 1234);

		BufferedReader input = new BufferedReader(new InputStreamReader(server.getInputStream()));

		try {
			System.out.println(input.readLine());
			System.out.println("Location: " + input.readLine());
			System.out.println("Tempreture: " + input.readLine() + "C");
			Desktop desktop = Desktop.getDesktop();
			desktop.browse(new URI("https://www.google.com/maps/search/google+maps/@"+input.readLine()+ ","+input.readLine()+",15z"));
			
			if (input != null) {
				input.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
