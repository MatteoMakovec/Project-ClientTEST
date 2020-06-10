import java.io.*;
import java.net.Socket;

public class ThreadClient extends Thread {
    Socket socket;

    public ThreadClient(Socket socket) throws IOException {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            for (int i = 0; i < 5; i++) {
                String sent = String.format("Hello world n. %d!", i);
                bw.write(sent + System.lineSeparator());
                bw.flush();
                String received = br.readLine();
                System.out.printf("Sent: %s%nReceived: %s%n", sent, received);
            }
            bw.write("bye" + System.lineSeparator());
            bw.flush();
            socket.close();
        } catch (IOException e) {
            System.err.printf("IO error: %s\n", e);
        }
    }
}
