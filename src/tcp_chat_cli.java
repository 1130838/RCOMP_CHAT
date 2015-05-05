import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

class tcp_chat_cli {
    static InetAddress IPdestino;
    static Socket sock;

    public static void main(String args[]) throws Exception {

        int test2 = 10;
        String nick, frase;
        byte[] data = new byte[300];


        if (args.length != 1) {
            System.out.println("Deve indicar o servidor na linha de comando");
            System.exit(1);
        }

        try {

            IPdestino = InetAddress.getByName(args[0]);

        } catch (UnknownHostException ex) {
            System.out.println("O nome do servidor fornecido (" + args[0] + ") nao e valido");
            System.exit(1);
        }

        try {
            sock = new Socket(IPdestino, 9999);
        } catch (IOException ex) {
            System.out.println("A ligacao TCP com o servidor falhou.");
            System.exit(1);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());

        System.out.print("Nickname: ");
        nick = in.readLine();

        Thread serverConn = new Thread(new tcp_chat_cli_con(sock, test2));
        serverConn.start();


       /* Thread serverConn2 = new Thread(new tcp_chat_cli_con(sock, test2));
        serverConn2.start();*/

        while (true) {
            frase = in.readLine();
            if (frase.compareTo("sair") == 0) {
                sOut.write(0);
                break;
            }
            frase = "(" + nick + ") " + frase;
            data = frase.getBytes();
            sOut.write((byte) frase.length());
            sOut.write(data, 0, (byte) frase.length());


        }

        serverConn.join();
        sock.close();
    }

    private static String getServerAdress() {
        return null;
    }
}

class tcp_chat_cli_con implements Runnable {
    private Socket s;
    private int teste;
    private DataInputStream sIn;


    public tcp_chat_cli_con(Socket tcp_s, int test) {
        s = tcp_s;
        this.teste = test;
    }

    public void run() {
        int nChars;
        byte[] data = new byte[300];
        String frase;

        try {
            sIn = new DataInputStream(s.getInputStream());
            while (true) {

                nChars = sIn.read();
                if (nChars == 0) break;
                sIn.read(data, 0, nChars);
                frase = new String(data, 0, nChars);
                System.out.println(frase);
                teste++;
                System.out.println(this.teste);

            }
        } catch (IOException ex) {
            System.out.println("Ligacao TCP terminada.");
        }
    }
}

