package murciegalo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class MurciegaloGame {
	private MurciegaloUI ui;
	private Stack<Casilla> pilaJugable = new Stack<Casilla>();
	private Stack<Casilla> pilaInversa = new Stack<Casilla>();
	private List<Casilla> listaInicial = new LinkedList<Casilla>();
	private Queue<Casilla> colaJugable = new LinkedList<Casilla>();
	private int dinero = 0;
	protected boolean pantallaDeInicio = true;

	// private boolean recompensaMuyEspecial == false

	Map<Integer, Palabra> nivel1 = new HashMap<Integer, Palabra>();
	Map<Integer, Palabra> nivel2 = new HashMap<Integer, Palabra>();
	Map<Integer, Palabra> nivel3 = new HashMap<Integer, Palabra>();

	public MurciegaloGame(MurciegaloUI ui) {
		this.ui = ui;
	}

	public void mostrarMensaje(String mensaje) {
		this.ui.mostrarComentario(mensaje);

	}

	public void click(int vertical, int horizontal) {
		// éste método contiene las acciones a realizar cada vez que se presione una
		// casilla
		if (pantallaDeInicio) { // si la matriz creada es la de la pantalla de inicio
			if (vertical == 2 || vertical == 3 || vertical == 4) {
				this.crearNivel(vertical);
				pantallaDeInicio = false;
			}
		} else {
			// Aquí el funcionamiento de todo el juego cuando ya se inicio un nivel

		}
	}

	private void crearNivel(int nivel) {
		// el contador debe guardar la cantidad de niveles resueltos para crear el
		// correspondiente
		int contador = 0;
		// Escoge el conjunto de palabras a utilizar, luego escoge una palabra de éste,
		// y crea una nueva matriz con las
		// listas y colas necesarias para el nivel

		if (nivel == 1) {
			String palabraDesordenada = nivel1.get(contador).getPalabraDesordenada();
			

		} else if (nivel == 2) {
			nivel2.get(contador);
		} else {
			nivel3.get(contador);
		}

	}
	public void crearListaInicial() {
		
	}

}
