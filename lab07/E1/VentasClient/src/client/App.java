package client;

public class App {
    public static void main(String[] args) {
        System.out.println(getProducts());
    }

    private static String getProducts() {
        ws.ProductoController_Service service = new ws.ProductoController_Service();
        ws.ProductoController port = service.getProductoControllerPort();
        return port.getProducts();
    }
}
