
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BlackjackServer extends Thread implements Runnable
{
	@Override
	public void run()
	{
		final int port = 8898;
		ServerSocket server = null;
		
		try
	    {
	    	server = new ServerSocket(port);
	    	while(true)
	    	{
	    		Socket s = server.accept();
	    		Player player = new Player("Player", 1000);
	    		BlackjackClient service = new BlackjackClient(s, player);
	    		Thread thread = new Thread(service);
	    		thread.run();
	    	}
	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	}
}
