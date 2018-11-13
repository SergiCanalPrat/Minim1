public class Producto {

    public Producto(String nombre) {
      this.nombre = nombre;
    }

    private int numeroVentas;

    public int getNumeroVentas() {
        return numeroVentas;
    }

    public String getNombre() {
        return nombre;
    }

    private String nombre;

    public int getCost() {

        return cost;
    }

    private int cost;


    public void updateNumVendes() {
        this.numeroVentas++;
    }
}
