/* Authored by Multiple 
   online sources*/
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Vserver extends Thread
{
   private ServerSocket serverSocket;
   
   public Vserver(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(90000);
   }

   public void run()
   {
      while(true)
      {
         try
         {
            Scanner input = new Scanner(System.in);
            String str ;
            System.out.println("Waiting for client on port " +
            serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            System.out.println("Just connected to "
                  + server.getRemoteSocketAddress());
            DataInputStream in =
                  new DataInputStream(server.getInputStream());
           // System.out.println(in.readUTF());
            DataOutputStream out =
                 new DataOutputStream(server.getOutputStream());
                 System.out.println("Enter the string to send");
                 str =input.nextLine(); 
            out.writeUTF(" "
              + str + "\n");
            server.close();
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
            break;
         }catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
   public static void main(String [] args)
   {
      int port = Integer.parseInt(args[0]);
      try
      {
         Thread t = new Vserver(port);
         t.start();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
