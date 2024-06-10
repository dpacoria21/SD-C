
package controller;

import entities.Producto;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import repositories.ProductoRepository;

@WebService(serviceName = "ProductoController")
public class ProductoController {

    ProductoRepository productoRepository = new ProductoRepository();
    
    @WebMethod(operationName = "getProducts")
    public String getProducts() {
        StringBuilder result = new StringBuilder();
        
        Map<Integer, Producto> productos = productoRepository.getAllProductos();
        
        for (Map.Entry<Integer, Producto> entry : productos.entrySet()) {
            Integer key = entry.getKey();
            Producto producto = entry.getValue();
            result.append("Código: ").append(key)
                  .append(", Nombre: ").append(producto.getName())
                  .append(", Cantidad: ").append(producto.getCantidad())
                  .append(", Precio: ").append(producto.getPrecio())
                  .append("\n");
        }
        
        return result.toString();
    }

    @WebMethod(operationName = "addProduct")
    public String addProduct(@WebParam(name = "name") String name, @WebParam(name = "cantidad") int cantidad, @WebParam(name = "precio") double precio) {
        Producto producto = new Producto(name, cantidad, precio);
        productoRepository.addProducto(producto);
        return "Producto agregado: " + name;
    }
    
    @WebMethod(operationName = "sellProduct")
    public String sellProduct(@WebParam(name = "code") int code, @WebParam(name = "cantidad") int cantidad, @WebParam(name = "saldoUsuario") double saldoUsuario) {
        return productoRepository.sellProducto(code, cantidad, saldoUsuario);
    }
    
    @WebMethod(operationName = "getPrecio")
    public String getPrecio(@WebParam(name = "code") int code) {
        return " " + productoRepository.getProducto(code).getPrecio();
    }
    

    @WebMethod(operationName = "getProduct")
    public String getProduct(@WebParam(name = "code") int code) {
        Producto producto = productoRepository.getProducto(code);
        if (producto != null) {
            return "Producto encontrado: Código: " + code + ", Nombre: " + producto.getName() + ", Cantidad: " + producto.getCantidad();
        } else {
            return "Producto no encontrado.";
        }
    }
    
    
    
    
    
}
