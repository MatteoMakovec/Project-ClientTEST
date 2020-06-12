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

        Socket socket1 = new Socket(serverInetAddress, port);
        //Socket socket2 = new Socket(serverInetAddress, port);
        //Socket socket3 = new Socket(serverInetAddress, port);
        //Socket socket4 = new Socket(serverInetAddress, port);
        //Socket socket5 = new Socket(serverInetAddress, port);

        ThreadClient threadClient1 = new ThreadClient(socket1);
        //ThreadClient threadClient2 = new ThreadClient(socket2);
        //ThreadClient threadClient3 = new ThreadClient(socket3);
        //ThreadClient threadClient4 = new ThreadClient(socket4);
        //ThreadClient threadClient5 = new ThreadClient(socket5);

        threadClient1.start();
        //threadClient2.start();
        //threadClient3.start();
        //threadClient4.start();
        //threadClient5.start();
    }
}