package org.example.comprasdeproducto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CompraProductos", value = "/compra-productos")
public class CompraProductos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Obtener los parámetros del formulario
        int cantidadPan = Integer.parseInt(request.getParameter("CantidadPan"));
        int cantidadQueso = Integer.parseInt(request.getParameter("CantidadQueso"));
        int cantidadPlatanos = Integer.parseInt(request.getParameter("CantidadPlatanos"));
        int cantidadNaranjas = Integer.parseInt(request.getParameter("CantidadNaranjas"));

        // Generar XML de solicitud SOAP
        String soapRequest = generateSOAPRequest(cantidadPan, cantidadQueso, cantidadPlatanos, cantidadNaranjas);

        // Calcular subtotales
        double precioPan = 0.5;
        double precioQueso = 2.5;
        double precioPlatanos = 1.25;
        double precioNaranjas = 0.4;

        double subTotalPan = cantidadPan * precioPan;
        double subTotalQueso = cantidadQueso * precioQueso;
        double subTotalPlatanos = cantidadPlatanos * precioPlatanos;
        double subTotalNaranjas = cantidadNaranjas * precioNaranjas;

        out.println("<html><body>");
        out.println("<h1>Compra de Productos</h1>");

        if (cantidadPan < 0 || cantidadQueso < 0 || cantidadPlatanos < 0 || cantidadNaranjas < 0) {
            out.println("<h1>Lo siento, ingrese una cantidad positiva.</h1>");
        } else {
            // Mostrar tabla con los inputs
            out.println("<table border='1'>");
            out.println("<tr><th>Producto</th><th>Cantidad</th><th>Subtotal</th></tr>");
            out.println("<tr><td>Pan</td><td>" + cantidadPan + "</td><td>" + subTotalPan + "</td></tr>");
            out.println("<tr><td>Queso</td><td>" + cantidadQueso + "</td><td>" + subTotalQueso + "</td></tr>");
            out.println("<tr><td>Plátanos</td><td>" + cantidadPlatanos + "</td><td>" + subTotalPlatanos + "</td></tr>");
            out.println("<tr><td>Naranjas</td><td>" + cantidadNaranjas + "</td><td>" + subTotalNaranjas + "</td></tr>");
            out.println("</table>");

            // Mostrar resultado del cálculo
            out.println("<h2>Resultado:</h2>");
            out.println("<p>Pan: " + cantidadPan + " Unidades -> SubTotal: " + subTotalPan + "</p>");
            out.println("<p>Queso: " + cantidadQueso + " Unidades -> SubTotal: " + subTotalQueso + "</p>");
            out.println("<p>Plátanos: " + cantidadPlatanos + " Unidades -> SubTotal: " + subTotalPlatanos + "</p>");
            out.println("<p>Naranjas: " + cantidadNaranjas + " Unidades -> SubTotal: " + subTotalNaranjas + "</p>");

            // Mostrar XML de la solicitud SOAP
            out.println("<h2>Solicitud SOAP:</h2>");
            out.println("<pre>" + soapRequest + "</pre>");
        }

        out.println("</body></html>");
    }

    private String generateSOAPRequest(int cantidadPan, int cantidadQueso, int cantidadPlatanos, int cantidadNaranjas) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <comprasProductos xmlns=\"http://productos.compra/\">\n" +
                "      <CantidadPan>" + cantidadPan + "</CantidadPan>\n" +
                "      <CantidadQueso>" + cantidadQueso + "</CantidadQueso>\n" +
                "      <CantidadPlatanos>" + cantidadPlatanos + "</CantidadPlatanos>\n" +
                "      <CantidadNaranjas>" + cantidadNaranjas + "</CantidadNaranjas>\n" +
                "    </comprasProductos>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";
    }
}
