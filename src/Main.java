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

        Socket socket1 = new Socket(serverInetAddress, 10000);
        /*
        Socket socket2 = new Socket(serverInetAddress, 10000);
        Socket socket3 = new Socket(serverInetAddress, 10000);
        Socket socket4 = new Socket(serverInetAddress, 10000);
        Socket socket5 = new Socket(serverInetAddress, 10000);
        */

        BufferedReader br1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
        BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
        /*
        BufferedReader br2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
        BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream()));
        BufferedReader br3 = new BufferedReader(new InputStreamReader(socket3.getInputStream()));
        BufferedWriter bw3 = new BufferedWriter(new OutputStreamWriter(socket3.getOutputStream()));
        BufferedReader br4 = new BufferedReader(new InputStreamReader(socket4.getInputStream()));
        BufferedWriter bw4 = new BufferedWriter(new OutputStreamWriter(socket4.getOutputStream()));
        BufferedReader br5 = new BufferedReader(new InputStreamReader(socket5.getInputStream()));
        BufferedWriter bw5 = new BufferedWriter(new OutputStreamWriter(socket5.getOutputStream()));
        */

        for (int i = 0; i < 5; i++) {
            String sent = String.format("Hello world n. %d!", i);
            bw1.write(sent + System.lineSeparator());
            bw1.flush();

            /*
            bw2.write(sent + System.lineSeparator());
            bw2.flush();
            bw3.write(sent + System.lineSeparator());
            bw3.flush();
            bw4.write(sent + System.lineSeparator());
            bw4.flush();
            bw5.write(sent + System.lineSeparator());
            bw5.flush();
            */

            String received = br1.readLine();
            System.out.printf("Sent: %s%nReceived: %s%n", sent, received);
        }



        bw1.write("bye" + System.lineSeparator());
        bw1.flush();
        /*
        bw2.write("bye" + System.lineSeparator());
        bw2.flush();
        bw3.write("bye" + System.lineSeparator());
        bw3.flush();
        bw4.write("bye" + System.lineSeparator());
        bw4.flush();
        bw5.write("bye" + System.lineSeparator());
        bw5.flush();
        */

        socket1.close();
        /*
        socket2.close();
        socket3.close();
        socket4.close();
        socket5.close();
        */
    }
}