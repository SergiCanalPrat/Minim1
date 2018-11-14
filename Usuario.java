
import java.util.List;

public class Usuario {
    public Usuario(int idUsuario, String userName, List<Pedido> listaPedidos) {
        this.idUsuario = idUsuario;
        this.userName = userName;
        this.listaPedidos = listaPedidos;
    }

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
