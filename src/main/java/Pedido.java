import java.util.List;
import java.util.Map;

public class Pedido {

    private int idUsuario;
    public boolean served;

    public List<Producto> getProductosPedido() {
        return productosPedido;
    }

    private List<Producto> productosPedido;


    public Pedido(int idUsuario, List<Producto> productosPedido, boolean served) {
        this.idUsuario = idUsuario;
        this.served = served;
        this.productosPedido = productosPedido;
    }


    public int getIdUsuarioFromPedido() {
        return idUsuario;
    }
}
