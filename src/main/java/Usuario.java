
import java.util.List;

public class Usuario {

    private int idUsuario;
    private String userName;
    List<Pedido> listaPedidos;

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void addPedido(Pedido p) {
        getListaPedidos().add(p);
    }



}
