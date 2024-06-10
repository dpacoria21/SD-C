package repositories;

import entities.Producto;
import java.util.HashMap;
import java.util.Map;

public class ProductoRepository {

    private Map<Integer, Producto> productos;
    Integer size = 0;

    public void addProducto(Producto producto) {
        producto.setCode(++size);
        productos.put(producto.getCode(), producto);
    }

    public Producto getProducto(int codigo) {
        return productos.get(codigo);
    }
    
    public String sellProducto(int codigo, int cantidad, double saldoUsuario) {
        Producto producto = productos.get(codigo);
        if(producto.getPrecio()*cantidad > saldoUsuario){
            return "Usuario con saldo insuficiente";
        }
        if (producto != null) {
            int currentStock = producto.getCantidad();
            if (currentStock >= cantidad) {
                producto.setCantidad(currentStock - cantidad);
                return "Venta realizada con éxito. Stock restante: " + producto.getCantidad();}
            else {
                return "No hay suficiente stock para realizar la venta.";
            }
        } else {
            return "Producto no encontrado.";
        }
    }

    public Map<Integer, Producto> getAllProductos() {
        return productos;
    }

    public ProductoRepository() {
        productos = new HashMap<Integer, Producto>();
        Producto producto1 = new Producto("Laptop Dell XPS 13", 10,10);
        Producto producto2 = new Producto("iPhone 13 Pro", 20, 20);
        Producto producto3 = new Producto("Samsung Galaxy S21", 15,30);
        Producto producto4 = new Producto("Sony WH-1000XM4 Headphones", 25,40);
        Producto producto5 = new Producto("Apple Watch Series 7", 30,50);

        productos.put(1, producto1);
        productos.put(2, producto2);
        productos.put(3, producto3);
        productos.put(4, producto4);
        productos.put(5, producto5);
        size = 5;
    }

}
