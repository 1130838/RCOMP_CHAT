import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge on 04/05/2015.
 */
public class ServerList {

    private ArrayList<Server> listaServidores;

    public ServerList() {
        listaServidores = new ArrayList<Server>();
    }


    public ArrayList<Server> getListaServidores() {
        return listaServidores;
    }

    public void setListaServidores(ArrayList<Server> listaServidores) {
        this.listaServidores = listaServidores;
    }

    public void adicionaServer(Server novoServer) {
        this.listaServidores.add(novoServer);
    }

    Server procurarServerPorNome(String procura) {

        for (int i = 0; i < listaServidores.size(); i++) {
            if (this.listaServidores.get(i).getNome().equalsIgnoreCase(procura)) {
                return this.listaServidores.get(i);
            }
        }
        return null;
    }

}
