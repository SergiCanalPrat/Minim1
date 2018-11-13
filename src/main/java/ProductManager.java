import java.util.List;

public interface ProductManager {

//Fachada: definir una interfaz y sus parámetros

    List<Producto> listadoPedidoOrdenado();
    void realizarPedido(int Usuario, List<Producto> p);
    boolean servirPedido();
    List<Pedido> historialPedidosUsuario(String Usuario);
    List<Producto> topVentas();
}
