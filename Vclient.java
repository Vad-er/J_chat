/* Authored by Multiple 
   online sources*/
import java.net.*;
import java.io.*;

public class Vclient
{
   public static void main(String [] args)
   {
      String serverName = args[0];
      int port = Integer.parseInt(args[1]);
      int count=1;
      while(true){
      try
      {
         if(count==1){
         System.out.println("Connecting to " + serverName
                             + " on port " + port);
     }
         Socket client = new Socket(serverName, port);
        if(count==1){
         System.out.println("Just connected to "
                      + client.getRemoteSocketAddress());
     }

         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out =
                       new DataOutputStream(outToServer);

         if(count==1){
         	out.writeUTF("Client connected "
                      + client.getLocalSocketAddress());
         	count++;
         }
         InputStream inFromServer = client.getInputStream();
         DataInputStream in =
                        new DataInputStream(inFromServer);
        
         System.out.println("Server says " + in.readUTF());
         client.close();
     
      
      }catch(IOException e)
      {
         e.printStackTrace();
         
      }
  }

   }
}
