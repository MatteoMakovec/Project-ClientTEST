import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        InetAddress serverInetAddress;
        final int port = 10000;

        if (args.length > 1) {
            serverInetAddress = InetAddress.getByName(args[0]);
        }
        else {
            serverInetAddress = InetAddress.getLocalHost();
        }

        Socket socket = new Socket(serverInetAddress, port);

        ThreadClient threadClient1 = new ThreadClient(socket);
        ThreadClient threadClient2 = new ThreadClient(socket);
        ThreadClient threadClient3 = new ThreadClient(socket);
        ThreadClient threadClient4 = new ThreadClient(socket);
        ThreadClient threadClient5 = new ThreadClient(socket);

        threadClient1.start();
        threadClient2.start();
        threadClient3.start();
        threadClient4.start();
        threadClient5.start();
    }
}