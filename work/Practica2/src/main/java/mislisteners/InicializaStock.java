package mislisteners;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class InicializaStock
 *
 */
@WebListener
public class InicializaStock implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public InicializaStock() {
		// TODO Auto-generated constructor stub
	}

	public void contextInitialized(ServletContextEvent sce) {
	    ServletContext contexto = sce.getServletContext();
	    String archStock = contexto.getInitParameter("stock");
	    BufferedReader stock = null;
	    Hashtable<String, Double> stockProductos = new Hashtable();
	    try {
	        stock = new BufferedReader(new InputStreamReader(contexto.getResourceAsStream(archStock)));
	        String linea;
	        while ((linea = stock.readLine()) != null) {
	            String[] partes = linea.split(",");
	            if (partes.length == 2) {
	                String nombre = partes[0];
	                double precio = Double.parseDouble(partes[1]);
	                stockProductos.put(nombre, precio);
	            }
	        }
	        contexto.setAttribute("stock", stockProductos);
	        contexto.log("Lista de productos creada ");
	    } catch (Exception e) {
	        contexto.log("Ocurrió una excepción mientras….", e);
	    } finally {
	        if (stock != null) {
	            try {
	                stock.close();
	            } catch (Exception e) {
	            }
	        }
	    }
	    

	    
	}


}