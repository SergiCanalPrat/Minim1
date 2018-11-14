import org.apache.log4j.Logger;

import java.util.*;

public class ProductManagerImpl implements ProductManager{

    HashMap<Integer, Producto> mapaProductos = new HashMap<Integer, Producto>();
    HashMap<Integer,Usuario> mapaUsuarios = new HashMap<Integer,Usuario>();
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


    private Producto getProducto(String nombre) {
        return mapaProductos.get(nombre);
    }

    private Usuario getUsuario(int idUsuario){
        return mapaUsuarios.get(idUsuario);
    }


    //Public functions

    public void realizarPedido (int idUsuario, List<Producto> productos){
        this.pedidos.add(new Pedido(idUsuario, productos, false));


        mapaUsuarios.get(idUsuario).getListaPedidos().add(new Pedido(idUsuario,productos,false));
        /*

        Usuario u = this.getUsuario(idUsuario);
        u.addPedido(p);

         */


    }

    public Pedido servirPedido() {

        Pedido pedido;
        if (!pedidos.isEmpty()) {
            this.pedidosServidos.add(this.pedidos.element());

            pedido = this.pedidos.remove();

            List<Producto> productoList = pedido.getProductosPedido();

            for (Producto p : productoList) {
                Producto productoDelCataleg = this.getProducto(p.getNombre());
                productoDelCataleg.updateNumVendes();


            Usuario u  = mapaUsuarios.get(pedido.getIdUsuarioFromPedido());
            u.addPedido(pedido);
        }
        }


    }



    public List<Pedido> historialPedidosUsuario(int idUsuario){
        return mapaUsuarios.get(idUsuario).getListaPedidos();
    }

    public List<Producto> topVentas(){
        List<Producto> aux = new ArrayList<Producto>();
        aux.addAll(this.mapaProductos.values());

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
