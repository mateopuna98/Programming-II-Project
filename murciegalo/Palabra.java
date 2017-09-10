package murciegalo;

public class Palabra {
	private int espacios;
	private int puntosQueDa;
	private String palabraDesordenada;
	private String palabraOrdenada;
	private boolean resuelto = false;
	private int subNivel;
	public int getEspacios() {
		return espacios;
	}
	public int getPuntosQueDa() {
		return puntosQueDa;
	}
	public String getPalabraDesordenada() {
		return palabraDesordenada;
	}
	public String getPalabraOrdenada() {
		return palabraOrdenada;
	}
	public boolean isResuelto() {
		return resuelto;
	}
	public int getSubNivel() {
		return subNivel;
	}
	
}
