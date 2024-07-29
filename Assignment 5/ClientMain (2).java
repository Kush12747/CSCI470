import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain 
{
	public static void main(String[] args) throws InterruptedException, IOException
	{
		BlackjackServer blackjackServer = new BlackjackServer();
		Thread BlackjackServerThread = new Thread(blackjackServer);
		BlackjackServerThread.start();
		final int port = 8898;
		
		try (Socket socket = new Socket("localhost", port))
		{
			InputStream inputStream = socket.getInputStream();
            OutputStream outputSteam = socket.getOutputStream();
            Scanner in = new Scanner(inputStream);
            PrintWriter out = new PrintWriter(outputSteam);
			Scanner input = new Scanner(System.in);	
		}
	}
}
