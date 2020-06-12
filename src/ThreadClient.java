import java.io.*;
import java.net.Socket;

public class ThreadClient extends Thread {
    Socket socket;

    public ThreadClient(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while(true){
                String toSend = brInput.readLine();
                bw.write(toSend + System.lineSeparator());
                bw.flush();
                String received = br.readLine();
                System.out.printf("Sent: %s%nReceived: %s\n\n", toSend, received);
                if(socket.isClosed() || received == null) break;
            }

        } catch (IOException e) {
            System.err.printf("IO error: %s\n", e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
