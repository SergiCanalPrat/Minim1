import org.apache.log4j.Logger;

import java.util.*;
import java.util.logging.Logger;

public class ProductManagerImpl implements ProductManager{

    ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private static ProductManagerImpl instance = null;
    final static Logger logger = Logger.getLogger(ProductManagerImpl.class);
    private ArrayList<Producto> productosVendidos;
    private Queue<Pedido> pedidos;
    private List<Pedido> pedidosServidos;

    //Singleton Pattern

    public static ProductManagerImpl getInstance() {
        if (instance == null) instance = new ProductManagerImpl();
        return instance;
    }


    //Getters

    public Queue<Pedido> getPedidos (){
        return pedidos;
    }

    public List<Pedido> getPedidosServidos(){
        return pedidosServidos;
    }

    //Public functions

    public List<Producto> listadoProductosOrdenados(){
        return ordenarProductosPorPrecio(listaProductos);
    }

    public void realizarPedido (int idUsuario, boolean servido, List<Producto> productos){
        this.pedidos.add(new Pedido(idUsuario, productos, false));
        listaUsuarios.get(idUsuario).getListaPedidos().add(new Pedido(idUsuario,productos,false));

    }

    public boolean servirPedido() {

        if (!pedidos.isEmpty()) {
            this.pedidosServidos.add(this.pedidos.element());
            this.pedidos.remove();
            int i = 0;
            int j=0;
            while (i < this.pedidosServidos.size()){
                while (j < this.pedidosServidos.get(i).getProductosPedido().size()){
                    int ventas = this.pedidosServidos.get(i).getProductosPedido().get(j).getNumeroVentas();
                    ventas++;
                    j++;
                }
                i++;
            }
            return true;
        } else {

            return false;

        }
    }

    public List<Pedido> historialPedidosUsuario(int idUsuario){
        return listaUsuarios.get(idUsuario).getListaPedidos();
    }

    public List<Producto> topVentas(){

    }

    //Private Functions
    private ArrayList<Producto> ordenarProductosPorPrecio(ArrayList<Producto> listaProductos){
        listaProductos.sort(Comparator.comparing(Producto::getCost));
        return listaProductos;
    }


}
