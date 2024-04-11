package misservlets.practica2;

public class Golosina {
		private String nombre;
		private Double precioUnidad;
		private int cant;
		
		
		
		
		public Golosina(String nombre, Double precioUnidad, int cant) {
			super();
			this.nombre = nombre;
			this.precioUnidad = precioUnidad;
			this.cant = cant;
		}
		public String getNombre() {
			return nombre;
		}
		public Double getPrecioUnidad() {
			return precioUnidad;
		}
		public int getCant() {
			return cant;
		}
		
		

}
