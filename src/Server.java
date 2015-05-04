/**
 * Created by Jorge on 04/05/2015.
 */
public class Server {

    private String nome;
    private String ip;
    private int porta;
    private boolean estado;

    public Server() {
    }

    public Server(String nome, String ip, int porta, boolean estado) {
        this.nome = nome;
        this.ip = ip;
        this.porta = porta;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Server{" +
                "nome='" + nome + '\'' +
                ", ip='" + ip + '\'' +
                ", porta=" + porta +
                ", estado=" + estado +
                '}';
    }
}
