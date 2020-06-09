import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        InetAddress serverInetAddress;
        if (args.length > 1) {
            serverInetAddress = InetAddress.getByName(args[0]);
        }
        else {
            serverInetAddress = InetAddress.getLocalHost();
        }
        Socket socket = new Socket(serverInetAddress, 10000);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        for (int i = 0; i < 10; i++) {
            String sent = String.format("Hello world n. %d!", i);
            bw.write(sent + System.lineSeparator());
            bw.flush();
            String received = br.readLine();
            System.out.printf("Sent: %s%nReceived: %s%n", sent, received);
        }
        bw.write("bye" + System.lineSeparator());
        bw.flush();
        socket.close();
    }
}