import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerImplTest {


    private ProductManagerImpl pm;

    public void setUp() {
        this.pm = ProductManagerImpl.getInstance();

        //

    }



    @Test
    public void test() {
        Producto cafe = new Producto("cafe");
        Producto bocata = new Producto("bocata");



        List<Producto> listPedido = new ArrayList<Producto>();
        listPedido.add(cafe);
        listPedido.add(cafe);
        listPedido.add(cafe);
        listPedido.add(bocata);


        //
        this.pm.realizarPedido(1, listPedido);


        //
        this.pm.realizarPedido(2, listPedido);


        this.pm.realizarPedido(3, listPedido);




        //

        Pedido p = this.pm.servirPedido();

        //Assert.assertEquals(1, p.getUsuario());
        Assert.assertEquals("cafe", p.getProductosPedido().get(0).getNombre());
        Assert.assertEquals("cafe", p.getProductosPedido().get(1).getNombre());
        Assert.assertEquals("cafe", p.getProductosPedido().get(2).getNombre());
        Assert.assertEquals("bocata", p.getProductosPedido().get(3).getNombre());




    }

}
