import java.util.ArrayList;

/**
 * Created by Jorge on 04/05/2015.
 */
public class Session {

    private String nickname;
    private ArrayList<TCPConnection> listaLigacoes ;
    //private ServerList ArrayList<Server> listaServidores;


    public Session(String nickname) {
        this.nickname = nickname;
        this.listaLigacoes = new ArrayList<TCPConnection>();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public ArrayList<TCPConnection> getListaLigacoes() {
        return listaLigacoes;
    }

    public void setListaLigacoes(ArrayList<TCPConnection> listaLigacoes) {
        this.listaLigacoes = listaLigacoes;
    }

    public void apagarTCPporNomeServer(String nomeServidor){

        for (int i = 0; i < listaLigacoes.size(); i++) {
            if(listaLigacoes.get(i).servidor.getNome().equalsIgnoreCase(nomeServidor)){
                this.listaLigacoes.remove(i);
            }

        }

    }

    public void adicionarTCP (TCPConnection liga){
        this.listaLigacoes.add(liga);

    }




}
