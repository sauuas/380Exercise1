import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.Socket;

// Shows a simple example of creating multiple threads.
// This program has three threads, not two!
// The main method itself is running in the first thread.
// It then creates two more threads.
// If your program needs two threads, you only have to create one!
public final class Threads extends Thread {
Socket socket;

Threads(Socket socket){
    this.socket = socket;
}

public void run(){
    try{
        String message = null;
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while((message = bufferedReader.readLine()) != null){
            printWriter.println("server> " + message);
        }
        socket.close();
    }catch(IOException e){
        e.printStackTrace();
    }
}

}
