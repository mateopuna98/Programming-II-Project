package murciegalo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MurciegaloGame {
	private MurciegaloUI ui;
	private Casilla CasillaDeLetras;
	private Casilla CasillaDeSoloVocales;
	protected boolean pantallaDeInicio = true;
	private List<Casilla> listaInicial = new LinkedList<Casilla>();
	private Stack<Casilla> pilaInversa = new Stack<Casilla>();
	private Queue<Casilla> colaJugable = new LinkedList<Casilla>();

	List<Palabra> nivel1 = new LinkedList<Palabra>();
	List<Palabra> nivel2 = new LinkedList<Palabra>();
	List<Palabra> nivel3 = new LinkedList<Palabra>();

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
				this.crearNivel(vertical - 1);
				pantallaDeInicio = false;
			}
		} else {
			// Aquí el funcionamiento de todo el juego cuando ya se inicio un nivel

		}
	}

	private void crearNivel(int nivel) {
		int identificador = 0;
		this.configurarPalabra(nivel, identificador);
	}

	private void configurarPalabra(int nivel, int identificador) {

		// el identificador debe permitir escoger el nivel a jugar
		// List<Casilla> listaInicial = new LinkedList<Casilla>();
		// Stack<Casilla> pilaInversa = new Stack<Casilla>();
		// Queue<Casilla> colaJugable = new LinkedList<Casilla>();

		// Escoge el conjunto de palabras a utilizar, luego escoge una palabra de éste,
		// y crea una nueva matriz con las
		// listas y colas necesarias para el nivel

		// if (nivel == 1) {
		// Obtener la palabra del nivel
		Palabra palabra = nivel1.get(identificador);
		this.crearLogicaDelNivel(palabra);
		// String palabraDesordenada = palabra.getPalabraDesordenada();
		// String palabraOrdenada = palabra.getPalabraOrdenada();
		// int largo = palabra.getLargo();
		// // Separar cada letra
		// char[] letrasDeLaPalabra = palabraDesordenada.toCharArray();
		// // Guardar cada letra en una casilla
		// Casilla[] casillaDeLetras = new Casilla[largo];
		// for (int i = 0; i < largo; i++) {
		// casillaDeLetras[i].setLetra(letrasDeLaPalabra[i]);
		// // Guardar cada casilla en la lista inicial de casillas
		// listaInicial.add(casillaDeLetras[i]);
		// }
		// // Crear una pila para compararla con la pila en la que estará el resultado
		// for (int i = 0; i < largo; i++) {
		// if (letrasDeLaPalabra[i] == 'a' || letrasDeLaPalabra[i] == 'e' ||
		// letrasDeLaPalabra[i] == 'i'
		// || letrasDeLaPalabra[i] == 'o' || letrasDeLaPalabra[i] == 'u' ||
		// letrasDeLaPalabra[i] == ' ') {
		// pilaInversa.add(CasillaDeSoloVocales);
		// } else {
		// pilaInversa.add(CasillaDeLetras);
		//
		// }
		// }
		this.crearInterfazDelNivel(palabra);
		// }
		// } else if (nivel == 2) {
		// nivel2.get(identificador2);
		// // Obtener la palabra del nivel
		// String palabraDesordenada =
		// nivel2.get(identificador2).getPalabraDesordenada();
		// // Separar cada letra
		// char[] letrasDeLaPalabra = palabraDesordenada.toCharArray();
		// // Guardar cada letra en una casilla
		// Casilla[] casillaDeLetras = new Casilla[palabraDesordenada.length()];
		// for (int i = 0; i < palabraDesordenada.length(); i++) {
		// casillaDeLetras[i].setLetra(letrasDeLaPalabra[i]);
		// // Guardar cada casilla en la lista inicial de casillas
		// listaInicial.add(casillaDeLetras[i]);
		// }
		// } else {
		// nivel3.get(identificador3);
		// // Obtener la palabra del nivel
		// String palabraDesordenada =
		// nivel3.get(identificador3).getPalabraDesordenada();
		// // Separar cada letra
		// char[] letrasDeLaPalabra = palabraDesordenada.toCharArray();
		// // Guardar cada letra en una casilla
		// Casilla[] casillaDeLetras = new Casilla[palabraDesordenada.length()];
		// for (int i = 0; i < palabraDesordenada.length(); i++) {
		// casillaDeLetras[i].setLetra(letrasDeLaPalabra[i]);
		// // Guardar cada casilla en la lista inicial de casillas
		// listaInicial.add(casillaDeLetras[i]);
		//
		// }
		// }

	}

	private void crearInterfazDelNivel(Palabra palabra) {

		this.ui.crearMatriz(16, 18, 0, 0, 12);
		this.dibujarImagenes(palabra);

	}

	public void dibujarImagenes(Palabra palabra) {
		char[] letraDeLaPalabra = palabra.getPalabraOrdenada().toCharArray();

		for (int v = 0; v < 18; v++) {
			for (int h = 0; h < 16; h++) {
				if (v == 1 && h > 0 && h < palabra.getLargo()) {
					// Aquí colocar imágenes de la palabra ordenada
					this.ui.dibujarImagen(v, h, "" + letraDeLaPalabra[h - 1]);
				} else if (v == 3 && h > 0 && h < 15) {
					// Aquí colocar las imágenes de la cola jugable
					if (h % 2 == 0) {
						// Si la casilla es par dibuja una celda de sólo vocales
						this.ui.dibujarImagen(v, h, "casillaDeSoloVocales");
					} else {
						this.ui.dibujarImagen(v, h, "casillaDeLetras");
					}
				} else if (v > 4 && v < palabra.getLargo() && h == 7) {
					// Aquí dibujar la pila jugable
					if (letraDeLaPalabra[v - 5] == 'a' || letraDeLaPalabra[v - 5] == 'e'
							|| letraDeLaPalabra[v - 5] == 'i' || letraDeLaPalabra[v - 5] == 'o'
							|| letraDeLaPalabra[v - 5] == 'u') {
						this.ui.dibujarImagen(v, h, "casillaDeSoloVocales");
					} else {
						this.ui.dibujarImagen(v, h, "casillaDeLetras");
					}
				} else if (v > 4 && v < palabra.getLargo() && h == 9) {
					// Aquí dibujar la palabra ordenada
					this.ui.dibujarImagen(v, h, "" + letraDeLaPalabra[v - 5]);
				} else {
					// Aquí dibujar el fondo
					this.ui.dibujarImagen(v, h, "fondo");
				}
			}
		}
	}

	public void crearLogicaDelNivel(Palabra palabra) {

		String palabraDesordenada = palabra.getPalabraDesordenada();
		String palabraOrdenada = palabra.getPalabraOrdenada();
		int largo = palabra.getLargo();
		// Separar cada letra
		char[] letrasDeLaPalabra = palabraDesordenada.toCharArray();
		// Guardar cada letra en una casilla
		Casilla[] casillaDeLetras = new Casilla[largo];
		for (int i = 0; i < largo; i++) {
			casillaDeLetras[i].setLetra(letrasDeLaPalabra[i]);
			// Guardar cada casilla en la lista inicial de casillas
			listaInicial.add(casillaDeLetras[i]);
		}
		// Crear una pila para compararla con la pila en la que estará el resultado
		for (int i = 0; i < largo; i++) {
			if (letrasDeLaPalabra[i] == 'a' || letrasDeLaPalabra[i] == 'e' || letrasDeLaPalabra[i] == 'i'
					|| letrasDeLaPalabra[i] == 'o' || letrasDeLaPalabra[i] == 'u' || letrasDeLaPalabra[i] == ' ') {
				pilaInversa.add(CasillaDeSoloVocales);
			} else {
				pilaInversa.add(CasillaDeLetras);

			}
		}
	}

	public void crearPalabrasyLlenarMapas() {
		Palabra amor = new Palabra(0, 0, "oram", "amor");
		Palabra perro = new Palabra(0, 0, "orerp", "perro");
		Palabra gato = new Palabra(0, 0, "toga", "gato");
		Palabra alexis = new Palabra(0, 0, "sixeal", "alexis");
		Palabra iphone = new Palabra(0, 0, "honipe", "iphone");
		Palabra tetekos = new Palabra(0, 0, "esketot", "tetekos");
		Palabra forum = new Palabra(0, 0, "rofum", "forum");
		Palabra rosa = new Palabra(0, 0, "saro", "rosa");
		Palabra feel = new Palabra(0, 0, "leef", "feel");
		Palabra bolivia = new Palabra(0, 0, "vobilia", "bolivia");
		Palabra osman = new Palabra(0, 0, "nasmo", "osman");

		nivel1.add(amor);
		nivel1.add(perro);
		nivel1.add(gato);
		nivel1.add(alexis);
		nivel1.add(iphone);
		nivel1.add(tetekos);
		nivel1.add(forum);
		nivel1.add(rosa);
		nivel1.add(feel);
		nivel1.add(bolivia);
		nivel1.add(osman);
	}

}
