import java.util.List;

public interface ProductManager {

//Fachada: definir una interfaz y sus parámetros

    void realizarPedido(int Usuario, List<Producto> p);
    Pedido servirPedido();
    List<Producto> topVentas();
}
