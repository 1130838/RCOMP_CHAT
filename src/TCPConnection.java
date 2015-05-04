import java.net.Socket;

/**
 * Created by Jorge on 04/05/2015.
 */
public class TCPConnection {
    Server servidor;
    Socket sock;
    int portaTCP;

    public TCPConnection(Server servidor, Socket sock, int portaTCP) {
        this.servidor = servidor;
        this.sock = sock;
        this.portaTCP = portaTCP;
    }

    public Server getServidor() {
        return servidor;
    }

    public void setServidor(Server servidor) {
        this.servidor = servidor;
    }

    public Socket getSock() {
        return sock;
    }

    public void setSock(Socket sock) {
        this.sock = sock;
    }

    @Override
    public String toString() {
        return "TCPConnection{" +
                "servidor=" + servidor +
                ", sock=" + sock +
                '}';
    }
}
