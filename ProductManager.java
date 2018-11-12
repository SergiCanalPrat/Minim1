import java.util.List;

public interface ProductManager {

//Fachada: definir una interfaz y sus parámetros

    List<Producto> listadoPedidoOrdenado();
    void realizarPedido(String Usuario, Pedido p);
    boolean servirPedido();
    List<Pedido> historialPedidosUsuario(String Usuario);
    List<Producto> topVentas();
}
