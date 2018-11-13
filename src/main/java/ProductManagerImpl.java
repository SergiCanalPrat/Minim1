import org.apache.log4j.Logger;

import java.util.*;
import java.util.logging.Logger;

public class ProductManagerImpl implements ProductManager{

    ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private static ProductManagerImpl instance = null;
    final static Logger logger = Logger.getLogger(ProductManagerImpl.class);
    //private ArrayList<Producto> productosVendidos;
    private LinkedList<Pedido> pedidos;
    private List<Pedido> pedidosServidos;
    private HashMap<String,Integer> ventas;

    //Singleton Pattern

    public static ProductManagerImpl getInstance() {
        if (instance == null) instance = new ProductManagerImpl();
        return instance;
    }


    //Getters

    public LinkedList<Pedido> getPedidos (){
        return pedidos;
    }

    public List<Pedido> getPedidosServidos(){
        return pedidosServidos;
    }

    //Public functions

    public List<Producto> listadoProductosOrdenados(){
        return ordenarProductosPorPrecio(listaProductos);
    }

    public void realizarPedido (int idUsuario, List<Producto> productos){
        this.pedidos.add(new Pedido(idUsuario, productos, false));


        listaUsuarios.get(idUsuario).getListaPedidos().add(new Pedido(idUsuario,productos,false));
        /*

        Usuario u = this.getUsuario(idUsuario);
        u.addPedido(p);

         */


    }

    public boolean servirPedido() {

        Pedido pedido;
        if (!pedidos.isEmpty()) {
            this.pedidosServidos.add(this.pedidos.element());
            this.pedidos.remove();

            pedido = this.pedidos.remove();

            List<Producto> productoList = pedido.getProductosPedido();

            for (Producto p : productoList) {
                Producto productoDelCataleg = this.getProducto(p.getNombre());
                productoDelCataleg.updateNumVendes();

            }
            //Usuario u  = pedido.getUser();
            //u.addPedido(pedido);
        }


    }

    public List<Pedido> historialPedidosUsuario(int idUsuario){
        return listaUsuarios.get(idUsuario).getListaPedidos();
    }

    public List<Producto> topVentas(){
        List<Producto> aux = new ArrayList<Producto>();
        aux.addAll(this.listaProductos);

        Collections.sort(aux, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return o1.getNumeroVentas()-o2.getNumeroVentas();
            }
        });

        return aux;


    }

    //Private Functions
    private ArrayList<Producto> ordenarProductosPorPrecio(ArrayList<Producto> listaProductos){
        listaProductos.sort(Comparator.comparing(Producto::getCost));
        return listaProductos;
    }


}
