
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public final class EchoClient {

    public static void main(String[] args) throws Exception {
        String name = args[0];
        try (Socket socket = new Socket("localhost", 22222)) {
            BufferedReader bufferedReaderFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println(name);
            BufferedReader bufferedReaderFromCommandPrompt = new java.io.BufferedReader(new InputStreamReader(System.in));
            while(true){
                String readerInput = bufferedReaderFromCommandPrompt.readLine();
                printWriter.println(name + ">"+ readerInput);
                System.out.println("client> "+bufferedReaderFromClient.readLine());
            }
        }
    }
}















